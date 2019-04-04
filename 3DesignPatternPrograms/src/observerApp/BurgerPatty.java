package observerApp;

import java.util.Observer;

import java.util.Observable;

/**
 * The observer class representing as a burger patty
 */
public class BurgerPatty implements Observer {

	private boolean cooked;
	private boolean onStoveTop;
	private boolean burgerServed;
	private String burgerPattyLabel;
	
	/**
	 * one lone burger patty
	 */
	public BurgerPatty(String burgerPattyLabel) {
		this.burgerPattyLabel = burgerPattyLabel;
		
		setBurgerStatus(false);
		setBurgerOnStoveTopStatus(false);
		setBurgerServedStatus(false);
	}
	
	private void setBurgerStatus(boolean burgerStatus) {
		cooked = burgerStatus;
	}
	
	private void setBurgerOnStoveTopStatus(boolean burgerOnStoveTopStatus) {
		onStoveTop = burgerOnStoveTopStatus;
	}
	
	private void setBurgerServedStatus(boolean burgerServedStatus) {
		burgerServed = burgerServedStatus;
	}
	
	private void addPattyToStoveTop() {
		if(burgerServed) {
			System.out.println(burgerPattyLabel + " was already served! You can't add a served burger to the stove!");
		} else if(onStoveTop) {
			System.out.println(burgerPattyLabel + " was already added to the stove top.");
		} else {
			System.out.println(burgerPattyLabel + " was added to the stove top.");
			onStoveTop = true;
		}
	}
	
	private void flipPatty() {
		if(!onStoveTop) {
			System.out.println(burgerPattyLabel + " can't be flipped since it hasn't even reached the stove top yet!");
		} else if(burgerServed) {
			System.out.println(burgerPattyLabel + " was already served! You can't flip a served burger!");
		} else {
			System.out.println(burgerPattyLabel + " was flipped to the other side.");
			cooked = true;
		}
	}
	
	private void serveBurger() {
		if(!onStoveTop) {
			System.out.println(burgerPattyLabel + " can't be served since it hasn't even reached the stove top yet!");
		} else if(burgerServed) {
			System.out.println(burgerPattyLabel + " was already served!");
		} else if(cooked) {
			System.out.println(burgerPattyLabel + " was served to a customer.");
			burgerServed = true;
		} else {
			System.out.println(burgerPattyLabel + " isn't cooked yet!");
		}
	}
	
	/**
	 * the method that gets notified when a change in the observable occurs
	 */
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof StoveTop) {
			addPattyToStoveTop();
		} else if (o instanceof Spatula) {
			flipPatty();
		} else if (o instanceof Plate) {
			serveBurger();
		}
	}
	
}
