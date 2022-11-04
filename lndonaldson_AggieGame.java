/*
Laila Donaldson
October 2, 2022
COMP 167-001 
This program creates a game that allows players to place x's on a 10x10 board
until one play manages to place 4 consecutive x's on the board
 */

import java.util.Random;
import java.util.Scanner;

public class lndonaldson_AggieGame {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		// declaring the number of rows and columns as constant
		final int ROWS = 10;
		final int COLUMNS = 10;

		// array which represents the dimensions of the game board (10 x 10)
		char[][] gameBoard = new char[ROWS][COLUMNS];

		// Creating the initial board, placing dashes as a placeholder for each space on
		// the board
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				gameBoard[i][j] = '-';
			} // close inner loop
		} // close outer loop

		boolean menuDisplay = true; // Indicates whether the menu is being displayed
		boolean error = false; // Indicates whether an error has been found
		boolean gameOver = false; // Indicates whether the game is in progress

		boolean playerOneMove = true; // Indicates that it's player one's turn
		boolean playerTwoMove = false; // Indicates that it's player two's turn

		char playerMove = 'x'; // character that indicates which player is which

		int row; // user will input a row for placement of the x
		int column; // user will input a row for placement of the x

		// display the menu until the character starts the game or chooses to quit
		do {
			lndonaldson_AGUtil.displayMenu();

			// enable user to pick an option
			int option = scnr.nextInt();

			switch (option) {
			default: // validation for if a user enters the incorrect menu input
				if (option != 1 && option != 2 && option != 3 && option != 4) {
					// error is found
					error = true;

					// error message will display until the user chooses a valid input
					while (error == true) {
						lndonaldson_AGUtil.errorMessage();

						System.out.print("\nSelect an option between 1-4 to return to the menu: ");
						// enable user to input another option
						option = scnr.nextInt();

						// when user chooses a valid option, the error loop breaks
						if (option == 1 || option == 2 || option == 3 || option == 4) {
							error = false;
							break;
						} // close error correction condition

					} // close error while loop

				} // close error condition
				break;

			case 4: // option 4 : quit the game
				// displays the exit message when the user chooses to quit
				lndonaldson_AGUtil.goodbye();
				menuDisplay = false;
				break;

			case 3: // option 3 : display the rules of the game
				lndonaldson_AGUtil.gameRules();
				break;

			case 2: // option 2 : two player mode
				menuDisplay = false;

				// display the game board to the user(s)
				lndonaldson_AGBRule.printBoard(gameBoard);

				// game will begin under the condition that the game is not over
				while (gameOver == false) {

					// it's player one's turn
					do {
						System.out.print("Player One: Select a row: ");
						row = scnr.nextInt();

						// input validation for row input
						if (row < 0 || row > 9) {
							error = true;

							// while the row input is incorrect
							while (error == true) {
								lndonaldson_AGUtil.errorMessage();

								// user must enter another input until valid input is given
								row = scnr.nextInt();
								if (row > 0 && row < 10) {
									error = false;
								} // close if
							} // close error validation loop
						} // close error conditional

						System.out.print("Player One: Select a column: ");
						column = scnr.nextInt();

						// input validation for column input
						if (column < 0 || column > 9) {
							error = true;

							// while the row input is incorrect
							while (error == true) {
								lndonaldson_AGUtil.errorMessage();

								// user must enter another input until valid input is given
								column = scnr.nextInt();
								if (column > 0 && column < 10) {
									error = false;
								} // close if
							} // close error validation loop
						} // close error conditional

						System.out.println();

						// if it's the player one's turn, an x will be placed on the board instead of an
						// x
						if (playerOneMove == true) {
							playerMove = 'x';
						}

						// add an x to the given place on the board
						gameBoard[row][column] = playerMove;
						lndonaldson_AGBRule.printBoard(gameBoard);

						// if four consecutive x's are found, game is over, player one wins
						if (lndonaldson_AGBRule.playerOneWin(gameBoard) == true) {
							gameOver = true; // game has ended
							playerOneMove = false; // player one can no longer make a move
							playerTwoMove = false; // player two can no longer make a move

						} else {
							playerOneMove = false; // player one has finished his/her turn
							playerTwoMove = true; // player two's turn

						} // close else

					} // closes player one turn's conditional
					while (playerOneMove == true);

					if (playerTwoMove == true)
						// it's the player two's turn
						do {
							System.out.print("Player Two: Select a row: ");
							row = scnr.nextInt();

							// input validation for row input
							if (row < 0 || row > 9) {
								error = true;

								// while the row input is incorrect
								while (error == true) {
									lndonaldson_AGUtil.errorMessage();

									// user must enter another input until valid input is given
									row = scnr.nextInt();
									if (row > 0 && row < 10) {
										error = false;
									} // close if
								} // close error validation loop
							} // close error conditional

							System.out.print("Player Two: Select a column: ");
							column = scnr.nextInt();

							// input validation for column input
							if (column < 0 || column > 9) {
								error = true;

								// while the row input is incorrect
								while (error == true) {
									lndonaldson_AGUtil.errorMessage();

									// user must enter another input until valid input is given
									column = scnr.nextInt();
									if (column > 0 && column < 10) {
										error = false;
									} // close if
								} // close error validation loop
							} // close error conditional

							System.out.println();

							// if it's the player two's turn, an X will be placed on the board instead of an
							// x
							if (playerTwoMove == true) {
								playerMove = 'X';
							}

							// add an x to the given place on the board
							gameBoard[row][column] = playerMove;

							lndonaldson_AGBRule.printBoard(gameBoard);
							// if four consecutive x's are found, game is over, the player two wins
							if (lndonaldson_AGBRule.playerTwoWin(gameBoard) == true) {
								gameOver = true;
								playerOneMove = false;
								playerTwoMove = false;

							} else {
								// player two has finished its turn
								playerTwoMove = false;

								playerOneMove = true;
							}

						} // close player two's turn conditional
						while (playerTwoMove == true);

					if (playerOneMove == false && playerTwoMove == false) {
						gameOver = true;
					}
				} // closes gameOver condition
				break;

			case 1: // option 1 : single player mode
				menuDisplay = false;

				// display the game board to the user(s)
				lndonaldson_AGBRule.printBoard(gameBoard);

				// game will begin under the condition that the game is not over
				while (gameOver == false) {

					// it's player one's turn
					do {
						System.out.print("Player One: Select a row: ");
						row = scnr.nextInt();

						// input validation for row input
						if (row < 0 || row > 9) {
							error = true;

							// while the row input is incorrect
							while (error == true) {
								lndonaldson_AGUtil.errorMessage();

								// user must enter another input until valid input is given
								row = scnr.nextInt();
								if (row > 0 && row < 10) {
									error = false;
								} // close if
							} // close error validation loop
						} // close error conditional

						System.out.print("Player One: Select a column: ");
						column = scnr.nextInt();

						// input validation for column input
						if (column < 0 || column > 9) {
							error = true;

							// while the row input is incorrect
							while (error == true) {
								lndonaldson_AGUtil.errorMessage();

								// user must enter another input until valid input is given
								column = scnr.nextInt();
								if (column > 0 && column < 10) {
									error = false;
								} // close if
							} // close error validation loop
						} // close error conditional

						System.out.println();

						// if it's the player one's turn, an x will be placed on the board instead of an
						// x
						if (playerOneMove == true) {
							playerMove = 'x';
						}
						// add an x to the given place on the board
						gameBoard[row][column] = playerMove;
						lndonaldson_AGBRule.printBoard(gameBoard);

						// if four consecutive x's are found, game is over, player one wins
						if (lndonaldson_AGBRule.playerOneWin(gameBoard) == true) {
							gameOver = true; // game has ended
							playerOneMove = false; // player one can no longer make a move
							playerTwoMove = false; // computer can no longer make a move

						} else {
							playerOneMove = false; // player one has finished his/her turn
							playerTwoMove = true; // computer's turn

						} // close else

					} // closes player one turn's conditional
					while (playerOneMove == true);

					if (playerTwoMove == true)
						// it's the computer's turn
						do {
							lndonaldson_AGUtil.border();
							System.out.println("\nComputer's Turn: \n");
							Random rand = new Random();

							// computer will place x on a random place on the board
							int rand_row = rand.nextInt(10);
							int rand_column = rand.nextInt(10);

							// if it's the computer's turn, an X will be placed on the board instead of an x
							if (playerTwoMove == true) {
								playerMove = 'X';
							}

							// add an x to the given place on the board
							gameBoard[rand_row][rand_column] = playerMove;

							lndonaldson_AGBRule.printBoard(gameBoard);
							// if four consecutive x's are found, game is over, the computer wins
							if (lndonaldson_AGBRule.playerTwoWin(gameBoard) == true) {
								gameOver = true;
								playerOneMove = false;
								playerTwoMove = false;

							} else {
								// the computer has finished its turn
								playerTwoMove = false;

								playerOneMove = true;
							}

						} // close computer's turn conditional
						while (playerTwoMove == true);

					if (playerOneMove == false && playerTwoMove == false) {
						gameOver = true;
					}
				} // closes gameOver condition
				break;
			} // close menuDisplay conditional
		} while (menuDisplay == true);

		scnr.close();
	}// close main

}// close class
