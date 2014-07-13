package puzzle.block;

import puzzle.space.Space;
import puzzle.util.Spot;
import puzzle.util.State;

public class IceBlock extends Block {

    public IceBlock(Spot origin, int number) {
        super(origin, number);
    }

    public IceBlock(Spot origin, Spot place, int remainingMoves) {
        super(origin,place,remainingMoves);
    }

    @Override
    public String getName() {
        return "Ice Block";
    }

    @Override
    public Block copy() {
        return new IceBlock(origin.copy(), place.copy(), remainingMoves);
    }

    @Override
    public void handleMovement(Space space) {

        place = space.getSpot();
        switch(space.getState()) {
            case OPEN: space.setState(State.ICED); remainingMoves--; break;
            case ICED: break;
        }
    }

}