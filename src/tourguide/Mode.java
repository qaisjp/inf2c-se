package tourguide;

import java.util.List;

public abstract class Mode {
    private final ModeType type;

    public Mode(ModeType type) {
        this.type = type;
    }

    ModeType getType() {
        return type;
    }

    abstract List<Chunk> getOutput();
}
