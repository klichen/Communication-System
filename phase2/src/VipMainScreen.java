public class VipMainScreen {
    VipSystem vs;
    String username;
    AttendeeManager am;
    EventScheduler es;
    OrganizerManager om;
    SpeakerManager sm;
    VipManager vm;

    /**
     * Constructor for the presenter showing all of the Actions VIP can do
     * @param username The username of the VIP as a String
     * @param am Instance of AttendeeManager with loaded information
     * @param es Instance of EventScheduler with loaded information
     * @param om Instance of OrganizerManager with loaded information
     * @param sm Instance of SpeakerManager with loaded information
     */
    public VipMainScreen(String username, AttendeeManager am, EventScheduler es, OrganizerManager om,
                              SpeakerManager sm, VipManager vm){
        this.vs = new VipSystem(am, es, om, sm, vm);
        this.username = username;
        this.am = am;
        this.es = es;
        this.om = om;
        this.sm = sm;
        this.vm = vm;
    }

    /**
     * Prints the texts for the Attendee to see, and takes in inputs accordingly.
     */
    public void run() {
    }
    }

