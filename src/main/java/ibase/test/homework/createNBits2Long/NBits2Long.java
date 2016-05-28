package ibase.test.homework.createNBits2Long;

import java.util.Scanner;

/**
 * 输入二进制数位，随机生成与该位数对应长度的二进制数，并转化为Long型的整数
 */
public class NBits2Long {

    //输入过滤，不为整数则提示重新输入
    public NBits2Long(){
        System.out.println("请给定一个二进制数的位数:");
        Scanner scan = new Scanner(System.in);
        try{
            int input = scan.nextInt();
            System.out.println("随机生成"+input+"位二进制数转化为long型数值为:");
            System.out.println(createRndInteger(input));
        } catch(Exception e){
            System.out.println("输入错误!请重新输入。");
            NBits2Long n = new NBits2Long();
        }
    }

    public long createRndInteger(int n){
        //生成一个n位二进制数（此处考虑最高位必须为1，否则n位不成立），并转换为long整数。
        long value = (long)(Math.random()*(Math.pow(2,n-1)-1)+Math.pow(2,n-1));
        return value;
    }

    public static void main(String[] args) {
        NBits2Long n = new NBits2Long();
    }
}
