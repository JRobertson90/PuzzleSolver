package puzzle.block;

import puzzle.Board;
import puzzle.space.Space;
import puzzle.util.Direction;
import puzzle.util.Spot;
import puzzle.util.State;

public abstract class Block {

    protected Spot origin;
    protected Spot place;
    protected int initialMoves;
    protected int remainingMoves;

    protected Block(Spot origin, int remainingMoves) {
        this.origin = origin;
        this.place = origin;
        this.initialMoves = remainingMoves;
        this.remainingMoves = remainingMoves;
    }
    protected Block(Spot origin, Spot place, int remainingMoves) {
        this.origin = origin;
        this.place = place;
        this.initialMoves = remainingMoves;
        this.remainingMoves = remainingMoves;
    }

    public abstract String getName();

    public void reset() {
        this.place = this.origin;
        this.remainingMoves = this.initialMoves;
    }

    public abstract Block copy();

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

    public int getRemainingMoves() {
        return remainingMoves;
    }

    public void setRemainingMoves(int remainingMoves) {
        this.remainingMoves = remainingMoves;
    }

    @Override
    public String toString() {
        return origin.toString() + " " + place.toString() + " " + remainingMoves;
    }

    public boolean hasMoved() {
        return !origin.equals(place);
    }

    /**
     * Attempts to move the block in the direction specified. Returns true or false whether it succeeded.
     * @param board - You should pass in a copy of the board because it will change states in the process of attempting the move.
     * @param direction - The direction to move the block when a user swipes their finger.
     * @return True if the operation succeded. False if the move was invalid.
     */
    public boolean move(Board board, Direction direction) {

        return tryMove(board, direction);
    }

    protected boolean tryMove(Board board, Direction direction) {

        Space next = board.getNextSpace(place, direction);
        if(canMoveOntoSpace(next)) {
            direction = next.processMovement(this,direction);
            return tryMove(board, direction);
        }
        else {
            finishMoving(board);
            return isValidPlacement();
        }
    }

    protected void finishMoving(Board board) {
        return;
    }

    protected boolean canMoveOntoSpace(Space nextSpace) {
        return nextSpace != null &&
                remainingMoves > 0 &&
                ! nextSpace.getState().equals(State.BLOCKED);
    }

    public abstract void handleMovement(Space space);

    protected boolean isValidPlacement() {
        return hasMoved() && remainingMoves == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Block block = (Block) o;

        if (initialMoves != block.initialMoves) return false;
        if (remainingMoves != block.remainingMoves) return false;
        if (origin != null ? !origin.equals(block.origin) : block.origin != null) return false;
        if (place != null ? !place.equals(block.place) : block.place != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = origin != null ? origin.hashCode() : 0;
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + initialMoves;
        result = 31 * result + remainingMoves;
        return result;
    }
}