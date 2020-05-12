package time;

import org.junit.Test;

import java.util.Date;

/**
 * @author tongjian
 * @version 1.0
 * @date 2020/5/12 17:03
 */
public class GetTimeTest {

    @Test
    public void getTimeTest() {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        Date date1 = new Date(1589274315782l);
        System.out.println(date1.before(date));
    }

}
