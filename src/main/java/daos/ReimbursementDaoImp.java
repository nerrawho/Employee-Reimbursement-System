package daos;

import models.Reimbursement;
import models.ReimbursementStatus;
import models.ReimbursementType;
import models.User;
import utils.ConnectionUtil;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


public class ReimbursementDaoImp implements ReimbursementDao{



    @Override
    public boolean createReimbursement(Reimbursement r) {

        String sql = "INSERT INTO reimbursement (user_id, type, amount, submitted, resolved_by, resolved, description, receipt, status) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, r.getEmployee().getUserID());
            ps.setInt(2, r.getType().ordinal());
            ps.setDouble(3, r.getAmount());
            ps.setString(4, r.getSubmit());
            ps.setString(5, r.getResolvedBy());
            ps.setString(6, r.getResolved());
            ps.setString(7, r.getDescription());
            ps.setString(8, "Placeholder");     //Placeholder for receipt
            ps.setInt(9, 2);

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected == 1) {
                return true;
            }
        }
        catch (SQLException e){

            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Reimbursement readReimbursementById(int id) {

        Reimbursement r = new Reimbursement();

        String sql = "SELECT * FROM reimbursement WHERE id = " + id;
        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement s = c.prepareStatement(sql);) {

            ResultSet rs = s.executeQuery();
            rs.next();

            r.setReimbursementID(rs.getInt(1));
            User u = new User();
            u.setUserID(rs.getInt(2));
            r.setEmployee(u);
            r.setType(ReimbursementType.values()[rs.getInt(3)]);
            r.setAmount(rs.getDouble(4));
            r.setSubmit(rs.getString(5));
            r.setResolvedBy(rs.getString(6));
            r.setResolved(rs.getString(7));
            r.setDescription(rs.getString(8));
            r.setStatus(ReimbursementStatus.values()[rs.getInt(10)-1]);

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public List<Reimbursement> readReimbursementByEmployee(int employeeId) {

        List<Reimbursement> list= new ArrayList<Reimbursement>();

        String sql = "SELECT * FROM reimbursement WHERE user_id = " + employeeId;
        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement s = c.prepareStatement(sql);) {

            ResultSet rs = s.executeQuery();

            while(rs.next()) {
                Reimbursement r = new Reimbursement();
                r.setReimbursementID(rs.getInt(1));
                User u = new User();
                u.setUserID(rs.getInt(2));
                r.setEmployee(u);
                r.setType(ReimbursementType.values()[rs.getInt(3)]);
                r.setAmount(rs.getDouble(4));
                r.setSubmit(rs.getString(5));
                r.setResolvedBy(rs.getString(6));
                r.setResolved(rs.getString(7));
                r.setDescription(rs.getString(8));
                r.setStatus(ReimbursementStatus.values()[rs.getInt(10)-1]);

                list.add(r);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Reimbursement> readReimbursementByType(ReimbursementType type) {
        List<Reimbursement> list= new ArrayList<Reimbursement>();

        String sql = "SELECT * FROM reimbursement WHERE type = " + type;
        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement s = c.prepareStatement(sql);) {

            ResultSet rs = s.executeQuery();

            while(rs.next()) {
                Reimbursement r = new Reimbursement();
                r.setReimbursementID(rs.getInt(1));
                User u = new User();
                u.setUserID(rs.getInt(2));
                r.setEmployee(u);
                r.setType(ReimbursementType.values()[rs.getInt(3)]);
                r.setAmount(rs.getDouble(4));
                r.setSubmit(rs.getString(5));
                r.setResolvedBy(rs.getString(6));
                r.setResolved(rs.getString(7));
                r.setDescription(rs.getString(8));
                r.setStatus(ReimbursementStatus.values()[rs.getInt(10)-1]);

                list.add(r);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Reimbursement> readReimbursementByStatus(ReimbursementStatus status) {
        List<Reimbursement> list= new ArrayList<Reimbursement>();

        String sql = "SELECT * FROM reimbursement WHERE status = " + status;
        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement s = c.prepareStatement(sql);) {

            ResultSet rs = s.executeQuery();

            while(rs.next()) {
                Reimbursement r = new Reimbursement();
                r.setReimbursementID(rs.getInt(1));
                User u = new User();
                u.setUserID(rs.getInt(2));
                r.setEmployee(u);
                r.setType(ReimbursementType.values()[rs.getInt(3)]);
                r.setAmount(rs.getDouble(4));
                r.setSubmit(rs.getString(5));
                r.setResolvedBy(rs.getString(6));
                r.setResolved(rs.getString(7));
                r.setDescription(rs.getString(8));
                r.setStatus(ReimbursementStatus.values()[rs.getInt(10)]);

                list.add(r);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Reimbursement> readAllReimbursement() {

        List<Reimbursement> list= new ArrayList<Reimbursement>();

        String sql = "SELECT * FROM reimbursement";
        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement s = c.prepareStatement(sql);) {

            ResultSet rs = s.executeQuery();

            while(rs.next()) {
                Reimbursement r = new Reimbursement();
                r.setReimbursementID(rs.getInt(1));
                User u = new User();
                u.setUserID(rs.getInt(2));
                r.setEmployee(u);
                r.setType(ReimbursementType.values()[rs.getInt(3)]);
                r.setAmount(rs.getDouble(4));
                r.setSubmit(rs.getString(5));
                r.setResolvedBy(rs.getString(6));
                r.setResolved(rs.getString(7));
                r.setDescription(rs.getString(8));
                r.setStatus(ReimbursementStatus.values()[rs.getInt(10)-1]);

                list.add(r);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void updateReimbursement(Reimbursement r) {

        String sql = "UPDATE reimbursement SET user_id = " + r.getEmployee().getUserID() + "," +
                "type = " + r.getType().ordinal() + "," +
                "amount = " + r.getAmount() + "," +
                "sbubmitted = " + r.getSubmit() + "," +
                "resolved_by = '" + r.getResolvedBy() + "'," +
                "resolved = '" + r.getResolved() + "'," +
                "description = '" + r.getDescription() + "'," +
                "status = " + r.getStatus().ordinal() +
                "WHERE id = " + r.getReimbursementID();

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement s = c.prepareStatement(sql);) {

            s.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReimbursement(Reimbursement r) {

        String sql = "DELETE FROM reimbursement WHERE id = " + r.getReimbursementID();

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement s = c.prepareStatement(sql);) {

            s.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Reimbursement> readAllPendingEmployee(int employeeId) {

        List<Reimbursement> list= new ArrayList<Reimbursement>();

        String sql = "SELECT * FROM reimbursement WHERE user_id = " + employeeId + " AND status = 2";
        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement s = c.prepareStatement(sql);) {

            ResultSet rs = s.executeQuery();

            while(rs.next()) {
                Reimbursement r = new Reimbursement();
                r.setReimbursementID(rs.getInt(1));
                User u = new User();
                u.setUserID(rs.getInt(2));
                r.setEmployee(u);
                r.setType(ReimbursementType.values()[rs.getInt(3)]);
                r.setAmount(rs.getDouble(4));
                r.setSubmit(rs.getString(5));
                r.setResolvedBy(rs.getString(6));
                r.setResolved(rs.getString(7));
                r.setDescription(rs.getString(8));
                r.setStatus(ReimbursementStatus.values()[rs.getInt(10)-1]);

                list.add(r);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Reimbursement> readAllResolvedEmployee(int employeeId) {

        List<Reimbursement> list= new ArrayList<Reimbursement>();

        String sql = "SELECT * FROM reimbursement WHERE user_id = " + employeeId + " AND status != 2";
        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement s = c.prepareStatement(sql);) {

            ResultSet rs = s.executeQuery();

            while(rs.next()) {
                Reimbursement r = new Reimbursement();
                r.setReimbursementID(rs.getInt(1));
                User u = new User();
                u.setUserID(rs.getInt(2));
                r.setEmployee(u);
                r.setType(ReimbursementType.values()[rs.getInt(3)]);
                r.setAmount(rs.getDouble(4));
                r.setSubmit(rs.getString(5));
                r.setResolvedBy(rs.getString(6));
                r.setResolved(rs.getString(7));
                r.setDescription(rs.getString(8));
                r.setStatus(ReimbursementStatus.values()[rs.getInt(10)-1]);

                list.add(r);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Reimbursement> readAllPendingReimbursement() {

        List<Reimbursement> list= new ArrayList<Reimbursement>();

        String sql = "SELECT * FROM reimbursement WHERE status = 2";
        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement s = c.prepareStatement(sql);) {

            ResultSet rs = s.executeQuery();

            while(rs.next()) {
                Reimbursement r = new Reimbursement();
                r.setReimbursementID(rs.getInt(1));
                User u = new User();
                u.setUserID(rs.getInt(2));
                r.setEmployee(u);
                r.setType(ReimbursementType.values()[rs.getInt(3)]);
                r.setAmount(rs.getDouble(4));
                r.setSubmit(rs.getString(5));
                r.setResolvedBy(rs.getString(6));
                r.setResolved(rs.getString(7));
                r.setDescription(rs.getString(8));
                r.setStatus(ReimbursementStatus.values()[rs.getInt(10)-1]);

                list.add(r);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Reimbursement> readAllResolvedReimbursement() {

        List<Reimbursement> list= new ArrayList<Reimbursement>();

        String sql = "SELECT * FROM reimbursement WHERE status != 2";
        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement s = c.prepareStatement(sql);) {

            ResultSet rs = s.executeQuery();

            while(rs.next()) {
                Reimbursement r = new Reimbursement();
                r.setReimbursementID(rs.getInt(1));
                User u = new User();
                u.setUserID(rs.getInt(2));
                r.setEmployee(u);
                r.setType(ReimbursementType.values()[rs.getInt(3)+1]);
                r.setAmount(rs.getDouble(4));
                r.setSubmit(rs.getString(5));
                r.setResolvedBy(rs.getString(6));
                r.setResolved(rs.getString(7));
                r.setDescription(rs.getString(8));
                r.setStatus(ReimbursementStatus.values()[rs.getInt(10)-1]);

                list.add(r);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void sendApprove(Reimbursement r) {

        String sql = "UPDATE reimbursement SET status = 3, resolved = '" + r.getResolved() + "', resolved_by = '" + r.getResolvedBy() + "'  WHERE id = " + r.getReimbursementID();

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement s = c.prepareStatement(sql);) {

            s.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendDeny(Reimbursement r) {

        String sql = "UPDATE reimbursement SET status = 1, resolved = '" + r.getResolved() + "', resolved_by = '" + r.getResolvedBy() + "'  WHERE id = " + r.getReimbursementID();

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement s = c.prepareStatement(sql);) {

            s.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }

    }
}
