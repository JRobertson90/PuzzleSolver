package puzzle.space;

import puzzle.model.Spot;
import puzzle.model.State;

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