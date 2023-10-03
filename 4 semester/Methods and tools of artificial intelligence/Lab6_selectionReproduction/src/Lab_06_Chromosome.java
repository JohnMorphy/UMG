import java.util.Arrays;
import java.util.Random;

public abstract class Lab_06_Chromosome {

    private final double lowerBound;
    private final double upperBound;
    private final int resolution;
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

    public void printPopulation(byte[][][] population) {
        for (byte[][] chromosome:population) {
            System.out.println();
            printChromosome(chromosome);
        }
    }

    public void printPopulationReal(byte [][][] population) {
        for (byte[][] chromosome:population) {
            System.out.println();
            printChromosome(chromosome);
            System.out.print(" ");
            System.out.print(getFunctionResult(getRealValues(chromosome)));
        }
    }

    public double getAverage(byte[][][] population) {
        double average = 0;

        for (byte[][] chromosome:population) {
            average += getFunctionResult(getRealValues(chromosome));
        }

        average /= population.length;

        return average;
    }

    public void printChromosome(byte[][] chromosome) {
        for (byte[] genome:chromosome) {
            for (byte value:genome){
                System.out.print(value);
            }
            System.out.print(" ");
        }
    }

    public void rouletteSelection(byte[][][] population) {



        double [] functionValues = new double[population.length];

        for (int i=0; i<functionValues.length; i++) {
            functionValues[i] = getFunctionResult(getRealValues(population[i]));
        }

        double minFunctionValue = functionValues[0];

        for (int i = 1; i < functionValues.length; i++) {
            if (functionValues[i] < minFunctionValue) {
                minFunctionValue = functionValues[i];
            }
        }

        double [] distanceFromMin = new double[population.length];
        for (int i=0; i<distanceFromMin.length; i++) {
            distanceFromMin[i] = functionValues[i] - minFunctionValue;
        }

        double [] improvementPercentage = new double[population.length];

        double modulatedMinFunctionValue = (minFunctionValue<0) ? -minFunctionValue : minFunctionValue;

        for (int i=0; i<improvementPercentage.length; i++) {
            improvementPercentage[i] = distanceFromMin[i]/modulatedMinFunctionValue;
        }

        double [] probability = new double[population.length];
        double [] rangeOfSelection = new double[population.length];

        probability[0] = improvementPercentage[0]+(1/population.length);
        rangeOfSelection[0] = probability[0];

        for (int i=1; i<probability.length; i++) {
            probability[i] = improvementPercentage[i]+(1/population.length);
            rangeOfSelection[i] = rangeOfSelection[i-1] + probability[i];
        }

        byte[][][] populationClone = population.clone();

        for(int i=0; i<population.length; i++) {
            double random = Math.random()*rangeOfSelection[population.length-1];
            for (int j=0; j<rangeOfSelection.length; j++) {
                if(random<rangeOfSelection[j]) {
                    population[i] = populationClone[j];
                    break;
                }
            }
        }

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

    static long toDecimal(byte[] arr) {

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
