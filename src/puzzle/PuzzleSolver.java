package puzzle;

import puzzle.block.Block;
import puzzle.util.Direction;
import puzzle.util.Importer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PuzzleSolver {

    public static void main(String[] args) throws FileNotFoundException {

        // TODO: Fix stack overflow bug where ice gets in an infinite loop

//        if(args.length < 2) {
//            System.out.println("Usage: puzzle.txt answer.txt");
//            return;
//        }
//
//        File puzzleFile = new File(args[0]);
//        File answerFile = new File(args[1]);

        System.out.println("Enter name of file (without .txt): ");
        String fileName = new Scanner(System.in).nextLine();

//        String fileName = "welcome-";
//        for(int lvl = 1; lvl <= 24; lvl++) {
//
//            File puzzleFile = new File("./puzzles/welcome/" + fileName + lvl + ".txt");
//            File answerFile = new File("./puzzles/welcome/answers/" + fileName + lvl + "-answer.txt");

            File puzzleFile = new File("./puzzles/" + fileName + ".txt");
            File answerFile = new File("./puzzles/" + fileName + "-answer.txt");

            Board board = Importer.importPuzzle(puzzleFile);
            Solver solver = new Solver(board,answerFile);
            solver.solve();
//        }
    }

}