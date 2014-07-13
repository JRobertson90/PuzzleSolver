package puzzle;

import puzzle.block.Block;
import puzzle.util.Direction;
import puzzle.util.Importer;

import java.io.File;
import java.io.FileNotFoundException;

public class PuzzleSolver {

    public static void main(String[] args) throws FileNotFoundException {

        if(args.length < 2) {
            System.out.println("Usage: puzzle.txt answer.txt");
            return;
        }

        File puzzleFile = new File(args[0]);
        File answerFile = new File(args[1]);

        Board board = Importer.importPuzzle(puzzleFile);
        Solver solver = new Solver(board,answerFile);
        solver.solve();
    }

}