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

    private Mode currentMode;

    private String startBanner(String messageName) {
        return LS
                + "-------------------------------------------------------------" + LS
                + "MESSAGE: " + messageName + LS
                + "-------------------------------------------------------------";
    }

    public ControllerImp(double waypointRadius, double waypointSeparation) {
        this.waypointRadius = waypointRadius;
        this.waypointSeparation = waypointSeparation;

        currentMode = new BrowseOverviewMode();
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

        if (!currentMode.getType().IsBrowse()) {
            return new Status.Error("startNewTour only valid if in browse tour mode");
        }

        currentMode = new CreateMode();

//        return Status.OK;
        return new Status.Error("unimplemented");
    }

    @Override
    public Status addWaypoint(Annotation annotation) {
        //todo
        logger.fine(startBanner("addWaypoint"));

        if (!currentMode.getType().IsCreate()) {
            return new Status.Error("addWaypoint only valid if in create tour mode");
        }

        logger.fine(startBanner("addWaypoint"));
        return new Status.Error("unimplemented");
    }

    @Override
    public Status addLeg(Annotation annotation) {
        // todo
        logger.fine(startBanner("addLeg"));

        if (!currentMode.getType().IsCreate()) {
            return new Status.Error("addLeg only valid if in create tour mode");
        }

        logger.fine(startBanner("addLeg"));
        return new Status.Error("unimplemented");
    }

    @Override
    public Status endNewTour() {
        // todo
        logger.fine(startBanner("endNewTour"));

        if (!currentMode.getType().IsCreate()) {
            return new Status.Error("endNewTour only valid if in create tour mode");
        }

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
        return currentMode.getOutput();
    }


}
