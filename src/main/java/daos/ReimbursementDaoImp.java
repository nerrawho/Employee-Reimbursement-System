package daos;

import models.Reimbursement;
import models.ReimbursementStatus;
import models.ReimbursementType;
import models.User;
import utils.ConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ReimbursementDaoImp implements ReimbursementDao{

    @Override
    public void createReimbursement(Reimbursement r) {

        String sql = "INSERT INTO reimbursement (user_id, type, amount, submitted, resolved, description, receipt, status) values (?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, r.getEmployee().getUserID());
            ps.setInt(2, r.getType().ordinal());
            ps.setDouble(3, r.getAmount());
            ps.setBoolean(4, r.isSubmit());
            ps.setString(5, r.getResolvedBy());
            ps.setString(6, r.getDescription());
            ps.setString(7, "Placeholder");     //Placeholder for receipt
            ps.setInt(8, r.getStatus().ordinal());

            ps.executeUpdate();
        }
        catch (SQLException e){

            e.printStackTrace();
        }
    }

    @Override
    public List<Reimbursement> readReimbursementByEmployee(int employeeId) {

        List<Reimbursement> list= new ArrayList<Reimbursement>();

        String sql = "SELECT * FROM reimbursement WHERE user_id = " + employeeId;
        try(Connection c = ConnectionUtil.getConnection();
            Statement s = c.createStatement();) {

            ResultSet rs = s.executeQuery(sql);

            while(rs.next()) {
                Reimbursement r = new Reimbursement();
                r.setReimbursementID(rs.getInt(1));
                User u = new User();
                u.setUserID(rs.getInt(2));
                r.setEmployee(u);
                r.setType(ReimbursementType.values()[rs.getInt(3)]);
                r.setAmount(rs.getDouble(4));
                r.setSubmit(rs.getBoolean(5));
                r.setResolvedBy(rs.getString(6));
                r.setDescription(rs.getString(7));
                r.setStatus(ReimbursementStatus.values()[rs.getInt(9)]);

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
            Statement s = c.createStatement();) {

            ResultSet rs = s.executeQuery(sql);

            while(rs.next()) {
                Reimbursement r = new Reimbursement();
                r.setReimbursementID(rs.getInt(1));
                User u = new User();
                u.setUserID(rs.getInt(2));
                r.setEmployee(u);
                r.setType(ReimbursementType.values()[rs.getInt(3)]);
                r.setAmount(rs.getDouble(4));
                r.setSubmit(rs.getBoolean(5));
                r.setResolvedBy(rs.getString(6));
                r.setDescription(rs.getString(7));
                r.setStatus(ReimbursementStatus.values()[rs.getInt(9)]);

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
                "sbubmitted = " + r.isSubmit() + "," +
                "resolved = '" + r.getResolvedBy() + "'," +
                "description = '" + r.getDescription() + "'," +
                "status = " + r.getStatus().ordinal() +
                "WHERE id = " + r.getReimbursementID();

        try(Connection c = ConnectionUtil.getConnection();
            Statement s = c.createStatement();) {

            s.executeUpdate(sql);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReimbursement(Reimbursement r) {

        String sql = "DELETE FROM reimbursement WHERE id = " + r.getReimbursementID();

        try(Connection c = ConnectionUtil.getConnection();
            Statement s = c.createStatement();) {

            s.executeUpdate(sql);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
