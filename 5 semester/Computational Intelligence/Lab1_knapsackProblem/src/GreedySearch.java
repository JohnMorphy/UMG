import java.util.Arrays;
import java.util.Random;

public class GreedySearch {

    public static void main(String[] args) {

        int backpackCapacity = 21;
        int[] itemSizes = {3, 9, 12, 4, 6, 2, 1, 6};
        int[] itemValues = {6, 4, 7, 9, 13, 11, 5, 6};
        double[] valueToSizeProportion = new double[8];

        for (int i = 0; i < itemSizes.length; i++) {
            valueToSizeProportion[i] = (double)itemValues[i]/(double)itemSizes[i];
        }

        int[] solution;

        // sequential

        solution = getSequentialSolution(backpackCapacity, itemSizes, itemValues);
        System.out.println("Sequential: " + Arrays.toString(solution));
        System.out.println("Value: " + getMappedValue(solution, itemValues));
        System.out.println("Size: " + getMappedValue(solution, itemSizes));


        // random

        solution = getRandomSolution(backpackCapacity, itemSizes, itemValues, 10);
        System.out.println("Sequential: " + Arrays.toString(solution));
        System.out.println("Value: " + getMappedValue(solution, itemValues));
        System.out.println("Size: " + getMappedValue(solution, itemSizes));

        // greedy -> items with best proportion

        solution = getByBestProportions(backpackCapacity, itemSizes, itemValues);
        System.out.println("Sequential: " + Arrays.toString(solution));
        System.out.println("Value: " + getMappedValue(solution, itemValues));
        System.out.println("Size: " + getMappedValue(solution, itemSizes));

    }

    public static int[] getSequentialSolution(int backpackCapacity,
                                              int[] itemSizes, int[] itemValues) {

        int bestSolutionValue = 0;
        int[] solution = new int[itemSizes.length];

        for (int i = 0; i < itemSizes.length; i++) {

            int tempSize = 0;
            int[] tempSolution = new int[itemSizes.length];

            if(itemSizes[i] <= backpackCapacity) {
                tempSolution[i] = 1;
                tempSize += itemSizes[i];
            }

            for (int j = i+1; j < itemSizes.length+i; j++) {
                if(j < itemSizes.length) {
                    if(itemSizes[j] + tempSize <= backpackCapacity) {
                        tempSolution[j] = 1;
                        tempSize += itemSizes[j];
                    }
                } else {
                    if(itemSizes[j-i] + tempSize <= backpackCapacity) {
                        tempSolution[j-i] = 1;
                        tempSize += itemSizes[j-i];
                    }
                }
            }

            int tempSolutionValue = getMappedValue(tempSolution, itemValues);

            if(tempSolutionValue > bestSolutionValue) {
                solution = tempSolution.clone();
                bestSolutionValue = tempSolutionValue;
            }
        }

        return solution;
    }

    public static int[] getRandomSolution(int backpackCapacity,
                                             int[] itemSizes, int[] itemValues, int amountOfIterations) {
        int iterationCount = 0;

        int bestSolutionValue = 0;
        int[] solution = new int[itemSizes.length];

        Random random = new Random();
        int randomIndex;

        while(iterationCount<amountOfIterations) {

            int tempSize = 0;
            int[] tempSolution = new int[itemSizes.length];

            while(true) {
                 randomIndex = random.nextInt(itemSizes.length);
                 if(tempSolution[randomIndex] == 0 && itemSizes[randomIndex] + tempSize <= backpackCapacity) {
                     tempSize += itemSizes[randomIndex];
                     tempSolution[randomIndex] = 1;
                 } else if (itemSizes[randomIndex] + tempSize > backpackCapacity) {
                     break;
                 }
            }

            int tempSolutionValue = getMappedValue(tempSolution, itemValues);

            if(tempSolutionValue > bestSolutionValue) {
                solution = tempSolution.clone();
                bestSolutionValue = tempSolutionValue;
            }
            iterationCount++;
        }

        return solution;
    }

    public static int[] getByBestProportions(int backpackCapacity,
                                             int[] itemSizes, int[] itemValues) {

        int bestSolutionValue = 0;
        int size = 0;
        int[] solution = new int[itemSizes.length];
        Double[] valueToSizeProportion = new Double[itemSizes.length];

        for (int i = 0; i < itemSizes.length; i++) {
            valueToSizeProportion[i] = (double)itemValues[i]/(double)itemSizes[i];
        }

        while(true) {
            int currentBest = getMaxIndex(valueToSizeProportion);
            if (valueToSizeProportion[currentBest] == -1) {
                break;
            }
            valueToSizeProportion[currentBest] = -1.0;

            if(size + itemSizes[currentBest] <= backpackCapacity) {
                size += itemSizes[currentBest];
                solution[currentBest] = 1;
            }
        }

        return solution;
    }

    public static <T extends Comparable<T>> int getMaxIndex(T[] array) {

        int maxIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(array[maxIndex]) > 0) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }
    public static int getMappedValue(int[] valuesToAdd, int[] value) {

        int sum = 0;

        for (int i = 0; i < value.length; i++) {
            if(valuesToAdd[i] == 1) {
                sum += value[i];
            }
        }

        return sum;
    }

    public static int[] convertToBinary(int decimal, int length) {

        int[] binaryNumber = new int[length];

        for(int i = 0; i < length; i++) {
            binaryNumber[i] = decimal & 1;
            decimal >>= 1;
        }

        return binaryNumber;
    }
}


