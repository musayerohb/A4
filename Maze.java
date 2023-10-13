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
        String[] mazeChoice = {"maze1"};
        Scanner file = null;
        String filename = (mazeChoice.length > 0) ? mazeChoice[0] : mazeChoice[0];
        int e = 0;
        int forHeight = 0;

        try {
            file = new Scanner(new File(mazeChoice[0]));
        } catch (FileNotFoundException x) {
            System.err.println("Cannot locate file.");
            System.exit(-1);
        }
        
        String[] forObtainingWidth = file.nextLine().split("");
        forHeight++;
        int forWidth = forObtainingWidth.length;
        
        //For getting height
        while (file.hasNextLine()) {
            String line = file.nextLine();
            forHeight++;
        }
            //Where do we incorporate this??
        
        this.height = forHeight;
        this.width = forWidth;
            //For every pound symbol, should add a wall
            //MazeContents[][] mazeContents.append(MazeContents.WALL);
            //For every period, should add open to array
            //MazeContents[][] mazeContents.append(MazeContents.OPEN);
        //Reopens file and starts creating 2d array maze.
        try {
            file = new Scanner(new File(mazeChoice[0]));
        } catch (FileNotFoundException x) {
            System.err.println("Cannot locate file.");
            System.exit(-1);
        }
        this.mazeContents = new MazeContents[this.height][this.width];
        char[][] viewMazeContents = new char[this.height][this.width];
        
        while (file.hasNextLine()) {
            String line = file.nextLine();
            char[] mazeVisual = line.toCharArray();
            forHeight = 0;
            // MazeContents[][] mazeContents = { {MazeContents.WALL, MazeContents.OPEN}};
            for (int w = 0; w < mazeVisual.length; w++) {
                // mazeContents[forHeight][Arrays.binarySearch(mazeVisual, "#")];
                if (mazeVisual[w] == '#') {
                    mazeContents[forHeight][w] = MazeContents.WALL;
                    viewMazeContents[forHeight][w] = mazeVisual[w];
                }
                else if (mazeVisual[w] == '.') {
                    mazeContents[forHeight][w] = MazeContents.OPEN;
                    viewMazeContents[forHeight][w] = mazeVisual[w];
                }
            }
            
            for (int getSF = 0; getSF < mazeVisual.length; getSF++) {
                if (mazeVisual[getSF] == 'S') {
                    this.startPoint = new MazeLocation(e, getSF);
                    viewMazeContents[forHeight][getSF] = mazeVisual[getSF];
                }
                if (mazeVisual[getSF] == 'F') {
                    this.finishPoint = new MazeLocation(e, getSF);
                    viewMazeContents[forHeight][getSF] = mazeVisual[getSF];
                }
            }
            e++;
        }
        System.out.println(viewMazeContents.toString());
        // read thing, parse thing, as u parse, translate that to the new array.
        
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
