package daos;

import models.User;
import utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImp implements UserDao
{

    @Override
    public void createUser(User u)
    {
        String sql = "Insert INTO users VALUES ( "+ u.getFirst() + " "+ u.getLast() +" "+ u.getUsername() +" "+ u.getPassword() +" "+ u.getEmail() +")";
        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);)
        {
            System.out.println(sql);
            ps.executeUpdate(sql);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public List<User> readAllUser()
    {
        return null;
    }

    @Override
    public User readPersonById(int id)
    {
        return null;
    }

    @Override
    public void updateUser(User u)
    {

    }

    @Override
    public void deleteUser(User u)
    {

    }
}
