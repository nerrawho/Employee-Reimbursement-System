package models;

public enum ReimbursementType {
    LODGING,
    TRAVEL,
    FOOD,
    OTHER;

    public static boolean exists(ReimbursementType t) {
        for(ReimbursementType type: ReimbursementType.values()) {
            if(t == type)
                return true;
        }
        return false;
    }
}

