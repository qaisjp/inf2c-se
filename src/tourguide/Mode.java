package tourguide;

public abstract class Mode {
    private final ModeType type;

    public Mode(ModeType type) {
        this.type = type;
    }

    ModeType getType() {
        return type;
    }
}
