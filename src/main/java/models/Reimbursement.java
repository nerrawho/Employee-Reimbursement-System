package models;

import java.sql.Date;

public class Reimbursement {
    private int reimbursementID;
    private User employee;
    private ReimbursementType type;
    private double amount;
    private Date submit;
    private String resolvedBy;
    private Date resolved;
    private String description;
    private ReimbursementStatus status;


    //Constructors
    public Reimbursement() {
    }

    public Reimbursement(User employee, ReimbursementType type, double amount, Date submit, String resolvedBy, Date resolved, String description, ReimbursementStatus status) {
        this.employee = employee;
        this.type = type;
        this.amount = amount;
        this.submit = submit;
        this.resolvedBy = resolvedBy;
        this.resolved = resolved;
        this.description = description;
        this.status = status;
    }

    public Reimbursement(int reimbursementID, User employee, ReimbursementType type, double amount, Date submit, String resolvedBy, Date resolved, String description, ReimbursementStatus status) {
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

    public Date getSubmit() {
        return submit;
    }

    public void setSubmit(Date submit) {
        this.submit = submit;
    }

    public String getResolvedBy() {
        return resolvedBy;
    }

    public void setResolvedBy(String resolvedBy) {
        this.resolvedBy = resolvedBy;
    }

    public Date getResolved() {
        return resolved;
    }

    public void setResolved(Date resolved) {
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