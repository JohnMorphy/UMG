import java.util.Arrays;
import java.util.Random;

public class Lab_02_z2 {

    //for testing
    public static void halfOfRange(byte[] arr) {
        fillWithZeros(arr);
        arr[1] = 1;
        arr[3] = 1;
        arr[7] = 1;
        arr[9] = 1;
        arr[10] = 1;
        arr[12] = 1;
    }


    //for testing
    public static void fillWithZeros(byte[] arr) {
        Arrays.fill(arr, (byte) 0);
    }

    //for testing
    public static void fillWithOnes(byte[] arr) {
        Arrays.fill(arr, (byte) 1);
    }

    public static void fillWithRandom(byte[] arr) {
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (byte) rand.nextInt(2);
        }
    }

    public static long toDecimal(byte[] arr) {

        long result = 0;

        for (int i = 0; i < arr.length; i++) {
            result += arr[i] * Math.pow(2, arr.length - i - 1);
        }

        return result;
    }

    public static double getRealValue(long value) {
        return -5.21 + ((double) value * 10.42)/(10420.0);
    }

    public static void printTable(byte[] arr) {
        System.out.println();
        for (byte i : arr) {
            System.out.print(i);
        }
    }

    public static void main(String[] args) {

        // xi -> <-5.21; 5.21>;
        // 10 elements

        // a) d = 3; resolution
        // num. of elements: 10 421
        // needed number of bits: 14

        // b) chromosome
        // is made out of potential results
        // 140 bits

        // c)

        byte[][] encoded = new byte[10][14];
        for (int i = 0; i<10; i++) {
            fillWithRandom(encoded[i]);
        }

        // decoding

        long[] decimal = new long[10];

        for(int i = 0; i<decimal.length; i++) {
            decimal[i] = toDecimal(encoded[i]);
        }

        // d)
        // get real value + checking

        double[] real = new double[10];

        decimal[0] = 5211;
        decimal[1] = 0;
        decimal[2] = 10420;

        for(int i = 0; i<real.length; i++) {
            do {
                real[i] = getRealValue(decimal[i]);
                if(real[i]<=5.21) {
                    break;
                }
                fillWithRandom(encoded[i]);
                decimal[i] = toDecimal(encoded[i]);
            } while (true);
        }


        // e)
        // evaluate expression

        double f = 10*10;

        for (int i = 0; i<10; i++) {
            System.out.println("x["+i+"]: " + real[i]);
        }

        System.out.println();
        System.out.println("-----");
        System.out.println();

        for (double x : real) {
            f += Math.pow(x, 2) - 10 * Math.cos(2 * Math.PI * x);
        }
        System.out.println(f);
    }
}