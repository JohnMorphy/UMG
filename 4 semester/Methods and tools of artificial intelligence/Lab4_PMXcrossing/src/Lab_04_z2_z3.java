import java.util.*;

public class Lab_04_z2_z3 {

    public static void invert(byte[] arr, int randomInt) {
        int spotRightOfRandom = (randomInt == arr.length-1) ? 0 : randomInt+1;
        byte buffer = arr[randomInt];
        arr[randomInt] = arr[spotRightOfRandom];
        arr[spotRightOfRandom] = buffer;
    }

    public static void main(String[] args) {
        System.out.println(" --- TASK 2 - PMX --- ");

        System.out.println("1 parent");
        byte[] parent1 = new byte[10];
        List<Byte> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add((byte) i);
        }
        Collections.shuffle(list);
        for (int i = 0; i < 10; i++) {
            parent1[i] = list.get(i);
        }
        System.out.println(Arrays.toString(parent1));

        System.out.println("2 parent");
        byte[] parent2 = new byte[10];
        List<Byte> list2 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list2.add((byte) i);
        }
        Collections.shuffle(list2);
        for (int i = 0; i < 10; i++) {
            parent2[i] = list2.get(i);
        }
        System.out.println(Arrays.toString(parent2));

        byte[] child1 = new byte[10];
        byte[] child2 = new byte[10];

        Random random = new Random();
        int cross1 = random.nextInt(12) - 1;
        int cross2 = random.nextInt(12) - 1;


        cross1 = (cross1>cross2)? cross2 : cross1;

        Map<Byte, Byte> mappedBytes1 = new HashMap<>();
        Map<Byte, Byte> mappedBytes2 = new HashMap<>();


        for (int i = 0; i<child1.length; i++) {
            if(i>cross1 && i<cross2) {
                child1[i] = parent2[i];
                child2[i] = parent1[i];
                mappedBytes1.put(child1[i], child2[i]);
                mappedBytes2.put(child2[i], child1[i]);
            }
        }

        for (int i = 0; i<child1.length; i++) {
            if(i<=cross1 || i>=cross2) {
                if(!(mappedBytes1.containsKey(parent1[i]) || mappedBytes2.containsKey(parent1[i]))) {
                    child1[i] = parent1[i];
                } else {
                    child1[i] = mappedBytes1.get(parent1[i]);
                }

                if(!(mappedBytes1.containsKey(parent2[i]) || mappedBytes2.containsKey(parent2[i]))) {
                    child2[i] = parent2[i];
                } else {
                    child2[i] = mappedBytes2.get(parent2[i]);
                }
            }
        }

        System.out.println("\nAfter PMX; points of crossing: " + cross1 + ", " + cross2 + "\n");
        System.out.println("Child 1:\n" + Arrays.toString(child1));
        System.out.println("Child 2:\n" + Arrays.toString(child2));


        System.out.println("\n --- TASK3 - invert (mutation) --- ");

        int randomInt1 = (int)(Math.random()*10);
        Lab_04_z2_z3.invert(parent1, randomInt1);

        int randomInt2 = (int)(Math.random()*10);
        Lab_04_z2_z3.invert(parent2, randomInt2);

        System.out.println("\nAfter inverting in points: " + randomInt1 + "(parent1), " + randomInt2 + "(parent2)\n");
        System.out.println("parent1:\n" + Arrays.toString(parent1));
        System.out.println("parent2:\n" + Arrays.toString(parent2));


    }
}
