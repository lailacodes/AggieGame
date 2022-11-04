/*
Laila Donaldson
October 2, 2022
COMP 167-001 
This program contains the business rule for the main program, Aggie Game, 
and is responsible for displaying the board and checking whether the players' win
 */

public class lndonaldson_AGBRule {

	// This method will create a 10x10 board for the game
	public static void printBoard(char[][] gameBoard) {
		// Print the layout for the game board
		for (int i = 0; i < gameBoard.length; i++) {
			// Prints each row of the board
			for (int j = 0; j < gameBoard[i].length; j++) {
				System.out.print(" " + gameBoard[i][j]);
			} // close inner loop
			// put each row on a separate line
			System.out.println();
		} // close outer loop
		System.out.println();
	} // close printBoard() method

	// this method checks if player one has gotten four consecutive x's
	public static boolean playerOneWin(char[][] gameBoard) {
		// will count the number of x's each player has consecutively
		int playerOneXs = 0;

		// checks if 4 x's are aligned horizontally
		// read through the row
		for (int i = 0; i < gameBoard.length; i++) {
			// read through the columns for consecutive x's
			for (int j = 0; j < 10; j++) {
				if (gameBoard[i][j] == 'x') {
					playerOneXs++;
				} // close if

				else {
					playerOneXs = 0;
				} // close else

				if (playerOneXs == 4) {
					lndonaldson_AGUtil.border();
					System.out.println("\tPlayer One Wins!");
					lndonaldson_AGUtil.border();

					return true;
				} // close if
			} // close inner for
		} // close outer for

		// checks if 4 x's are aligned vertically
		// read through the column
		for (int i = 0; i < gameBoard.length; i++) {
			// read through the rows for consecutive x's
			for (int j = 0; j < 10; j++) {
				if (gameBoard[j][i] == 'x') {
					playerOneXs++;
				} // close if

				else {
					playerOneXs = 0;
				} // close else

				if (playerOneXs == 4) {
					lndonaldson_AGUtil.border();
					System.out.println("\tPlayer One Wins!");
					lndonaldson_AGUtil.border();

					return true;
				} // close if
			} // close inner for
		} // close out for

		// checks if 4 x's are aligned ascending diagonally
		for (int i = 0; i < 10; i++) {
			if (gameBoard[i][i] == 'x') {
				playerOneXs++;
			} // close if

			else {
				playerOneXs = 0;
			} // close else

			if (playerOneXs == 4) {
				lndonaldson_AGUtil.border();
				System.out.println("\tPlayer One Wins!");
				lndonaldson_AGUtil.border();

				return true;
			} // close if
		} // close for

		// checks if 4 x's are aligned descending diagonally

		for (int i = 0; i < 10; i++) {
			if (gameBoard[i][gameBoard.length - 1 - i] == 'x') {
				playerOneXs++;
			} // close if

			else {
				playerOneXs = 0;
			} // close else

			if (playerOneXs == 4) {
				lndonaldson_AGUtil.border();
				System.out.println("\tPlayer One Wins!");
				lndonaldson_AGUtil.border();

				return true;
			} // close if
		} // close for

		return false;

	} // close playerOneWin() method

	// this method checks if player two has gotten four consecutive x's
	public static boolean playerTwoWin(char[][] gameBoard) {
		// will count the number of x's each player has consecutively
		int playerTwoXs = 0;

		// checks if 4 x's are aligned horizontally
		// read through the row
		for (int i = 0; i < gameBoard.length; i++) {
			// read through the columns for consecutive x's
			for (int j = 0; j < 10; j++) {
				if (gameBoard[i][j] == 'X') {
					playerTwoXs++;
				} // close if

				else {
					playerTwoXs = 0;
				} // close else

				if (playerTwoXs == 4) {
					lndonaldson_AGUtil.border();
					System.out.println("\tPlayer Two Wins!");
					lndonaldson_AGUtil.border();

					return true;
				} // close if
			} // close inner for
		} // close outer for

		// checks if 4 x's are aligned vertically
		// read through the column
		for (int i = 0; i < gameBoard.length; i++) {
			// read through the rows for consecutive x's
			for (int j = 0; j < 10; j++) {
				if (gameBoard[j][i] == 'X') {
					playerTwoXs++;
				} // close if

				else {
					playerTwoXs = 0;
				} // close else

				if (playerTwoXs == 4) {
					lndonaldson_AGUtil.border();
					System.out.println("\tPlayer Two Wins!");
					lndonaldson_AGUtil.border();

					return true;
				} // close if
			} // close inner for
		} // close outer for

		// checks if 4 x's are aligned ascending diagonally
		for (int i = 0; i < 10; i++) {
			if (gameBoard[i][i] == 'x') {
				playerTwoXs++;
			} // close if

			else {
				playerTwoXs = 0;
			} // close else

			if (playerTwoXs == 4) {
				lndonaldson_AGUtil.border();
				System.out.println("\tPlayer Two Wins!");
				lndonaldson_AGUtil.border();

				return true;
			} // close if
		} // close for

		// checks if 4 x's are aligned descending diagonally
		for (int i = 0; i < 10; i++) {
			if (gameBoard[i][gameBoard.length - i - 1] == 'x') {
				playerTwoXs++;
			} // close if

			else {
				playerTwoXs = 0;
			} // close else

			if (playerTwoXs == 4) {
				lndonaldson_AGUtil.border();
				System.out.println("\tPlayer Two Wins!");
				lndonaldson_AGUtil.border();

				return true;
			} // close if
		} // close for

		return false;

	} // close playerTwoWin() method

} // close class
