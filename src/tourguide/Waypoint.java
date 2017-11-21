package tourguide;

public class Waypoint extends Node {
    Displacement position;

    Waypoint(Annotation a, Displacement position) {
        super(a);

        this.position = position;
    }
}
