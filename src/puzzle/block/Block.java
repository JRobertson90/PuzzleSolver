package puzzle.block;

import puzzle.util.Spot;

public abstract class Block {

    protected Spot origin;
    protected Spot place;
    protected int moves;

    protected Block(Spot origin, int moves) {
        this.origin = origin;
        this.moves = moves;
    }

    public Spot getOrigin() {
        return origin;
    }

    public void setOrigin(Spot origin) {
        this.origin = origin;
    }

    public Spot getPlace() {
        return place;
    }

    public void setPlace(Spot place) {
        this.place = place;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

}