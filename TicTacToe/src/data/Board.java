package data;

/**
 * Interaction with the board of tic tac toe.
 * @author Ethan Treece
 *
 */
public class Board {
    
    /** Tic tac toe board */
    private String[] board;
    
    /** Number of values currently on the board */
    private int size;
    
    
    /**
     * Constructs the board
     */
    public Board() {
        board = new String[] { "1", "2", "3", 
                            "4", "5", "6", 
                            "7", "8", "9" };
        size = 0;
    }
    
    public void printBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append("|---|---|---|\n");
        
        sb.append("|-");
        sb.append(board[0]);
        sb.append("-|-");
        sb.append(board[1]);
        sb.append("-|-");
        sb.append(board[2]);
        sb.append("-|\n");

        sb.append("|-----------|\n");
        
        sb.append("|-");
        sb.append(board[3]);
        sb.append("-|-");
        sb.append(board[4]);
        sb.append("-|-");
        sb.append(board[5]);
        sb.append("-|\n");

        sb.append("|-----------|\n");
        
        sb.append("|-");
        sb.append(board[6]);
        sb.append("-|-");
        sb.append(board[7]);
        sb.append("-|-");
        sb.append(board[8]);
        sb.append("-|\n");

        sb.append("|---|---|---|\n");
        
        System.out.println(sb.toString());
    }
    
    /**
     * Adds an "X" to the board
     * @param pos position on the board
     */
    public void addX(int pos) {
        if (!isValid(pos)) {
            throw new IllegalArgumentException("Please choose a different spot.");
        }
        board[pos - 1] = "X";
        size++;
    }

    /**
     * Adds an "O" to the board
     * @param pos position on the board
     */
    public void addO(int pos) {
        if (!isValid(pos)) {
            throw new IllegalArgumentException("Please choose a different spot.");
        }
        board[pos - 1] = "O";
        size++;
    }
    
    /**
     * Returns the number of values in the board
     * @return
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Checks if the board has a winner, returns the result as a string
     * @return
     */
    public String isWinner() {
        
        for (int i = 0; i < 8; i++) {
            
            String line = null;
            
            switch (i) {
            case 0:
                line = board[0] + board[1] + board[2];
                break;
            case 1:
                line = board[3] + board[4] + board[5];
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                break;  
            }
            
            if ("OOO".equals(line)) {
                return "O";
            } else if ("XXX".equals(line)) {
                return "X";
            }
        }
        
        if (size == 9) {
            return "draw";
        } else {
            return null;
        }
    }
    
    /**
     * Checks if the current position of the board is a valid space.
     * @param x x position
     * @param y y position
     * @return if the position on the board is not equal to 1-9, than it"s already been taken
     */
    private boolean isValid(int pos) {
        return board[pos - 1].equals(String.valueOf(pos));
    }
    
    
    
}
