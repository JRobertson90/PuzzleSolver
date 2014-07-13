package puzzle.space;

import puzzle.block.Block;
import puzzle.model.Direction;
import puzzle.model.Spot;
import puzzle.model.State;

public abstract class Space {

    protected State state;
    protected Spot spot;

    public Space(State state, Spot spot) {
        this.state = state;
        this.spot = spot;
    }

    public abstract boolean isAcceptableWinState();

    public abstract Space copy();

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    /**
     * Processes when a block arrives onto this space. Can override to do special ops before and after a block moves here.
     * @param block The block that is trying to move onto this space.
     * @param direction The direction the block is headed when it arrived.
     * @return The new direction, override this if you want to redirect blocks, otherwise return the same direction.
     */
    public Direction processMovement(Block block, Direction direction) {
        block.handleMovement(this);
        return direction;
    }

    @Override
    public String toString() {
        return spot.toString() + " - " + state;
    }
}