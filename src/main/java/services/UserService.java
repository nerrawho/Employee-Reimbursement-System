package services;

import daos.UserDao;
import models.User;
import models.UserRole;

import java.util.List;

public class UserService
{
    private UserDao ud;
    public UserService(UserDao ud)
    {
        this.ud = ud;
    }
    public User createNewUser(String username, String password, String first, String last, UserRole role)
    {
        String email = first+"."+last+"@MBASB.org";
        email = email.toLowerCase();
        User u = new User (username, password, first, last, email, role);
        ud.createUser(u);
        return u;
    }

    public List<User> getAllUser()
    {
        return ud.readAllUser();
    }

    public User getUserById(int id)
    {
        return ud.readPersonById(id);
    }
    public void updateUser(User u)
    {
        ud.updateUser(u);
    }
    public void deleteUser(User u)
    {
      ud.deleteUser(u);
    }
}
