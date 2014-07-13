package puzzle.solver;

import puzzle.block.Block;
import puzzle.model.Board;
import puzzle.space.Space;
import puzzle.model.Direction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Solver {

    private Board board;
    private File answerFile;
    private List<String> answerInstructions = new ArrayList<String>();

    public Solver(Board board, File answerFile) {
        this.board = board;
        this.answerFile = answerFile;
    }

    public void solve() throws FileNotFoundException {

        PrintWriter pw = new PrintWriter(answerFile);
        boolean foundSolution = iterate(board);

        if(foundSolution) {

            pw.println("-------------------------\n  " + answerFile.getName() + "\n-------------------------");

            int instructionNumber = 1;
            for(int i = answerInstructions.size() - 1; i >= 0; i--) {
                pw.println(instructionNumber + ". " + answerInstructions.get(i));
                instructionNumber++;
            }

        }
        else {
            pw.println("Sorry! I couldn't find a solution to this puzzle, my bad.");
        }

        pw.close();
    }

    public boolean iterate(Board board) {

        if(board.getRemainingBlocks().isEmpty()) {
            return checkWinStatus(board);
        }

        Direction direction;

        for(Block b : board.getRemainingBlocks()) {

            for(int i = 0; i < 4; i++) {

                Board copy = board.copy();

                switch(i) {
                    case 0: direction = Direction.UP; break;
                    case 1: direction = Direction.LEFT; break;
                    case 2: direction = Direction.RIGHT; break;
                    case 3: direction = Direction.DOWN; break;
                    default: direction = null;
                }

                boolean successful = b.move(copy, direction);
                b.reset();

                if(successful) {
                    copy.getRemainingBlocks().remove(b);
                    boolean foundSolution = iterate(copy);

                    if(foundSolution) {
                        String instruction = "Move " + b.getName() + " at " +
                                b.getOrigin().toString() + " " + direction.toString() + ".";
                        answerInstructions.add(instruction);
                        return true;
                    }
                }

            }

        }

        return false;

    }

    private boolean checkWinStatus(Board board) {

        Space[][] grid = board.getGrid();

        for(int row = 0; row < grid.length; row++) {

            for(int col = 0; col < grid[0].length; col++) {

                if( ! grid[row][col].isAcceptableWinState()) {
                    return false;
                }
            }
        }
        return true;
    }

}