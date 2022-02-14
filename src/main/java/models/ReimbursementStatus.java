package models;

public enum ReimbursementStatus {
    PENDING,
    APPROVED,
    DENIED;

    public static boolean exists(ReimbursementStatus s) {
        for(ReimbursementStatus status: ReimbursementStatus.values()) {
            if(s == status)
                return true;
        }
        return false;
    }
}
