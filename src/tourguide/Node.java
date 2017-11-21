package tourguide;

public abstract class Node {
    private Annotation annotation;

    Node(Annotation a) {
        annotation = a;
    }

    public Annotation getAnnotation() {
        return annotation;
    }

    @Override
    public String toString() {
        return "Node{" +
                "annotation=" + annotation +
                '}';
    }
}
