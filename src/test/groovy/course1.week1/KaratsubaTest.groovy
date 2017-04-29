package course1.week1

import org.junit.Assert
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Ignore
import org.junit.Test


class KaratsubaTest {

    BigInteger first
    BigInteger second

    @Before
    void initialize() {
        first =  new BigInteger("12345678909890");
        second = new BigInteger("11221122112211");
    }

    @Test
    void multiplyByZero() {
        println "From inside the test : multiplyByZero"
        def zero = new BigInteger("0")
        def res = KaratsubaSimple.multiply(first, zero)
        Assert.assertEquals("When multiplied by zero, should result in zero", zero, res)
    }

    @Test
    @Ignore
    void correctness() {
        println "From inside the test : correctness"
        def res = KaratsubaSimple.multiply(first, second);
        def expected = first.multiply(second)
        Assert.assertEquals("Karatsuba multiplication should produce the same result as BigInteger multiplication", expected, res)
    }

    @Test
    @Ignore
    void symmetry() {
        def leftToRight = KaratsubaSimple.multiply(first, second);
        def rightToLeft = KaratsubaSimple.multiply(second, first);
        assert leftToRight == rightToLeft //groovy! this is equals
    }



}