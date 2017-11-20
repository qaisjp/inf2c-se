package tourguide;

import java.util.ArrayList;
import java.util.List;

public class CreateMode extends Mode {
    private Tour tour;

    public CreateMode(Tour tour) {
        super(ModeType.CREATE);

        this.tour = tour;
    }

    @Override
    List<Chunk> getOutput() {
        ArrayList<Chunk> chunks = new ArrayList<>();

        chunks.add(new Chunk.CreateHeader(
                tour.getTitle(),
                tour.getLegs(),
                tour.getWaypoints()
        ));

        return chunks;
    }

    public Tour getTour() {
        return tour;
    }
}
