package models;

public enum ReimbursementStatus {
    DENIED,
    PENDING,
    APPROVED;

    public static boolean exists(ReimbursementStatus s) {
        for(ReimbursementStatus status: ReimbursementStatus.values()) {
            if(s == status)
                return true;
        }
        return false;
    }
}
