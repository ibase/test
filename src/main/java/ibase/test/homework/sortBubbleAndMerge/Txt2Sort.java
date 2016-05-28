package ibase.test.homework.sortBubbleAndMerge;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Scanner;

public class Txt2Sort {

    //返回冒泡排序所用时间
    public long bubbleSort(int[] dataArray){
        DateFormat dfDefault = DateFormat.getInstance();
        long startTime = System.currentTimeMillis();
        System.out.println("\n冒泡排序开始时间："+dfDefault.format(startTime));

        //冒泡排序算法
        for(int i=1,lineCount=dataArray.length;i<lineCount;i++) {
            for (int j = 0; j < lineCount - i; j++) {
                if (dataArray[j] > dataArray[j + 1]) {
                    int t = dataArray[j];
                    dataArray[j] = dataArray[j + 1];
                    dataArray[j + 1] = t;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("冒泡排序结束时间："+dfDefault.format(endTime));
        long useTimeSeconds = (long)((endTime - startTime)/1000);
        return useTimeSeconds;
    }

    //写入文件使用时长
    public long writeToFile(int[] array,String fileName) throws FileNotFoundException{

        DateFormat dfDefault = DateFormat.getInstance();//获取时间，格式：3/27/14 10:50 PM
        PrintWriter pw = new PrintWriter(new File(fileName));

        long startTime = System.currentTimeMillis();
        System.out.println("\n写入文件开始时间："+dfDefault.format(startTime));
        for(int i=0,lineCount=array.length;i<lineCount;i++){
            pw.println(array[i]);
        }
        pw.close();
        long endTime = System.currentTimeMillis();
        System.out.println("写入文件结束时间："+dfDefault.format(endTime));
        long useTimeMills = (long)(endTime - startTime); //单位：毫秒
        return useTimeMills;
    }

    //返回归并排序使用的时间
    public long mergeSort(int[] needSortArray,int arrayLength,String fileName) throws FileNotFoundException{
        int[] medium = new int[arrayLength];

        DateFormat dfDefault = DateFormat.getInstance();
        long startTime = System.currentTimeMillis();
        System.out.println("归并排序开始时间："+dfDefault.format(startTime));
        //排序
        MergeAll(needSortArray, medium, arrayLength);
        long endTime = System.currentTimeMillis();
        System.out.println("归并排序结束时间："+dfDefault.format(endTime));

        this.writeToFile(needSortArray, fileName);
        long useTimeSeconds = (long)(endTime - startTime);
        return useTimeSeconds;
    }

    //一次相邻数组排序
    public void MergeFirst(int[] r,int[] r1, int s,int m,int t){
        //相邻有序序列r[s]~r[m]和r[m+1]~r[t],合成有序序列r1[s]~r1[t]
        //i,j分别指向相邻有序序列的当前元素，k指向合成有序序列的当前元素
        int i=s,j=m,k=s;
        while(i<m && j<t){
            if(r[i]<=r[j])
                r1[k++] = r[i++];
            else
                r1[k++] = r[j++];
        }
        //处理未排序的序列,前半部分和后半部分
        if(i<m)
            while(i<m)
                r1[k++]=r[i++];
        else
            while(j<t)
                r1[k++]=r[j++];
    }

    //一层相邻数组排序,从下标为0开始存放待排序列
    public void MergeSecond(int[] r,int[] r1,int n,int h){
        int i=0;
        while(i<=n-2*h){
            MergeFirst(r, r1, i,i+h,i+2*h);
            i+=2*h;
        }
        //最后一个序列长度小于h（子序列的数组长度）
        if(i<n-h)
            MergeFirst(r, r1, i,i+h,n);
            //排至剩下最后一个子序列
        else
            for(int k=i;k<n;k++)
                r1[k]=r[k];
    }

    //全体二路归并排序非递归实现
    public void MergeAll(int[] r,int[] r1,int n){
        int h=1;//h为初始子序列(h)长度
        while(h<n){
            MergeSecond(r, r1, n, h);//待排序列r传至r1
            h=2*h;
            MergeSecond(r1, r, n, h);//待排序列r1传回r
            h=2*h;
        }
    }

    //全体二路归并排序递归实现

    public static void main(String[] args) throws FileNotFoundException{
        //从文件读取数据
        int[] readCount = new int[1000000];
        Scanner scan = new Scanner(new File(args[0]));//第一个个参数指定读取的文件名
        while(scan.hasNextInt()){
            for(int n=0,lineCount= readCount.length;n<lineCount;n++){
                readCount[n] = scan.nextInt();
            }
        }
        scan.close();

        //冒泡排序调用，返回排序时长
        Txt2Sort t = new Txt2Sort();
        long useSortTime = t.bubbleSort(readCount);
        System.out.println("\n冒泡排序法使用时长："+useSortTime+" seconds");

        //写入文件调用，返回写入时长，第二个参数指定生成的文件名
        long useWriteTime = t.writeToFile(readCount,args[1]);
        System.out.println("写入文件使用时长："+useWriteTime+" mills");
        long bubbleUseAllTime = useSortTime+useWriteTime;
        System.out.println("冒泡排序总共使用时长："+bubbleUseAllTime+" seconds");

        //归并排序调用，返回排序时长
        long MegerUseAllTime = t.mergeSort(readCount, readCount.length,args[1]);
        System.out.println("归并排序使用时长："+MegerUseAllTime+" mills");
    }
}
