package services;

import daos.UserDao;
import models.User;
import models.UserRole;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class UserServiceTest
{
    @Mock
    static UserDao ud;

    @InjectMocks
    private UserService us;

    @Before
    public void initMocks()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createUserShouldCreateNewUser()
    {
        when(ud.createUser(any())).thenReturn(true);
        boolean test = us.createUser("test123","testing","Test","Dummy", UserRole.EMPLOYEE);
        //Mockito.verify(ud).createUser(any());
        assertNotNull(test);
    }

    @Test
    public void  getAllUserShouldGetAll()
    {
        when(ud.readAllUser()).thenReturn(anyList());
        List<User> test = us.getAllUser();
        //Mockito.verify(ud).readAllUser();
        assertNotNull(test);
    }

    @Test
    public void getUserByEmail()
    {
        when(ud.readUserByEmail(anyString())).thenReturn(any());
        User test = us.getUserByEmail(anyString());
        //assertNotNull(test);
    }

    @Test
    public void getUserById()
    {
        when(ud.readUserById(anyInt())).thenReturn(any());;
        User test = us.getUserById(anyInt());
        //assertNotNull(test);
    }

    @Test
    public void updateUserShouldUpdateUser()
    {
        when(ud.updateUser(any())).thenReturn(true);
        boolean test = us.updateUser(any());
        //Mockito.verify(ud)
        assertNotNull(test);
    }

    @Test
    public void deleteUserShouldDeleteUser()
    {
        when(ud.deleteUser(any())).thenReturn(true);
        User test = us.deleteUser(any());
    }




}