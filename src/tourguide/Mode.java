package tourguide;

import java.util.List;

public abstract class Mode {

    private enum ModeType {
        CREATE,
        BROWSE_OVERVIEW,
        BROWSE_DETAILS,
        FOLLOW;

        boolean IsBrowse() {
            return (this == BROWSE_DETAILS) ||  (this == BROWSE_OVERVIEW);
        }
        boolean IsCreate() { return this == CREATE; }
        boolean IsFollow() { return this == FOLLOW; }
    }

    private final ModeType type;

    public Mode(ModeType type) {
        this.type = type;
    }

    ModeType getType() {
        return type;
    }

    abstract List<Chunk> getOutput();
}
