package stateApp;

/**
 * Class that acts as the widget for the state pattern
 */
public class FantasyWarriorWidget {
	private CurrentClass currentClass;
	
	private CurrentClass knightClass;
	private CurrentClass archerClass;
	private CurrentClass lightMageClass;
	private CurrentClass darkMageClass;
	private CurrentClass monsterClass;
	
	/**
	 * constructor
	 */
	public FantasyWarriorWidget() {
		knightClass = new KnightClass(this);
		archerClass = new ArcherClass(this);
		lightMageClass = new LightMageClass(this);
		darkMageClass = new DarkMageClass(this);
		monsterClass = new MonsterClass(this);
		
		currentClass = knightClass;
		currentClass.printClass();
	}
	
	/**
	 * attack command
	 */
	public void attack() {
		currentClass.attack();
	}
	
	/**
	 * special command
	 */
	public void useSpecial() {
		currentClass.useSpecial();
	}
	
	/**
	 * magic command
	 */
	public void castMagic() {
		currentClass.castMagic();
	}
	
	/**
	 * defend command
	 */
	public void defend() {
		currentClass.defend();
	}
	
	/**
	 * item command
	 */
	public void useItem() {
		currentClass.useItem();
	}
	
	/**
	 * switch command
	 */
	public void switchClass() {
		currentClass.switchClass();
	}
	
	//getters and setters for each character class
	
	public CurrentClass getClassKnight() {
		return knightClass;
	}

	public void setKnightClass(CurrentClass knightClass) {
		this.knightClass = knightClass;
	}

	public CurrentClass getClassArcher() {
		return archerClass;
	}

	public void setArcherClass(CurrentClass archerClass) {
		this.archerClass = archerClass;
	}

	public CurrentClass getClassLightMage() {
		return lightMageClass;
	}

	public void setLightMageClass(CurrentClass lightMageClass) {
		this.lightMageClass = lightMageClass;
	}

	public CurrentClass getClassDarkMage() {
		return darkMageClass;
	}

	public void setDarkMageClass(CurrentClass darkMageClass) {
		this.darkMageClass = darkMageClass;
	}

	public CurrentClass getClassMonster() {
		return monsterClass;
	}

	public void setMonsterClass(CurrentClass monsterClass) {
		this.monsterClass = monsterClass;
	}

	/**
	 * use so the user can know what class he/she is
	 */
	public CurrentClass getCurrentClass() {
		return currentClass;
	}
	
	/**
	 * switch command outcome
	 */
	public void setCurrentClass(CurrentClass currentClass) {
		this.currentClass = currentClass;
		currentClass.printClass();
	}
}
