package tourguide;

import java.util.logging.Logger;

/**
 *
 */
public class Displacement {
    private static Logger logger = Logger.getLogger("tourguide");

    // x-value
    public double east;

    // y-value
    public double north;

    /**
     * Class constructor for the displacement.
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
     * Find the distance of the displacement from the origin.
     *
     * @return the distance from the origin
     */
    public double distance() {
        logger.finer("Entering");

        return Math.sqrt(east * east + north * north);
    }

    /**
     * Get the bearing of the displacement.
     *
     * @return the bearing measured clockwise form the north direction
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
