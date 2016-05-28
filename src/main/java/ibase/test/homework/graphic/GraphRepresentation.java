package ibase.test.homework.graphic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GraphRepresentation {

    //将生成的矩阵toGraphic写入文件fileName
    public void writeToTxt(int [][] toGraphic,String fileName) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(new File(fileName));
        int length = toGraphic.length;
        //输出邻接矩阵到指定的文件名fileName
        for(int n=0;n<length;n++){
            for(int m=0;m<length;m++){
                pw.print(toGraphic[n][m]+" ");
            }
            pw.println();
        }
        System.out.println("文件生成成功!");
        pw.close();
    }
    public static void main(String[] args) throws FileNotFoundException{
        //定义读取文件对象，读取顶点数和边数
        Scanner scan = new Scanner(new File(args[0]));//源文件名
        int vertex = scan.nextInt();
        int edge = scan.nextInt();

        //定义二维数组，并初始化为0
        int[][] toGraphic = new int[vertex][edge];
        int length = toGraphic.length;
        for(int i=0;i<length;i++)
            for(int j=0;j<length;j++)
                toGraphic[i][j] = 0;

        //查询两个顶点是否有边，若有则设置边数为1
        int vertex1,vertex2;
        while(scan.hasNextInt()){
            vertex1 = scan.nextInt();
            vertex2 = scan.nextInt();
            toGraphic[vertex1][vertex2] = 1;
            toGraphic[vertex2][vertex1] = 1;
        }
        scan.close();

        //写到文件
        GraphRepresentation gp = new GraphRepresentation();
        gp.writeToTxt(toGraphic,args[1]);//生成文件名

        //读取文件验证结果
        System.out.println("\n读取生成文件验证结果:");
        Scanner scanResult = new Scanner(new File(args[1]));//源文件名
        int count = 0;
        while(scanResult.hasNextInt()){
            count++;
            if(count % 14 != 0)
                System.out.print(scanResult.nextInt()+" ");
            else
                System.out.println();
        }
        scanResult.close();
    }
}
