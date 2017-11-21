package tourguide;

public class Waypoint extends Node {
    Displacement position;

    Waypoint(Annotation a, Displacement position) {
        super(a);

        this.position = position;
    }

    @Override
    public String toString() {
        return "Waypoint{" +
                "pos.north=" + position.north +
                "pos.east=" + position.east +
                "pos.bearing()=" + position.bearing() +
                "pos.distance()=" + position.distance() +
                '}';
    }
}
