package ibase.test.learning;

import java.text.DecimalFormat;

public class FormatHelper {

    /**
     * 设置格式化小数精确位数,三位数字一个逗号，精确到百分位
     * @param digital 待格式化显示的数字
     * @return
     */
    public static String digitalShow(double digital){
        DecimalFormat df = new DecimalFormat("###,##0.00");
        return df.format(digital);
    }
}
