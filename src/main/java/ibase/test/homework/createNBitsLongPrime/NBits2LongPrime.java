package ibase.test.homework.createNBitsLongPrime;

import java.util.Scanner;

/**
 * 输入二进制数位，随机生成与该位数对应长度的二进制数
 * (生成的数需是素数，否则重新生成)，并转化为Long型的整数。
 *
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

    //输入过滤，不为整数则提示重新输入
    public NBits2LongPrime(){
        System.out.println("请给定一个二进制数的位数:");
        Scanner scan = new Scanner(System.in);
        try{
            int input = scan.nextInt();
            //生成一个n位二进制数对应的long型质数
            long Count = createRndPrime(input);
            System.out.println("随机生成"+input+"位二进制数（并且为素数）转化为long型数值为:");
            System.out.println(Count);
        } catch(Exception e){
            System.out.println("输入错误!请重新输入。");
            NBits2LongPrime n = new NBits2LongPrime();
        }
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

    public static void main(String[] args) {
        NBits2LongPrime n = new NBits2LongPrime();
    }
}

