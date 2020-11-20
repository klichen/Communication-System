import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.*;

public class LoadAndSaveObjects{

    public void saveAll(EventScheduler scheduler,  SpeakerManager speakerManager,
                        AttendeeManager attendeeManager, OrganizerManager organizerManager) throws IOException {
        try{
            FileOutputStream f = new FileOutputStream(new File("phase1/src/allObjects.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            //o.writeBytes("Events");
            //o.write('\n');
            for (String i : scheduler.getEventList()){
                o.writeObject(scheduler.getIdToEvent().get(i));
            }
            //o.writeBytes("Speakers");
            //o.write('\n');
            for(Speaker i : speakerManager.getAllSpeakers()){
                o.writeObject(i);
            }
            //o.writeBytes("Attendees");
            //o.write('\n');
            for(Attendee i : attendeeManager.getAllAttendees()){
                o.writeObject(i);
            }
            //o.writeBytes("Organizers");
            //o.write('\n');
            for(Organizer i : organizerManager.getAllOrganizers()){
                o.writeObject(i);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void loadAll(EventScheduler scheduler,  SpeakerManager speakerManager,
                        AttendeeManager attendeeManager, OrganizerManager organizerManager) throws IOException {
        try{
            FileInputStream  f = new FileInputStream (new File("phase1/src/allObjects.txt"));
            ObjectInputStream  o = new ObjectInputStream (f);

            while(true){
                Object obj=null;
                try {
                    obj = o.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if(obj instanceof Event){
                    scheduler.updateEventObjects((Event)obj);
                    System.out.println(scheduler.getEventList());
                }
                else if(obj instanceof Attendee){
                    attendeeManager.updateAttendeeObjects((Attendee) obj);
                    System.out.println(attendeeManager.getAllAttendees());
                }
                else if(obj instanceof Speaker){
                    speakerManager.updateSpeakerObjects((Speaker) obj);
                }
                else if(obj instanceof Organizer){
                    organizerManager.updateOrganizerObjects((Organizer) obj);
                }
                else
                    break;
                    //cont = false;
            }
        }
        catch (IOException e) {
            System.out.println("");
        }
    }

}
