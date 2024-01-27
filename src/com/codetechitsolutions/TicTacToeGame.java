package com.codetechitsolutions;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    
    public static void main(String[] args) {
	char[][] board = {{' ',' ',' '}, {' ',' ',' '}, {' ',' ',' '}};
	
	printBoard(board);
	
	while(true) {
	    playersTurn(board);
	    if(isGameFinished(board)) {
		break;
	    }
	    printBoard(board);
	    computersTurn(board);
	    if(isGameFinished(board)) {
		break;
	    }
	    printBoard(board);
	}
    }
    
    // This method is used to print the board of the game.
    private static void printBoard(char[][] board) {
	System.out.print(board[0][0]);
	System.out.print("|");
	System.out.print(board[0][1]);
	System.out.print("|");
	System.out.println(board[0][2]);
	System.out.println("-----");
	System.out.print(board[1][0]);
	System.out.print("|");
	System.out.print(board[1][1]);
	System.out.print("|");
	System.out.println(board[1][2]);
	System.out.println("-----");
	System.out.print(board[2][0]);
	System.out.print("|");
	System.out.print(board[2][1]);
	System.out.print("|");
	System.out.println(board[2][2]);
    }
    
    // This method is used to place a move of a player
    private static void placeMove(char[][] board, String position, char symbol) {
	switch(position) {
	case "1": board[0][0] = symbol; break;
	case "2": board[0][1] = symbol; break;
	case "3": board[0][2] = symbol; break;
	case "4": board[1][0] = symbol; break;
	case "5": board[1][1] = symbol; break;
	case "6": board[1][2] = symbol; break;
	case "7": board[2][0] = symbol; break;
	case "8": board[2][1] = symbol; break;
	case "9": board[2][2] = symbol; break;
	default: System.out.println("Invalid move");
	}
    }
    
    // This method is used to check if the move is a valid move
    private static boolean isValidMove(char[][] board, String position) {
	switch(position) {
	case "1": return (board[0][0] == ' '); 
	case "2": return (board[0][1] == ' ');
	case "3": return (board[0][2] == ' ');
	case "4": return (board[1][0] == ' ');
	case "5": return (board[1][1] == ' ');
	case "6": return (board[1][2] == ' ');
	case "7": return (board[2][0] == ' ');
	case "8": return (board[2][1] == ' ');
	case "9": return (board[2][2] == ' ');
	default: return false;
	}
    }
    
    // This method is used to perform player's turn
    private static void playersTurn(char[][] board) {
	Scanner sc = new Scanner(System.in);
	String input;
	
	while(true) {
	    System.out.println("Enter your move:");
	    input = sc.nextLine();
	    
	    if(isValidMove(board, input)) {
		break;
	    } else {
		System.out.println("Invalid move.");
	    }
	}
	placeMove(board, input, 'X');
    }
    
    // This method is used to perform computer's turn
    private static void computersTurn(char[][] board) {
	Random num = new Random();
	int move;
	
	while(true) {
	    move = num.nextInt(9) + 1;
	    if(isValidMove(board, Integer.toString(move))) {
		break;
	    }
	}
	
	System.out.println("Computer's move: "+move);
	placeMove(board, Integer.toString(move), '0');
    }
    
    // This method is used to check if the game is finished or not
    private static boolean isGameFinished(char[][] board) {
	
	if(isWinner(board, 'X')) {
	    printBoard(board);
	    System.out.println("Player is winner!");
	    return true;
	}
	
	if(isWinner(board, '0')) {
	    printBoard(board);
	    System.out.println("Computer is winner!");
	    return true;
	}
	
	for(int i = 0; i < board.length; i++) {
	    for(int j = 0; j < board[i].length; j++) {
		if(board[i][j] == ' ') {
		    return false;
		}
	    }
	}
	
	printBoard(board);
	System.out.println("The game is draw!");
	return true;
    }
    
    // This method is used to check the winner of the game
    private static boolean isWinner(char[][] board, char symbol) {
	
	if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
		(board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
		(board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||
		(board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
		(board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
		(board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||
		(board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
		(board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
		    return true;
		}
	
	return false;
    }
}
