package tourguide;

public class Leg extends Node {
    Leg() {
        super(Annotation.getDefault());
    }

    Leg(Annotation a) {
        super(a == null ? Annotation.getDefault() : a);
    }
}
