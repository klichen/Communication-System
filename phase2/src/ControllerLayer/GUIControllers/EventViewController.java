package ControllerLayer.GUIControllers;

public class EventViewController {
    private boolean cancel = false;
    private String eventID;

    public  EventViewController(){
    }

    public void setCancel(boolean cancel){
        this.cancel = cancel;
    }

    public boolean getCancel(){
        return cancel;
    }
    public String getEventID(){
        return eventID;
    }

    public void setEventID(String id){
        eventID = id;
    }
}
