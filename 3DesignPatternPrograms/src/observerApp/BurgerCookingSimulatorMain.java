package observerApp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Burger cooking simulator to simulate flipping burgers on a stove
 * @author GustyWinds24
 */
public class BurgerCookingSimulatorMain {

	private static StoveTop stoveTop;
	private static Spatula spatula;
	private static Plate plate;
	private static ArrayList<BurgerPatty> burgerPatties;
	
	/**
	 * required main method
	 * @param args common arguments for java programs
	 */
	public static void main(String[] args) {
		stoveTop = new StoveTop();
		spatula = new Spatula();
		plate = new Plate();
		burgerPatties = new ArrayList<BurgerPatty>();
		
		beginSimulatorText();
		runBurgerCookingSimulator();
	}
	
	private static void beginSimulatorText() {
		System.out.println("Welcome to the burger cooking simulator! Here you will be cooking as many");
		System.out.println("burgers as you want! Once you specify how many burgers your are cooking ");
		System.out.println("you will have to add the burger patties to the stove top with the command");
		System.out.println("\"add\". Flip patties with the command \"flip\" and serve them with the");
		System.out.println("\"serve\" command. Burgers will get cooked after flipping them once so");
		System.out.println("make sure they are before serving them. If you want to quit cooking then");
		System.out.println("type in the command \"quit\". Also if you need to see the commands again");
		System.out.println("use the command \"show\" to show the command list. Happy cooking!");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Insert the number of burgers you want to cook below:");
	}
	
	private static void runBurgerCookingSimulator() {
		Scanner commandInput;
		boolean continueSimulation;
		
		commandInput = new Scanner(System.in);
		continueSimulation = true;
		
		giveNumberOfBurgersToCook(commandInput);
		setUpTheKitchen();
		
		System.out.println("Insert a command below:");
		while(continueSimulation) {
			continueSimulation = getCommands(commandInput);
		}
		System.out.println("Good work out there! The customers are enjoying their burgers.");
		
		commandInput.close();
	}
	
	private static void giveNumberOfBurgersToCook(Scanner commandInput) {
		String numberOfBurgersGiven;
		int numberOfBurgers;
		numberOfBurgers = 0;
		
		while(numberOfBurgers == 0) {
			numberOfBurgersGiven = commandInput.next();
			numberOfBurgers = checkIfNumberGivenWasInteger(numberOfBurgersGiven);
			if(numberOfBurgers <= 0) {
				System.out.println("You can't cook " + numberOfBurgers + " burgers! Insert a reasonable number!");
			}
		}
		for(int i = 0; i < numberOfBurgers; i++) {
			burgerPatties.add(new BurgerPatty("patty" + i));
		}
	}
	
	private static int checkIfNumberGivenWasInteger(String numberOfBurgersGiven) {
		int numberOfBurgers;
		try {
			numberOfBurgers = Integer.parseInt(numberOfBurgersGiven);
			return numberOfBurgers;
		} catch (NumberFormatException exception) {
			System.err.println("ERROR: Please only use integers. Number of Burgers set to 0.");
			numberOfBurgers = 0;
			return numberOfBurgers;
		}
	}
	
	private static void setUpTheKitchen() {
		for(BurgerPatty patty : burgerPatties) {
			stoveTop.addObserver(patty);
			spatula.addObserver(patty);
			plate.addObserver(patty);
		}
	}
	
	private static boolean getCommands(Scanner commandInput) {
		String givenCommand = commandInput.next().toLowerCase();
		boolean userWantsToContinueCooking;
		
		userWantsToContinueCooking = executeGivenCommand(givenCommand);
		
		return userWantsToContinueCooking;
	}
	
	private static boolean executeGivenCommand(String givenCommand) {
		switch(givenCommand) {
		case "add":
			stoveTop.addToStoveTop();
			break;
		case "flip":
			spatula.flipBurgers();
			break;
		case "serve":
			plate.serveBurgers();
			break;
		case "show":
			showCommandList();
			break;
		case "quit":
			return false;
		default:
			System.out.println("Invalid Command. Enter \"show\" to show the list of valid commands.");
		}
		return true;
	}

	private static void showCommandList() {
		System.out.println("Commands");
		System.out.println("-------------------------------------------");
		System.out.println("add   - Add the burgers to the stove top.");
		System.out.println("flip  - Flip the burgers on the stove.");
		System.out.println("serve - Serve.");
		System.out.println("show  - Show this command list.");
		System.out.println("quit  - Stop working and exit the program.");
	}
	
}
