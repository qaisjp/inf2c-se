package tourguide;

public class Tour {
    private String id;
    private String title;
    private Annotation annotation;

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
}
