package ibase.test.homework.graphicReserse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1.有向图的邻接表表示
 * 2.有向图的反转
 * @date 2014-4-8
 */
public class GraphReverse {

    /**
     * @param args[0] 指定文件名，需指定文件类型
     * @throws FileNotFoundException
     */
    public static void main(String... args) throws FileNotFoundException{

        //获取源文件中边边关系数目
        GraphReverse gr = new GraphReverse();
        final int count = gr.lineCout("txt/tinyDG.txt", 2);//args[0]

        //定义读取文件对象，读取顶点数（需要显示的邻接表行数）
        Scanner scan = new Scanner(new File("txt/tinyDG.txt"));//args[0]
        final int vertex = scan.nextInt();

        //定义二维数组，保存读取的顶点之间的连接关系
        int[][] lineData = new int[count][2];
        int[][] reverseLineData = new int[count][2];
        //跳过开始两行
        scan.nextLine();
        scan.nextLine();

        //二维数组，初始化二维数组，按源文件顺序保存顶点之间的连接关系
        int line = 0;
        while(scan.hasNextInt()){
            lineData[line][0] = scan.nextInt();
            lineData[line][1] = scan.nextInt();
            reverseLineData[line][1] = lineData[line][0];
            reverseLineData[line][0] = lineData[line][1];
            line++;
        }
        scan.close();

        //输出原图的邻接表
        String str = "1.有向图的邻接表如下:";
        System.err.println(str);
        outGraph(count, vertex, lineData);

        //输出反向图的邻接表
        str = "\n2.反向图的邻接表如下:";
        System.err.println(str);
        outGraph(count, vertex, reverseLineData);
    }

    /**
     * @param count 顶点关系数目
     * @param vertex 顶点个数
     * @param lineData 顶点关系
     */
    private static void outGraph(final int count, final int vertex,
                                 int[][] lineData) {

        //保存顶点指向的顶点数值
        List<Integer> list = new ArrayList<Integer>();
        //判断顶点关系中第一个顶点的值是否与顶点输出序列值相同
        //若相同则输出该顶点指向的顶点值
        for(int n=0;n<vertex;n++){
            System.out.print(n+": ");
            for(int i=0;i<count;i++){
                if(n==lineData[i][0]){
                    list.add(lineData[i][1]);//把指向的顶点数值放入list中
                }
            }

            //定义一个等于已有list元素长度的数组
            int elementCount = list.size();
            int[] arraySort = new int[elementCount];
            for(int j=0;j<elementCount;j++){
                arraySort[j] = (int)list.get(j);
            }
            list.clear();
            //排序数组，以实现按数字顺序输出
            GraphReverse gr = new GraphReverse();
            arraySort = gr.sortArray(arraySort);
            for(int j=0;j<elementCount;j++){
                System.out.print(arraySort[j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * @param filePath 源文件路径
     * @param n 文件头忽略的行数
     * @return 返回顶点的边边关系数目
     */
    public int lineCout(String filePath,int n) throws FileNotFoundException{
        int count=0;
        Scanner scanTxt = new Scanner(new File(filePath));
        while(scanTxt.hasNextLine()){
            //读取指针指向下一行
            scanTxt.nextLine();
            count++;
        }
        scanTxt.close();
        return count-n;
    }

    //传入数组进行冒泡排序
    public int[] sortArray(int[] array){
        for(int i=1,n=array.length;i<n;i++)
            for(int j=0;j<n-i;j++){
                if(array[j]>array[j+1]){
                    int t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                }
            }
        return array;
    }
}
