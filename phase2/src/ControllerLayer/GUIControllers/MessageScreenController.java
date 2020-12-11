package ControllerLayer.GUIControllers;

public class MessageScreenController {
    boolean openSent = false;

    public MessageScreenController(){}

    public void setOpenSent(boolean bool){
        openSent = bool;
    }
    public boolean getOpenSent(){
        return openSent;
    }
}
