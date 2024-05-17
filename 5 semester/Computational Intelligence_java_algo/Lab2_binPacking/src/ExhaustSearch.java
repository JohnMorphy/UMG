import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ExhaustSearch {

    public static void main(String[] args) {

        String fileName = "binpack1.txt";

        int[] data = getBinpackData(fileName);
        int binCapacity = data[0];
        int itemCount = data[1];
        int optimalSolution = data[2];
        int[] sizes = new int[itemCount];
        for (int i = 3; i < data.length; i++) {
            sizes[i-3] = data[i];
        }

        System.out.println("Optimal solution is: " + optimalSolution + "\n");

        // next-fit
        int[] solution1 = nextFit(binCapacity, sizes);

        // first-fit
        int[] solution2 = firstFit(binCapacity, sizes);

        // best-fit
        int[] solution3 = bestFit(binCapacity, sizes);

        // worst-fit
        int[] solution4 = worstFit(binCapacity, sizes);

        // first-fit-decreasing
        int[] solution5 = firstFitDecreasing(binCapacity, sizes);

    }

    // reading values from file
    public static int[] getBinpackData(String fileName) {

        try {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            String[] values = content.split("[ \n]" );

            int[] intArray = new int[values.length];

            for (int i = 0; i < values.length; i++) {
                intArray[i] = Integer.parseInt(values[i]);
            }
            
            return intArray;

        } catch (IOException exception) {
            return null;
        }

    }

    // Next-Fit
    public static int[] nextFit(int binCapacity, int[] sizes) {

        int binCount = 1;
        int lastBinTakenSpace = 0;

        int[] solution = new int[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            if(lastBinTakenSpace + sizes[i] <= binCapacity) {
                solution[i] = binCount;
                lastBinTakenSpace += sizes[i];
            } else {
               binCount ++;
               lastBinTakenSpace = sizes[i];
               solution[i] = binCount;
            }
        }

        System.out.println("Bin count in \"next-fit\" algorithm: " + binCount);

        return solution;
    }

    // First-Fit

    public static int[] firstFit(int binCapacity, int[] sizes) {

        int[] solution = new int[sizes.length];
        int[] binsCapacity = new int[sizes.length];

        for (int i = 0; i < sizes.length; i++) {

            int firstFit = 0;

            while(binsCapacity[firstFit] + sizes[i] > binCapacity) {
                firstFit++;
            }

            solution[i] = firstFit+1;
            binsCapacity[firstFit] += sizes[i];
        }

        System.out.println("Bin count in \"first-fit\" algorithm: " + Arrays.stream(solution).max().getAsInt());

        return solution;
    }

    // Best-Fit

    public static int[] bestFit(int binCapacity, int[] sizes) {

        int[] solution = new int[sizes.length];
        int[] binsCapacity = new int[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            int bestFit = 0;

            while(binsCapacity[bestFit] + sizes[i] > binCapacity) {
                bestFit++;
            }

            for (int j = bestFit+1; j < sizes.length && binsCapacity[j] > 0 ; j++) {
                if(binsCapacity[j] + sizes[i] <= binCapacity && binsCapacity[j] > binsCapacity[bestFit]) {
                    bestFit = j;
                }
            }

            binsCapacity[bestFit] += sizes[i];
            solution[i] = bestFit+1;
        }

        System.out.println("Bin count in \"best-fit\" algorithm: " + Arrays.stream(solution).max().getAsInt());

        return solution;
    }

    // Worst-Fit

    public static int[] worstFit(int binCapacity, int[] sizes) {

        int[] solution = new int[sizes.length];
        int[] binsCapacity = new int[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            int bestFit = 0;

            while(binsCapacity[bestFit] + sizes[i] > binCapacity) {
                bestFit++;
            }

            for (int j = bestFit+1; j < sizes.length && binsCapacity[j] > 0 ; j++) {
                if(binsCapacity[j] + sizes[i] <= binCapacity && binsCapacity[j] < binsCapacity[bestFit]) {
                    bestFit = j;
                }
            }

            binsCapacity[bestFit] += sizes[i];
            solution[i] = bestFit+1;
        }

        System.out.println("Bin count in \"worst-fit\" algorithm: " + Arrays.stream(solution).max().getAsInt());

        return solution;
    }

    // First-Fit_Decreasing
    public static int[] firstFitDecreasing(int binCapacity, int[] sizes) {

        // sorting and reversing 'sizes' array
        int[] reverseSorted = sizes.clone();

        Arrays.sort(reverseSorted);

        int left = 0;
        int right = reverseSorted.length - 1;

        while (left < right) {

            int temp = reverseSorted[left];
            reverseSorted[left] = reverseSorted[right];
            reverseSorted[right] = temp;

            left++;
            right--;
        }

        //placing values in bins
        int[] solution = new int[reverseSorted.length];
        int[] binsCapacity = new int[reverseSorted.length];

        for (int i = 0; i < reverseSorted.length; i++) {

            int firstFit = 0;

            while(binsCapacity[firstFit] + reverseSorted[i] > binCapacity) {
                firstFit++;
            }

            solution[i] = firstFit+1;
            binsCapacity[firstFit] += reverseSorted[i];
        }

        //mapping the values - here I made it inefficient, just for simplicity;
        //it would be easier to build this using objective paradigm, but
        //I opted for imperative
        int[] mappedSolution = new int[sizes.length];

        for (int i = 0; i < solution.length; i++) {

            for(int j = 0; j < solution.length; j++) {
                if(reverseSorted[i] == sizes[j]) {
                    mappedSolution[j] = solution[i];
                    sizes[j] = -1;
                    break;
                }
            }

        }

        System.out.println("Bin count in \"first-fit-decreasing\" algorithm: " + Arrays.stream(mappedSolution).max().getAsInt());

        return mappedSolution;
    }

}
