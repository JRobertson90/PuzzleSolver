package puzzle.model;

public enum Direction {

    UP,LEFT,RIGHT,DOWN;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
