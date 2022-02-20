package services;

import daos.UserDao;
import daos.UserDaoImp;
import models.User;
import models.UserRole;
import utils.LoggingSingleton;

import java.util.List;

public class UserService
{
    private UserDao ud;

    public UserService()
    {
    }

    public UserService(UserDao ud)
    {
        this.ud = ud;
    }

    private final UserDao userDao = new UserDaoImp();


    public boolean createUser(String username, String password, String first, String last, UserRole role)
    {
        String email = first+"."+last+"@dc.com";
        email = email.toLowerCase();
        User u = new User (username, password, first, last, email, role);
        return userDao.createUser(u);
    }
    public boolean createUser(User u)
    {
        String email = u.getFirst()+"."+u.getLast()+"@dc.com";
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
        return userDao.readUserById(id);
    }

    public User getUserByEmail(String email) {
        return userDao.readUserByEmail(email);
    }


    public void updateUser(User u) {
        userDao.updateUser(u);
        LoggingSingleton.logger.info(u.getRole() + " " + u.getFirst() + " " + u.getLast() +
                " has updated their personal information");
    }

    public User deleteUser(User u)
    {
        userDao.deleteUser(u);
        return null;
    }
}