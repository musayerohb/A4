import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Maze implements DisplayableMaze {
    private int height;
    private int width;
    private MazeLocation startPoint;
    private MazeLocation finishPoint;
    private MazeContents[][] mazeContents;
     

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

    /** @return height of maze grid */
    public int getHeight() {
        return this.height;
    }
    
    /** @return width of maze grid */
    public int getWidth() {
      return this.width;
    }
    
    /** @return contents of maze grid at row i, column j */
    public MazeContents getContents(int i, int j) { 
        return this.mazeContents[i][j]; 
    }
    
    /** @return location of maze start point */
    public MazeLocation getStart() {
        return this.startPoint;
    }
    
    /** @return location of maze finish point */
    public MazeLocation getFinish() {
        return this.finishPoint;
    }


    public static void main(String args[]) {
        new Maze(); 
    }
}   
