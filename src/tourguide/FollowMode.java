package tourguide;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FollowMode extends Mode {
    private static Logger logger = Logger.getLogger("tourguide");

    private Tour tour;
    private int stage = 0;
    private Displacement location;
    private double waypointRadius;

    public FollowMode(Tour tour, double waypointRadius) {
        super(ModeType.FOLLOW);
        logger.finer("Tour: " + tour.getID() + ",  waypointRadius: " + waypointRadius);

        this.tour = tour;
        this.waypointRadius = waypointRadius;
    }

    /**
     * sets the location the user is currently at, and returns
     * whether the tour has been completed.
     *
     * @param loc the user is currently at
     * @return completion state
     */
    public boolean setLocation(Displacement loc) {
        logger.finer("Entering with location(e: " + loc.east + ", n: " + loc.north + ")");
        this.location = loc;

        Displacement d = getDisplacementToStage(nextStage());
        if (d != null && d.distance() <= waypointRadius) {
            stage += 1;
            logger.fine("stage advanced to " + stage + " with displacement(e: " + d.east + ", n: " + d.north + ")");
        }

        logger.finest("is current stage final: " + String.valueOf(currentStage().isFinal()));
        return currentStage().isFinal();
    }

    private Stage currentStage() {
        return tour.getStages().get(stage);
    }

    private Stage nextStage() {
        return tour.getStages().get(stage + 1);
    }

    private Displacement getDisplacementToStage(Stage nextStage) {
        if (nextStage == null || nextStage.waypoint == null) {
            logger.finer((nextStage == null) ? "nextStage null" : "nextStage.waypoint null");

            if (nextStage.waypoint == null) {
                logger.finest("stage: " + stage + ", nextStage: " + nextStage.toString());
            }

            return null;
        }

        Displacement target = nextStage.waypoint.position;
        Displacement d = new Displacement(target.east - location.east, target.north - location.north);

        return d;
    }

    @Override
    List<Chunk> getOutput() {
        logger.finer("Entering");

        ArrayList<Chunk> chunks = new ArrayList<>();
        chunks.add(new Chunk.FollowHeader(
            tour.getTitle(),
            stage,
            tour.getWaypoints()
        ));

        Waypoint waypoint = currentStage().waypoint;
        Displacement currentD = getDisplacementToStage(currentStage());
        if (waypoint != null && currentD != null && currentD.distance() <= waypointRadius) {
            logger.finest("Adding Chunk.FollowWaypoint: " + waypoint.getAnnotation());
            chunks.add(new Chunk.FollowWaypoint(
                    waypoint.getAnnotation()
            ));
        }

        Leg leg = currentStage().leg;
        if (leg != null) {
            logger.finest("Adding Chunk.FollowLeg: " + leg.getAnnotation());
            chunks.add(new Chunk.FollowLeg(
                    leg.getAnnotation()
            ));
        }

        if (!currentStage().isFinal()) {
            Displacement d = getDisplacementToStage(nextStage());
            if (d != null) {
                logger.finest("Adding Chunk.FollowBearing: bearing(" + d.bearing() + "), distance(" + d.distance() + ")");
                chunks.add(new Chunk.FollowBearing(
                        d.bearing(), d.distance()
                ));
            }
        }

        return chunks;
    }
}
