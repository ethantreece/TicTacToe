package ui;

import java.util.Scanner;

import data.Board;

public class ConsoleUI {

    public static void main(String[] args) {
        
        String turn = "X";
        
        System.out.println("Welcome to Tic-Tac-Toe. Here is what the board looks like. The\n"
                         + "player who's turn it is will enter a number corresponding to the\n"
                         + "position they would like to slot. Good luck!");
        Board board = new Board();
        Scanner s = new Scanner(System.in);
        String input = "";
        while (board.isWinner() == null) {
            board.printBoard();
            System.out.println("It is " + turn + "'s turn, please enter a position (1-9).");
            input = s.nextLine();
            if (!"123456789".contains(input)) {
                System.out.println("Please enter a valid position (1-9)");
                input = s.nextLine();
                continue;
            }
            if ("X".equals(turn)) {
                try {
                    board.addX(Integer.parseInt(input));
                    turn = "O";
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                try {
                    board.addO(Integer.parseInt(input));
                    turn = "X";
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            }
        }
        
        board.printBoard();
        
        if ("X".equals(board.isWinner())) {
            System.out.println("The winner is X!");
        } else if ("O".equals(board.isWinner())) {
            System.out.println("The winner is O!");
        } else if ("draw".equals(board.isWinner())) {
            System.out.println("The game is a draw.");
        }
        
    }

}
