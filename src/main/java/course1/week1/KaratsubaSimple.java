package course1.week1;

import java.math.BigInteger;

/**
 * Created by andrey on 17/03/17.
 */
public class KaratsubaSimple {

    /**
     * Assumes x and y are of same length, and are both powers of 2
     *
     * @param x
     * @param y
     * @return
     */
    public static BigInteger multiply(BigInteger x, BigInteger y) {
        return multiply(x, y, length(x));
    }

    public static BigInteger multiply(BigInteger x, BigInteger y, int n) {
        if (1==n) {
            return x.multiply(y);
        }
        BigInteger a = getLeftHalf(x, n);
        BigInteger b = getRighttHalf(x, n);
        BigInteger c = getLeftHalf(y, n);
        BigInteger d = getRighttHalf(y, n);

        BigInteger ac = multiply(a, c, n/2);
        BigInteger bd = multiply(b, d, n/2);
        BigInteger temp = multiply(a.add(b), c.add(d)); //these can be longer ....

        BigInteger adPbc = temp.subtract(ac).subtract(bd);

        BigInteger tenN = BigInteger.TEN.pow(n);
        BigInteger tenN2 = BigInteger.TEN.pow(n / 2);

        BigInteger alfa = tenN.multiply(ac);
        BigInteger beta = tenN2.multiply(adPbc);

        return alfa.add(beta).add(bd);
    }

    public static int length(BigInteger a) {
        return a.toString().length();
    }

    private static BigInteger getLeftHalf(BigInteger x, int n) {
        int rightDigits = n - n / 2;
        BigInteger divider = BigInteger.TEN.pow(rightDigits);
        return x.divide(divider);
    }

    private static BigInteger getRighttHalf(BigInteger x, int n) {
        int rightDigits = n - n / 2;
        BigInteger divider = BigInteger.TEN.pow(rightDigits);
        return x.mod(divider);
    }
}