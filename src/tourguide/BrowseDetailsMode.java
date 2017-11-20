package tourguide;

import java.util.List;

public class BrowseDetailsMode extends Mode {
    public BrowseDetailsMode() {
        super(ModeType.BROWSE_DETAILS);
    }

    @Override
    List<Chunk> getOutput() {
        return null;
    }
}
