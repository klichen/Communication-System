package ControllerLayer;

import UseCases.*;

import java.io.*;
import java.util.List;

public class EventsToHtml {
    public void saveToHtml(EventScheduler eventScheduler){
        String html = "<html>\n" +
                "<head>\n" +
                "<style>\n" +
                "table, th, td {\n" +
                "  border: 1px solid black;\n" +
                "  border-collapse: collapse;\n" +
                "}\n" +
                "th, td {\n" +
                "  padding: 15px;\n" +
                "  text-align: left;\n" +
                "}\n" +
                "#t01 {\n" +
                "  width: 100%;    \n" +
                "  background-color: #f1f1c1;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h2>All Events</h2>\n" +
                "\n" +
                "<table style=\"width:100%\">\n" +
                "  <tr>\n" +
                "    <th>Event ID</th> \n" +
                "    <th>Room Number</th>\n" +
                "    <th>Event Time (Military)</th>\n" +
                "    <th>Max Participants</th>\n" +
                "    <th>Current Number of Participants</th>\n" +
                "    <th>VIP Only</th>\n" +
                "    <th>Speaker(s)</th>\n" +
                "  </tr>\n";

        try{
            File f = new File("phase2/src/Files/SavedEvents.html");
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));

            for (String i : eventScheduler.getEventList()){
                html = html + "<tr>\n";
                html = html + eventIdHelper(eventScheduler,i);
                html = html + roomNumHelper(eventScheduler,i);
                html = html + eventTimeHelper(eventScheduler,i);
                html = html + maxParticipantsHelper(eventScheduler,i);
                html = html + currentParticipantsHelper(eventScheduler,i);
                html = html + vipOnlyHelper(eventScheduler,i);
                html = html + speakerHelper(eventScheduler,i);
                html = html + "</tr>\n";
            }

            html = html + "</table>\n</body>\n</html>";
            bw.write(html);
            bw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public String eventIdHelper(EventScheduler eventScheduler, String id){
        String html = "<th>";
        html = html + eventScheduler.getIdToEvent().get(id).getID();
        html = html + "</th>";
        return html;
    }
    public String roomNumHelper(EventScheduler eventScheduler, String id){
        String html = "<th>";
        html = html + eventScheduler.getIdToEvent().get(id).getRoomNum();
        html = html + "</th>";
        return html;
    }
    public String eventTimeHelper(EventScheduler eventScheduler, String id){
        String html = "<th>";
        html = html + eventScheduler.getIdToEvent().get(id).getFullTime();
        html = html + "</th>";
        return html;
    }
    public String maxParticipantsHelper(EventScheduler eventScheduler, String id){
        String html = "<th>";
        html = html + eventScheduler.getIdToEvent().get(id).getCapacity();
        html = html + "</th>";
        return html;
    }
    public String currentParticipantsHelper(EventScheduler eventScheduler, String id){
        List<String> temp = eventScheduler.getIdToEvent().get(id).getInEvent();
        String html = "<th>";
        html = html + temp.size();
        html = html + "</th>";
        return html;
    }
    public String vipOnlyHelper(EventScheduler eventScheduler, String id){
        String html = "<th>";
        html = html + eventScheduler.getIdToEvent().get(id).getIsVip();
        html = html + "</th>";
        return html;
    }
    public String speakerHelper(EventScheduler eventScheduler, String id){
        String html = "<th>";
        if (eventScheduler.getIdToEvent().get(id).getSpeaker().size()==0){
            html = html + "None";
        }
        else{
            html = html + eventScheduler.getIdToEvent().get(id).getSpeaker();
        }
        html = html + "</th>";
        return html;
    }
}
