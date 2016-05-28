package ibase.test.learning;

import java.io.*;

public class ReaderWriter {

    public static void main(String [] args) throws IOException {
        //将读取文件的信息写入另一个文件
        fileWriter(fileReader());
        System.out.println("读写成功！");
    }

    public static String fileReader() throws IOException {

        //从文件获得文件输入流
        FileInputStream fis = new FileInputStream(new File("F:\\workspace\\IDEA\\per\\per-util\\src\\main\\resources\\fileReading.txt"));

        //从文件输入流读取
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis,"utf-8"));

        //输出读取内容
        StringBuilder sb = new StringBuilder();
        String line = null;
        while((line = reader.readLine()) != null){
            sb.append(line+"\n");
        }

        return sb.toString();
    }

    public static void fileWriter(String string) throws IOException {
        //true:追加
        FileWriter fw = new FileWriter("F:\\workspace\\IDEA\\per\\per-util\\src\\main\\resources\\fileWriting.txt",true);
        PrintWriter pw = new PrintWriter(fw);
        pw.write(string);
        pw.close();
    }
}
