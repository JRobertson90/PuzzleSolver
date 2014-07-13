package puzzle.space;

import puzzle.block.Block;
import puzzle.util.Direction;
import puzzle.util.Spot;
import puzzle.util.State;

public class DiversionSpace extends Space {

    private Direction direction;

    public DiversionSpace(Spot spot, Direction direction) {
        super(State.OPEN, spot);
        this.direction = direction;
    }

    public DiversionSpace(State state, Spot spot, Direction direction) {
        super(state,spot);
        this.direction = direction;
    }

    @Override
    public boolean isAcceptableWinState() {
        return true;
    }

    @Override
    public Space copy() {
        return new DiversionSpace(state, spot, this.direction);
    }

    public Direction processMovement(Block block, Direction direction) {
        block.setPlace(spot);
        return this.direction;
    }
}