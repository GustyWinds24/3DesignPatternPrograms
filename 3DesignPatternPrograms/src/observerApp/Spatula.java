package observerApp;

import java.util.Observable;

/**
 * The spatula observable
 */
public class Spatula extends Observable{
	
	/**
	 * flip the burgers
	 */
	public void flipBurgers() {
		setChanged();
		notifyObservers();
	}
	
}
