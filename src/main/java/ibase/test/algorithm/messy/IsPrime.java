package ibase.test.algorithm.messy;

/**
 * 质数判定
 */
public class IsPrime
{
    /**
     * 素数判断算法
     * @param num 待检测数
     * @return 是否是素数
     */
    public static boolean isPrime(long num){
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i!=0)
                continue;
            else
                return true;
        }
        return false;
    }
}