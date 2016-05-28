package ibase.test.homework.createRSA;

/**
 * 输入二进制数位，随机生成与该位数对应长度的二进制数(生成的数需是素数，否则重新生成)，并转化为Long型的整数
 */
public class NBits2LongPrime {
    //素数判断算法
    public int isPrime(Long num){
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i!=0)
                continue;
            else
                return 0;
        }
        return 1;
    }
    //随机生成一个n位的长整数
    public long createRndPrime(int n){
        //生成一个n位二进制数（此处考虑最高位必须为1，否则n位不成立），并转换为long整数。
        long value = (long)(Math.random()*(Math.pow(2,n-1))+Math.pow(2,n-1));
        //不是质数则重新生成
        while(isPrime(value)!=1){
            value = createRndPrime(n);
        }
        return value;
    }
    //返回最大公约数
    public long Gcd(long n,long m){
        if(n<m){
            n=n+m;
            m=n-m;
            n=n-m;
        }
        while(n%m!=0){
            long t = n%m;
            n=m;
            m=t;
        }
        return m;
    }
}
