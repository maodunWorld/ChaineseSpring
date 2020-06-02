package MockItoTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * @author tongjian
 * @date 2020/6/2 13:20
 */
@ExtendWith(MockitoExtension.class)
public class Eleven2Twenty {

    @Mock
    private List list;

    /**
     * 更多类似
     * doReturn(Object)
     * <p>
     * doThrow(Throwable...)
     * <p>
     * doThrow(Class)
     * <p>
     * doAnswer(Answer)
     * <p>
     * doNothing()
     * <p>
     * doCallRealMethod()
     */
    @Test
    public void TestSutbbingWithCallBack() {
        when(list.get(anyInt())).thenAnswer(e -> {
            Object[] arguments = e.getArguments();
            Object mock = e.getMock();
            return "called with arg " + Arrays.toString(arguments);
        });
        System.out.println(list.get(1));
    }


    @Test
    public void TestWithSpying() {
        LinkedList linkedList = new LinkedList();
        LinkedList spy = spy(linkedList);
        when(spy.size()).thenReturn(100);

        spy.add("one");
        spy.add("two");
        System.out.println(spy.get(0));
        System.out.println(spy.size());

        verify(spy).add("one");
        verify(spy).add("two");
    }

    @Test
    public void TestReturnV() {
        List mock = mock(List.class, RETURNS_SMART_NULLS);
    }

    @Test
    public void testRealMethod() {
        LinkedList<Object> spy = spy(new LinkedList<>());
        when(spy.size()).thenCallRealMethod();
    }

    @Test
    public void testReset() {
        List mock = mock(List.class);
        when(mock.size()).thenReturn(0);
        mock.add(1);
        reset(mock);
        System.out.println(mock.size());
    }


    @Test
    public void testSerializableMock() {
        List mock = mock(List.class, withSettings().serializable());

    }

}
