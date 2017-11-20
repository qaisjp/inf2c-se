package tourguide;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowseOverviewMode extends Mode {
    ArrayList<Chunk> output = new ArrayList<>();

    public BrowseOverviewMode() {
        super(ModeType.BROWSE_OVERVIEW);

        output.add(new Chunk.BrowseOverview());
    }

    public BrowseOverviewMode(Set<Tour> tours) {
        this();

        Chunk.BrowseOverview overview = (Chunk.BrowseOverview) output.get(0);
        for (Tour t : tours) {
            overview.addIdAndTitle(t.getID(), t.getTitle());
        }
    }

    @Override
    List<Chunk> getOutput() {
        ArrayList<Chunk> output = new ArrayList<>();
        output.add(new Chunk.BrowseOverview());

        return output;
    }
}
