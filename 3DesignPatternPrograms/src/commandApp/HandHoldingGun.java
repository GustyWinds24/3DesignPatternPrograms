package commandApp;

import java.util.ArrayList;
import java.util.List;

/**
 * The invoker class for the gun acting as a hand
 */
public class HandHoldingGun {
	
	private List<Command> commandHistory;
	
	/**
	 * a hand instantiation
	 */
	public HandHoldingGun() {
		commandHistory = new ArrayList<Command>();
	}
	
	/**
	 * commands that are called are stored in the command history and executed
	 */
	public void storeAndExecute(Command command) {
		commandHistory.add(command);
		command.execute();
	}
	
	/**
	 * printed when a user quits the program
	 */
	public void printCommandHistory() {
		System.out.println("Command History of Your Gun");
		System.out.println("---------------------------");
		
		for(Command command : commandHistory) {
			System.out.println(command);
		}
		
		System.out.println("---------------------------");
	}
	
}
