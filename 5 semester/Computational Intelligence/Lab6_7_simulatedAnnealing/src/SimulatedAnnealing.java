import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SimulatedAnnealing {

    private static int[][] workersTime;
    private static final int MAX_ITERATIONS = 3000;
    private static final String fileName = "assign100.txt";

    // parameters for simulatedAnnealing
    private static final int temperature = 100;
    private static final double alfa =0.95;
    private static final int INTERNAL_ITERATIONS = 50;

    public static void main(String[] args) {

        // simulated annealing

        try {
            workersTime = readData(fileName);
            ArrayList<Double> array = new ArrayList<>();
            double average = 0;
            for(int i=0; i<10; i++) {
                array.add((double) evaluateSolution(workersTime, simulatedAnnealing(workersTime, temperature, alfa, INTERNAL_ITERATIONS, MAX_ITERATIONS)));
                System.out.println(array.get(i));
                average += array.get(i);
            }
            average /=10.0;
            System.out.println(average);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int[][] readData(String filename) throws IOException {

        String content = new String(Files.readAllBytes(Paths.get(filename)));
        content = content.trim();
        String[] contentArray = content.split("\\s+");

        final int taskCount = Integer.parseInt(contentArray[0]);

        int[][] workersTime = new int[taskCount][taskCount];

        for(int i = 0; i< taskCount; i++) {
            for(int j = 0; j<taskCount; j++) {
                workersTime[i][j] = Integer.parseInt(contentArray[1 + i* taskCount + j]);
            }
        }

        return workersTime;
    }

    public static WorkAssignment simulatedAnnealing(int[][] workerTimes, double temperature, final double alfa,
                                                       final int INTERNAL_ITERATIONS, final int MAX_ITERATIONS) {

        Random random = new Random();
        WorkAssignment vc = randomSolution(workerTimes);
        WorkAssignment vn;
        int iterations = 0;

        while(iterations < MAX_ITERATIONS) {

            for(int i = 0; i<INTERNAL_ITERATIONS; i++) {
                vn = randomLocalSolution(vc);

                double currentEnergy = evaluateSolution(workerTimes, vc);
                double newEnergy = evaluateSolution(workerTimes, vn);

                if (newEnergy < currentEnergy || random.nextDouble(0,1) < Math.exp((currentEnergy - newEnergy) / temperature)) {
                    vc = vn;
                }

            }

            temperature = temperature*alfa;
            iterations++;

            //System.out.println(evaluateSolution(workerTimes, vc));
        }

        return vc;
    }

    public static WorkAssignment randomSolution(int[][] workerTimes) {

        ArrayList<Integer> random = new ArrayList<>();

        for(int i = 0; i<workerTimes.length; i++) {
            random.add(i);
        }
        Collections.shuffle(random);

        WorkAssignment initialSolution = new WorkAssignment();

        for(int i=0; i< workerTimes.length; i++) {
            initialSolution.add(random.get(i));
        }

        return initialSolution;
    }

    public static WorkAssignment randomLocalSolution(WorkAssignment initialSolution) {

        WorkAssignment randomLocalSolution = new WorkAssignment();

        for (Worker worker:initialSolution.getWorkList()) {
            randomLocalSolution.add(worker.getAssignedTaskId());
        }

        Random random = new Random();

        int lastIndex = randomLocalSolution.getWorkList().size()-1;

        randomLocalSolution.swap(random.nextInt(0, lastIndex), random.nextInt(0, lastIndex));

        return randomLocalSolution;
    }

    public static WorkAssignment greedyRandomSolution(int[][] workerTimes, WorkAssignment initialSolution) {

        WorkAssignment greedyLocalSolution = new WorkAssignment();

        for (Worker worker:initialSolution.getWorkList()) {
            greedyLocalSolution.add(worker.getAssignedTaskId());
        }

        Random random = new Random();
        int workerIndex1 = random.nextInt(0, greedyLocalSolution.getWorkList().size());

        int bestTaskId = findBestTask(workerTimes, workerIndex1);

        greedyLocalSolution.swap(workerIndex1, greedyLocalSolution.findByTaskId(bestTaskId).getWorkerId());

        return greedyLocalSolution;
    }


    public static int evaluateSolution(int[][] workerTimes, WorkAssignment solution) {

        int sum = 0;

        for (Worker worker:solution.getWorkList()) {
            sum += workerTimes[worker.getWorkerId()][worker.getAssignedTaskId()];
        }

        return sum;
    }

    public static int findBestTask(int[][] workerTimes, int workerId) {

        int minId = 0;
        for(int i=1; i<workerTimes[workerId].length; i++) {
            if(workerTimes[workerId][i] < workerTimes[workerId][minId]) {
                minId = i;
            }
        }

        return minId;
    }

}

