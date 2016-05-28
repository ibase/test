package ibase.test.learning;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class JxlExcel {

    public static void main(String[] args) {
        try {
            //获取文件输入流
            InputStream is = new FileInputStream("ExcelData/中文.xls");
            //得到工作薄
            Workbook wb = Workbook.getWorkbook(is);
            //得到工作簿中的工作表1
            Sheet sheet = wb.getSheet(0);
            //当前列数
            for(int i=0;i<sheet.getColumns();i++){
                //当前行数
                for(int j=0;j<sheet.getRows();j++){
                    //得到工作簿中的单元格内容
                    Cell cell = sheet.getCell(j, i);
                    //输出测试
                    System.out.print(cell.getContents()+"  ");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
