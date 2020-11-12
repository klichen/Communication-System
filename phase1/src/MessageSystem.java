public class MessageSystem {
    private final Person[] users;

    public MessageSystem(Person[] users){
        this.users = users;
    }

    public void sendMessage(String message, Person sender, String receiver, Person currPerson){
        boolean singleRecipient = false;
        Person recipient = null;
        for(Person user: users){
            if (receiver.equals(user.getUsername())) {
                singleRecipient = true;
                recipient = user;
                break;
            }
        }
        if(sender.isOrganizerType()){
            OrganizerText text = new OrganizerText(users);
            if(singleRecipient) {
                text.messageSingleRecipient(message, currPerson, recipient);
            }
            else if(receiver.equals("All Speakers")){
                text.messageAllSpeakers(message, currPerson);
            }
            else if(receiver.equals("All Attendees")) {
                text.messageAllAttendees(message, currPerson);
            }
        }
        else if(sender.isAttendeeType()){
            AttendeeText text = new AttendeeText(users); // Assuming the AttendeeText is implemented in the same way as
                                                         // OrganizerText.
            text.sendMessage(message, currPerson, recipient); // Assuming AttendeeText is implemented similar to
                                                              // OrganizerText
        }
        else if(sender.isSpeakerType()){
            // Waiting for SpeakerText class to be completed first
        }
    }

}
