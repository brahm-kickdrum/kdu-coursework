package org.example.question2;

public class Main {

    public static void main(String[] args) {
        TicketReservation ticketReservation = new TicketReservation();

        ticketReservation.bookFlight("John", "Doe", 30, "Male", "Economy", "C1");
        ticketReservation.bookFlight("Jane", "Smith", 25, "Female", "Business", "C2");
        ticketReservation.bookFlight("Bob", "Johnson", 40, "Male", "First Class", "C3");
        ticketReservation.cancel("C2");
    }
}
