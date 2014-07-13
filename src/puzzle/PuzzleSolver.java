package puzzle;

import puzzle.importer.Importer;
import puzzle.model.Board;
import puzzle.solver.Solver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PuzzleSolver {

    public static void main(String[] args) throws FileNotFoundException {

        String packName = "morning";

        for(int lvl = 1; lvl <= 36; lvl++) {

            File puzzleFile = new File("./puzzles/" + packName + "/" + packName + "-" + lvl + ".txt");
            File answerFile = new File("./puzzles/" + packName + "/answers/" + packName + "-" + lvl + "-answer.txt");

            puzzleFile.mkdirs();
            answerFile.mkdirs();

            Board board = Importer.importPuzzle(puzzleFile);
            Solver solver = new Solver(board,answerFile);

            try {
                solver.solve();
            }
            catch (StackOverflowError error) {
                PrintWriter pw = new PrintWriter(answerFile);
                pw.println("Stack Overflow Error!");
                pw.println("Most likely caused by a block in an infinite loop!");
                pw.println("Sorry about that! This will be fixed soon, I promise.");
                pw.close();
            }
        }
    }

}