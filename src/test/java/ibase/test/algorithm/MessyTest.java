package ibase.test.algorithm;

import ibase.test.algorithm.messy.Eculid;
import ibase.test.algorithm.messy.Fibonacci;
import org.junit.Test;

public class MessyTest {

    @Test
    public void testFibonacci() {
        //Fibonacci
        System.out.print("Fibonacci数列：");
        Fibonacci fi = new Fibonacci();
        for (int n = 1; n <= 10; n++) {
            System.out.print(fi.fibonacci(n) + ",");
        }
        System.out.println();
    }

    @Test
    public void testEculid() {
        //Eculid
        Eculid e = new Eculid();
        {
            int m = 36, n = 48;
            System.out.println(m + "," + n + "最大公因数为：" + e.gcd(m, n));
        }
    }

}
