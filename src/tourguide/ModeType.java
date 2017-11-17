package tourguide;

public enum ModeType {
    CREATE,
    BROWSE_OVERVIEW,
    BROWSE_DETAILS,
    FOLLOW;

    boolean IsBrowse() {
        return (this == BROWSE_DETAILS) ||  (this == BROWSE_OVERVIEW);
    }
}
