package teststation;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.util.Random;
import java.util.Queue;


public class Arriving extends Event {
    static Logger logger = Logger.getLogger(Arriving.class);
    public Arriving(int timeStamp, int peopleInCar) {
        super(timeStamp, peopleInCar);
    }
    int seed = 1;
    Random generator = new Random(seed);
    @Override
    public Testing generateFutureEvent(int entryTimeStamp, int carID, int peopleInCar) {

        int newEventTimeStamp = entryTimeStamp + generator.nextInt(60,120);
        Testing event = new Testing(newEventTimeStamp, carID, peopleInCar);
        return event;
    }

    @Override
    public void printLn(Eventlist eventList) {
        PropertyConfigurator.configure("log4j.properties");

        logger.info("The car "+ this.getCarID() + " arrived at " + this.getEntryTimeStamp() + " sek, as " +
                eventList.carIDs.size() + " in the queue with " + this.getPeopleInCar() + " people " + "["+this.getClass().getName() + "]" +  eventList.carIDs);
        //System.out.println("Arrived car "+ this.getCarID());

    }

    @Override
    public void printLnNoSpace(Eventlist eventList) {
        logger.info("The car "+ this.getCarID() +" with " + this.getPeopleInCar() + " people came and goes");
    }
}
