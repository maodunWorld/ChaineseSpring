package MockItoTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * @author tongjian
 * @date 2020/6/1 18:26
 */
@ExtendWith(MockitoExtension.class)
public class One2TenTest {


    @Mock
    private List list;

    @Test
    public void testVerifySome() {
        List list = mock(List.class);
        list.add("one");
        list.clear();
        verify(list).add("one");
        verify(list).clear();
    }

    @Test
    public void TestStubbing() {
        LinkedList mock = mock(LinkedList.class);
        when(mock.get(0)).thenReturn("first");
        when(mock.get(1)).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> {
            System.out.println(mock.get(0));
        });
        System.out.println(mock.get(1));
        System.out.println(mock.get(999));
        verify(mock).get(0);
    }

    @Test
    public void TestArgumentMatcher() {
        LinkedList mock = mock(LinkedList.class);
        when(mock.get(anyInt())).thenReturn("element");
        System.out.println(mock.get(999));
        verify(mock).get(anyInt());
    }

    @Test
    public void TestExact() {
        LinkedList mock = mock(LinkedList.class);
        mock.add("once");
        mock.add("twice");
        mock.add("twice");


        mock.add("three times");
        mock.add("three times");
        mock.add("three times");

        verify(mock).add("once");
        verify(mock, times(1)).add("once");
        verify(mock, times(2)).add("twice");
        verify(mock, times(3)).add("three times");

        verify(mock, never()).add("never happend");

        verify(mock, atMostOnce()).add("once");
        verify(mock, atLeastOnce()).add("three times");
        verify(mock, atLeast(2)).add("three times");
        verify(mock, atMost(5)).add("three times");
    }

    @Test
    public void TestMethodExc() {
        LinkedList mock = mock(LinkedList.class);
        doThrow(new RuntimeException()).when(mock).clear();
        mock.clear();
    }

    @Test
    public void TestVerifyOrder() {
        List mock = mock(List.class);

        mock.add("was added first");
        mock.add("was added second");

        InOrder inOrder = inOrder(mock);

        inOrder.verify(mock).add("was added first");
        inOrder.verify(mock).add("was added second");

        List fistMock = mock(List.class);
        List secondMock = mock(List.class);

        fistMock.add("was called first");
        secondMock.add("was called second");
        InOrder inOrder1 = inOrder(fistMock, secondMock);
        inOrder1.verify(fistMock).add("was called first");
        inOrder1.verify(secondMock).add("was called second");
    }

    @Test
    public void TestInteraction() {
        List mock = mock(List.class);
        List mock1 = mock(List.class);
        mock.add("one");

        verify(mock).add("one");
        verify(mock, never()).add("two");
        verifyZeroInteractions(mock, mock1);
    }

    @Test
    public void TestFind() {
        List mock = mock(List.class);
        mock.add("one");
        mock.add("two");
        verify(mock).add("one");
        verifyNoMoreInteractions(mock);
    }

    @Test
    public void TestWithAnatation() {

        list.add("one");

        verify(list).add("one");
        verify(list, never()).add("two");
    }

    @Test
    public void TestStubbingConsecutive() {
        List mock = mock(List.class);

        when(mock.contains("some arg"))
                .thenThrow(new RuntimeException())
                .thenReturn(true);

        mock.contains("some arg");
        System.out.println(mock.contains("some arg"));
    }
}

