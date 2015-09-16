import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by zhengshouzi on 2015/9/16.
 */
public class TestSomeUncertain {


    public static void main(String args[]) {

        String s = "2013-11-11 11:11:11";
        Timestamp timestamp = Timestamp.valueOf(s);
        System.out.printf(timestamp.toString());






    }


}
