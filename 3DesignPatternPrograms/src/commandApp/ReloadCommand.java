package commandApp;

/**
 * Class that holds the command to reload
 */
public class ReloadCommand implements Command{
	
	private Gun gun;
	
	/**
	 * a gun object's form
	 */
	public ReloadCommand(Gun gun) {
		this.gun = gun;
	}
	
	/**
	 * sent to the interface to reload
	 */
	@Override
	public void execute() {
		gun.reloadGun();
	}

	/**
	 * sent to the documenter for history purposes
	 */
	@Override
	public String toString() {
		return "Reload Gun Command";
	}
	
}
