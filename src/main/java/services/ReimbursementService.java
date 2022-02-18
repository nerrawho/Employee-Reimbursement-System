package services;

import daos.ReimbursementDao;
import daos.ReimbursementDaoImp;
import models.Reimbursement;
import models.ReimbursementStatus;
import models.ReimbursementType;
import models.User;
import utils.LoggingSingleton;

import java.util.List;
import java.sql.Date;
import java.util.Locale;

public class ReimbursementService {

    private ReimbursementDao rd;


    public ReimbursementService() {
    }

    public ReimbursementService(ReimbursementDao rd) {
        this.rd = rd;
    }

    //Method to create reimbursement with minimal parameters
    public boolean createReimbursement(User u, String type, double amount, String description) {

        ReimbursementType t = ReimbursementType.valueOf(type.trim().toUpperCase(Locale.ROOT));
        Reimbursement r = new Reimbursement(u, t, amount, description);


        if(rd.createReimbursement(r)) {
            LoggingSingleton.logger.info("New reimbursement created: " + r.toString());
            return true;
        }
        else
            return false;
    }

    //Method to create new reimbursement with all parameters
    public Reimbursement createReimbursement(User u, ReimbursementType type, double amount, String submit, String resolvedBy, String resolved, String description, ReimbursementStatus status) {

        Reimbursement r = new Reimbursement(u, type, amount, submit, resolvedBy, resolved, description, status);

        LoggingSingleton.logger.info("New reimbursement created: " + r.toString());

        rd.createReimbursement(r);

        return r;
    }

    //Method to return a single reimbursement by primary key ID.
    public Reimbursement getReimbursementById(int id) {
        return rd.readReimbursementById(id);
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

    //Method to return a list of reimbursements by the user ID.
    public List<Reimbursement> getPendingForEmployee(User u) {
        return rd.readAllPendingEmployee(u.getUserID());
    }

    //Method to return a list of reimbursements by the user ID.
    public List<Reimbursement> getResolvedForEmployee(User u) {
        return rd.readAllResolvedEmployee(u.getUserID());
    }

    //Method to return a list of all reimbursements.
    public List<Reimbursement> getAllPendingReimbursement() {
        return rd.readAllPendingReimbursement();
    }

    //Method to return a list of all reimbursements.
    public List<Reimbursement> getAllResolvedReimbursement() {
        return rd.readAllResolvedReimbursement();
    }

    public void approve(Reimbursement r) {
        LoggingSingleton.logger.info("Reimbursement" + r.getReimbursementID() + " Approved");
        rd.sendApprove(r);
    }

    public void deny(Reimbursement r) {
        LoggingSingleton.logger.info("Reimbursement" + r.getReimbursementID() + " Denied");
        rd.sendDeny(r);
    }
}
