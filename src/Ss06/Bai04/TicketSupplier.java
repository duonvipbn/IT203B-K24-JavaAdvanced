package Ss06.Bai04;

public class TicketSupplier implements Runnable {

    private TicketPool pool;

    public TicketSupplier(TicketPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {

        try {

            Thread.sleep(5000);

            pool.addTickets(3);

        } catch (Exception e) {
        }
    }
}