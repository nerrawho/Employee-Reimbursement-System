package daos;

import models.User;
import models.UserRole;
import utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao
{

    @Override
    public boolean createUser(User u)
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
        return false;
    }


    @Override
    public List<User> readAllUser()
    {
        List<User> uList = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);)
        {
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                User u = new User();
                int id = rs.getInt("id");
                u.setUserID(id);

                int roleOrdinal = rs.getInt("type");
                UserRole[] role = UserRole.values();
                u.setRole(role[roleOrdinal]);

                u.setFirst(rs.getString("first"));
                u.setLast(rs.getString("last"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));

                uList.add(u);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } return uList;
    }

    @Override
    public User readUserById(int id)
    {

        String sql = "SELECT * FROM users where id= ?";
        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);)
        {
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                User u = new User();
                u.setUserID(id);
                int roleOrdinal = rs.getInt("type");
                UserRole[] role = UserRole.values();
                u.setRole(role[roleOrdinal]);

                u.setFirst(rs.getString("first"));
                u.setLast(rs.getString("last"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                return u;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } return null;
    }

    @Override
    public User readUserByEmail(String email) {

        String sql = "SELECT * FROM users WHERE email = ?";
        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt("id"));
                int roleOrdinal = rs.getInt("type") - 1;
                UserRole[] role = UserRole.values();
                u.setRole(role[roleOrdinal]);

                u.setFirst(rs.getString("first"));
                u.setLast(rs.getString("last"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateUser(User u)
    {
        String sql = "UPDATE users SET first = ?, last = ?, username = ?, password = ?, email = ?, type = ? where id = ? ";
        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);)
        {
            ps.setString(1,u.getFirst());
            ps.setString(2, u.getLast());
            ps.setString(3, u.getUsername());
            ps.setString(4, u.getPassword());
            ps.setString(5, u.getEmail());
            ps.setInt(6, u.getRole().ordinal());
            int rowsAffected = ps.executeUpdate();

            if(rowsAffected==1){
                return true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(User u)
    {
        String sql = "DELETE FROM users WHERE id= ?";
        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);)
        {
            ps.setInt(1, u.getUserID());
            int rowsAffected = ps.executeUpdate();

            if(rowsAffected==1){
                return true;
            }
            ps.executeUpdate(sql);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

}
