package puzzle.space;

import puzzle.util.Spot;
import puzzle.util.State;

public abstract class Space {

    protected State state;
    protected Spot spot;

    public Space(State state, Spot spot) {
        this.state = state;
        this.spot = spot;
    }

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


}