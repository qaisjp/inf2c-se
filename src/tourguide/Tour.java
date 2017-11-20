package tourguide;

import java.util.ArrayList;

public class Tour {
    private String id;
    private String title;
    private Annotation annotation;

    private ArrayList<Annotation> waypoints;
    private ArrayList<Annotation> legs;

    public Tour(String id, String title, Annotation annotation) {
        this.id = id;
        this.title = title;
        this.annotation = annotation;
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
        return legs.size();
    }

    public int getWaypoints() {
        return waypoints.size();
    }

    public String getID() {
        return id;
    }
}
