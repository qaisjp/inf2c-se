/**
 *
 */
package tourguide;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author pbj
 */
public class DisplacementTest {
    /**
     * EPS = Epsilon, the difference to allow in floating point numbers when
     * comparing them for equality.
     */
    private static final double EPS = 0.01;

    @Test
    public void testNorthBearing() {
        double bearing = new Displacement(0.0, 1.0).bearing();
        assertEquals(0.0, bearing, EPS);
    }

    @Test
    public void testEastBearing() {
        double bearing = new Displacement(1.0, 0.0).bearing();
        assertEquals(90.0, bearing, EPS);
    }

    @Test
    public void testSouthBearing() {
        double bearing = new Displacement(0.0, -1.0).bearing();
        assertEquals(180, bearing, EPS);
    }

    @Test
    public void testWestBearing() {
        double bearing = new Displacement(-1.0, 0.0).bearing();
        assertEquals(270, bearing, EPS);
    }

    @Test
    public void testNorthWestBearing() {
        double bearing = new Displacement(-1.0, 1.0).bearing();
        assertEquals(315, bearing, EPS);
    }

    @Test
    public void testNorthEastBearing() {
        double bearing = new Displacement(1.0, 1.0).bearing();
        assertEquals(45, bearing, EPS);
    }

    @Test
    public void testSouthEastBearing() {
        double bearing = new Displacement(1.0, -1.0).bearing();
        assertEquals(135, bearing, EPS);
    }

    @Test
    public void testSouthWestBearing() {
        double bearing = new Displacement(-1.0, -1.0).bearing();
        assertEquals(225, bearing, EPS);
    }


    @Test
    public void testNorthDistance() {
        double distance = new Displacement(0.0, 1.0).distance();
        assertEquals(1, distance, EPS);
    }

    @Test
    public void testEastDistance() {
        double distance = new Displacement(1.0, 0.0).distance();
        assertEquals(1, distance, EPS);
    }

    @Test
    public void testSouthDistance() {
        double distance = new Displacement(0.0, -1.0).distance();
        assertEquals(1, distance, EPS);
    }

    @Test
    public void testWestDistance() {
        double distance = new Displacement(-1.0, 0.0).distance();
        assertEquals(1, distance, EPS);
    }

    @Test
    public void testNorthWestDistance() {
        double distance = new Displacement(-1.0, 1.0).distance();
        assertEquals(Math.sqrt(2), distance, EPS);
    }

    @Test
    public void testNorthEastDistance() {
        double distance = new Displacement(1.0, 1.0).distance();
        assertEquals(Math.sqrt(2), distance, EPS);
    }

    @Test
    public void testSouthEastDistance() {
        double distance = new Displacement(1.0, -1.0).distance();
        assertEquals(Math.sqrt(2), distance, EPS);
    }

    @Test
    public void testSouthWestDistance() {
        double distance = new Displacement(-1.0, -1.0).distance();
        assertEquals(Math.sqrt(2), distance, EPS);
    }

    @Test
    public void testValidBearings() {
        for (int north = -100; north < 100; north++) {
            for (int east = -100; east < 100; east++) {
                double bearing = new Displacement(east, north).bearing();

                assertTrue("all bearings should be gteq 0 and lteq 360", (bearing >= 0) && (bearing < 360));
            }
        }
    }

    @Test
    public void testNorthDistances() {
        for (int north = -100; north < 100; north++) {
            double distance = new Displacement(0, north).distance();
            assertEquals("Distances where (east=0) should be equal to |north|", distance, Math.abs(north), EPS);
        }
    }

    @Test
    public void testEastDistances() {
        for (int east = -100; east < 100; east++) {
            double distance = new Displacement(east, 0).distance();
            assertEquals("Distances where (north=0) should be equal to |east|", distance, Math.abs(east), EPS);
        }
    }

    @Test
    public void testDiagonalDistances() {
        for (int length = -100; length < 100; length++) {
            double actualDistance = new Displacement(length, length).distance();
            double expectedDistance = Math.sqrt(2 * length * length);
            assertEquals(expectedDistance, actualDistance, EPS);
        }
    }

}
