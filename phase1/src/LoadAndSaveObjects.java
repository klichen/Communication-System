import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.*;

public class LoadAndSaveObjects{
    /**
     * Saves all objects (Events, Attendees, Speakers, and Organizers) and their
     * stored data into a .txt file
     *
     * @param scheduler Instance of UseCases.EventScheduler to access the list of events
     * @param speakerManager Instance of UseCases.SpeakerManager to access the list of speakers
     * @param attendeeManager Instance of UseCases.AttendeeManager to access the list of attendees
     * @param organizerManager Instance of UseCases.OrganizerManager to access the list of organizers
     * */
    public void saveAll(EventScheduler scheduler,  SpeakerManager speakerManager,
                        AttendeeManager attendeeManager, OrganizerManager organizerManager) throws IOException {
        try{
            FileOutputStream f = new FileOutputStream(new File("phase1/src/allObjects.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            for (String i : scheduler.getEventList()){
                o.writeObject(scheduler.getIdToEvent().get(i));
            }

            for(Speaker i : speakerManager.getAllSpeakers()){
                o.writeObject(i);
            }

            for(Attendee i : attendeeManager.getAllAttendees()){
                o.writeObject(i);
            }

            for(Organizer i : organizerManager.getAllOrganizers()){
                o.writeObject(i);
            }
            o.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    /**
     * Loads all objects (Events, Attendees, Speakers, and Organizers) and their
     * stored data from a .txt file
     *
     * @param scheduler Instance of UseCases.EventScheduler to save the list of events
     * @param speakerManager Instance of UseCases.SpeakerManager to save the list of speakers
     * @param attendeeManager Instance of UseCases.AttendeeManager to save the list of attendees
     * @param organizerManager Instance of UseCases.OrganizerManager to save the list of organizers
     * */
    public void loadAll(EventScheduler scheduler,  SpeakerManager speakerManager,
                        AttendeeManager attendeeManager, OrganizerManager organizerManager) throws IOException {
        try{
            FileInputStream  f = new FileInputStream (new File("phase1/src/allObjects.txt"));
            ObjectInputStream  o = new ObjectInputStream(f);

            while(true){
                Object obj=null;
                try {
                    obj = o.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if(obj instanceof Event){
                    scheduler.updateEventObjects((Event)obj);
                }
                else if(obj instanceof Attendee){
                    attendeeManager.updateAttendeeObjects((Attendee) obj);
                }
                else if(obj instanceof Speaker){
                    speakerManager.updateSpeakerObjects((Speaker) obj);
                }
                else if(obj instanceof Organizer){
                    organizerManager.updateOrganizerObjects ((Organizer) obj);
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
