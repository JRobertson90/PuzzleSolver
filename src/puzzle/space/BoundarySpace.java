package puzzle.space;

import puzzle.util.Spot;
import puzzle.util.State;

public class BoundarySpace extends Space {

    public BoundarySpace(Spot spot) {
        super(State.BLOCKED, spot);
    }

    public BoundarySpace(State state, Spot spot) {
        super(state,spot);
    }

    @Override
    public boolean isAcceptableWinState() {
        return true;
    }

    @Override
    public Space copy() {
        return new BoundarySpace(state,spot);
    }
}