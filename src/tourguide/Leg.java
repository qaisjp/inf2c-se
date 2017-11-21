package tourguide;

public class Leg extends Node {
    Leg() {
        super(Annotation.getDefault());
    }

    Leg(Annotation a) {
        super(a == null ? Annotation.getDefault() : a);
    }

    @Override
    public String toString() {
        return "Leg{} " + super.toString();
    }
}
