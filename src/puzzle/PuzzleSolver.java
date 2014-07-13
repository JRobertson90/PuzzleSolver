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
        int start = 1;
        int end = 36;

        findSolutions(packName, start, end);
    }
      
    public static void findSolutions(String packName, int start, int end) throws FileNotFoundException {

        for(int lvl = start; lvl <= end; lvl++) {

            File puzzleFile = new File("./puzzles/" + packName + "/" + packName + "-" + lvl + ".txt");
            File answerFile = new File("./puzzles/" + packName + "/answers/" + packName + "-" + lvl + "-answer.txt");

            answerFile.getParentFile().mkdirs();

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