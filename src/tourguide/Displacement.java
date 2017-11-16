package tourguide;

import java.util.logging.Logger;

/**
 * A Displacement object is used to represent the offset
 * in both the North and East direction.
 * <p>
 * Useful utilities
 * are also provided to retrieve useful information about
 * the displacement.
 */
public class Displacement {
    private static Logger logger = Logger.getLogger("tourguide");

    /**
     * east is essentially the distance in the x-direction.
     */
    public double east;

    /**
     * north is essentially the distance in the y-direction.
     */
    public double north;

    /**
     * Class constructor for Displacement.
     *
     * @param e the offset towards the east
     * @param n the offset towards the north
     */
    public Displacement(double e, double n) {
        logger.finer("East: " + e + "  North: " + n);

        east = e;
        north = n;
    }

    /**
     * Finds the distance of the displacement.
     *
     * @return the distance from the origin
     */
    public double distance() {
        logger.finer("Entering");

        return Math.sqrt(east * east + north * north);
    }

    /**
     * Finds the bearing of the displacement. This bearing will always
     * be positive.
     *
     * @return the bearing measured clockwise form the North direction
     */
    public double bearing() {
        logger.finer("Entering");

        // atan2(y,x) computes angle from x-axis towards y-axis, returning a negative result
        // when y is negative.

        double inRadians = Math.atan2(east, north);

        if (inRadians < 0) {
            inRadians = inRadians + 2 * Math.PI;
        }

        return Math.toDegrees(inRadians);
    }


}
