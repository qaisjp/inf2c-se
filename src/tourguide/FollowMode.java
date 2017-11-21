package tourguide;

import java.util.ArrayList;
import java.util.List;

public class FollowMode extends Mode {
    private Tour tour;
    private int stage;
    private Displacement location;
    private double waypointRadius;

    public FollowMode(Tour tour, double waypointRadius) {
        super(ModeType.FOLLOW);

        this.tour = tour;
        this.waypointRadius = waypointRadius;
    }

    /**
     * sets the location the user is currently at, and returns
     * whether the tour has been completed.
     *
     * @param location the user is currently at
     * @return completion state
     */
    public boolean setLocation(Displacement location) {
        this.location = location;

        Displacement d = displacementToNext();
        if (d != null && d.distance() <= waypointRadius) {
            stage += 1;

        }

        return currentStage().isFinal();
    }

    private Stage currentStage() {
        return tour.getStages().get(stage);
    }

    private Displacement displacementToNext() {
        Stage nextStage = tour.getStages().get(stage + 1);
        if (nextStage == null || nextStage.waypoint == null) {
            return null;
        }

        Displacement target = nextStage.waypoint.position;
        Displacement d = new Displacement(target.east - location.east, target.north - location.north);

        return d;
    }

    @Override
    List<Chunk> getOutput() {
        ArrayList<Chunk> chunks = new ArrayList<>();
        chunks.add(new Chunk.FollowHeader(
            tour.getTitle(),
            stage,
            tour.getWaypoints()
        ));

        Waypoint waypoint = currentStage().waypoint;
        if (waypoint != null) {
            chunks.add(new Chunk.FollowWaypoint(
                    waypoint.getAnnotation()
            ));
        }

        Leg leg = currentStage().leg;
        if (leg != null) {
            chunks.add(new Chunk.FollowLeg(
                    leg.getAnnotation()
            ));
        }

        // What happens if we do this when we have finished?
        Displacement d = displacementToNext();
        if (d != null) {
            chunks.add(new Chunk.FollowBearing(
                    d.bearing(), d.distance()
            ));
        }

        return chunks;
    }
}
