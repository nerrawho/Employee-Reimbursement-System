package daos;

import models.Reimbursement;
import models.ReimbursementStatus;
import models.ReimbursementType;

import java.util.List;

public interface ReimbursementDao {
    public void createReimbursement(Reimbursement r);
    public List<Reimbursement> readReimbursementByEmployee(int id);
    public List<Reimbursement> readReimbursementByType(ReimbursementType type);
    public List<Reimbursement> readReimbursementByStatus(ReimbursementStatus status);
    public List<Reimbursement> readAllReimbursement();
    public void updateReimbursement(Reimbursement r);
    public void deleteReimbursement(Reimbursement r);
}
