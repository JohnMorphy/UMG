import java.util.Random;

public class Lab_02_z1 {

    public static long toDecimal(byte[] arr) {

        long result = 0;

        for(int i = 0; i < arr.length; i++) {
            result+=arr[i] * Math.pow(2,arr.length-i-1);
        }

        return result;
    }

    public static void printTable(byte[] arr) {
        System.out.println();
        for (byte i:arr) {
            System.out.print(i);
        }
    }

    public static void main(String[] args) {
        // function: -x1^2 -x2^2+2
        // x1 -> <-2; 2>;
        // x2 -> <-2; 2>;
        //

        // a) d = 5; resolution
        // num. of elements: 400 001
        // needed number of bits: 19

        // b) chromosome
        // is made out of potential results
        // 38 bits

        // c)

        Random rand = new Random();

        // random

        byte[] x1 = new byte[19];
        for (int i=0; i<x1.length; i++) {
            x1[i] = (byte)rand.nextInt(2);
        }

        byte[] x2 = new byte[19];
        for (int i=0; i<x2.length; i++) {
            x2[i] = (byte)rand.nextInt(2);
        }

        Lab_02_z1.printTable(x1);
        Lab_02_z1.printTable(x2);
        System.out.println();
        System.out.println();

        // decoding

        long x1_decimal = Lab_02_z1.toDecimal(x1);
        long x2_decimal = Lab_02_z1.toDecimal(x2);

        System.out.println(x1_decimal);
        System.out.println(x2_decimal);
        System.out.println();

        // d)
        // checking5

        double x1_real = -2.0 + ((double) x1_decimal * 4.0)/(400000.0);
        double x2_real = -2.0 + ((double) x2_decimal * 4.0)/(400000.0);

        System.out.println(x1_real);
        System.out.println(x2_real);

        if(x1_real>2.0 || x2_real>2.0) {
            System.out.println("Number out of bounds -> generate again");
        }

        // e)

        else{
            double f = -Math.pow(x1_real, 2) - Math.pow(x2_real,2) + 2;
            System.out.println("Value of function with random numbers: " + f);
        }
    }
}