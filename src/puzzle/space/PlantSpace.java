package puzzle.space;

import puzzle.block.Block;
import puzzle.model.Direction;
import puzzle.model.Spot;
import puzzle.model.State;

public class PlantSpace extends Space {

    public PlantSpace(Spot spot) {
        super(State.OPEN, spot);
    }

    public PlantSpace(State state, Spot spot) {
        super(state,spot);
    }

    @Override
    public boolean isAcceptableWinState() {
        return state.equals(State.BLOCKED);
    }

    @Override
    public Space copy() {
        return new PlantSpace(state,spot);
    }

    public Direction processMovement(Block block, Direction direction) {

        block.handleMovement(this);
        state = State.BLOCKED;
        return direction;
    }
}