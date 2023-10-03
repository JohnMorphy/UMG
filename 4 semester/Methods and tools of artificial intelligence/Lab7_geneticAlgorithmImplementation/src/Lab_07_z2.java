public class Lab_07_z2 {


    public static void main(String[] args) {

        Lab_07_Chromosome geneticAlgorithm = new Lab_07_Chromosome(-5.21, 5.21, 3, 10) {
            @Override
            public double getFunctionResult(double[] values) {
                double value = 0;
                for (double x : values) {
                    value += Math.pow(x, 2) - 10 * Math.cos(2 * Math.PI * x);
                }
                value += 100;
                value*=-1;
                return value;
            }
        };

        byte[][][][] generations = geneticAlgorithm.geneticAlgorithm(10000, geneticAlgorithm.generatePopulation(20),
                8, 0.6,
                0.02, 0.1);

        geneticAlgorithm.printInformationAboutGenerations(generations);

    }
}
