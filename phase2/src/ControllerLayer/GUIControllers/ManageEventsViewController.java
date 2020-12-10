package ControllerLayer.GUIControllers;

public class ManageEventsViewController {
    private boolean addEvent = false;
    private String eventID;
    private boolean saveEvents = false;

    public ManageEventsViewController(){}

    public void setAddEvent(boolean bool){
        addEvent = bool;
    }

    public boolean getAddEvent(){
        return addEvent;
    }

    public void setSaveEvents(boolean bool){
        saveEvents = bool;
    }

    public boolean getSaveEvents(){
        return saveEvents;
    }

    public String getEventID(){
        return eventID;
    }

    public void setEventID(String id){
        eventID = id;
    }

}
