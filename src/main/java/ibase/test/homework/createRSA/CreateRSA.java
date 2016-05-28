package ibase.test.homework.createRSA;

public class CreateRSA {
    public static void main(String[] args) {
        //随机生成两个大质数
        NBits2LongPrime getLongPrime = new NBits2LongPrime();
        long p = getLongPrime.createRndPrime((int)(Math.random()*20+10));
        long q = getLongPrime.createRndPrime((int)(Math.random()*20+10));
        while(p == q)
            q = getLongPrime.createRndPrime((int)(Math.random()*20+10));

        long N = p*q;
        long medium = (p-1)*(q-1);
        //生成e
        long e = (long)(Math.random()*20+3);
        //循环至最大公约数为1，生成数e
        while(getLongPrime.Gcd(medium,e)!=1){
            e = (long)(Math.random()*20+3);
        }
        System.out.println("生成的公钥(N,e)为: ("+N+","+e+")");
    }
}
