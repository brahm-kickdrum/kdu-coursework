package org.example.question2;

import org.example.LoggerFile;

import java.util.*;
public class TicketReservation {

    private static final LoggerFile log = new LoggerFile();
    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;
    private List<Passenger> confirmedList = new ArrayList<>();
    private Deque<Passenger> waitingList = new ArrayDeque<>();

    /**
     * String s is used to remove the duplicate use of the string "Passenger with confirmation number "
     */
    String s = "Passenger with confirmation number ";

    /**
     * bookFlight function books the flight
     *
     * @param firstName
     * @param lastName
     * @param age
     * @param gender
     * @param travelClass
     * @param confirmationNumber
     * @return boolean
     */
    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber) {
        Passenger p = new Passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);
        if(confirmedList.size()<CONFIRMEDLIST_LIMIT){
            confirmedList.add(p);
            log.logInfo(s + confirmationNumber + " is added to confirmed list");
            return true;
        }
        else if(waitingList.size()<WAITINGLIST_LIMIT){
            waitingList.add(p);
            log.logInfo(s + confirmationNumber + " is added to waiting list");
            return true;
        }
        return false;
    }

    /**
     * cancel function cancels the booking and books other passenger present in the waiting list if any
     *
     * @param confirmationNumber
     * @return boolean
     */
    public boolean cancel(String confirmationNumber) {
        Iterator<Passenger> confirmedListIterator = confirmedList.iterator();
        boolean passengerRemoved = removePassenger(confirmedListIterator,confirmationNumber);
        if(!passengerRemoved){
            log.logError(s + confirmationNumber);
            return false;
        }
        Passenger passengerInWaitingList = waitingList.poll();
        if(passengerInWaitingList!=null){
            confirmedList.add(passengerInWaitingList);
            log.logInfo(s + confirmationNumber + " is added to confirmed list");
        }
        return true;
    }

    /**
     * removePassenger function removes the passenger from confirmed list
     * @param iterator
     * @param confirmationNumber
     * @return
     */
    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {
        while (iterator.hasNext()){
            Passenger passenger = iterator.next();
            if(confirmationNumber.equals(passenger.getConfirmationNumber())){
                confirmedList.remove(passenger);
                log.logInfo(s + confirmationNumber + " has been removed from confirmed list");
                return true;
            }
        }
        return false;
    }
}
