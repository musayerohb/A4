
/**
 * Calls the methods to solve the maze by having the square navigate from start to finish.
 */
class SolveMaze {
  public Maze maze;

  
  public static void main(String[] args) {
    Maze maze = new Maze();
    MazeViewer viewer = new MazeViewer(maze);

    //Solve operation, should I implement this as a method or as just an operation here?
    SolveMaze solveIt = new SolveMaze(maze);

  }

  /**
   * Constructor for the solve method
   * @param maze (Maze) The maze being solved
   */
  public SolveMaze(Maze maze) {
    this.maze = maze;
    MazeLocation currentLocation = maze.getStart();
    this.solve(currentLocation);
    
    //call solve on the start.
  }

  /**
   * Solves the maze by marking the visitied coordinates as visited and by marking the path to the finish point.
   * @param i (int)
   * @param j (int)
   * @param currentLocation (MazeLocation)
   * @return true if the location of the square is the same as the finishing location of the maze, false if not.
   */
  public boolean solve(MazeLocation currentLocation){
    
    if (currentLocation.equals(maze.getFinish())) {
        return true;
    }
    else if (!maze.getContents(currentLocation.getRow(), currentLocation.getCol()).equals(MazeContents.WALL) && !maze.getContents(currentLocation.getRow(), currentLocation.getCol()).equals(MazeContents.VISITED)) {
      this.maze.setContents(currentLocation.getRow(), currentLocation.getCol());
      currentLocation.setRow(currentLocation.getRow()-1);
      solve(currentLocation);
    }
    else if (!maze.getContents(currentLocation.getRow(), currentLocation.getCol()).equals(MazeContents.WALL) && !maze.getContents(currentLocation.getRow(), currentLocation.getCol()).equals(MazeContents.WALL)) {
      this.maze.setContents(currentLocation.getRow(), currentLocation.getCol());
      currentLocation.setCol(currentLocation.getCol()+1);
      solve(currentLocation);
    }
    else if (!maze.getContents(currentLocation.getRow(), currentLocation.getCol()).equals(MazeContents.WALL) && !maze.getContents(currentLocation.getRow(), currentLocation.getCol()).equals(MazeContents.WALL)) {
      this.maze.setContents(currentLocation.getRow(), currentLocation.getCol());
      currentLocation.setRow(currentLocation.getRow()+1);
      solve(currentLocation);
    }
    else if (!maze.getContents(currentLocation.getRow(), currentLocation.getCol()).equals(MazeContents.WALL) && !maze.getContents(currentLocation.getRow(), currentLocation.getCol()).equals(MazeContents.WALL)) {
      this.maze.setContents(currentLocation.getRow(), currentLocation.getCol());
      currentLocation.setCol(currentLocation.getCol()-1);
      solve(currentLocation);
    }
    else{
      //mark dead end.
    }
    return false;
  }

  
}