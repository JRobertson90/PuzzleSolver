package puzzle.model;

import puzzle.block.Block;
import puzzle.space.Space;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Space[][] grid;
    private List<Block> remainingBlocks;

    public Board(Space[][] grid, List<Block> remainingBlocks) {
        this.grid = grid;
        this.remainingBlocks = remainingBlocks;
    }

    public Space get(int row, int col) {
        return grid[row][col];
    }

    public List<Block> getRemainingBlocks() {
        return remainingBlocks;
    }

    public Space[][] getGrid() {
        return grid;
    }

    public void setGrid(Space[][] grid) {
        this.grid = grid;
    }

    public void setRemainingBlocks(List<Block> remainingBlocks) {
        this.remainingBlocks = remainingBlocks;
    }

    public Space getNextSpace(Spot current, Direction direction) {

        int row = current.getRow();
        int col = current.getCol();

        switch (direction) {
            case UP: row--; break;
            case DOWN: row++; break;
            case LEFT: col--; break;
            case RIGHT: col++; break;
        }

        if(row < 0 || row >= grid.length ||
                col < 0 || col >= grid[0].length) {
            return null;
        }

        return grid[row][col];
    }

    public Board copy() {

        // Copy spaces
        Space[][] newGrid = new Space[grid.length][grid[0].length];
        for(int row = 0; row < newGrid.length; row++) {
            for(int col = 0; col < newGrid[0].length; col++) {
                newGrid[row][col] = grid[row][col].copy();
            }
        }

        // Copy remainingBlocks
        List<Block> newBlocks = new ArrayList<Block>();
        for(Block b : this.remainingBlocks) {
            newBlocks.add(b.copy());
        }

        return new Board(newGrid,newBlocks);
    }
}