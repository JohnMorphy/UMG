package Gameplay;

import java.util.ArrayList;

public class Hero extends Character{

    public static ArrayList<Hero> heroes = new ArrayList<>();
    private String name;
    private int remainingPoints = 15;

    public boolean addMaxHealth() {
        if(this.removeRemainingPoints()) {
            maxHealth += 5;
            health = maxHealth;
            return true;
        }

        return false;
    }

    public boolean removeMaxHealth() {
        if(this.getMaxHealth() <= 5) {
            return false;
        }

        maxHealth -= 5;
        health = maxHealth;
        this.addRemainingPoints();
        return true;
    }

    public boolean addStrength() {
        if(this.removeRemainingPoints()) {
            strength++;
            return true;
        }

        return false;
    }

    public boolean removeStrength() {
        if(this.getStrength() <= 1) {
            return false;
        }

        strength--;
        this.addRemainingPoints();
        return true;
    }

    public boolean addAgility() {
        if(this.removeRemainingPoints()) {
            agility++;
            return true;
        }

        return false;
    }

    public boolean removeAgility() {
        if(this.getAgility() <= 1) {
            return false;
        }

        agility--;
        this.addRemainingPoints();
        return true;
    }

    public boolean addIntelligence() {
        if(this.removeRemainingPoints()) {
            intelligence++;
            return true;
        }

        return false;
    }

    public boolean removeIntelligence() {
        if(this.getStrength() <= 1) {
            return false;
        }

        intelligence--;
        this.addRemainingPoints();
        return true;
    }


    public int getRemainingPoints() {
        return remainingPoints;
    }

    public boolean removeRemainingPoints() {

        if(remainingPoints <= 0) {
            return false;
        }

        remainingPoints--;
        return true;
    }

    public boolean addRemainingPoints() {

        remainingPoints++;
        return true;
    }

    private Inventory inventory;


    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        this.name = name;
        return true;
    }

    public Hero(int health, int strength, int agility, int intelligence, String name) {
        super(health, strength, agility, intelligence);
        this.name = name;
        heroes.add(this);
    }

    public Hero(int health, int strength, int agility, int intelligence, String name, Inventory inventory) {
        super(health, strength, agility, intelligence);
        this.name = name;
        this.inventory = inventory;
        heroes.add(this);
    }

    @Override
    public void deathMessage() {
        System.out.println(name + " has fallen! This mighty hero will never be forgotten!");
    }

    @Override
    public int attack() {
        System.out.println(name + " is attacking!");
        return (strength > agility)? strength : agility;
    }

    @Override
    public void loseHealth(int value) {
        super.loseHealth(value);
        System.out.println(name + " lost " + value + " health");
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", remainingPoints=" + remainingPoints +
                ", inventory=" + inventory +
                "} " + super.toString();
    }

}