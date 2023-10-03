public class Lab_06_z2 {

    public static void main(String[] args) {
        Lab_06_Chromosome testChromosome = new Lab_06_Chromosome(-5.21, 5.21, 3, 14, 10) {
            @Override
            public double getFunctionResult(double[] values) {
                double value = 0;
                for (double x : values) {
                    value += Math.pow(x, 2) - 10 * Math.cos(2 * Math.PI * x);
                }
                value += 100;
                return value;
            }
        };

        // 2.1 -> generate population

        byte[][][] population = testChromosome.generatePopulation(10);

        System.out.println("For Rastring function\nGenerated population P(1):");
        testChromosome.printPopulationReal(population);

        byte[][][] population2 = population.clone();

        int n = 2;

        // 2.2 -> roulette population

        for (int i = 0; i < n; i++) {
            testChromosome.rouletteSelection(population2);
        }

        System.out.println("\nP(2) -> population after " + n + " selections");

        testChromosome.printPopulationReal(population2);

        // 2.3 -> average values

        System.out.println("\n\nP(1) average function result: " + testChromosome.getAverage(population));
        System.out.println("\n\nP(2) average function result: " + testChromosome.getAverage(population2));

    }
}
