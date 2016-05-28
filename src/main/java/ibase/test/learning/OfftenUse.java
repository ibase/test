package ibase.test.learning;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OfftenUse {

    /**
     * Pattern
     */
    public void usePattern(){
        String value = "1111111<div class=\"class\">3333333</div>555555";
        Pattern p = Pattern.compile("(.*)(<div class=\"class\">)(.*?)(</div>)(.*)");
        Matcher m = p.matcher(value);
        if(m.matches()){
            System.out.println(m.group(1));
            System.out.println(m.group(2));
            System.out.println(m.group(3));
            System.out.println(m.group(4));
            System.out.println(m.group(5));
        }
    }

    /**
     * Random
     */
    public void useRandom(){
        double dx = Math.random();//0.0 =< dx < 1.0
        int ix = new Random().nextInt(100);//1 =< ix < 100
    }
}
