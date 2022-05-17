package data;

/**
 * Interaction with the board of tic tac toe.
 * @author Ethan Treece
 *
 */
public class Board {

    /** Tic tac toe board */
    private char[][] board;
    
    /** Number of values currently on the board */
    private int size;
    
    
    /**
     * Constructs the board
     */
    public Board() {
        board = new char[3][3];
        size = 0;
    }
    
    /**
     * Adds an 'X' to the board
     * @param x x position
     * @param y y position
     */
    public void addX(int x, int y) {
        if (!isValid(x, y)) {
            throw new IllegalArgumentException("Please choose a different spot.");
        }
        board[x][y] = 'X';
        size++;
    }

    /**
     * Adds an 'O' to the board
     * @param x x position
     * @param y y position
     */
    public void addO(int x, int y) {
        if (!isValid(x, y)) {
            throw new IllegalArgumentException("Please choose a different spot.");
        }
        board[x][y] = 'O';
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
        // Checking horizontals
        for (int i = 0; i < 3; i++) {
            String line = "";
            line += board[i][0];
            line += board[i][1];
            line += board[i][2];
            if ("XXX".equals(line)) {
                return "X wins!";
            } else if ("OOO".equals(line)) {
                return "O wins!";
            }
        }
        // Checking verticals
        for (int i = 0; i < 3; i++) {
            String line = "";
            line += board[0][i];
            line += board[1][i];
            line += board[2][i];
            if ("XXX".equals(line)) {
                return "X wins!";
            } else if ("OOO".equals(line)) {
                return "O wins!";
            }
        }
        // Checking slashes
        String line = "";
        line += board[0][0];
        line += board[1][1];
        line += board[2][2];
        if ("XXX".equals(line)) {
            return "X wins!";
        } else if ("OOO".equals(line)) {
            return "O wins!";
        }
        
        line = "";
        line += board[0][2];
        line += board[1][1];
        line += board[2][0];
        if ("XXX".equals(line)) {
            return "X wins!";
        } else if ("OOO".equals(line)) {
            return "O wins!";
        }
        
        if (size == 9) {
            return "Draw.";
        } else {
            return "Continue.";
        }
        
    }
    
    /**
     * Checks if the current position of the board is a valid space.
     * @param x x position
     * @param y y position
     * @return if the position on the board is not equal to 0, than it's already been taken
     */
    private boolean isValid(int x, int y) {
        return board[x][y] == 0;
    }
    
    
    
}
