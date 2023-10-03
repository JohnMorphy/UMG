public class Task1 implements Lab_04_Chromosome {

    @Override
    public double getFunctionResult(double[] values) {
        return -Math.pow(values[0],2)-Math.pow(values[1],2) + 2;
    }

    public static void main(String[] args) {

        Task1 task = new Task1();

        System.out.println(" --- TASK 1 - mutation --- ");

        byte[][] bitParent1 = Lab_04_Chromosome.generateChromosome(2, -2,2,19, 5);
        double[] parent1 = Lab_04_Chromosome.getRealValues(2, -2,2,5, bitParent1);
        System.out.println("FIRST PARENT");
        for (byte[] arr :bitParent1) {
            Lab_04_Chromosome.printTable(arr);
        }
        System.out.println();
        for (double result:parent1) {
            System.out.println(result);
        }

        System.out.println();
        System.out.println("function result: " + task.getFunctionResult(parent1));
        System.out.println();

        System.out.println("SECOND PARENT");
        byte[][] bitParent2 = Lab_04_Chromosome.generateChromosome(2, -2,2,19, 5);
        double[] parent2 = Lab_04_Chromosome.getRealValues(2, -2,2, 5, bitParent2);
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
        bitParent1 = Lab_04_Chromosome.mutate(-5.21, 5.21,5, bitParent1, 0.1);
        for (byte[] arr:bitParent1) {
            Lab_04_Chromosome.printTable(arr);
        }

        System.out.println("\n-----mutation, parent 2, probability -> 0.1-----");
        bitParent2 = Lab_04_Chromosome.mutate(-5.21, 5.21,5, bitParent2, 0.1);
        for (byte[] arr:bitParent2) {
            Lab_04_Chromosome.printTable(arr);
        }

        System.out.println("variable values change due to mutation, so function value will also change");
    }

}
