package observerApp;

import java.util.Observable;

/**
 * The stove top observable
 */
public class StoveTop extends Observable {
	
	/**
	 * adds burger patties to the stove top
	 */
	public void addToStoveTop() {
		setChanged();
		notifyObservers();
	}
	
}
