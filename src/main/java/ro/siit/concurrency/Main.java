package ro.siit.concurrency;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        FestivalGate gate1 = new FestivalGate();
        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate1);

        statisticsThread.start();

        for (int i = 1; i <= 1000; i++) {
            TicketType ticketType = TicketType.values()[new Random().nextInt(TicketType.values().length)];
            Thread festivalAttendee = new FestivalAttendeeThread(ticketType, gate1);
            festivalAttendee.start();
            Thread.sleep(500);
            festivalAttendee.join();
        }


    }
}
