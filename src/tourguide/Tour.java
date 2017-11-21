package tourguide;

import java.util.ArrayList;

public class Tour {
    private String id;
    private String title;
    private Annotation annotation;

    private ArrayList<Stage> stages;

    public Tour(String id, String title, Annotation annotation, ArrayList<Stage> stages) {
        this.id = id;
        this.title = title;
        this.annotation = annotation;
        this.stages = stages;
    }

    public Annotation getAnnotation() {
        return annotation;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public String getTitle() {
        return title;
    }

    public int getLegs() {
        return Stage.countLegs(stages);
    }

    public int getWaypoints() {
        return Stage.countWaypoints(stages);
    }

    public String getID() {
        return id;
    }

    public ArrayList<Stage> getStages() {
        return stages;
    }
}
