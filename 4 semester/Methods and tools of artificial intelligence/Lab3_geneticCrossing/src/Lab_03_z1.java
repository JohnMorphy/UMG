import java.util.Arrays;

public class Task1 implements Lab_03_Chromosome {

    @Override
    public double getFunctionResult(double[] values) {
        return -Math.pow(values[0],2)-Math.pow(values[1],2) + 2;
    }

    public static void main(String[] args) {

        byte[][] bitParent1 = Lab_03_Chromosome.generateChromosome(2, -2,2,19, 5);
        double[] parent1 = Lab_03_Chromosome.getRealValues(2, -2,2,5, bitParent1);
        System.out.println("FIRST PARENT");
        for (byte[] arr :bitParent1) {
            Lab_03_Chromosome.printTable(arr);
        }
        System.out.println();
        for (double result:parent1) {
            System.out.println(result);
        }

        System.out.println();

        Task1 task = new Task1();
        System.out.println("function result: " + task.getFunctionResult(parent1));
        System.out.println();

        System.out.println("SECOND PARENT");
        byte[][] bitParent2 = Lab_03_Chromosome.generateChromosome(2, -2,2,19, 5);
        double[] parent2 = Lab_03_Chromosome.getRealValues(2, -2,2, 5, bitParent2);
        for (byte[] arr :bitParent2) {
            Lab_03_Chromosome.printTable(arr);
        }
        System.out.println();
        for (double result:parent2) {
            System.out.println(result);
        }

        System.out.println();
        System.out.println("function result: " + task.getFunctionResult(parent2));

        // 1 point crossing

        String strParent1 = (Arrays.toString(bitParent1[0]) + Arrays.toString(bitParent1[1])).replaceAll("[\\[\\]\\s,]", "");
        String strParent2 = (Arrays.toString(bitParent2[0]) + Arrays.toString(bitParent2[1])).replaceAll("[\\[\\]\\s,]", "");

        boolean correctCrossing = true;
        byte[][] bitChild1;
        byte[][] bitChild2;
        int pointOfCross1;

        do {
            StringBuilder strChild1 = new StringBuilder();
            StringBuilder strChild2 = new StringBuilder();


            pointOfCross1 = (int)(Math.random() * 38);

            for(int i= 0; i<strParent1.length(); i++) {
                if(i<pointOfCross1) {
                    strChild1.append(strParent1.charAt(i));
                    strChild2.append(strParent2.charAt(i));
                } else {
                    strChild1.append(strParent2.charAt(i));
                    strChild2.append(strParent1.charAt(i));
                }
            }
            bitChild1 = Lab_03_Chromosome.stringToChromosome(strChild1.toString(),2);
            bitChild2 = Lab_03_Chromosome.stringToChromosome(strChild2.toString(),2);

            double[] child1Real = Lab_03_Chromosome.getRealValues(2,-2,2,5, bitChild1);
            double[] child2Real = Lab_03_Chromosome.getRealValues(2,-2,2,5, bitChild2);

            for(int i = 0; i<child1Real.length; i++) {
                if (child1Real[i] > 2 || child2Real[i] > 2) {
                    correctCrossing = false;
                    break;
                }
            }
        } while (!correctCrossing);

        System.out.println("\n------one point crossing------");
        System.out.println("point of crossing: " + pointOfCross1);
        System.out.println("\nFIRST CHILD\n");
        for (byte[] arr :bitChild1) {
            Lab_03_Chromosome.printTable(arr);
        }
        double[] child1 = Lab_03_Chromosome.getRealValues(2, -2,2, 5, bitChild1);
        System.out.println();
        for (double result:child1) {
            System.out.println(result);
        }

        System.out.println("\nSECOND CHILD\n");

        for (byte[] arr:bitChild2) {
            Lab_03_Chromosome.printTable(arr);
        }
        double[] child2 = Lab_03_Chromosome.getRealValues(2, -2,2, 5, bitChild2);

        System.out.println();
        for (double result:child2) {
            System.out.println(result);
        }

        // 2 point crossing

        correctCrossing = true;
        int pointOfCross2_1;
        int pointOfCross2_2;

        do {
            StringBuilder strChild1 = new StringBuilder();
            StringBuilder strChild2 = new StringBuilder();


            pointOfCross2_1 = (int)(Math.random() * 38);
            pointOfCross2_2 = (int)(Math.random() * 38);

            if(pointOfCross2_1>pointOfCross2_2) {
                int buffer = pointOfCross2_1;
                pointOfCross2_1 = pointOfCross2_2;
                pointOfCross2_2 = buffer;
            }

            for(int i= 0; i<strParent1.length(); i++) {
                if(i>pointOfCross2_1 && i<pointOfCross2_2) {
                    strChild1.append(strParent2.charAt(i));
                    strChild2.append(strParent1.charAt(i));
                } else {
                    strChild1.append(strParent1.charAt(i));
                    strChild2.append(strParent2.charAt(i));
                }
            }
            bitChild1 = Lab_03_Chromosome.stringToChromosome(strChild1.toString(),2);
            bitChild2 = Lab_03_Chromosome.stringToChromosome(strChild2.toString(),2);

            double[] child1Real = Lab_03_Chromosome.getRealValues(2,-2,2,5, bitChild1);
            double[] child2Real = Lab_03_Chromosome.getRealValues(2,-2,2,5, bitChild2);

            for(int i = 0; i<child1Real.length; i++) {
                if (child1Real[i] > 2 || child2Real[i] > 2) {
                    correctCrossing = false;
                    break;
                }
            }
        } while (!correctCrossing);

        System.out.println("\n------two point crossing------");
        System.out.println("points of crossing: " + pointOfCross2_1 + ", " + pointOfCross2_2);
        System.out.println("\nFIRST CHILD\n");
        for (byte[] arr :bitChild1) {
            Lab_03_Chromosome.printTable(arr);
        }
        child1 = Lab_03_Chromosome.getRealValues(2, -2,2, 5, bitChild1);
        System.out.println();
        for (double result:child1) {
            System.out.println(result);
        }

        System.out.println("\nSECOND CHILD\n");

        for (byte[] arr:bitChild2) {
            Lab_03_Chromosome.printTable(arr);
        }
        child2 = Lab_03_Chromosome.getRealValues(2, -2,2, 5, bitChild2);

        System.out.println();
        for (double result:child2) {
            System.out.println(result);
        }

    }

}
