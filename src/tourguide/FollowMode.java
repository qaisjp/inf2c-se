package tourguide;

import java.util.ArrayList;
import java.util.List;

public class FollowMode extends Mode {
    Tour tour;
    int stage;
    Displacement location;


    public FollowMode(Tour tour) {
        super(ModeType.FOLLOW);

        this.tour = tour;
    }

    public void setLocation(Displacement location) {
        this.location = location;
    }

    private Stage currentStage() {
        return tour.getStages().get(stage);
    }

    @Override
    List<Chunk> getOutput() {
        ArrayList<Chunk> chunks = new ArrayList<>();
        chunks.add( new Chunk.FollowHeader(
            tour.getTitle(),
            stage,
            tour.getWaypoints()
        ));

        return chunks;
    }
}
