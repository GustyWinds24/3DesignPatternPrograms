package commandApp;

/**
 * Class that holds the command to shoot
 */
public class ShootCommand implements Command{
	
	private Gun gun;
	
	/**
	 * a gun object's form
	 */
	public ShootCommand(Gun gun) {
		this.gun = gun;
	}
	
	/**
	 * sent to the interface to shoot
	 */
	@Override
	public void execute() {
		gun.shootGun();
	}

	/**
	 * sent to the documenter for history purposes
	 */
	@Override
	public String toString() {
		return "Shoot Gun Command";
	}
	
}
