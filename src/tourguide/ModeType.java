package tourguide;

public enum ModeType {
    CREATE,
    BROWSE_OVERVIEW,
    BROWSE_DETAILS,
    FOLLOW;

    boolean IsBrowse() {
        return (this == BROWSE_DETAILS) ||  (this == BROWSE_OVERVIEW);
    }
    boolean IsCreate() { return this == CREATE; }
    boolean IsFollow() { return this == FOLLOW; }
}
