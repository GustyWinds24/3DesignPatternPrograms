package stateApp;

import java.util.Random;

/**
 * Archer character class
 */
public class ArcherClass implements CurrentClass{
	
	private FantasyWarriorWidget widget;
	private int healthAmount;
	private int maxHealth;
	private int noHealth;
	private int healthRestorePoints;
	private int enemyHealth;
	private int attackPoints;
	private int enemyAttackPoints;
	private int attackChance;
	private int hit;
	private int multiplier;
	private Random randomInt;
	private boolean isDead;
	private boolean enemyIsDead;
	
	public ArcherClass(FantasyWarriorWidget widget) {
		this.widget = widget;
		maxHealth = 100;
		noHealth = 0;
		healthRestorePoints = 20;
		healthAmount = maxHealth;
		enemyHealth = 50;
		attackPoints = 10;
		enemyAttackPoints = 15;
		attackChance = 0;
		randomInt = new Random();
		hit = 200;
		multiplier = 3;
		isDead = false;
		enemyIsDead = false;
	}
	
	/**
	 * attack action
	 */
	@Override
	public void attack() {
		randomInt = new Random();
		if(isDead) {
			System.out.println("The archer can't do anything when dead!");
		} else if(enemyIsDead) {
			System.out.println("The enemy is already dead!");
		} else {
			attackChance = randomInt.nextInt(400);
			if(attackChance >= hit) {
				System.out.println("The archer attacks the enemy with 10 dmg!");
				enemyHealth = enemyHealth - attackPoints;
				checkEnemyHealth();
			} else {
				System.out.println("The archer misses his attack!");
			}
			if(!enemyIsDead) {
				enemyAttack();
				checkKnightHealth();
			}
		}
	}
	
	private void checkEnemyHealth() {
		if(enemyHealth <= noHealth) {
			System.out.println("The enemy has died!");
			enemyIsDead = true;
		} else {
			System.out.println("The enemy currently has " + enemyHealth + " HP left!");
		}
		
	}
	
	private void checkKnightHealth() {
		if(healthAmount <= noHealth) {
			System.out.println("The archer has died!");
			isDead = true;
		} else {
			System.out.println("The archer currently has " + healthAmount + " HP left!");
		}
	}
	
	private void enemyAttack() {
		randomInt = new Random();
		attackChance = randomInt.nextInt(400);
		
		if(attackChance >= hit) {
			System.out.println("The enemy attacks the archer with 15 dmg!");
			healthAmount = healthAmount - enemyAttackPoints;
		} else {
			System.out.println("The enemy misses his attack!");
		}
	}
	
	/**
	 * special action
	 */
	@Override
	public void useSpecial() {
		randomInt = new Random();
		if(isDead) {
			System.out.println("The archer can't do anything when dead!");
		} else if(enemyIsDead) {
			System.out.println("The enemy is already dead!");
		} else {
			attackChance = randomInt.nextInt(400);
			if(attackChance >= hit) {
				System.out.println("The archer attacks the enemy with 20 dmg!");
				enemyHealth = enemyHealth - (attackPoints*multiplier);
				checkEnemyHealth();
			} else {
				System.out.println("The archer misses his special!");
			}
			if(!enemyIsDead) {
				enemyAttack();
				checkKnightHealth();
			}
		}
	}
	
	@Override
	public void castMagic() {
		System.err.println("Archers don't have magic!");
	}
	
	@Override
	public void defend() {
		if(isDead) {
			System.out.println("The archer can't do anything when dead!");
		} else {
			if(enemyIsDead) {
				System.out.println("No need to defend. The enemy is dead!");
			} else {
				System.out.println("The archer is defending!");
				enemyAttackForDefenseMethod();
			}
		}
	}
	
	private void enemyAttackForDefenseMethod() {
		randomInt = new Random();
		attackChance = randomInt.nextInt(400);
		
		if(attackChance >= hit) {
			System.out.println("The enemy attacks and couldn't penetrate the archer's defense!");
		} else {
			System.out.println("The archer fails to defend!");
			enemyAttack();
			checkKnightHealth();
		}
	}
	
	@Override
	public void useItem() {
		if (healthAmount == maxHealth) {
			System.out.println("Already at full health!");
		} else {
			System.out.println("The archer uses an item to heal with 20 HP!");
			healthAmount = healthAmount + healthRestorePoints;
			if(healthAmount > 100) {
				healthAmount = 100;
			}
			if(!enemyIsDead) {
				enemyAttack();
				checkKnightHealth();
			}
		}
	}
	
	@Override
	public void switchClass() {
		widget.setCurrentClass(widget.getClassLightMage());
	}
	
	@Override
	public void printClass() {
		System.out.println("You are now an archer");
	}
	
}
