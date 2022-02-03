package models;

public class Reimbursement {
    private int reimbursementID;
    private ReimbursementType type;
    private ReimbursementStatus status;
    private int amount;
    private boolean submit;
    private String resolvedBy;
    private String description;

    public Reimbursement() {
    }

    public Reimbursement(ReimbursementType type, int amount, boolean submit, String resolvedBy, String description, ReimbursementStatus status) {
        this.type = type;
        this.amount = amount;
        this.submit = submit;
        this.resolvedBy = resolvedBy;
        this.description = description;
        this.status = status;
    }

    public int getReimbursementID() {
        return reimbursementID;
    }

    public void setReimbursementID(int reimbursementID) {
        this.reimbursementID = reimbursementID;
    }

    public ReimbursementType getType() {
        return type;
    }

    public void setType(ReimbursementType type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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

    public ReimbursementStatus getStatus() {
        return status;
    }

    public void setStatus(ReimbursementStatus status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
