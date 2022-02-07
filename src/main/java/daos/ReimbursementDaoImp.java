package daos;

import models.Reimbursement;
import utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ReimbursementDaoImp implements ReimbursementDao{


    @Override
    public void createReimbursement(Reimbursement r) {
        String sql = "INSERT into ";
        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);) {

        } catch (SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public Reimbursement readReimbursementById(int id) {
        return null;
    }

    @Override
    public List<Reimbursement> readAllReimbursement() {
        return null;
    }

    @Override
    public void updateReimbursement(Reimbursement r) {

    }

    @Override
    public void deleteReimbursement(Reimbursement r) {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
