package Gameplay;

import java.util.Random;

public class Character {

    protected int maxHealth;
    protected int health;
    protected int strength;
    protected int agility;
    protected int intelligence;

    public Character(int maxHealth, int strength, int agility, int intelligence) {
        this.maxHealth = maxHealth;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = maxHealth;
    }


    public void loseHealth(int value) {

        health = (health < value)? 0 : health - value;
    }
    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getHealth() {
        return health;
    }
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void deathMessage() {
        System.out.println("RIP");
    }

    public void restoreHealth() {
        health = maxHealth;
    }

    public int attack() {
        System.out.println("The character is attacking!");
        return strength;
    }

    public void getAttacked(int value) {
        Random random = new Random();
        int luck = random.nextInt(100);
        if(agility > luck) {
            System.out.println("Dodge!");
            return;
        } else {
            this.loseHealth(value);
        }
    }

    @Override
    public String toString() {
        return "Character{" +
                "maxHealth=" + maxHealth +
                ", health=" + health +
                ", strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                '}';
    }
}
