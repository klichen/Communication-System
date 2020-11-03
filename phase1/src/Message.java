public class Message {
    private int id;
    private String message;
    private Person sender;
    private Person receiver;

    public Message(String message, Person sender, Person receiver, int id){
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
        this.id = id;
    }

    public String getMessage(){
        return message;
    }

    public Person getSender(){
        return sender;
    }

    public Person getReceiver(){
        return receiver;
    }
}
