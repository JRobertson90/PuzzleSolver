package puzzle.block;

import puzzle.model.Board;
import puzzle.space.Space;
import puzzle.model.Spot;
import puzzle.model.State;

public class DiamondBlock extends Block {

    public DiamondBlock(Spot origin) {
        super(origin, 1);
    }

    public DiamondBlock(Spot origin, Spot place, int remainingMoves) {
        super(origin,place,remainingMoves);
    }

    @Override
    public String getName() {
        return "Diamond Block";
    }

    @Override
    public Block copy() {
        return new DiamondBlock(origin.copy(), place.copy(), remainingMoves);
    }

    @Override
    public void handleMovement(Space space) {

        place = space.getSpot();
        switch(space.getState()) {
            case OPEN: remainingMoves--; break;
            case ICED: break;
        }
    }

    @Override
    protected void finishMoving(Board board) {
        board.get(place.getRow(),place.getCol()).setState(State.BLOCKED);
    }

}