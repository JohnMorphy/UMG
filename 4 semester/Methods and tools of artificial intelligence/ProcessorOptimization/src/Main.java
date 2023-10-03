import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] tasks_10 = {2, 46, 86, 45, 2, 74, 57, 95, 5, 8};
        int[] tasks_20 = {83, 15, 22, 57, 22, 35, 71, 86, 77, 89, 45, 35, 82, 84, 75, 80, 1, 18, 55, 21};
        int[] tasks_50 = {3, 77, 99, 27, 29, 46, 1, 5, 48, 28, 91, 6, 57, 4, 55, 83, 3, 51, 70, 66, 48,
                93, 66, 12, 61, 41, 19, 90, 78, 65, 12, 16, 47, 63, 82, 33, 16, 12, 6, 42, 56, 84, 7,
                70, 26, 24, 51, 7, 85, 55};
        int[] tasks_100 = {41, 64, 14, 88, 79, 20, 39, 87, 49, 3, 45, 3, 37, 70, 77, 2, 76, 33, 69, 70, 2,
                57, 5, 12, 97, 56, 75, 60, 47, 77, 24, 72, 31, 3, 81, 31, 8, 37, 31, 52, 51, 9, 50, 92,
                32, 22, 2, 61, 99, 23, 76, 80, 76, 97, 61, 85, 27, 40, 9, 22, 40, 71, 17, 74, 8, 86,
                6, 57, 77, 18, 66, 90, 67, 12, 50, 92, 67, 78, 91, 90, 62, 75, 32, 6, 7, 6, 24, 9,
                75, 91, 51, 13, 70, 30, 23, 47, 11, 76, 41, 20};

        int[] tasks_1000 = ProcessorTask.generateTasks(1, 100,1000);

        ProcessorTask p2t10 = new ProcessorTask(tasks_10,2);
        ProcessorTask p3t10 = new ProcessorTask(tasks_10,3);
        ProcessorTask p2t20 = new ProcessorTask(tasks_20,2);
        ProcessorTask p3t20 = new ProcessorTask(tasks_20,3);
        ProcessorTask p4t50 = new ProcessorTask(tasks_50,4);
        ProcessorTask p4t100 = new ProcessorTask(tasks_100,4);

        ProcessorTask p20t1000 = new ProcessorTask(tasks_1000, 20);


        int[] result1 = p2t10.saveAverageFromFiles(10000, 100, 1,
                0.6,0.2, 0.1,30);

        int[] result2 = p3t10.saveAverageFromFiles(10000, 100, 1,
                0.6,0.2, 0.1,30);

        int[] result3 = p2t20.saveAverageFromFiles(10000, 100, 2,
                0.6,0.2, 0.1,30);

        int[] result4 = p3t20.saveAverageFromFiles(10000, 100, 2,
                0.6,0.2, 0.1,30);

        int[] result5 = p4t50.saveAverageFromFiles(10000, 100, 4,
                0.6,0.2, 0.1,30);

        int[] result6 = p4t100.saveAverageFromFiles(10000, 100, 8,
                0.6,0.2, 0.1,30);

        p2t10.showResult(result1);
        p3t10.showResult(result2);
        p2t20.showResult(result3);
        p3t20.showResult(result4);
        p4t50.showResult(result5);
        p4t100.showResult(result6);
    }
}