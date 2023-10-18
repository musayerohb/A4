import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Calls the methods to solve the maze by having the square navigate from start to finish.
 */
class SolveMaze {
  
  public static void main(String[] args) {
    Scanner file = null;
    ArrayList<String> fileContents = new ArrayList<String>();
    
    if (args.length > 0) {
      String filename = args[0];
      try {
        file = new Scanner(new File(filename));
      } catch (FileNotFoundException e) {
        System.err.println("Cannot locate file.");
        System.exit(-1);
      }
    } else {
      file = new Scanner(System.in);
    }

    while (file.hasNextLine()) {
      String line = file.nextLine();
      fileContents.add(line);
    }
    
    Maze maze = new Maze(fileContents);
    MazeViewer viewer = new MazeViewer(maze);
    MazeLocation currentLocation = maze.getStart();
    maze.solve(currentLocation);

  }
  
}