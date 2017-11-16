/**
 *
 */
package tourguide;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author pbj
 */
public class ControllerImp implements Controller {
    private static Logger logger = Logger.getLogger("tourguide");
    private static final String LS = System.lineSeparator();

    private final double waypointRadius, waypointSeparation;

    private String startBanner(String messageName) {
        return LS
                + "-------------------------------------------------------------" + LS
                + "MESSAGE: " + messageName + LS
                + "-------------------------------------------------------------";
    }

    public ControllerImp(double waypointRadius, double waypointSeparation) {
        // TODO
        this.waypointRadius = waypointRadius;
        this.waypointSeparation = waypointSeparation;
    }

    //--------------------------
    // Create tour mode
    //--------------------------

    // Some examples are shown below of use of logger calls.  The rest of the methods below that correspond 
    // to input messages could do with similar calls.

    @Override
    public Status startNewTour(String id, String title, Annotation annotation) {
        // todo
        logger.fine(startBanner("startNewTour"));
        return new Status.Error("unimplemented");
    }

    @Override
    public Status addWaypoint(Annotation annotation) {
        //todo
        logger.fine(startBanner("addWaypoint"));
        return new Status.Error("unimplemented");
    }

    @Override
    public Status addLeg(Annotation annotation) {
        // todo
        logger.fine(startBanner("addLeg"));
        return new Status.Error("unimplemented");
    }

    @Override
    public Status endNewTour() {
        // todo
        logger.fine(startBanner("endNewTour"));
        return new Status.Error("unimplemented");
    }

    //--------------------------
    // Browse tours mode
    //--------------------------

    @Override
    public Status showTourDetails(String tourID) {
        //todo
        return new Status.Error("unimplemented");
    }

    @Override
    public Status showToursOverview() {

        //todo
        return new Status.Error("unimplemented");
    }

    //--------------------------
    // Follow tour mode
    //--------------------------

    @Override
    public Status followTour(String id) {
        // todo
        return new Status.Error("unimplemented");
    }

    @Override
    public Status endSelectedTour() {

        //todo
        return new Status.Error("unimplemented");
    }

    //--------------------------
    // Multi-mode methods
    //--------------------------
    @Override
    public void setLocation(double easting, double northing) {
        // todo
    }

    @Override
    public List<Chunk> getOutput() {
        //todo


        return new ArrayList<Chunk>();
    }


}
