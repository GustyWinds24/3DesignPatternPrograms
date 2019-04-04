package commandApp;

/**
 * Class that holds the command to fix
 */
public class FixGunCommand implements Command{
	
	private Gun gun;
	
	/**
	 * a gun object's form
	 */
	public FixGunCommand(Gun gun) {
		this.gun = gun;
	}
	
	/**
	 * sent to the interface to fix
	 */
	@Override
	public void execute() {
		gun.fixGun();
	}

	/**
	 * sent to the documenter for history purposes
	 */
	@Override
	public String toString() {
		return "Fix Gun Command";
	}
	
}
