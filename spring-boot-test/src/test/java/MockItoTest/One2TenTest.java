package MockItoTest;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author tongjian
 * @date 2020/6/1 18:26
 */
public class One2TenTest {


    @Test
    public void test1() {
        List list = mock(List.class);
        list.add("one");
        list.clear();
        verify(list).add("one");
        verify(list).clear();
    }
}
