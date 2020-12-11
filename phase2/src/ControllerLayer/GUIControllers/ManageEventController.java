package ControllerLayer.GUIControllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ManageEventController {
    private boolean cancelEvent = false;
    private boolean addEvent = false;
    private boolean downloadEvent = false;
    private String id;
    private int time;
    private List<String> listSpeakerUsername;
    private String roomNum;
    private boolean isVip;
    private int duration;
    private int capacity;

    public ManageEventController() {
    }

    public void setCancelEvent(boolean bool) {
        cancelEvent = bool;
    }

    public boolean getCancelEvent() {
        return cancelEvent;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTime(int t) {
        this.time = t;
    }

    public void setListSpeakerUsername(String speakers) {
        listSpeakerUsername = Arrays.asList(speakers.split(", "));
    }

    public void setRoomNum(String n) {
        roomNum = n;
    }

    public void setVip(boolean b) {
        isVip = b;
    }

    public void setDuration(int d) {
        duration = d;
    }

    public void setCapacity(int c) {
        capacity = c;
    }

    public String getId() {
        return id;
    }

    public int getTime() {
        return time;
    }

    public List<String> getListSpeakerUsername() {
        return listSpeakerUsername;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public boolean getVIP() {
        return isVip;
    }

    public int getDuration() {
        return duration;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setAddEvent(boolean b){
        addEvent = b;
    }
    public boolean getAddEvent(){
        return  addEvent;
    }
    public void setDownloadEvent(boolean b){
        downloadEvent = b;
    }
    public boolean getDownloadEvent(){
        return downloadEvent;
    }
}
