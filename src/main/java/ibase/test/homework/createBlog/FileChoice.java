package ibase.test.homework.createBlog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileChoice extends JFrame{

    private String path = null;//源文件所在路径
    private String outHtmlName = null;//生成文件路径+文件名

    public FileChoice(){
        JPanel center = new JPanel();
        center.setLayout(null);

        JLabel sourceName = new JLabel("源文件:");
        JLabel fileName = new JLabel("生成的网页文件名:");
        final JTextField sourceNameInput = new JTextField();
        final JTextField fileNameInput = new JTextField();
        sourceName.setBounds(30,20,50, 30);
        sourceNameInput.setBounds(90,23,160,22);
        fileName.setBounds(30,60,130, 30);
        fileNameInput.setBounds(150,63,100,22);
        sourceNameInput.setEditable(false);//源文件路径不可编辑

        JButton chooseTxt = new JButton("选择文件");
        JButton confirm = new JButton("确定");
        JButton cancel = new JButton("取消");
        chooseTxt.setBounds(30,110,100, 30);
        confirm.setBounds(140,110,60, 30);
        cancel.setBounds(210,110,60, 30);


        //选择文件按钮监听
        chooseTxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
                //弹出文件选择对话框
                JFileChooser c = new JFileChooser();
                c.setDialogTitle("请选择博客名单源文件");//标题栏
                int result = c.showOpenDialog(null);
                //点击确定按钮
                if(JFileChooser.APPROVE_OPTION == result) {
                    FileChoice.this.path = c.getSelectedFile().getPath();//获取选择文件的路径
                    sourceNameInput.setText(FileChoice.this.path);
                    outHtmlName = sourceNameInput.getText().toString().trim();
                }
            }
        });

        //确定按钮监听
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    //源文件不能为空
                    if(sourceNameInput.getText().toString().trim().length()==0)
                        JOptionPane.showMessageDialog(FileChoice.this,"源文件名错误，请重新选择。");
                        //生成文件名不能为空
                    else if(fileNameInput.getText().toString().trim().length()==0)
                        JOptionPane.showMessageDialog(FileChoice.this,"请输入生成文件名。");
                    else{
                        //截取路径，除去源文件名称和扩展名
                        outHtmlName = outHtmlName.substring(0,outHtmlName.lastIndexOf("\\"))+"\\";
                        outHtmlName = outHtmlName+fileNameInput.getText().toString().trim()+".html";
                        new Out2Html(sourceNameInput.getText().toString().trim(),outHtmlName);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                fileNameInput.setText("");
            }
        });

        //取消按钮监听
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        center.add(sourceName);
        center.add(sourceNameInput);
        center.add(fileName);
        center.add(fileNameInput);
        center.add(chooseTxt);
        center.add(confirm);
        center.add(cancel);

        this.setTitle("生成blog网页名册");
        this.add(center,BorderLayout.CENTER);
        this.setVisible(true);
        this.setBounds(300, 200, 300, 200);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new FileChoice();
    }
}
