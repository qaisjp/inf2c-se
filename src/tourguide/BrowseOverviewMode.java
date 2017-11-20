package tourguide;

import java.util.List;

public class BrowseOverviewMode extends Mode {
    public BrowseOverviewMode() {
        super(ModeType.BROWSE_OVERVIEW);
    }

    @Override
    List<Chunk> getOutput() {
        return null;
    }
}
