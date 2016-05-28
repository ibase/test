package ibase.test.homework.createBlog;

import javax.swing.*;
import java.io.*;

public class Out2Html extends JFrame{
    /**
     * @param path 源文件路径
     * @param outHtmlName 输出文件名
     */
    //源文件名单文件路径，格式：名称+空格+博客地址。首行标题忽略。
    public Out2Html(String path,String outHtmlName) throws Exception{
        File file = new File(outHtmlName);
        PrintStream outFile = null;
        //存在文件名相同则取消
        if(file.exists()){
            JOptionPane.showMessageDialog(this,"已存在文件："+outHtmlName);
        }
        else{
            outFile = new PrintStream(file);

            String lineData = null;
            StringBuffer web = new StringBuffer();//字符串，用于设置页面内容

            web.append("<!DOCTYPE html PUBLIC "+"-//W3C//DTD XHTML 1.0 Transitional//EN");
            web.append("http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"+">");
            web.append("<html xmlns="+"http://www.w3.org/1999/xhtml"+">");
            web.append("<head>");
            web.append("<title>studentList</title>");
            web.append("<style type="+"text/css"+">");
            web.append(".name {font-size: 16px; font-weight: bold;}");
            web.append("a:link {color: #00F;");
            web.append("text-decoration: none}");
            web.append("a:visited {color: #00F;");
            web.append("text-decoration: none}");
            web.append("a:hover {color: #09C;");
            web.append("text-decoration: none}");
            web.append("a:active {color: #09C;");
            web.append("text-decoration: none}");
            web.append("</style>");
            web.append("</head>");
            web.append("<body><table width='600' border='0' align='center' style='margin-top:100px;'>");
            web.append("<caption height='80' align='center' valign='middle'>CSDN博客列表</caption>");
            web.append("<tr height='30'><td></td><td></td><td></td></tr><tr>");

            //得到文件，并用输入流读取文件内容
            File inputFile = new File(path);
            InputStreamReader read = new InputStreamReader(new FileInputStream(inputFile), "GBK");
            BufferedReader bufferedReader = new BufferedReader(read);
            String[] user = new String[2];//获取每一行数据
            bufferedReader.readLine();//文档首行标题不要

            //从第二行开始读起
            while((lineData = bufferedReader.readLine()) != null){
                String[] info = lineData.split("\\s+");
                for(int n=0;n<info.length;n++){
                    user[n] = info[n];
                }
                web.append("<tr height='40'><td align='center' valign='middle'><a href='"+user[1]+"'>"+user[0]+"</a></td>");

                if((lineData = bufferedReader.readLine())!=null){ //换行获取数据
                    info = lineData.split("\\s+");
                    for(int n=0;n<info.length;n++){
                        user[n] = info[n];
                    }
                    web.append("<td align='center'><a href='"+user[1]+"'>"+user[0]+"</a></td>");
                }

                if((lineData = bufferedReader.readLine())!=null){ //换行获取数据
                    info = lineData.split("\\s+");
                    for(int n=0;n<info.length;n++){
                        user[n] = info[n];
                    }
                    web.append("<td align='center'><a href='"+user[1]+"'>"+user[0]+"</a></td>");
                }

                if((lineData = bufferedReader.readLine())!=null){ //换行获取数据
                    info = lineData.split("\\s+");
                    for(int n=0;n<info.length;n++){
                        user[n] = info[n];
                    }
                    web.append("<td align='center'><a href='"+user[1]+"'>"+user[0]+"</a></td>");
                }

                if((lineData = bufferedReader.readLine())!=null){ //换行获取数据
                    info = lineData.split("\\s+");
                    for(int n=0;n<info.length;n++){
                        user[n] = info[n];
                    }
                    web.append("<td align='center'><a href='"+user[1]+"'>"+user[0]+"</a></td></tr>");
                }
            }
            web.append("</table></body></html>");
            outFile.println(web.toString());//输出html文件
            read.close();
            outFile.close();
            JOptionPane.showMessageDialog(this,"成功生成文件："+outHtmlName);
        }
    }
}
