package Ss05.Bai02;

import java.util.Random;

public class BookingCounter implements Runnable {

    private String counterName;
    private TicketPool roomA;
    private TicketPool roomB;
    private int soldCount = 0;

    Random random = new Random();

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
    }

    @Override
    public void run() {

        while (true) {

            if (!roomA.hasAvailableTicket() && !roomB.hasAvailableTicket())
                break;

            boolean chooseA = random.nextBoolean();

            Ticket ticket = null;

            if (chooseA) {
                ticket = roomA.sellTicket();

                if (ticket == null)
                    ticket = roomB.sellTicket();

            } else {

                ticket = roomB.sellTicket();

                if (ticket == null)
                    ticket = roomA.sellTicket();
            }

            if (ticket != null) {

                soldCount++;

                System.out.println(counterName +
                        " đã bán vé " + ticket.getTicketId());
            }

            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
        }
    }

    public int getSoldCount() {
        return soldCount;
    }
}