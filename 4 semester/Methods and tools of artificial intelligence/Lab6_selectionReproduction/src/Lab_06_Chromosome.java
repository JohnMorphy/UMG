import java.util.Arrays;
import java.util.Random;

public abstract class Lab_06_Chromosome {

    private double lowerBound;
    private double upperBound;
    private int resolution;
    private int size;
    private int numOfGenomes;

    public Lab_06_Chromosome() {
        this(-2.0, 2.0, 5, 19, 2);
    }

    public Lab_06_Chromosome(double lowerBound, double upperBound, int resolution, int size, int numOfGenomes) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.resolution = resolution;
        this.size = size;
        this.numOfGenomes = numOfGenomes;
    }

    static void fillWithZeros(byte[] arr) {
        Arrays.fill(arr, (byte) 0);
    }

    static void fillWithOnes(byte[] arr) {
        Arrays.fill(arr, (byte) 1);
    }

    static void fillWithRandom(byte[] arr) {
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (byte) rand.nextInt(2);
        }
    }

    static void printTable(byte[] arr) {
        System.out.println();
        for (byte i : arr) {
            System.out.print(i);
        }
    }

    static byte[][] stringToChromosome(String value, int numberOfVariables) {
        int varLength = value.length() / numberOfVariables;
        byte[][] chromosome = new byte[numberOfVariables][varLength];

        for (int i = 0; i < numberOfVariables; i++) {
            for (int j = 0; j < varLength; j++) {
                chromosome[i][j] = (byte) ((byte) value.charAt(i * varLength + j) == 48 ? 0 : 1);
            }
        }

        return chromosome;
    }

    private byte[][] mutate(byte[][] chromosome, double probabilityOfMutation) {

        byte[][] mutated = chromosome.clone();

        boolean nonAllowedValues;

        do {
            nonAllowedValues = false;
            for (int i = 0; i < mutated.length; i++) {
                for (int j = 0; j < mutated[i].length; j++) {
                    if (Math.random() < probabilityOfMutation) {
                        mutated[i][j] = (byte) ((mutated[i][j] == 1) ? 0 : 1);
                    }
                }
                double real = getRealValue(toDecimal(mutated[i]));
                if (real > upperBound) {
                    nonAllowedValues = true;
                    break;
                }
            }
        } while (nonAllowedValues);

        return mutated;
    }

    private long toDecimal(byte[] arr) {

        long result = 0;

        for (int i = 0; i < arr.length; i++) {
            result += arr[i] * Math.pow(2, arr.length - i - 1);
        }

        return result;
    }

    private byte[][] generateChromosome() {
        if (size <= 0) {
            size = 1;
        }

        if (numOfGenomes <= 0) {
            numOfGenomes = 1;
        }

        byte[][] values = new byte[numOfGenomes][size];

        for (int i = 0; i < numOfGenomes; i++) {
            while (true) {
                Lab_06_Chromosome.fillWithRandom(values[i]);
                double real = getRealValue(toDecimal(values[i]));
                if (real <= upperBound) {
                    break;
                }
            }
        }
        return values;
    }

    public byte[][][] generatePopulation(int numberOfChromosomes) {
        byte[][][] population = new byte[numberOfChromosomes][numOfGenomes][size];

        for (int i = 0; i < numberOfChromosomes; i++) {
            population[i] = generateChromosome();
        }

        return population;
    }

    public double[] generateRealValues() {

        byte[][] bitValues = generateChromosome();
        return getRealValues(bitValues);
    }

    public double[] getRealValues(byte[][] bitValues) {
        double[] realValues = new double[bitValues.length];

        for (int i = 0; i < numOfGenomes; i++) {
            long decimal = toDecimal(bitValues[i]);
            realValues[i] = getRealValue(decimal);
        }

        return realValues;
    }

    private double getRealValue(long decimal) {
        return lowerBound + decimal * (upperBound - lowerBound) / ((upperBound - lowerBound) * Math.pow(10, resolution));
    }

    // abstract method
    abstract double getFunctionResult(double[] values);

}
