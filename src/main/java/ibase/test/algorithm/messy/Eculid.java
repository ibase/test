package ibase.test.algorithm.messy;

/**
 * 欧几里得算法
 */
public class Eculid {
    /**
     *
     * @param m 第一个整数
     * @param n 第二个整数
     * @return m,n的最大公因数
     */
	public int gcd(int m,int n){
		int temp=1;
		if(m<n){
			temp=n;
			n=m;
			m=temp;
		}
		while(n%m!=0){
			temp=n%m;
			n=m;
			m=temp;
		}
		return temp;
	}
}
