package tourguide;

import java.util.List;

public class FollowMode extends Mode {
    public FollowMode() {
        super(ModeType.CREATE);
    }

    @Override
    List<Chunk> getOutput() {
        return null;
    }
}