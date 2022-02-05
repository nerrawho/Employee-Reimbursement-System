package daos;

import models.User;
import models.UserRole;
import utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao
{

    @Override
    public void createUser(User u)
    {
        String sql = "Insert INTO users VALUES ("+ u.getFirst() + " "+ u.getLast() +" "+ u.getUsername() +" "+ u.getPassword() +" "+ u.getEmail() +" "+ (u.getRole().ordinal()) +")";
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
        List<User> uList = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);)
        {
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next())
            {
                User u = new User (rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), UserRole.values()[rs.getInt(6)]);
                uList.add(u);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } return uList;
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
