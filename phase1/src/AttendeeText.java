public class AttendeeText {
    private Person[] people;

    public AttendeeText(Person[] people){
        this.people = people;
    }
    public void sendMessage(String message, Person currentPerson, Person recipient){
        Message m = new Message(message, currentPerson, recipient);
        recipient.addToMessageStorage(m.getMessage(), m.getSender());
    }
}
