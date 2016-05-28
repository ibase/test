package ibase.test.algorithm.messy;

/**
 * 斐波拉茨数列
 */
public class Fibonacci {
    /**
     *
     * @param n 第n个数字
     * @return  第n个数字的值
     */
	 public int fibonacci(int n){
		if(n<=2){
			if(n==1)
				return 0;
			else
				return 1;
			}
		return fibonacci(n-1)+fibonacci(n-2);
	 }
}
