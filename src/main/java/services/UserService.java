package services;

import daos.UserDao;
import daos.UserDaoImp;
import models.User;
import models.UserRole;

import java.util.List;

public class UserService
{
    private final UserDao userDao = new UserDaoImp();

    public boolean createUser(String username, String password, String first, String last, UserRole role)
    {
        String email = first+"."+last+"@MBASB.org";
        email = email.toLowerCase();
        User u = new User (username, password, first, last, email, role);
        return userDao.createUser(u);
    }
    public boolean createUser(User u)
    {
        String email = u.getFirst()+"."+u.getLast()+"@MBASB.org";
        email = email.toLowerCase();
        u.setEmail(email);
        return userDao.createUser(u);
    }

    public List<User> getAllUser()
    {
        return userDao.readAllUser();
    }

    public User getUserById(int id)
    {
        return userDao.readPersonById(id);
    }
    public boolean updateUser(User u)
    {
        userDao.updateUser(u);
        return false;
    }
    public void deleteUser(User u)
    {
        userDao.deleteUser(u);
    }
}