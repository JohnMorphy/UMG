import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Lab_01_z2 {


    public static double[] monteCarlo(int numberOfIterations, double min, double max) {
        if (numberOfIterations <= 0) {
            numberOfIterations = 1;
        }

        Random random = new Random();

        double[] result = new double[2];

        for (int i = 0; i<result.length; i++) {
            result[i] = min + (max - min) * random.nextDouble();
        }

        double fMax = -Math.pow(result[0],2) -Math.pow(result[1],2) + 2;

        double[] current = result.clone();
        double fCurrent = fMax;

        System.out.println("[" + result[0] + ", " + result[1] + "], " + fMax);

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

        for(int i = 0; i < numberOfIterations; i++) {

            int w = random.nextInt(2);

            double[] temporary = new double[2];

            if(w == 1) {
                for (int j = 0; j<temporary.length; j++) {
                    temporary[j] = current[j] + 0.1*Math.random();
                }
            } else {
                for (int j = 0; j<temporary.length; j++) {
                    temporary[j] = current[j] - 0.1*Math.random();
                }
            }

            double fTemp = -Math.pow(temporary[0],2) -Math.pow(temporary[1],2) + 2;

            if(fTemp > fMax) {
                fMax = fTemp;
                result = temporary.clone();
                current = temporary.clone();
                fCurrent = fTemp;
            }
            /*
            else {
                double Z = Math.random();
                if(Z < Math.exp(-(fTemp-fCurrent)/0.1)) {
                    fMax = fTemp;
                    result = temporary.clone();
                    current = temporary.clone();
                    fCurrent = fTemp;
                }
            }
            */
            try {
                FileWriter writer = new FileWriter(fMaxFile, true);
                writer.write(String.valueOf(fMax) + "\n");
                writer.close();
                writer = new FileWriter(fCurrentFile, true);
                writer.write(String.valueOf(fTemp) + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while saving");
            }

            System.out.println("[" + result[0] + ", " + result[1] + "], " + fMax);
        }

        return result;
    }

    public static void main(String[] args) {

        Lab_01_z2.monteCarlo(50, -2.0, 2.0);

    }
}
