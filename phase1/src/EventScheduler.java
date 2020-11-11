
public class EventScheduler {
    private Event[] eventList;
    public EventScheduler(Event[] eventList) {
        this.eventList = eventList;
    }
    public boolean checkEventList() {
        int i = 0;
        while (i < this.eventList.length){
            for (int j = i; j < this.eventList.length; j++) {
                if (this.eventList[j].getTime() <= this.eventList[i].getTime() &
                        this.eventList[i].getTime() < this.eventList[j].getTime() + 100 & i != j) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}
