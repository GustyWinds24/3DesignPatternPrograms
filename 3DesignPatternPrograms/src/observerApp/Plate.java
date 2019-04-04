package observerApp;

import java.util.Observable;

/**
 * The plate observable
 */
public class Plate extends Observable{
	
	/**
	 * burgers are served to customers
	 */
	public void serveBurgers() {
		setChanged();
		notifyObservers();
	}
	
}
