package Gameplay;

import UserInterface.CharacterCreation;

public class Fight {

    public static void start() {

        Mob mob = new Mob(20, 5, 6, 2, "Goblin");

        Character character1;
        Character character2;

        try {
            character1 = Hero.heroes.get(0);
            character2 = Mob.mobs.get(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Cowards! They didn't show up for the fight!");
            return;
        }

        System.out.println(character1);
        System.out.println(character2);

        while(true) {

            character1.getAttacked(character2.attack());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            character2.getAttacked(character1.attack());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            if(character1.getHealth() == 0) {
                character1.deathMessage();
                character1.restoreHealth();
                character2.restoreHealth();
                break;
            }

            if(character2.getHealth() == 0) {
                character2.deathMessage();
                character1.restoreHealth();
                character2.restoreHealth();
                break;
            }
        }

    }
}
