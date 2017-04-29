import course1.week1.Karatsuba;
import course1.week1.KaratsubaSimple;
import course1.week1.MyNumber;

import java.math.BigInteger;

/**
 * Created by andrey on 17/03/17.
 */
public class Main {

    public static void main(String[] args) {
        out("Week One");
        week1();
    }

    public static void week1() {
        out("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        out("Karatsuba Multiplication");
        BigInteger first = new BigInteger("1234567890");
        BigInteger second = new BigInteger("11221122112211");

        out("First : " + first);
        out("Second : " + second);

        BigInteger res = first.multiply(second);
        out("Multiplication result : " + res);

        res = KaratsubaSimple.multiply(first, second);
        out("Karatsuba multiplication result : " + res);
    }

    public static void out(String msg) {
        System.out.println(msg);
    }

}
