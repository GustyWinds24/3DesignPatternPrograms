package stateApp;

import java.util.Scanner;

/**
 * Fantasy Warrior program where the user can act like a real RPG character and change their class
 * @author GustyWinds24
 */
public class FantasyWarriorMain {

	public static FantasyWarriorWidget widget;
	
	/**
	 * required main method for java programs
	 * @param args common argument for java programs
	 */
	public static void main(String[] args) {
		beginFantasyWarriorText();
		
		widget = new FantasyWarriorWidget();
		
		runFantasyWarrior();
	}
	
	private static void beginFantasyWarriorText() {
		System.out.println("Welcome to Fantasy Warrior! This program simulates an rpg character by");
		System.out.println("allowing the player to switch out their class and try out their moves ");
		System.out.println("against a designated enemy. Have fun and don't die! Below are the commands.");
		System.out.println("---------------------------------------------------------------------------");
		
		showCommandList();
	}
	
	private static void runFantasyWarrior() {
		Scanner commandInput;
		boolean continueProgram;
		
		commandInput = new Scanner(System.in);
		continueProgram = true;
		
		System.out.println("Insert a command below:");
		while(continueProgram) {
			continueProgram = getCommands(commandInput);
		}
		System.out.println("Play again sometime!");
		
		commandInput.close();
	}
	
	private static boolean getCommands(Scanner commandInput) {
		String givenCommand = commandInput.next().toLowerCase();
		boolean userWantsToContinueCooking;
		
		userWantsToContinueCooking = UserCommands.executeGivenCommand(givenCommand);
		
		return userWantsToContinueCooking;
	}
	
	/**
	 * Use when forgot about commands
	 */
	public static void showCommandList() {
		System.out.println("Commands");
		System.out.println("---------------------------------------------");
		System.out.println("attack  - Attack the enemy normally.");
		System.out.println("special - Attack the enemy with a special.");
		System.out.println("magic   - Cast magic on the enemy.");
		System.out.println("defend  - Defend yourself from the enemy.");
		System.out.println("item    - Use a healing item.");
		System.out.println("switch  - Change character class.");
		System.out.println("show    - Show this command list.");
		System.out.println("quit    - Stop working and exit the program.");
		System.out.println("---------------------------------------------");
	}
}
