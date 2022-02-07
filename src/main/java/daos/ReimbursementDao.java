package daos;

import models.Reimbursement;

import java.util.List;

public interface ReimbursementDao {
    public void createReimbursement(Reimbursement r);
    public List<Reimbursement> readReimbursementByEmployee(int id);
    public List<Reimbursement> readAllReimbursement();
    public void updateReimbursement(Reimbursement r);
    public void deleteReimbursement(Reimbursement r);
}
