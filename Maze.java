import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Initializes the getters, setters, and attributes making up the characteristics of the maze. Read by the MazeViewer class to have the maze displayed graphically.
 * @attribute height (int) The number of rows in the maze.
 * @attribute width (int) The number of columns in the maze.
 * @attribute startPoint (MazeLocation) The starting point of the maze.
 * @attribute finishPoint (MazeLocation) The finishing point of the maze.
 * @attribute mazeContents (MazeContents[][]) The characteristics of the square in its current location (the current row & column it's in)
 * @attribute atFinish (bool) Checks if the square is at the finish point of the maze. Returns true if it is, returns false if not.
 */
public class Maze implements DisplayableMaze {
    private int height;
    private int width;
    private MazeLocation startPoint;
    private MazeLocation finishPoint;
    private MazeContents[][] mazeContents;
    private boolean atFinish;
     
    /**
     * The constructor for the maze.
     * @param fileContents (ArrayList<String>) A list containing the contents of a file read in the main method.
     */
    public Maze(ArrayList<String> fileContents){
        this.atFinish = false;

        this.height = fileContents.size();
        this.width = fileContents.get(0).length();

        this.mazeContents = new MazeContents[this.height][this.width];
        
        //i is the row we're in, j is the column we're in
        for (int i = 0; i < fileContents.size(); i++) {
            String[] fileLine = fileContents.get(i).split("");
            for (int j = 0; j < fileLine.length; j++) {
                if (fileLine[j].equals("#")) {
                    mazeContents[i][j] = MazeContents.WALL;
                }
                else if (fileLine[j].equals(".")) {
                    mazeContents[i][j] = MazeContents.OPEN;
                }
                else if (fileLine[j].equals("S")) {
                    mazeContents[i][j] = MazeContents.OPEN;
                    this.startPoint = new MazeLocation(i, j);
                }
                else if (fileLine[j].equals("F")) {
                    mazeContents[i][j] = MazeContents.OPEN;
                    this.finishPoint = new MazeLocation(i, j);
                    
                }
            }

        }
        
    }
    

    /**
     * Getter for the height, or number of rows, in the maze.
     * @return height of maze grid
     */
    public int getHeight() {
        return this.height;
    }
    
    /**
     * Getter for the width, or number of columns, in the maze.
     * @return width of maze grid */
    public int getWidth() {
      return this.width;
    }
    
    /**
     * Getter for location of the square in the maze. 
     * @return contents of maze grid at row i, column j
     */
    public MazeContents getContents(int i, int j) { 
      if(i > mazeContents.length-1 && i < 0) {
        return MazeContents.WALL;
      }
      else if (j > mazeContents.length-1 && j < 0){
        return MazeContents.WALL;
      }
        return this.mazeContents[i][j]; 
    }
    
    /**
     * Overloaded getter method for location of a square in the maze.
     * @param ij (MazeLocation) The location of a square in the maze. 
     * @return contents of maze grid at row i, column j
     */
    public MazeContents getContents(MazeLocation ij) {
        return this.mazeContents[ij.getRow()][ij.getCol()];
    }


    /**
     * Getter for the starting location of the maze.
     * @return location of maze start point
     */
    public MazeLocation getStart() {
        return this.startPoint;
    }
    
    /**
     * Getter for the point of the end of the maze.
     * @return location of maze finish point
     */
    public MazeLocation getFinish() {
        return this.finishPoint;
    }

    /**
     * Setter for the current 'visited' coordinates in the 2D Array, adding it to the 'path'.
     * @param i (int) The row  of the current coordinate
     * @param k (int) The column of the current coordinate
     * @return The coordinate under the 2D Array
     */
    public MazeContents setContents(int i, int j) {
        this.mazeContents[i][j] = MazeContents.PATH;
        return this.mazeContents[i][j];
    }
    
    
   /**
   * Solves the maze by marking the visitied coordinates as visited and by marking the path to the finish point.
   * @param currentLocation (MazeLocation) The location of the square that is being marked
   * @return true if the current location of the square is the same as the finishing location of the maze, false if not. Returns the solve method if the square can move anywhere else, and false if not (dead end).
   */
  public boolean solve(MazeLocation currentLocation){
    try { Thread.sleep(10);	} catch (InterruptedException e) {};
    mazeContents[currentLocation.getRow()][currentLocation.getCol()] = MazeContents.VISITED;

    if (currentLocation.equals(this.getFinish()) || atFinish == true) {
        atFinish = true;
        mazeContents[this.startPoint.getRow()][this.startPoint.getCol()] = MazeContents.PATH;
        return true;
    }

    else if (this.getContents(currentLocation.neighbor(MazeDirection.NORTH)).equals(MazeContents.OPEN)) {
      boolean seeIfExplorable = solve(currentLocation.neighbor(MazeDirection.NORTH));
      if (seeIfExplorable == false) {
        return solve(currentLocation);
      }
      else {
        mazeContents[currentLocation.getRow()][currentLocation.getCol()] = MazeContents.PATH;
        mazeContents[currentLocation.neighbor(MazeDirection.NORTH).getRow()][currentLocation.neighbor(MazeDirection.NORTH).getCol()] = MazeContents.PATH;
      }
    }
    else if (this.getContents(currentLocation.neighbor(MazeDirection.EAST)).equals(MazeContents.OPEN)) {
      boolean seeIfExplorable = solve(currentLocation.neighbor(MazeDirection.EAST));
      if (seeIfExplorable == false) {
        return solve(currentLocation);
      }
      else {
        mazeContents[currentLocation.getRow()][currentLocation.getCol()] = MazeContents.PATH;
        mazeContents[currentLocation.neighbor(MazeDirection.EAST).getRow()][currentLocation.neighbor(MazeDirection.EAST).getCol()] = MazeContents.PATH;
      }
    }
    else if (this.getContents(currentLocation.neighbor(MazeDirection.SOUTH)).equals(MazeContents.OPEN)) {
      boolean seeIfExplorable = solve(currentLocation.neighbor(MazeDirection.SOUTH));
      if (seeIfExplorable == false) {
        return solve(currentLocation);
      }
      else {
        mazeContents[currentLocation.getRow()][currentLocation.getCol()] = MazeContents.PATH;
        mazeContents[currentLocation.neighbor(MazeDirection.SOUTH).getRow()][currentLocation.neighbor(MazeDirection.SOUTH).getCol()] = MazeContents.PATH;
      }
    }
    else if (this.getContents(currentLocation.neighbor(MazeDirection.WEST)).equals(MazeContents.OPEN)) {
      boolean seeIfExplorable = solve(currentLocation.neighbor(MazeDirection.WEST));
      if (seeIfExplorable == false) {
        return solve(currentLocation);
      }
      else {
        mazeContents[currentLocation.getRow()][currentLocation.getCol()] = MazeContents.PATH;
        mazeContents[currentLocation.neighbor(MazeDirection.WEST).getRow()][currentLocation.neighbor(MazeDirection.WEST).getCol()] = MazeContents.PATH;
      }
    }
    else {
      mazeContents[currentLocation.getRow()][currentLocation.getCol()] = MazeContents.DEAD_END;
      return false;
    }
    return false;
  }

}   
