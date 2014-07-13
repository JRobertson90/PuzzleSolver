package puzzle.space;


import puzzle.util.Spot;
import puzzle.util.State;

public class BlockSpace extends Space {

    public BlockSpace(Spot spot) {
        super(State.BLOCKED, spot);
    }

    public BlockSpace(State state, Spot spot) {
        super(state,spot);
    }

    @Override
    public boolean isAcceptableWinState() {
        return true;
    }

    @Override
    public Space copy() {
        return new BlockSpace(state,spot);
    }
}