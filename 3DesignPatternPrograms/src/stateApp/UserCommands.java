package stateApp;

/**
 * Class used for the commands the user must type in
 */
public class UserCommands extends FantasyWarriorMain{
	
	/**
	 * The commands for the user to use for their character class
	 * @param givenCommand
	 */
	public static boolean executeGivenCommand(String givenCommand) {
		switch(givenCommand) {
		case "attack":
			widget.attack();
			break;
		case "special":
			widget.useSpecial();
			break;
		case "magic":
			widget.castMagic();
			break;
		case "defend":
			widget.defend();
			break;
		case "item":
			widget.useItem();
			break;
		case "switch":
			widget.switchClass();
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
	
}
