package Ss06.Bai04;

public class BookingCounter implements Runnable {

    private String counterName;
    private TicketPool pool;

    public BookingCounter(String counterName, TicketPool pool) {
        this.counterName = counterName;
        this.pool = pool;
    }

    @Override
    public void run() {

        while (true) {

            pool.sellTicket(counterName);

            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}