package commandApp;

/**
 * The receiver class for the commands
 */
public class Gun {
	
	private boolean notEmptyGun;
	private boolean brokenGun;
	private int magazine;
	private int emptyMag;
	private int fullMag;
	private int gunLife;
	private int healthyGun;
	private int deadGun;
	private int roundShottedOff;
	private int damageFromUseOfGun;
	
	/**
	 * one gun instantiation
	 */
	public Gun() {
		notEmptyGun = false;
		brokenGun = false;
		
		fullMag = 6;
		emptyMag = 0;
		magazine = emptyMag;
		healthyGun = 7;
		deadGun = 0;
		gunLife = healthyGun;
		roundShottedOff = 1;
		damageFromUseOfGun = 1;
	}
	
	/**
	 * executed when shoot is called
	 */
	public void shootGun() {
		if(brokenGun) {
			System.out.println("Your gun is broken! Fix it!");
		} else if(notEmptyGun) {
			magazine = magazine - roundShottedOff;
			gunLife = gunLife - damageFromUseOfGun;
			
			System.out.println("You shot off a round from your gun!");
			System.out.println("Your gun now has " + magazine + " out of 6 rounds left!");
			
			if(magazine == emptyMag) {
				notEmptyGun = false;
			}
			if(gunLife == deadGun) {
				brokenGun = true;
				System.out.println("Your gun just broke!");
			}
		} else {
			System.out.println("Your gun has no rounds! Please reload it!");
		}
	}
	
	/**
	 * executed when reload is called
	 */
	public void reloadGun() {
		if(magazine == fullMag) {
			System.out.println("Your gun's already full!");
		} else {
			magazine = fullMag;
			notEmptyGun = true;
			
			System.out.println("You reload your gun with a 6 round magazine!");
		}
	}
	
	/**
	 * executed when fix is called
	 */
	public void fixGun() {
		if(gunLife == healthyGun) {
			System.out.println("Your gun's already fixed to it's best!");
		} else {
			gunLife = healthyGun;
			brokenGun = false;
			
			System.out.println("You fixed your gun!");
		}
	}
}
