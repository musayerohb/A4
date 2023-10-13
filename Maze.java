import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze implements DisplayableMaze {
    private int height;
    private int width;
    private MazeLocation startPoint;
    private MazeLocation finishPoint; 

    public Maze(){
        String mazeChoice = "maze1";
        Scanner file = mazeChoice;
        String filename = mazeChoice;
        int i = 0;
        int e = 0;
        int forHeight = 0;

        try {
            file = new Scanner(new File(mazeChoice));
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
        file = new Scanner(new File(mazeChoice));
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String[] mazeVisual = line.split("");
            MazeContents[][] mazeContents = new MazeContents[this.height][this.width];
            forHeight = 0;
            // MazeContents[][] mazeContents = { {MazeContents.WALL, MazeContents.OPEN}};
            for (int w = 0; w < mazeVisual.length; w++) {
                if (mazeVisual[w].equals('#')) {
                    mazeContents[forHeight][w] = MazeContents.WALL;
                }
                else if (mazeVisual[w].equals('.')) {
                    mazeContents[forHeight][w] = MazeContents.OPEN;
                }
            }
            // MazeContents.WALL represents the walls against the star
            // MazeContents.OPEN represents the open space in front of, next to, and/or behind the star
            for (int getSF = 0; getSF < mazeVisual.length; getSF++) {
                if (mazeVisual[getSF].equals('S')) {
                    this.startPoint = new MazeLocation(i, getSF);
                }
                if (mazeVisual[getSF].equals('F')) {
                    this.finishPoint = new MazeLocation(i, getSF);
                }
            }
            i++;
            e++;
        }


        System.out.println(mazeContents.deeptoString());
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
        MazeContents contents = MazeContents.WALL; 
        return contents; 
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
