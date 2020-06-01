package MockItoTest;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author tongjian
 * @date 2020/6/1 13:03
 */
public class QuickStart {
    @Test
    public void test1() {
        List mock = mock(List.class);
        mock.add("one");
        mock.clear();
        verify(mock).add("one");
        verify(mock).clear();
    }

    @Test
    public void test2() {
        LinkedList mock = mock(LinkedList.class);
        OngoingStubbing<Object> first = when(mock.get(0)).thenReturn("first");
        System.out.println(mock.get(0));
        System.out.println(mock.get(999));
    }

    @Test(expected = IOException.class)
    public void test3() throws IOException {
        OutputStream mock = mock(OutputStream.class);
        doThrow(new IOException()).when(mock).close();
        mock.close();
    }

    @Test
    public void test4() {
        Iterator mock = mock(Iterator.class);
        when(mock.next()).thenReturn("hello").thenReturn("world");
        String result = mock.next() + " " + mock.next() + " " + mock.next();
        Assert.assertEquals("hello world world", result);
    }
}

