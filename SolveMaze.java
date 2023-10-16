//hi testing.
/**
 * Calls the methods to solve the maze by having the square navigate from start to finish.
 */
class SolveMaze {
  public Maze maze;

  
  public static void main(String[] args) {
    Maze maze = new Maze();
    MazeViewer viewer = new MazeViewer(maze);
    MazeLocation currentLocation = maze.getStart();
    maze.solve(currentLocation);

    //Solve operation, should I implement this as a method or as just an operation here?

  }



  
}