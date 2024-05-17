import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class KnapsackTabu {

    public static int BACKPACK_CAPACITY;
    private static final String fileName = "small_instances/f8_l-d_kp_23_10000";

    private static final TaskQueue<KnapsackSwapRecord> TABU_LIST = new TaskQueue<>();
    private static final int TABU_LENGTH = 50;
    private static final int MAX_ITERATIONS = 10000;

    private static final double TEMPERATURE = 100.0;
    private static final double ALFA = 0.95;

    public static void main(String[] args) {

        double optimalVal = 9767;

        // initial random, then tabu
        try {
            KnapsackObject[] allKnapsackObjects = readData(fileName);

            int[] evaluations = new int[10];
            double avg = 0;
            for (int i = 0; i < 10; i++) {
                int[] tabuSolution = tabuSearch(allKnapsackObjects, MAX_ITERATIONS, TABU_LENGTH, "RANDOM");

                evaluations[i] =  evaluateSolution(tabuSolution, allKnapsackObjects);
                System.out.println(evaluations[i]);

            }
            for (int val:evaluations) {
                avg += val;
            }
            avg /= 10;
            System.out.println(avg + "");

            double avgError = 0;
            double[] error = new double[10];
            for (int i = 0; i<evaluations.length; i++) {
                error[i] = Math.round(10000.0 * (double)(optimalVal - evaluations[i])/(double) optimalVal)/100.0;
                System.out.println(error[i]+"%");
                avgError += error[i];
            }
            avgError /= 10;
            System.out.println(avgError + "% \n");

            System.out.println();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // greedy; then tabu
        try {
            KnapsackObject[] allKnapsackObjects = readData(fileName);

            int[] evaluations = new int[10];
            double avg = 0;
            for (int i = 0; i < 10; i++) {
                int[] tabuSolution = tabuSearch(allKnapsackObjects, MAX_ITERATIONS, TABU_LENGTH, "GREEDY");

                evaluations[i] =  evaluateSolution(tabuSolution, allKnapsackObjects);
                System.out.println(evaluations[i]);

            }
            for (int val:evaluations) {
                avg += val;
            }
            avg /= 10;
            System.out.println(avg + "");

            double avgError = 0;
            double[] error = new double[10];
            for (int i = 0; i<evaluations.length; i++) {
                error[i] = Math.round(10000.0 * (double)(optimalVal - evaluations[i])/(double) optimalVal)/100.0;
                System.out.println(error[i]+"%");
                avgError += error[i];
            }
            avgError /= 10;
            System.out.println(avgError + "% \n");

            System.out.println();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // initial random; then simulated annealing
        try {
            KnapsackObject[] allKnapsackObjects = readData(fileName);
            int[] evaluations = new int[10];
            double avg = 0;
            for (int i = 0; i < 10; i++) {
                int[] tabuSolution = simulatedAnnealing(allKnapsackObjects, MAX_ITERATIONS,
                        "RANDOM",TEMPERATURE, ALFA);

                evaluations[i] =  evaluateSolution(tabuSolution, allKnapsackObjects);
                System.out.println(evaluations[i]);

            }
            for (int val:evaluations) {
                avg += val;
            }
            avg /= 10;
            System.out.println(avg + "");

            double avgError = 0;
            double[] error = new double[10];
            for (int i = 0; i<evaluations.length; i++) {
                error[i] = Math.round(10000.0 * (double)(optimalVal - evaluations[i])/(double) optimalVal)/100.0;
                System.out.println(error[i]+"%");
                avgError += error[i];
            }
            avgError /= 10;
            System.out.println(avgError + "% \n");

            System.out.println();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // GREEDY; then simulated annealing


        try {
            KnapsackObject[] allKnapsackObjects = readData(fileName);
            int[] evaluations = new int[10];
            double avg = 0;
            for (int i = 0; i < 10; i++) {
                int[] tabuSolution = simulatedAnnealing(allKnapsackObjects, MAX_ITERATIONS,
                        "GREEDY",TEMPERATURE, ALFA);

                evaluations[i] =  evaluateSolution(tabuSolution, allKnapsackObjects);
                System.out.println(evaluations[i]);

            }
            for (int val:evaluations) {
                avg += val;
            }
            avg /= 10;
            System.out.println(avg + "");

            double avgError = 0;
            double[] error = new double[10];
            for (int i = 0; i<evaluations.length; i++) {
                error[i] = Math.round(10000.0 * (double)(optimalVal - evaluations[i])/(double) optimalVal)/100.0;
                System.out.println(error[i]+"%");
                avgError += error[i];
            }
            avgError /= 10;
            System.out.println(avgError + "% \n");

            System.out.println();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static KnapsackObject[] readData(String filename) throws IOException {

        String content = new String(Files.readAllBytes(Paths.get(filename)));
        content = content.trim();
        String[] contentArray = content.split("\\s+");

        final int objectCount = Integer.parseInt(contentArray[0]);
        final int knapsackSize = Integer.parseInt(contentArray[1]);

        KnapsackObject[] knapsackArray = new KnapsackObject[objectCount];

        KnapsackTabu.BACKPACK_CAPACITY = knapsackSize;

        for(int i = 0; i < objectCount; i++) {
            int value = Integer.parseInt(contentArray[(i*2)+2]);
            int size = Integer.parseInt(contentArray[(i*2)+3]);
            knapsackArray[i] = new KnapsackObject(value, size);
        }

        return knapsackArray;
    }

    public static int[] simulatedAnnealing(KnapsackObject[] knapsackObjects,
                                           final int MAX_ITERATIONS,
                                           String initialSolution,
                                           double temperature, double alfa) {

        int[] vc;
        if (initialSolution == "GREEDY") {
            vc = initialGreedySolution(knapsackObjects);
        } else {
            vc = initialRandomSolution(knapsackObjects);
        }

        int[] best = vc.clone();

        Random random = new Random();
        int iteration = 0;

        while(iteration < MAX_ITERATIONS) {

            int[] vn = randomLocalSolution(vc, knapsackObjects);

            double currentEnergy = evaluateSolution(vc, knapsackObjects);
            double newEnergy = evaluateSolution(vn, knapsackObjects);

            if (newEnergy > currentEnergy || random.nextDouble() < Math.exp((newEnergy - currentEnergy) / temperature)) {
                vc = vn;
            }

            temperature = temperature*alfa;
            iteration++;

        }

        return vc;
    }

    public static int[] tabuSearch(KnapsackObject[] knapsackObjects, final int MAX_ITERATIONS,
                                   final int TABU_LENGTH, String initialSolution) {

        TABU_LIST.clear();

        int[] vc;
        if (initialSolution == "GREEDY") {
            vc = initialGreedySolution(knapsackObjects);
        } else {
            vc = initialRandomSolution(knapsackObjects);
        }

        int[] best = vc.clone();

        int iteration = 0;
        do {
            vc = randomTabuSolution(best, knapsackObjects, TABU_LENGTH);

            int currentTime = evaluateSolution(vc, knapsackObjects);
            int currentSize = getSolutionSize(vc,knapsackObjects);

            int bestTime = evaluateSolution(best, knapsackObjects);

            if(currentTime > bestTime && currentSize <= BACKPACK_CAPACITY) {
                best = vc.clone();
            }
            iteration++;

        } while (iteration < MAX_ITERATIONS);

        return best;
    }

    public static int[] randomLocalSolution(int[] initialSolution, KnapsackObject[] knapsackObjects) {

        int[] randomLocalSolution = initialSolution.clone();

        Random random = new Random();
        int lastIndex = initialSolution.length-1;

        int id1 = 0;

        for (int i = 0; i<100; i++) {
            id1 = (random.nextInt(0, lastIndex));

            if (initialSolution[id1] == 1) {
                break;
            }
        }

        int id2 = (random.nextInt(0, lastIndex));

        int buffer = randomLocalSolution[id1];
        randomLocalSolution[id1] = randomLocalSolution[id2];
        randomLocalSolution[id2] = buffer;

        if(getSolutionSize(randomLocalSolution,knapsackObjects) > BACKPACK_CAPACITY) {
            return initialSolution.clone();
        }

        return randomLocalSolution;
    }


    public static int[] randomTabuSolution(int[] initialSolution, KnapsackObject[] knapsackObjects, final int TABU_LENGTH) {

        int[] randomLocalSolution = initialSolution.clone();

        KnapsackSwapRecord knapsackSwapRecord = randomSwapRecord(randomLocalSolution, knapsackObjects);

        if(TABU_LIST.contains(knapsackSwapRecord)) {
            return randomTabuSolution(initialSolution, knapsackObjects, TABU_LENGTH);
        } else {
            int buffer = randomLocalSolution[knapsackSwapRecord.id1()];
            randomLocalSolution[knapsackSwapRecord.id1()] = randomLocalSolution[knapsackSwapRecord.id2()];
            randomLocalSolution[knapsackSwapRecord.id2()] = buffer;
            addToTabuList(knapsackSwapRecord, TABU_LENGTH);
        }

        return randomLocalSolution;
    }

    public static KnapsackSwapRecord randomSwapRecord(int[] solution, KnapsackObject[] knapsackObjects) {

        Random random = new Random();

        int lastIndex = solution.length-1;

        int id1 = 0;

        // 100 attempts to find used knapsack
        for (int i = 0; i<100; i++) {
            id1 = (random.nextInt(0, lastIndex));

            if (solution[id1] == 1) {
                break;
            }
        }
        int id2 = (random.nextInt(0, lastIndex));

        KnapsackObject obj1 = knapsackObjects[id1];
        KnapsackObject obj2 = knapsackObjects[id2];

        return new KnapsackSwapRecord(obj1, obj2, id1, id2);
    }

    public static void addToTabuList(KnapsackSwapRecord knapsackSwapRecord, int TABU_LENGTH) {
        if(TABU_LIST.length() >= TABU_LENGTH) {
            TABU_LIST.poll();
            TABU_LIST.offer(knapsackSwapRecord);
        } else {
            TABU_LIST.offer(knapsackSwapRecord);
        }
    }

    public static int[] initialRandomSolution(KnapsackObject[] knapsackArray) {

        int[] solution = new int[knapsackArray.length];

        Random random = new Random();
        int randomIndex;

        int tempSize = 0;

        while(true) {
            randomIndex = random.nextInt(solution.length);
            if(solution[randomIndex] == 0 && knapsackArray[randomIndex].getSize() + tempSize <= BACKPACK_CAPACITY) {
                tempSize += knapsackArray[randomIndex].getSize();
                solution[randomIndex] = 1;
            } else if (knapsackArray[randomIndex].getSize() + tempSize > BACKPACK_CAPACITY) {
                break;
            }
        }

        return solution;
    }

    public static int[] initialGreedySolution(KnapsackObject[] knapsackObjects) {

        Double[] valueToSizeProportions = new Double[knapsackObjects.length];
        int currentSize = 0;

        for (int i = 0; i<knapsackObjects.length; i++) {
            valueToSizeProportions[i] = (double)knapsackObjects[i].getValue()/(double)knapsackObjects[i].getSize();
        }

        int[] solution = new int[knapsackObjects.length];

        while(true) {
            int currentBest = getMaxIndex(valueToSizeProportions);
            if (valueToSizeProportions[currentBest] == -1) {
                break;
            }
            valueToSizeProportions[currentBest] = -1.0;

            if(currentSize + knapsackObjects[currentBest].getSize() <= BACKPACK_CAPACITY) {
                currentSize += knapsackObjects[currentBest].getSize();
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

    public static int evaluateSolution (int[] solution, KnapsackObject[] knapsackArray) {

        int evaluation = 0;

        for (int i = 0; i<solution.length; i++) {
            evaluation += solution[i] * knapsackArray[i].getValue();
        }

        return evaluation;
    }

    public static int getSolutionSize(int[] solution, KnapsackObject[] knapsackArray) {

        int size = 0;

        for (int i = 0; i<solution.length; i++) {
            size += solution[i] * knapsackArray[i].getSize();
        }

        return size;
    }

    public static class KnapsackObject {
        final private int value;
        final private int size;

        public KnapsackObject(int value, int size) {
            this.value = value;
            this.size = size;
        }

        public int getValue() {
            return value;
        }

        public int getSize() {
            return size;
        }

        @Override
        public String toString() {
            return "(v: " + value +
                    " s: " + size +
                    ')';
        }
    }

    public record KnapsackSwapRecord (KnapsackObject obj1, KnapsackObject obj2, int id1, int id2) {

        public boolean isBeneficial(KnapsackObject[] knapsackObjects) {

            int valueWithoutSwap = obj1.getValue();

            int valueWithSwap = obj2.getValue();

            int gainedOnSwap = valueWithSwap - valueWithoutSwap;

            return gainedOnSwap > 0;
        }

        @Override
        public boolean equals(Object o) {
            if (null == o) return true;
            if (!(o instanceof KnapsackSwapRecord knapsackSwapRecord)) return false;
            return obj1.equals(knapsackSwapRecord.obj1) && obj2.equals(knapsackSwapRecord.obj2);
        }

    }
}
