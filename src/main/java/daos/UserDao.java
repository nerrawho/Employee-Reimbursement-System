package daos;

import models.User;

import java.util.List;

public interface UserDao
{
    public void createUser(User u);
    public List<User> readAllUser();
    public User readPersonById(int id);
    public void updateUser(User u);
    public void deleteUser(User u);
}