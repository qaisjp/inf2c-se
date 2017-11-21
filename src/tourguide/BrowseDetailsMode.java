package tourguide;

import java.util.Arrays;
import java.util.List;

public class BrowseDetailsMode extends Mode {
    Tour tour;

    public BrowseDetailsMode(Tour tour) {
        super(ModeType.BROWSE_DETAILS);

        this.tour = tour;
    }

    @Override
    List<Chunk> getOutput() {
        return Arrays.asList(
                new Chunk.BrowseDetails(
                        tour.getID(),
                        tour.getTitle(),
                        tour.getAnnotation()
                )
        );
    }
}
