package Gameplay;

import java.util.ArrayList;

public class Mob extends Character{

    private String mobName;
    public static ArrayList<Mob> mobs = new ArrayList<>();

    public Mob(int maxHealth, int strength, int agility, int intelligence, String mobName) {
        super(maxHealth, strength, agility, intelligence);
        this.mobName = mobName;
        mobs.add(this);
    }

    @Override
    public void deathMessage() {
        System.out.println(mobName + " is dead; another fiend gone");
    }

    @Override
    public int attack() {
        System.out.println(mobName + " is attacking!");
        return strength;
    }

    @Override
    public void loseHealth(int value) {
        super.loseHealth(value);
        System.out.println(mobName + " lost " + value + " health");
    }

    @Override
    public String toString() {
        return "Mob{" +
                "mobName='" + mobName + '\'' +
                "} " + super.toString();
    }
}
