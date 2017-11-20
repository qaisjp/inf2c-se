package tourguide;

import java.util.ArrayList;
import java.util.List;

public class BrowseOverviewMode extends Mode {
    public BrowseOverviewMode() {
        super(ModeType.BROWSE_OVERVIEW);
    }

    @Override
    List<Chunk> getOutput() {
        ArrayList<Chunk> output = new ArrayList<>();
        output.add(new Chunk.BrowseOverview());

        return output;
    }
}
