import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TabuSearch {

    private static final int MAX_ITERATIONS = 2000;
    private static final int INTERNAL_ITERATIONS = 20;
    private static final String fileName = "assign100.txt";

    // parameters for tabu search
    private static final TaskQueue<TaskSwapRecord> TABU_LIST = new TaskQueue<>();
    private static final int TABU_LENGTH = 20;

    public static void main(String[] args) {

        //tabu search - random choice

        try {
            int[][] workersTime = readData(fileName);
            ArrayList<Double> array = new ArrayList<>();
            double average = 0;

            for(int i=0; i<10; i++) {
                WorkAssignment val = tabuSearch(workersTime, MAX_ITERATIONS, TABU_LENGTH);
                array.add((double) evaluateSolution(workersTime, val));
                System.out.println(array.get(i));
                average += array.get(i);
            }
            average /=10.0;
            System.out.println(average);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        //tabu search - random choice (but only when beneficial), with internal iterations
        try {
            int[][] workersTime = readData(fileName);
            ArrayList<Double> array = new ArrayList<>();
            double average = 0;

            for(int i=0; i<10; i++) {
                array.add((double) evaluateSolution(workersTime, tabuSearchWithInternalIterations(workersTime, MAX_ITERATIONS,
                        TABU_LENGTH, INTERNAL_ITERATIONS)));
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

    public static WorkAssignment tabuSearch(int[][] workerTimes, final int MAX_ITERATIONS, final int TABU_LENGTH) {

        TABU_LIST.clear();

        WorkAssignment vc = randomSolution(workerTimes);
        WorkAssignment best = new WorkAssignment(vc);

        int iteration = 0;
        do {
            vc = randomTabuSolution(best, TABU_LENGTH);

            int currentTime = evaluateSolution(workerTimes, vc);
            int bestTime = evaluateSolution(workerTimes, best);

            if(currentTime < bestTime) {
                best = new WorkAssignment(vc);
            }
            iteration++;

        } while (iteration < MAX_ITERATIONS);

        return best;
    }

    public static WorkAssignment tabuSearchWithInternalIterations(int[][] workerTimes, final int MAX_ITERATIONS,
                                                                  final int TABU_LENGTH, final int INTERNAL_ITERATIONS) {

        TABU_LIST.clear();

        WorkAssignment vc = randomSolution(workerTimes);
        WorkAssignment best = new WorkAssignment(vc);

        int iteration = 0;
        do {

            for (int i = 0; i < INTERNAL_ITERATIONS; i++) {
                TaskSwapRecord taskSwapRecord = worstPerformerSwapRecord(best, workerTimes);
                if(taskSwapRecord.isBeneficial(workerTimes)) {
                    vc = new WorkAssignment(best);
                    vc.swap(taskSwapRecord);
                }
            }

            int currentTime = evaluateSolution(workerTimes, vc);
            int bestTime = evaluateSolution(workerTimes, best);

            if(currentTime < bestTime) {
                best = new WorkAssignment(vc);
            }
            iteration++;

        } while (iteration < MAX_ITERATIONS);

        return best;
    }

    // creating initial random solution
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

    // adding swap record to tabu list
    public static void addToTabuList(TaskSwapRecord taskSwapRecord, int TABU_LENGTH) {
        if(TABU_LIST.length() >= TABU_LENGTH) {
            TABU_LIST.poll();
            TABU_LIST.offer(taskSwapRecord);
        } else {
            TABU_LIST.offer(taskSwapRecord);
        }
    }

    // generating random swap record
    public static TaskSwapRecord randomSwapRecord(WorkAssignment solution) {

        Random random = new Random();

        int lastIndex = solution.getWorkList().size()-1;

        Worker worker1 = solution.get(random.nextInt(0, lastIndex));
        Worker worker2 = solution.get(random.nextInt(0, lastIndex));

        return new TaskSwapRecord(worker1, worker2);
    }

    // generating swapping worst with random record
    public static TaskSwapRecord worstPerformerSwapRecord(WorkAssignment solution, int[][] workerTimes) {

        Random random = new Random();

        int lastIndex = solution.getWorkList().size()-1;

        Worker worker1 = solution.getWorstPerformer(workerTimes);
        Worker worker2 = solution.get(random.nextInt(0, lastIndex));

        return new TaskSwapRecord(worker1, worker2);
    }

    public static WorkAssignment randomTabuSolution(WorkAssignment initialSolution, final int TABU_LENGTH) {

        WorkAssignment randomLocalSolution = new WorkAssignment();

        for (Worker worker:initialSolution.getWorkList()) {
            randomLocalSolution.add(worker.getAssignedTaskId());
        }

        TaskSwapRecord taskSwapRecord = randomSwapRecord(randomLocalSolution);

        if(TABU_LIST.contains(taskSwapRecord)) {
            return randomTabuSolution(randomLocalSolution, TABU_LENGTH);
        } else {
            randomLocalSolution.swap(taskSwapRecord.worker1().getWorkerId(), taskSwapRecord.worker2().getWorkerId());
            addToTabuList(taskSwapRecord, TABU_LENGTH);
        }

        return randomLocalSolution;
    }



    public static int evaluateSolution(int[][] workerTimes, WorkAssignment solution) {

        int sum = 0;

        for (Worker worker:solution.getWorkList()) {
            sum += workerTimes[worker.getWorkerId()][worker.getAssignedTaskId()];
        }

        return sum;
    }

}