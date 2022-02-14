package models;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Reimbursement {
    private int reimbursementID;
    private User employee;
    private ReimbursementType type;
    private double amount;
    private String submit;
    private String resolvedBy;
    private String resolved;
    private String description;
    private ReimbursementStatus status;

    SimpleDateFormat dateFormat =  new SimpleDateFormat("MM/dd/yyyy");
    long currentDate = System.currentTimeMillis();


    //Constructors
    public Reimbursement() {
    }

    public Reimbursement(User employee, ReimbursementType type, double amount, String description) {
        this.employee = employee;
        this.type = type;
        this.amount = amount;
        submit = dateFormat.format(currentDate);
        resolvedBy = null;
        resolved = null;
        this.description = description;
        status = ReimbursementStatus.PENDING;
    }

    public Reimbursement(User employee, ReimbursementType type, double amount, String submit, String resolvedBy, String resolved, String description, ReimbursementStatus status) {
        this.employee = employee;
        this.type = type;
        this.amount = amount;
        this.submit = submit;
        this.resolvedBy = resolvedBy;
        this.resolved = resolved;
        this.description = description;
        this.status = status;
    }

    public Reimbursement(int reimbursementID, User employee, ReimbursementType type, double amount, String submit, String resolvedBy, String resolved, String description, ReimbursementStatus status) {
        this.reimbursementID = reimbursementID;
        this.employee = employee;
        this.type = type;
        this.amount = amount;
        this.submit = submit;
        this.resolvedBy = resolvedBy;
        this.resolved = resolved;
        this.description = description;
        this.status = status;
    }



    //Mutators
    public int getReimbursementID() {
        return reimbursementID;
    }

    public void setReimbursementID(int reimbursementID) {
        this.reimbursementID = reimbursementID;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public ReimbursementType getType() {
        return type;
    }

    public void setType(ReimbursementType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    public String getResolvedBy() {
        return resolvedBy;
    }

    public void setResolvedBy(String resolvedBy) {
        this.resolvedBy = resolvedBy;
    }

    public String getResolved() {
        return resolved;
    }

    public void setResolved(String resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ReimbursementStatus getStatus() {
        return status;
    }

    public void setStatus(ReimbursementStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursementID=" + reimbursementID +
                ", employee=" + employee +
                ", type=" + type +
                ", amount=" + amount +
                ", submit='" + submit + '\'' +
                ", resolvedBy='" + resolvedBy + '\'' +
                ", resolved='" + resolved + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}