package daos;

import models.Reimbursement;
import models.User;
import models.UserRole;
import utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao
{

    @Override
    public void createUser(User u)
    {
            String sql = "INSERT INTO users (first, last, username, password, email, type) values (?, ?, ?, ?, ?, ?)";
            try(Connection c = ConnectionUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);)
            {
                ps.setString(1,u.getFirst());
                ps.setString(2, u.getLast());
                ps.setString(3, u.getUsername());
                ps.setString(4, u.getPassword());
                ps.setString(5, u.getEmail());
                ps.setInt(6, u.getRole().ordinal());
                ps.executeUpdate();
            }
            catch (SQLException e)
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
        User u = new User();
        String sql = "SELECT * FROM users where id=" + id;
        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);)
        {
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next())
            {
                u = new User (rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), UserRole.values()[rs.getInt(6)]);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } return u;
    }

    @Override
    public void updateUser(User u)
    {
        String sql = "UPDATE users SET first_name= " + u.getFirst() +", " + "last_name= " + u.getLast() + ", "
                + "username = " + u.getUsername() + ", " + "password= " + u.getPassword() + ", "
                + "email='" + u.getEmail() + ", " + "Role= " + (u.getRole().ordinal()) + " WHERE id=" + u.getUserID();
        try (Connection c = ConnectionUtil.getConnection();
             Statement s = c.createStatement();)
        {
            s.executeUpdate(sql);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteUser(User u)
    {
        String sql = "DELETE FROM users WHERE id=" + u.getUserID();
        try (Connection c = ConnectionUtil.getConnection();
             Statement s = c.createStatement();)
        {
            s.executeUpdate(sql);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
