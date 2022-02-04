package daos;

import models.Reimbursement;

import java.util.List;

public class ReimbursementDaoImp implements ReimbursementDao{


    @Override
    public void createReimbursement(Reimbursement r) {
        try() {
            String sql = "INSERT into "
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
