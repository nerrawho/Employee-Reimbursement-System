package daos;

import models.User;

import java.util.List;

public interface UserDao
{
    public boolean createUser(User u);
    public List<User> readAllUser();
    public User readPersonById(int id);
    public boolean updateUser(User u);
    public boolean deleteUser(User u);
}