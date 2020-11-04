public class Message {
    private String message;
    private Person sender;
    private Person receiver;

    public Message(String message, Person sender, Person receiver){
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
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
