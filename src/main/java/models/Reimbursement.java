package models;

public class Reimbursement {
    private int reimbursementID;
    private User employee;
    private ReimbursementType type;
    private double amount;
    private boolean submit;
    private String resolvedBy;
    private String description;
    private ReimbursementStatus status;

    public Reimbursement() {
    }

    public Reimbursement(int reimbursementID, User employee, ReimbursementType type, double amount, boolean submit, String resolvedBy, String description, ReimbursementStatus status) {
        this.reimbursementID = reimbursementID;
        this.employee = employee;
        this.type = type;
        this.amount = amount;
        this.submit = submit;
        this.resolvedBy = resolvedBy;
        this.description = description;
        this.status = status;
    }

    public Reimbursement(User employee, ReimbursementType type, ReimbursementStatus status, double amount, boolean submit, String resolvedBy, String description) {
        this.employee = employee;
        this.type = type;
        this.status = status;
        this.amount = amount;
        this.submit = submit;
        this.resolvedBy = resolvedBy;
        this.description = description;


    }

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

    public ReimbursementStatus getStatus() {
        return status;
    }

    public void setStatus(ReimbursementStatus status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isSubmit() {
        return submit;
    }

    public void setSubmit(boolean submit) {
        this.submit = submit;
    }

    public String getResolvedBy() {
        return resolvedBy;
    }

    public void setResolvedBy(String resolvedBy) {
        this.resolvedBy = resolvedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
