package puzzle.block;

import puzzle.model.Board;
import puzzle.space.Space;
import puzzle.model.Spot;
import puzzle.model.State;

public class FireBlock extends Block {

    public FireBlock(Spot origin) {
        super(origin, 1);
    }

    public FireBlock(Spot origin, Spot place, int remainingMoves) {
        super(origin,place,remainingMoves);
    }

    @Override
    public String getName() {
        return "Fire Block";
    }

    @Override
    public void handleMovement(Space space) {

        place = space.getSpot();
        switch(space.getState()) {
            case OPEN: remainingMoves--; break;
            case ICED: space.setState(State.OPEN); break;
        }
    }

    @Override
    public Block copy() {
        return new FireBlock(origin.copy(), place.copy(), remainingMoves);
    }

    @Override
    public boolean isValidPlacement() {
        return hasMoved();
    }

    @Override
    protected void finishMoving(Board board) {
        board.get(place.getRow(),place.getCol()).setState(State.BLOCKED);
    }
}