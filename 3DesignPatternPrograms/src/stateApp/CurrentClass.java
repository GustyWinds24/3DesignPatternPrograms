package stateApp;

/**
 * The interface that handles the character class actions
 */
public interface CurrentClass {

	public abstract void attack();
	public abstract void useSpecial();
	public abstract void castMagic();
	public abstract void defend();
	public abstract void useItem();
	public abstract void switchClass();
	public abstract void printClass();

}
