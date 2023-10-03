public class Lab_05_z1 {

    public static void main(String[] args) {
        Lab_05_Chromosome testChromosome = new Lab_05_Chromosome() {
            @Override
            double getFunctionResult(double[] values) {
                return -Math.pow(values[0],2)-Math.pow(values[1],2) + 2;
            }
        };

        // 1.1 -> generate genome

        byte[][][] genome = testChromosome.generatePopulation(10);


        for (int i=0; i<genome.length; i++) {
            System.out.println("Chromosome " + (i+1));
            for (byte[] chromosome:genome[i]) {
                Lab_05_Chromosome.printTable(chromosome);
            }
            System.out.println();
        }

        // 1.2 -> get function values

        double[] functionValues = new double[10];
        System.out.println();

        for (int i=0; i<functionValues.length; i++) {
            functionValues[i] = testChromosome.getFunctionResult(testChromosome.getRealValues(genome[i]));
            System.out.println("Chromosome " + (i + 1) + ": " + functionValues[i]);
        }

        // 1.4 -> average value

        double average = 0;

        for (double value:functionValues) {
            average += value;
        }

        average/= functionValues.length;

        System.out.println();
        System.out.println("Average function value: " + average);
        System.out.println();

        // 1.5 & 1.6 -> chromosomes with below/above average value

        int belowAverageCount = 0;
        int aboveAverageCount = 0;

        for (double value:functionValues) {
            if (value < average) {
                belowAverageCount++;
            } else {
                aboveAverageCount++;
            }
        }

        System.out.println("Amount of chromosomes with below average value: " + belowAverageCount);
        System.out.println("Amount of chromosomes with above/equal value to average : " + aboveAverageCount);

    }
}
