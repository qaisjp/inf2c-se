package tourguide;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CreateMode extends Mode {
    private static Logger logger = Logger.getLogger("tourguide");

    String id;
    String title;
    Annotation annotation;
    Displacement location;
    private double separation;

    ArrayList<Stage> stages = new ArrayList<>();

    public CreateMode(String id, String title, Annotation annotation, double separation) {
        super(ModeType.CREATE);

        this.id = id;
        this.title = title;
        this.annotation = annotation;

        stages.add(new Stage(Stage.StageType.FIRST));
    }

    public void setLocation(Displacement loc) {
        location = loc;
    }

    @Override
    List<Chunk> getOutput() {
        ArrayList<Chunk> chunks = new ArrayList<>();

        chunks.add(new Chunk.CreateHeader(
                title,
                Stage.countLegs(stages),
                Stage.countWaypoints(stages)
        ));

        return chunks;
    }

    private Stage currentStage() {
        return stages.get(stages.size()-1);
    }

    public Status addWaypoint(Annotation annotation) {
        logger.finest("Adding waypoint: " + annotation);

        if (currentStage().isFinal()) {
            return new Status.Error("attempted to add waypoint to finished tour");
        }

        if (currentStage().type != Stage.StageType.FIRST) {
            Displacement from = currentStage().waypoint.position;
            Displacement to = location;

            Displacement d = new Displacement(to.east - from.east, to.north - from.north);
            if (d.distance() <= separation) {
                logger.finest("Too close to previous waypoint: " + annotation);
                return new Status.Error("too close to previous waypoint");
            }
        }

        if (currentStage().leg == null) {
            currentStage().setLeg(new Leg());
        }

        stages.add(new Stage(Stage.StageType.INTERMEDIATE));

        if (!currentStage().setWaypoint(new Waypoint(annotation, location))) {
            return new Status.Error("Could not set waypoint");
        }

        return Status.OK;
    }

    public Status addLeg(Annotation annotation) {
        logger.finest("Adding leg: " + annotation);

        if (stages.size() == 0) {
            Stage firstStage = new Stage(Stage.StageType.FIRST);
            if (!firstStage.setLeg(new Leg(annotation))) {
                return new Status.Error("leg already set for 0th stage");
            }

            stages.add(firstStage);
            return Status.OK;
        }

        if (currentStage().isFinal()) {
            return new Status.Error("cannot set leg of final stage");
        }

        currentStage().setLeg(new Leg(annotation));

        return Status.OK;
    }

    public Tour finishTour() {
        logger.finest("Entering");
        if (!currentStage().setFinal()) {
            return null;
        }

        logger.finest("Success");
        return new Tour(id, title, annotation, stages);
    }
}
