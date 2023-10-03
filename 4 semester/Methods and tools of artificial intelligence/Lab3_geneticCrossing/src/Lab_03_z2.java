import java.util.Arrays;

public class Lab_03_z2 implements Lab_03_Chromosome {

    @Override
    public double getFunctionResult(double[] values) {
        double value = 0;
        for (double x : values) {
            value += Math.pow(x, 2) - 10 * Math.cos(2 * Math.PI * x);
        }
        value += 100;
        return value;
    }

    public static void main(String[] args) {

        byte[][] bitParent1 = Lab_03_Chromosome.generateChromosome(10, -5.21,5.21,14, 3);
        double[] parent1 = Lab_03_Chromosome.getRealValues(10, -5.21,5.21,3, bitParent1);
        System.out.println("FIRST PARENT");
        for (byte[] arr :bitParent1) {
            Lab_03_Chromosome.printTable(arr);
        }
        System.out.println();
        for (double result:parent1) {
            System.out.println(result);
        }

        System.out.println();

        Lab_03_z1 task = new Lab_03_z1();
        System.out.println("function result: " + task.getFunctionResult(parent1));
        System.out.println();

        System.out.println("SECOND PARENT");
        byte[][] bitParent2 = Lab_03_Chromosome.generateChromosome(10, -5.21,5.21,14, 3);
        double[] parent2 = Lab_03_Chromosome.getRealValues(10, -5.21,5.21, 3, bitParent2);
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
        String strParent1 = "";

        for(int i = 0; i<10; i++) {
            strParent1 += Arrays.toString(bitParent1[i]);
        }
         strParent1 = strParent1.replaceAll("[\\[\\]\\s,]", "");

        String strParent2 = "";

        for(int i = 0; i<10; i++) {
            strParent2 += Arrays.toString(bitParent1[i]);
        }
        strParent2 = strParent1.replaceAll("[\\[\\]\\s,]", "");


        boolean correctCrossing = true;
        byte[][] bitChild1;
        byte[][] bitChild2;
        int pointOfCross1;

        do {
            StringBuilder strChild1 = new StringBuilder();
            StringBuilder strChild2 = new StringBuilder();


            pointOfCross1 = (int)(Math.random() * 140);

            for(int i= 0; i<strParent1.length(); i++) {
                if(i<pointOfCross1) {
                    strChild1.append(strParent1.charAt(i));
                    strChild2.append(strParent2.charAt(i));
                } else {
                    strChild1.append(strParent2.charAt(i));
                    strChild2.append(strParent1.charAt(i));
                }
            }
            bitChild1 = Lab_03_Chromosome.stringToChromosome(strChild1.toString(),10);
            bitChild2 = Lab_03_Chromosome.stringToChromosome(strChild2.toString(),10);

            double[] child1Real = Lab_03_Chromosome.getRealValues(10,-5.21,5.21,3, bitChild1);
            double[] child2Real = Lab_03_Chromosome.getRealValues(10,-5.21,5.21,3, bitChild2);

            for(int i = 0; i<child1Real.length; i++) {
                if (child1Real[i] > 5.21 || child2Real[i] > 5.21) {
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
        double[] child1 = Lab_03_Chromosome.getRealValues(10, -5.21,5.21, 3, bitChild1);
        System.out.println();
        for (double result:child1) {
            System.out.println(result);
        }

        System.out.println("\nSECOND CHILD\n");

        for (byte[] arr:bitChild2) {
            Lab_03_Chromosome.printTable(arr);
        }
        double[] child2 = Lab_03_Chromosome.getRealValues(10, -5.21,5.21, 3, bitChild2);

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


            pointOfCross2_1 = (int)(Math.random() * 140);
            pointOfCross2_2 = (int)(Math.random() * 140);

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
            bitChild1 = Lab_03_Chromosome.stringToChromosome(strChild1.toString(),10);
            bitChild2 = Lab_03_Chromosome.stringToChromosome(strChild2.toString(),10);

            double[] child1Real = Lab_03_Chromosome.getRealValues(10,-5.21,5.21,3, bitChild1);
            double[] child2Real = Lab_03_Chromosome.getRealValues(10,-5.21,5.21,3, bitChild2);

            for(int i = 0; i<child1Real.length; i++) {
                if (child1Real[i] > 5.21 || child2Real[i] > 5.21) {
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
        child1 = Lab_03_Chromosome.getRealValues(10, -5.21,5.21, 3 , bitChild1);
        System.out.println();
        for (double result:child1) {
            System.out.println(result);
        }

        System.out.println("\nSECOND CHILD\n");

        for (byte[] arr:bitChild2) {
            Lab_03_Chromosome.printTable(arr);
        }
        child2 = Lab_03_Chromosome.getRealValues(10, -5.21,5.21, 3, bitChild2);

        System.out.println();
        for (double result:child2) {
            System.out.println(result);
        }


    }

}
