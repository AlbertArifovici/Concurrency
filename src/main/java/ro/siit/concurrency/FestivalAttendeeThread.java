package ro.siit.concurrency;

public class FestivalAttendeeThread extends Thread {
    private TicketType ticketType;

    FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        gate.addTicket(ticketType);
    }

    @Override
    public void run() {
        System.out.println("new ticket: " + ticketType);
    }

}
