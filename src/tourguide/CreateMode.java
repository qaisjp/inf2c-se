package tourguide;

import java.util.List;

public class CreateMode extends Mode {
    public CreateMode() {
        super(ModeType.CREATE);
    }

    @Override
    List<Chunk> getOutput() {
        return null;
    }
}
