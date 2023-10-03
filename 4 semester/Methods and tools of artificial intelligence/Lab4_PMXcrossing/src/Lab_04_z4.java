public class Lab_04_z4 implements Lab_04_Chromosome {

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

        Lab_04_z4 task = new Lab_04_z4();

        System.out.println(" --- TASK 4 - mutation, Rastring--- ");

        byte[][] bitParent1 = Lab_04_Chromosome.generateChromosome(10, -5.21,5.21,14, 3);
        double[] parent1 = Lab_04_Chromosome.getRealValues(10, -5.21,5.21,3, bitParent1);
        System.out.println("FIRST PARENT");
        for (byte[] arr :bitParent1) {
            Lab_04_Chromosome.printTable(arr);
        }
        System.out.println();
        for (double result:parent1) {
            System.out.println(result);
        }

        System.out.println();
        System.out.println("\nfunction result: " + task.getFunctionResult(parent1));
        System.out.println();

        System.out.println("SECOND PARENT");
        byte[][] bitParent2 = Lab_04_Chromosome.generateChromosome(10, -5.21,5.21,14, 3);
        double[] parent2 = Lab_04_Chromosome.getRealValues(10, -5.21,5.21, 3, bitParent2);
        for (byte[] arr :bitParent2) {
            Lab_04_Chromosome.printTable(arr);
        }
        System.out.println();
        for (double result:parent2) {
            System.out.println(result);
        }

        System.out.println();
        System.out.println("function result: " + task.getFunctionResult(parent2));

        System.out.println("-----mutation, parent 1, probability -> 0.1-----");
        bitParent1 = Lab_04_Chromosome.mutate(-5.21, 5.21,3, bitParent1, 0.1);
        for (byte[] arr:bitParent1) {
            Lab_04_Chromosome.printTable(arr);
        }

        System.out.println("\n-----mutation, parent 2, probability -> 0.1-----");
        bitParent2 = Lab_04_Chromosome.mutate(-5.21, 5.21,3, bitParent2, 0.1);
        for (byte[] arr:bitParent2) {
            Lab_04_Chromosome.printTable(arr);
        }

        System.out.println("\nvariable values change due to mutation, so function value will also change");
    }

}
