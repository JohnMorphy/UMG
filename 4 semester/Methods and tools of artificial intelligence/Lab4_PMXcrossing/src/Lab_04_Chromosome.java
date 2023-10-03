import java.util.Arrays;
import java.util.Random;

public interface Lab_04_Chromosome {
        //for testing
        static void fillWithZeros(byte[] arr) {
            Arrays.fill(arr, (byte) 0);
        }

        //for testing
        static void fillWithOnes(byte[] arr) {
            Arrays.fill(arr, (byte) 1);
        }

        static void fillWithRandom(byte[] arr) {
            Random rand = new Random();

            for (int i = 0; i < arr.length; i++) {
                arr[i] = (byte) rand.nextInt(2);
            }
        }

        static byte[][] mutate(double lowerBound, double upperBound, int resolution,
                byte[][] chromosome, double probabilityOfMutation) {

            byte[][] mutated = chromosome.clone();

            boolean nonAllowedValues;

            do {
                nonAllowedValues = false;
                for(int i = 0; i<mutated.length; i++) {
                    for (int j = 0; j < mutated[i].length; j++) {
                        if (Math.random() < probabilityOfMutation) {
                            mutated[i][j] = (byte) ((mutated[i][j] == 1) ? 0 : 1);
                        }
                    }
                    double real = getRealValue(lowerBound, upperBound, toDecimal(mutated[i]), resolution);
                    if(real > upperBound) {
                        nonAllowedValues = true;
                        break;
                    }
                }
            }while(nonAllowedValues);

            return mutated;
        }

        static long toDecimal(byte[] arr) {

            long result = 0;

            for (int i = 0; i < arr.length; i++) {
                result += arr[i] * Math.pow(2, arr.length - i - 1);
            }

            return result;
        }

        static void printTable(byte[] arr) {
            System.out.println();
            for (byte i : arr) {
                System.out.print(i);
            }
        }
        static byte[][] generateChromosome(int numOfGenomes, double lowerBound, double upperBound, int size, int resolution) {
            if(size <= 0) {
                size = 1;
            }

            if(numOfGenomes <= 0) {
                numOfGenomes = 1;
            }

            byte[][] values = new byte[numOfGenomes][size];

            for (int i = 0; i < numOfGenomes; i++) {
                while(true) {
                    Lab_04_Chromosome.fillWithRandom(values[i]);
                    long decimal = toDecimal(values[i]);
                    double real = getRealValue(lowerBound, upperBound, decimal, resolution);
                    if(real<=upperBound) {
                        break;
                    }
                }
            }
            return values;
        }

        static double[] generateRealValues(int numOfGenomes, long lowerBound, long upperBound, int size, int resolution) {

            byte[][] bitValues = generateChromosome(numOfGenomes, lowerBound, upperBound, size, resolution);
            return getRealValues(numOfGenomes, lowerBound, upperBound, resolution, bitValues);
        }

        static double[] getRealValues(int numOfGenomes, double lowerBound, double upperBound, int resolution, byte[][] bitValues) {
            double[] realValues = new double[bitValues.length];

            for (int i = 0; i < numOfGenomes; i++) {
                long decimal = toDecimal(bitValues[i]);
                realValues[i] = getRealValue(lowerBound, upperBound, decimal, resolution);
            }

            return realValues;
        }

        static double getRealValue(double lowerBound, double upperBound, double decimal, int resolution) {
            return lowerBound + decimal * (upperBound - lowerBound)/((upperBound - lowerBound)*Math.pow(10, resolution));
        }

        static byte[][] stringToChromosome(String value, int numberOfVariables) {
            int varLength = value.length()/numberOfVariables;
            byte[][] chromosome = new byte[numberOfVariables][varLength];

            for(int i=0; i<numberOfVariables; i++) {
                for(int j=0; j<varLength; j++) {
                    chromosome[i][j] = (byte) ((byte)value.charAt(i*varLength+j)==48 ? 0 : 1);
                }
            }

            return chromosome;
        }

        // abstract method
        double getFunctionResult(double[] values);

}
