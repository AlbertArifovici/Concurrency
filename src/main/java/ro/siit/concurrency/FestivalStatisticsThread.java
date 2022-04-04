package ro.siit.concurrency;

public class FestivalStatisticsThread extends Thread {

    FestivalGate gate;

    FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {

        do {
            gate.countTickets();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (gate.tickets != null);
    }
}
