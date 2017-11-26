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

        ArrayList<Tour> sortedTours = new ArrayList<>(tours);
        sortedTours.sort(Comparator.comparing(Tour::getID));

        for (Tour t : sortedTours) {
            overview.addIdAndTitle(t.getID(), t.getTitle());
        }

        return new ArrayList<>(Arrays.asList(overview));
    }
}
