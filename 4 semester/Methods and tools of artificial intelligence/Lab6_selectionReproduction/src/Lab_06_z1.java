import jdk.swing.interop.SwingInterOpUtils;

public class Lab_06_z1 {

    public static void main(String[] args) {
        Lab_06_Chromosome testChromosome = new Lab_06_Chromosome() {
            @Override
            double getFunctionResult(double[] values) {
                return -Math.pow(values[0], 2) - Math.pow(values[1], 2) + 2;
            }
        };

        // 1.1 -> generate population

        byte[][][] population = testChromosome.generatePopulation(10);

        System.out.println("Generated population P(1):");
        testChromosome.printPopulationReal(population);

        byte[][][] population2 = population.clone();

        int n = 100;

        // 1.2 -> roulette population

        for(int i=0; i<n; i++) {
            testChromosome.rouletteSelection(population2);
        }

        System.out.println("\nP(2) -> population after " + n + " selections");

        testChromosome.printPopulationReal(population2);

        // 1.3 -> average values

        System.out.println("\n\nP(1) average function result: " + testChromosome.getAverage(population));
        System.out.println("\n\nP(2) average function result: " + testChromosome.getAverage(population2));

    }
}
