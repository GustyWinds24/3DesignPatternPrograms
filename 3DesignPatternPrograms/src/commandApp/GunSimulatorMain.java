package commandApp;

import java.util.Scanner;

/**
 * Gun Simulator program that simulates handling a gun
 * @author GustyWinds24
 */
public class GunSimulatorMain {
	static Gun glock;
	
	static Command shootGun;
	static Command reloadGun;
	static Command fixGun;
	
	static HandHoldingGun myHand;
	
	/**
	 * standard java main function
	 * @param args standard args for java
	 */
	public static void main(String[] args) {
		glock = new Gun();
		
		shootGun = new ShootCommand(glock);
		reloadGun = new ReloadCommand(glock);
		fixGun = new FixGunCommand(glock);
		myHand = new HandHoldingGun();
		
		introText();
		runGunSimulator();
	}
	
	private static void introText() {
		System.out.println("Welcome to gun simulator! Here you are given a six round gun to mess with.");
		System.out.println("You can shoot your gun with the \"shoot\" command. You can also reload it");
		System.out.println("with the \"reload\" command. Be very aware that your gun can lose its");
		System.out.println("ability to fire after 7 shots due to wear and tear. Once that happens you");
		System.out.println("can use the command \"fix\" to fix your gun. If you need to see the list of");
		System.out.println("commands use the \"show\" command. Use the \"quit\" command to print your");
		System.out.println("command history with the gun not for \"show\" and \"quit\" and quit the");
		System.out.println("program.");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Insert your commands below:");
	}
	
	private static void runGunSimulator() {
		Scanner commandInput;
		boolean continueSimulation;
		
		commandInput = new Scanner(System.in);
		continueSimulation = true;
		
		while(continueSimulation) {
			continueSimulation = getCommands(commandInput);
		}
		System.out.println("See you next time!");
		
		commandInput.close();
	}
	
	private static boolean getCommands(Scanner commandInput) {
		String givenCommand; 
		givenCommand = commandInput.next().toLowerCase();
		boolean userWantsToContinueSimulation;
		
		userWantsToContinueSimulation = executeGivenCommand(givenCommand);
		
		return userWantsToContinueSimulation;
	}
	
	private static boolean executeGivenCommand(String givenCommand) {
		switch(givenCommand) {
		case "shoot":
			myHand.storeAndExecute(shootGun);
			break;
		case "reload":
			myHand.storeAndExecute(reloadGun);
			break;
		case "fix":
			myHand.storeAndExecute(fixGun);
			break;
		case "show":
			showCommandList();
			break;
		case "quit":
			myHand.printCommandHistory();
			return false;
		default:
			System.out.println("Invalid Command. Enter \"show\" to show the list of valid commands.");
		}
		return true;
	}
	
	private static void showCommandList() {
		System.out.println("Commands");
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("shoot  - Fire off a round from your gun.");
		System.out.println("reload - Reload your gun with a 6 round magazine ");
		System.out.println("fix    - Fix your broken down gun into perfect condition.");
		System.out.println("show   - Show this command list.");
		System.out.println("quit   - Print your command history with the gun only and exit the program.");
	}
}
