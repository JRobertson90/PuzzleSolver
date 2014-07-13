package puzzle.model;

public class Spot {

    private int row;
    private int col;

    public Spot(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Spot copy() {
        return new Spot(row,col);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spot spot = (Spot) o;

        if (col != spot.col) return false;
        if (row != spot.row) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

    @Override
    public String toString() {
        return "(row = " + (row + 1) + ", col = " + (col + 1) + ")";
    }
}