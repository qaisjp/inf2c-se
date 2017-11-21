package tourguide;

import java.util.ArrayList;
import java.util.List;

public class CreateMode extends Mode {
    String id;
    String title;
    Annotation annotation;
    Displacement location;

    ArrayList<Stage> stages = new ArrayList<>();

    public CreateMode(String id, String title, Annotation annotation) {
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
        if (currentStage().isFinal()) {
            return new Status.Error("attempted to add waypoint to finished tour");
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
        if (stages.size() == 0) {
            Stage firstStage = new Stage(Stage.StageType.FIRST);
            firstStage.setLeg(new Leg(annotation));
            stages.add(firstStage);

            stages.add(new Stage(Stage.StageType.INTERMEDIATE));
            return Status.OK;
        }

        currentStage().setLeg(new Leg(annotation));

        stages.add(new Stage(Stage.StageType.INTERMEDIATE));
        return Status.OK;
    }

    public Tour finishTour() {
        if (!currentStage().setFinal()) {
            return null;
        }

        return new Tour(id, title, annotation, stages);
    }
}
