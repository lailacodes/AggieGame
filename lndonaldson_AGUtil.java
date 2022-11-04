/*
Laila Donaldson
October 2, 2022
COMP 167-001 
This program contains the utilities for the main program, Aggie Game
 */

import java.util.Scanner;

public class lndonaldson_AGUtil {
	static Scanner scnr = new Scanner(System.in);

	// this method creates a boarder
	public static void border() {
		// prints a border
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	} // close border()

	// this method displays a menu of options for user to choose from
	public static void displayMenu() {
		// header for the game with the title included
		border();
		System.out.println("\t   AGGIE GAME");
		border();

		// welcome the user and explain how to play the game
		System.out.println("   Welcome to the Aggie Game! \n   Get four x's in a row\n   to win the game\n");

		// prompt the user to select which game mode they want to play
		System.out.println("\n   Select a Game Mode:");
		// gaming options for users to choose from
		System.out.println("   1) Single Player");
		System.out.println("   2) Two Players");
		System.out.println("   3) How to Play");
		System.out.println("   4) Quit\n");
		border();
	} // close displayMenu()

	// this method displays a goodbye message
	public static void goodbye() {
		// exit message to thank the user for playing the game
		System.out.println("   Thank you for playing the \n   Aggie Game! Goodbye!");
	} // close goodbye()

	// this method is for validation if a user enters the incorrect input
	public static void errorMessage() {
		// error message if user inputs an invalid character
		System.out.println("Invalid input. Please try again.");
	}

	// this method displays the rules for Aggie Game
	public static void gameRules() {
		System.out.println("\t   RULES\n" + "\tPlayer One is x \n   Player Two/Computer is X\n\n"
				+ "1. Each turn players must select a row. \nRows begin at 0 and end at 9\n\n"
				+ "2. Then they must select a column. \nColumns also begin at 0 and end at 9\n\n"
				+ "3. An x will be placed on the given \nrow and column\n\n"
				+ "4. Players will continue to place x's \non the board until one players gets "
				+ "4\nconsective x's on the board\n");
	}
}
