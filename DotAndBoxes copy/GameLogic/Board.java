package GameLogic;

/**
 * Represents the game board for a Dot and Boxes game.
 */

public class Board {
    //Counter to keep track of the number of boxes each player has completed
    //Used to determine who the player is (the one who has more boxes win)
    public static int[][][] cellsArray;
    public static boolean[] edgesArray;
   public static int DIM = 3;
   private static final String SPACE = "     ";
   private static final String BOX = "      ";

   private static final String RED = "\u001B[31m";
   private static final String BLUE = "\u001B[34m";
   private static final String DEFAULT = "\u001B[0m";
    public static int playerOneBoxes = 0;
    public static int playerTwoBoxes = 0;

    //size of the grid: the number of cells in a row
    public static final int gridSize = 5;

    //Used to determine when the game is over
    public static int totalBoxesNumber = gridSize*gridSize;

    /**
     * Sets up the grid for the game board with given cellsArray.
     *
     * @param cellsArray The array representing the game board.
     */

    public static void setupGrid(int [] [] [] cellsArray){
        //To go through each row
        for (int rowIdx = 0; rowIdx <gridSize; rowIdx++){
            //To go through each column
            for (int columnIdx = 0; columnIdx<gridSize; columnIdx++){
                //Values are for a 5*5 grid
                //Calculating the indices to match the figure of the dot and boxes game given
                int topEgdeIdx = rowIdx * 11 + columnIdx;
                int bottomEdgeIdx = topEgdeIdx + 11;
                int leftEdgeIdx = 5 + (11*rowIdx) + columnIdx;
                int rightEdgeIdx = leftEdgeIdx +1;

                //Cell array: top edge, left edge, right edge and bottom edge
                cellsArray[rowIdx][columnIdx][0] = topEgdeIdx;
                cellsArray[rowIdx][columnIdx][1] = leftEdgeIdx;
                cellsArray[rowIdx][columnIdx][2] = rightEdgeIdx;
                cellsArray[rowIdx][columnIdx][3] = bottomEdgeIdx;
            }
        }
    }

    /**
     * Counts and returns the number of filled boxes on the game board.
     *
     * @param cellsArray The array representing the game board.
     * @param edgesArray The array representing the filled edges.
     * @return The number of filled boxes.
     */
    public static int getNumberFilledBoxes(int[][][] cellsArray, boolean[] edgesArray){
        //Counter for the filed boxes
        int boxesCounter = 0;

        for(int rowIdx = 0; rowIdx <gridSize; rowIdx++){
            for (int columnIdx = 0; columnIdx<gridSize; columnIdx++){
                //Extract the indices from the edges of the current box
                int topIdx = cellsArray[rowIdx][columnIdx][0];
                int leftIdx = cellsArray[rowIdx][columnIdx][1];
                int rightIdx = cellsArray[rowIdx][columnIdx][2];
                int bottomIdx = cellsArray[rowIdx][columnIdx][3];

                //True indicates that the edge is filled, so if the four edges are filled (true) it will add +1 to the counter
                if(edgesArray[topIdx] && edgesArray[leftIdx] && edgesArray[rightIdx] && edgesArray[bottomIdx]){
                    boxesCounter++;
                }
            }
        }
        return boxesCounter;
    }
    public String toString(){
        return String.valueOf(cellsArray[0][0][0]);
    }
}