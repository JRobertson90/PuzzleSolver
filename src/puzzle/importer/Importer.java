package puzzle.importer;

import puzzle.model.Board;
import puzzle.block.Block;
import puzzle.block.DiamondBlock;
import puzzle.block.FireBlock;
import puzzle.block.IceBlock;
import puzzle.space.*;
import puzzle.model.Direction;
import puzzle.model.Spot;
import puzzle.model.State;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Importer {

    private static Scanner reader;

    public static Board importPuzzle(File puzzleFile) throws FileNotFoundException, IllegalArgumentException {

        try {
            reader = new Scanner(puzzleFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> lines = new ArrayList<String>();
        for(int i = 0; reader.hasNextLine(); i++) {
            lines.add(reader.nextLine());
        }

        if( ! isRectangle(lines)) {
            throw new IllegalArgumentException("Puzzle needs to be a rectangle.");
        }

        int numRows = lines.size();
        int numCols = lines.get(0).length();

        Space[][] spaces = new Space[numRows][numCols];
        List<Block> blocks = new ArrayList<Block>();

        for(int row = 0; row < lines.size(); row++) {

            String line = lines.get(row);
            for(int col = 0; col < line.length(); col++) {

                Space s;
                Spot spot = new Spot(row,col);

                char c = line.charAt(col);
                switch(c) {

                    case '#': s = new BoundarySpace(spot); break;
                    case ' ': s = new NormalSpace(State.OPEN, spot); break;
                    case '<': s = new DiversionSpace(spot, Direction.LEFT); break;
                    case '>': s = new DiversionSpace(spot, Direction.RIGHT); break;
                    case '^': s = new DiversionSpace(spot, Direction.UP); break;
                    case 'v': s = new DiversionSpace(spot, Direction.DOWN); break;
                    case 't': s = new PlantSpace(spot); break;
                    case '1': s = new BlockSpace(spot); blocks.add(new IceBlock(spot, 1)); break;
                    case '2': s = new BlockSpace(spot); blocks.add(new IceBlock(spot, 2)); break;
                    case '3': s = new BlockSpace(spot); blocks.add(new IceBlock(spot, 3)); break;
                    case '4': s = new BlockSpace(spot); blocks.add(new IceBlock(spot, 4)); break;
                    case '5': s = new BlockSpace(spot); blocks.add(new IceBlock(spot, 5)); break;
                    case 'f': s = new BlockSpace(spot); blocks.add(new FireBlock(spot)); break;
                    case '.': s = new BlockSpace(spot); blocks.add(new DiamondBlock(spot)); break;
                    default: throw new IllegalArgumentException("Unknown character found in puzzle file: " + c);
                }

                spaces[row][col] = s;
            }
        }

        return new Board(spaces, blocks);
    }

    private static boolean isRectangle(List<String> lines) {

        if(lines.size() <= 0) {
            return false;
        }

        // Make sure every line has the same length
        int firstLength = lines.get(0).length();
        for(String s : lines) {

            if(s.length() != firstLength) {
                return false;
            }
        }

        return true;
    }

}