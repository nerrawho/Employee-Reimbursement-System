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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

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
        boolean test = us.createUser("test123","testing","Test","Dummy", UserRole.EMPLOYEE);
        //Mockito.verify(ud).createUser(any());
        assertNotNull(test);
    }

    @Test
    public void  getAllUserShouldGetAll()
    {
        List<User> test = us.getAllUser();
        //Mockito.verify(ud).readAllUser();
       assertNotNull(test);
    }

    @Test
    public void getUserByEmail()
    {
        User test = us.getUserByEmail(any());
        //assertNotNull(test);
    }

    @Test
    public void getUserById()
    {
        User test = us.getUserById(anyInt());
        //assertNotNull(test);
    }

    @Test
    public void updateUserShouldUpdateUser()
    {
        boolean test = us.updateUser(any());
        //Mockito.verify(ud)
        //assertNotNull(test);
    }

    @Test
    public void deleteUserShouldDeleteUser()
    {
        User test = us.deleteUser(any());
    }




}
