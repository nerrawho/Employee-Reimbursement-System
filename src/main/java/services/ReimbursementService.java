package services;

import daos.ReimbursementDao;
import models.Reimbursement;
import models.ReimbursementStatus;
import models.ReimbursementType;
import models.User;
import utils.LoggingSingleton;

import java.util.List;

public class ReimbursementService {

    private ReimbursementDao rd;

    public ReimbursementService(ReimbursementDao rd) {
        this.rd = rd;
    }

    //Method to create new reimbursement
    public Reimbursement createReimbursement(User u, ReimbursementType type, double amount, String submit, String resolvedBy, String resolved, String description, ReimbursementStatus status) {

        Reimbursement r = new Reimbursement(u, type, amount, submit, resolvedBy, resolved, description, status);

        LoggingSingleton.logger.info("New reimbursement created: " + r.toString());

        rd.createReimbursement(r);

        return r;
    }


    //Method to return a list of reimbursements by the user ID.
    public List<Reimbursement> getReimbursementByEmployee(User u) {
        return rd.readReimbursementByEmployee(u.getUserID());
    }

    //Method to return a list of reimbursements by the type.
    public List<Reimbursement> getReimbursementByType(ReimbursementType type) {
        return rd.readReimbursementByType(type);
    }

    //Method to return a list of reimbursements by the status.
    public List<Reimbursement> getReimbursementByStatus(ReimbursementStatus status) {
        return rd.readReimbursementByStatus(status);
    }

    //Method to return a list of all reimbursements.
    public List<Reimbursement> getAllReimbursement() {
        return rd.readAllReimbursement();
    }

    //Method to update reimbursement
    public void updateReimbursement(Reimbursement r) {
        LoggingSingleton.logger.info("Updated: " + r.toString());
        rd.updateReimbursement(r);
    }

    //Method to delete reimbursement
    public void deleteReimbursement(Reimbursement r) {
        LoggingSingleton.logger.info("Deleted: " + r.toString());
        rd.deleteReimbursement(r);
    }

}
