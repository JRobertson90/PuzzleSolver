package puzzle.space;

import puzzle.block.Block;
import puzzle.util.Direction;
import puzzle.util.Spot;
import puzzle.util.State;

public class NormalSpace extends Space {

    public NormalSpace(State state, Spot spot) {
        super(state, spot);
    }

    @Override
    public boolean isAcceptableWinState() {
        return ! state.equals(State.OPEN);
    }

    @Override
    public Space copy() {
        return new NormalSpace(state,spot);
    }
}