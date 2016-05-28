package ibase.test.algorithm.messy;

/**
 * 超级素数
 */
public class SuperPrime {

    /**
     * 判断一个数是否为超级素数
     * @param num 长整数
     * @return 是否为超级素数
     */
    public boolean isSuperPrime(long num){

        //小于10直接判断
        if(num<10)
            if(IsPrime.isPrime(num))
                return true;

        //大于10递归判断
        while(num>10){
            num = num/10;
            if(IsPrime.isPrime(num)){
                if(num<10){
                    if(IsPrime.isPrime(num))
                        return true;
                    else
                        return false;
                }
                else
                    continue;
            }
            else
                return false;
        }
        return false;
    }
}
