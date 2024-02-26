import java.util.Arrays;

public class ExhaustSearch {

    public static void main(String[] args) {

        int backpackCapacity = 21;
        int[] itemSizes = {3, 9, 12, 4, 6, 2, 1, 6};
        int[] itemValues = {6, 4, 7, 9, 13, 11, 5, 6};

        int[] solution = getSolution(backpackCapacity, itemSizes, itemValues);

        System.out.println(Arrays.toString(solution));
        System.out.println("Value: " + getSizeValue(solution, itemValues));
        System.out.println("Size: " + getSizeValue(solution, itemSizes));
    }

    public static int[] getSolution(int backpackCapacity, int[] itemSizes, int[] itemValues) {

        int bestSolutionValue = 0;
        int[] solution = new int[itemSizes.length];

        for (int i = 0; i < 256; i++) {

            int[] tempSolution = convertToBinary(i, itemSizes.length);
            int tempSize = getSizeValue(tempSolution, itemSizes);

            if(tempSize <= backpackCapacity) {
                int tempValue = getSizeValue(tempSolution, itemValues);
                if(tempValue > bestSolutionValue) {
                    bestSolutionValue = tempValue;
                    System.arraycopy(tempSolution, 0, solution, 0, tempSolution.length);
                }
            }


        }

        return solution;

    }

    public static int getSizeValue(int[] binaryTaken, int[] itemSizes) {

        int size = 0;

        for (int i = 0; i < itemSizes.length; i++) {
            if(binaryTaken[i] == 1) {
                size += itemSizes[i];
            }
        }

        return size;
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
