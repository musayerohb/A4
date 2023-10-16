import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Initializes the getters, setters, and attributes making up the characteristics of the maze. Read by the MazeViewer class to have the maze displayed graphically. 
 */
public class Maze implements DisplayableMaze {
    private int height;
    private int width;
    private MazeLocation startPoint;
    private MazeLocation finishPoint;
    private MazeContents[][] mazeContents;
     
    /**
     * The constructor for the maze.
     */
    public Maze(){
        String[] mazeChoice = {"maze1", "maze2"};
        Scanner file = null;
        ArrayList<String> fileContents = new ArrayList<String>();

        //store it first as string array, then use the amount of elements in the list as your height and length of first element as width.
        try {
            file = new Scanner(new File(mazeChoice[1]));
        } catch (FileNotFoundException x) {
            System.err.println("Cannot locate file.");
            System.exit(-1);
        }
        
        while (file.hasNextLine()) {
            String line = file.nextLine();
            fileContents.add(line);
        }
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
        return this.mazeContents[i][j]; 
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
     * Setter for the current coordinate in the 2D Array as a 'visited' location and adds it to the 'path'.
     * @param i (int) The row  of the current coordinate
     * @param k (int) The column of the current coordinate
     * @return The coordinate under the 2D Array
     */
    public MazeContents setContents(int i, int j) {
        this.mazeContents[i][j] = MazeContents.VISITED;
        this.mazeContents[i][j] = MazeContents.PATH;
        return this.mazeContents[i][j];
    }


    public static void main(String args[]) {
        new Maze(); 
    }
}   
