import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Lab_01_z1 {

    public static double[] randomWandering(int numberOfIterations, double min, double max) {

        if (numberOfIterations <= 0) {
            numberOfIterations = 1;
        }

        Random random = new Random();

        double[] result = new double[2];

        for (int i = 0; i<result.length; i++) {
            result[i] = min + (max - min) * random.nextDouble();
        }
        double fMax = -Math.pow(result[0],2) -Math.pow(result[1],2) + 2;

        String fMaxFile = "fMax.txt";
        String fCurrentFile = "fCurrent.txt";

        try {
            FileWriter writer = new FileWriter(fMaxFile);
            writer.write(String.valueOf(fMax) + "\n");
            writer.close();
            writer = new FileWriter(fCurrentFile);
            writer.write(String.valueOf(fMax) + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error while saving");
        }

        System.out.println("[" + result[0] + ", " + result[1] + "], " + fMax);

        double[] pending = new double[2];
        double pendingMax;

        for(int i=0; i<numberOfIterations; i++) {

            for (int j = 0; j<pending.length; j++) {
                pending[j] = min + (max - min) * random.nextDouble();
            }

            pendingMax = -Math.pow(pending[0],2) -Math.pow(pending[1],2) + 2;

            if(pendingMax > fMax) {
                fMax = pendingMax;
                System.arraycopy(pending, 0, result, 0, result.length);

                System.out.println("[" + result[0] + ", " + result[1] + "], " + fMax);
            }

            try {
                FileWriter writer = new FileWriter(fMaxFile, true);
                writer.write(String.valueOf(fMax) + "\n");
                writer.close();
                writer = new FileWriter(fCurrentFile, true);
                writer.write(String.valueOf(pendingMax) + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while saving");
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Lab_01_z1.randomWandering(50, -2.0, 2.0);

    }
}
