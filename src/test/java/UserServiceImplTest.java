import org.example.HashProvider;
import org.example.User;
import org.example.UserService;
import org.example.UserServiceImpl;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
/**
public class TestDoublures {

    @Test
    public void test_UnPremierStub() {
        User user = mock(User.class);
        when(user.getLogin()).thenReturn("Nestor");
        System.out.println(user.getLogin());
        assertEquals(user.getLogin(), "Nestor");
        //assertEquals(user.getLogin(), "bob");
    }
    @Test
    public void test_UnPremierMock() {
        User user = mock(User.class);
        when(user.getLogin()).thenReturn("Nestor");
        System.out.println(user.getLogin());
        System.out.println(user.getLogin());
        verify(user, times(2)).getLogin();
    }
    @Test
    public void test_OptionsVerification() {

        LinkedList<String> mockedList = mock(LinkedList.class);

        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        //following two verifications work exactly the same - times(1) is used by default
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        //exact number of invocations verification
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //verification using never(). never() is an alias to times(0)
        verify(mockedList, never()).add("never happened");

        //verification using atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("three times");
        verify(mockedList, atMost(5)).add("three times");
    }
}
 */
public class UserServiceImplTest {

    @Test
    public void should_create_user_with_hashed_password() {
        HashProvider mockHashProvider = mock(HashProvider.class);
        when(mockHashProvider.hash("secret")).thenReturn("hashedSecret");

        UserService userService = new UserServiceImpl(mockHashProvider);

        User user = userService.createUser("Bob", "secret");

        assertEquals(user.firstName(), "Bob");
        assertEquals(user.hashedPassword(), "hashedSecret");

        verify(mockHashProvider).hash("secret");
    }
}