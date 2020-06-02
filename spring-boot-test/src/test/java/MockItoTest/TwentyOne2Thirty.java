package MockItoTest;

import org.junit.jupiter.api.Test;
import org.mockito.MockingDetails;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author tongjian
 * @Captor, @Spy, @InjectMocks 注解
 * @date 2020/6/2 13:56
 */
public class TwentyOne2Thirty {
    /*
     //instead:
    @Spy BeerDrinker drinker = new BeerDrinker();
 //you can write:
    @Spy BeerDrinker drinker;

 //same applies to @InjectMocks annotation:
    @InjectMocks LocalPub;
     */
    @Test
    public void testTimeOut() {
        List mock = mock(List.class);
        verify(mock, timeout(100)).size();
        verify(mock, timeout(100).times(2)).size();
    }

    @Test
    public void testMockDetail() {
        List mock = mock(List.class);
        LinkedList<Object> objects = new LinkedList<>();
        LinkedList<Object> spy = spy(objects);
        System.out.println(mockingDetails(mock).isMock());
        System.out.println(mockingDetails(spy).isSpy());

        MockingDetails mockingDetails = mockingDetails(mock);
        mockingDetails.getMockCreationSettings().getTypeToMock();
    }
}
