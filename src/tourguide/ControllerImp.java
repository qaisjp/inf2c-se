/**
 *
 */
package tourguide;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * @author pbj
 */
public class ControllerImp implements Controller {
    private static Logger logger = Logger.getLogger("tourguide");
    private static final String LS = System.lineSeparator();

    private final double waypointRadius, waypointSeparation;

    private Mode currentMode;
    private Set<Tour> tours;

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
        tours = new HashSet<>();
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
            logger.finer("Not in browse mode");
            return new Status.Error("startNewTour only valid if in browse tour mode");
        }

        currentMode = new CreateMode(id, title, annotation);

        return Status.OK;
    }

    @Override
    public Status addWaypoint(Annotation annotation) {
        //todo
        logger.fine(startBanner("addWaypoint"));

        if (!currentMode.getType().IsCreate()) {
            logger.finer("Not in create mode");
            return new Status.Error("addWaypoint only valid if in create tour mode");
        }

        CreateMode mode = (CreateMode) currentMode;

        return mode.addWaypoint(annotation);
    }

    @Override
    public Status addLeg(Annotation annotation) {
        // todo
        logger.fine(startBanner("addLeg"));

        if (!currentMode.getType().IsCreate()) {
            logger.finer("Not in create mode");
            return new Status.Error("addLeg only valid if in create tour mode");
        }

        CreateMode mode = (CreateMode) currentMode;

        return mode.addLeg(annotation);
    }

    @Override
    public Status endNewTour() {
        // todo
        logger.fine(startBanner("endNewTour"));

        if (!currentMode.getType().IsCreate()) {
            logger.finer("Not in create mode");
            return new Status.Error("endNewTour only valid if in create tour mode");
        }

        CreateMode mode = (CreateMode) currentMode;

        Tour tour = mode.finishTour();
        if (tour == null) {
            return new Status.Error("could not finish tour in current state");
        }

        tours.add(tour);

        currentMode = new BrowseOverviewMode(tours);

        return Status.OK;
    }

    //--------------------------
    // Browse tours mode
    //--------------------------

    @Override
    public Status showTourDetails(String tourID) {
        Tour tour = null;

        for (Tour t : tours) {
            if (t.getID() == tourID) {
                tour = t;
                break;
            }
        }

        if (tour == null) {
            return new Status.Error("tour does not exist");
        }


        currentMode = new BrowseDetailsMode(tour);

        return Status.OK;
    }

    @Override
    public Status showToursOverview() {
        currentMode = new BrowseOverviewMode(tours);

        return Status.OK;
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
        if (currentMode.getType().IsCreate()) {
            CreateMode mode = (CreateMode) currentMode;
            mode.setLocation(new Displacement(easting, northing));
        }
    }

    @Override
    public List<Chunk> getOutput() {
        return currentMode.getOutput();
    }


}
