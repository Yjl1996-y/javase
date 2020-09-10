import javax.xml.crypto.Data;
import javax.xml.transform.Templates;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public static void main(String[] args) {
        Date date = new Date();
        String str="19960811 06:14:22 145";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss SSS");
        try {
            //parse将字符串转化为Date对象
            Date parse = simpleDateFormat.parse(str);
            long time = parse.getTime();
            long l = System.currentTimeMillis();
            System.out.println(l);
            System.out.println(time);
            System.out.println(l-time);
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //formate将date转化为字符串
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }
}
