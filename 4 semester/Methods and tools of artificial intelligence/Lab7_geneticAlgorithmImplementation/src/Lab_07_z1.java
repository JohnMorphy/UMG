public class Lab_07_z1 {


    public static void main(String[] args) {

        Lab_07_Chromosome geneticAlgorithm = new Lab_07_Chromosome() {
            @Override
            double getFunctionResult(double[] values) {
                return -Math.pow(values[0], 2) - Math.pow(values[1], 2) + 2;
            }
        };

        byte[][][][] generations = geneticAlgorithm.geneticAlgorithm(1000, geneticAlgorithm.generatePopulation(20),
                2, 0.6,
                0.02, 0.1);

        geneticAlgorithm.printInformationAboutGenerations(generations);


    }

}
