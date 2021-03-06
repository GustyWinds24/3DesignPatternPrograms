package stateApp;

import java.util.Random;

/**
 * Dark mage character class
 */
public class DarkMageClass implements CurrentClass{

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
	
	public DarkMageClass(FantasyWarriorWidget widget) {
		this.widget = widget;
		maxHealth = 100;
		noHealth = 0;
		healthRestorePoints = 20;
		healthAmount = maxHealth;
		enemyHealth = 50;
		attackPoints = 20;
		enemyAttackPoints = 15;
		attackChance = 0;
		randomInt = new Random();
		hit = 200;
		multiplier = 2;
		isDead = false;
		enemyIsDead = false;
	}
	
	@Override
	public void attack() {
		randomInt = new Random();
		if(isDead) {
			System.out.println("The dark mage can't do anything when dead!");
		} else if(enemyIsDead) {
			System.out.println("The enemy is already dead!");
		} else {
			attackChance = randomInt.nextInt(400);
			if(attackChance >= hit) {
				System.out.println("The dark mage attacks the enemy with 20 dmg!");
				enemyHealth = enemyHealth - attackPoints;
				checkEnemyHealth();
			} else {
				System.out.println("The dark mage misses his attack!");
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
			System.out.println("The dark mage has died!");
			isDead = true;
		} else {
			System.out.println("The dark mage currently has " + healthAmount + " HP left!");
		}
	}
	
	private void enemyAttack() {
		randomInt = new Random();
		attackChance = randomInt.nextInt(400);
		
		if(attackChance >= hit) {
			System.out.println("The enemy attacks the dark mage with 15 dmg!");
			healthAmount = healthAmount - enemyAttackPoints;
		} else {
			System.out.println("The enemy misses his attack!");
		}
	}
	
	@Override
	public void useSpecial() {
		randomInt = new Random();
		if(isDead) {
			System.out.println("The dark mage can't do anything when dead!");
		} else if(enemyIsDead) {
			System.out.println("The enemy is already dead!");
		} else {
			attackChance = randomInt.nextInt(400);
			if(attackChance >= hit) {
				System.out.println("The dark mage attacks the enemy with 40 dmg!");
				enemyHealth = enemyHealth - (attackPoints*multiplier);
				checkEnemyHealth();
			} else {
				System.out.println("The dark mage misses his special!");
			}
			if(!enemyIsDead) {
				enemyAttack();
				checkKnightHealth();
			}
		}
	}
	
	@Override
	public void castMagic() {
		randomInt = new Random();
		if(isDead) {
			System.out.println("The dark mage can't do anything when dead!");
		} else if(enemyIsDead) {
			System.out.println("The enemy is already dead!");
		} else {
			attackChance = randomInt.nextInt(400);
			if(attackChance >= hit) {
				System.out.println("The dark mage casts magic against the enemy with 60 dmg!");
				enemyHealth = enemyHealth - (attackPoints*multiplier+attackPoints);
				checkEnemyHealth();
			} else {
				System.out.println("The dark mage misses his special!");
			}
			if(!enemyIsDead) {
				enemyAttack();
				checkKnightHealth();
			}
		}
	}
	
	@Override
	public void defend() {
		if(isDead) {
			System.out.println("The dark mage can't do anything when dead!");
		} else {
			if(enemyIsDead) {
				System.out.println("No need to defend. The enemy is dead!");
			} else {
				System.out.println("The dark mage is defending!");
				enemyAttackForDefenseMethod();
			}
		}
	}
	
	private void enemyAttackForDefenseMethod() {
		randomInt = new Random();
		attackChance = randomInt.nextInt(400);
		
		if(attackChance >= hit) {
			System.out.println("The enemy attacks and couldn't penetrate the dark mage's defense!");
		} else {
			System.out.println("The dark mage fails to defend!");
			enemyAttack();
			checkKnightHealth();
		}
	}
	
	@Override
	public void useItem() {
		if (healthAmount == maxHealth) {
			System.out.println("Already at full health!");
		} else {
			System.out.println("The dark mage uses an item to heal with 20 HP!");
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
		widget.setCurrentClass(widget.getClassMonster());
	}
	
	@Override
	public void printClass() {
		System.out.println("You are now a dark mage");
	}
	
}
