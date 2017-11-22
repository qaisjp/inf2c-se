package tourguide;

import java.util.*;

public class BrowseOverviewMode extends Mode {
    private Set<Tour> tours = new HashSet<>();

    public BrowseOverviewMode() {
        super(ModeType.BROWSE_OVERVIEW);
    }

    public BrowseOverviewMode(Set<Tour> tours) {
        this();

        this.tours.addAll(tours);
    }

    @Override
    List<Chunk> getOutput() {
        Chunk.BrowseOverview overview = new Chunk.BrowseOverview();

        for (Tour t : tours) {
            overview.addIdAndTitle(t.getID(), t.getTitle());
        }

        return new ArrayList<>(Arrays.asList(overview));
    }
}
