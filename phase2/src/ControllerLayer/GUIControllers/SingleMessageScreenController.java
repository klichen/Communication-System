package ControllerLayer.GUIControllers;

public class SingleMessageScreenController {
    private String message;
    private boolean read = true;
    private boolean delete = false;
    private boolean archive = false;

    public SingleMessageScreenController(){
    }

    public void setRead(boolean read){
        this.read = read;
    }

    public void setDelete(boolean delete){
        this.delete = delete;
    }

    public void setArchive(boolean archive){
        this.archive = archive;
    }
    public void setMessage(String msg){
        message = msg;
    }

    public boolean getRead(){
        return read;
    }
    public boolean getArchive(){
        return archive;
    }
    public boolean getDelete(){
        return delete;
    }
    public String getMessage(){
        return message;
    }


}
