package course1.week1;

import common.NotFinished;

/**
 * Created by andrey on 17/03/17.
 */
@NotFinished("First try, not used.")
public class Karatsuba {

    public static long multiply(long x, long y) {
        //System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //System.out.println("X : " + x);
        short xLength = length(x);
        short yLength = length(y);
        if (xLength == 1 || yLength == 1) {
            return x * y;
        }
        //System.out.println("Length of X: " + xLength);
        long a = getLeftHalf(x, xLength);
        long b = getRighttHalf(x, xLength);
        long c = getLeftHalf(y, yLength);
        long d = getRighttHalf(y, yLength);

        //System.out.println("Left half (a): " + a);
        //System.out.println("Right half (b): " + b);

        //System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //System.out.println("Y : " + y);
        //System.out.println("Length of Y: " + yLength);
        //System.out.println("Left half (c): " + a);
        //System.out.println("Right half (d): " + b);
        long ac = multiply(a, c);
        long bd = multiply(b, d);
        long temp = multiply(a+b, c+d);

        long adPbc = temp - ac - bd;

        return x * y;
    }

    public static short length(long a) {
        if (a<0) {
            return length((-1) * a);
        }
        short n = 0;

        while (a > 0) {
            n++;
            a = a / 10;
        }
        return n;
    }

    private static long getLeftHalf(long x, short n) {
        int rightDigits = n - n / 2;
        int divider = (int) Math.pow(10, rightDigits);
        return x / divider;
    }

    private static long getRighttHalf(long x, short n) {
        int rightDigits = n - n / 2;
        int divider = (int) Math.pow(10, rightDigits);
        return x % divider;
    }
}