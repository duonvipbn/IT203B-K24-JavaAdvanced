package Ss05.Bai03;

public class BookingCounter implements Runnable {

    private String counterName;
    private TicketPool roomA;
    private TicketPool roomB;
    private boolean lockAFirst;

    public BookingCounter(String counterName,
                          TicketPool roomA,
                          TicketPool roomB,
                          boolean lockAFirst) {

        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
        this.lockAFirst = lockAFirst;
    }

    public void sellCombo() {

        TicketPool first = lockAFirst ? roomA : roomB;
        TicketPool second = lockAFirst ? roomB : roomA;

        synchronized (first) {

            Ticket t1 = first.takeTicket();

            if (t1 != null)
                System.out.println(counterName + ": Đã lấy vé " + t1.getTicketId());

            try { Thread.sleep(100); } catch (Exception e) {}

            synchronized (second) {

                Ticket t2 = second.takeTicket();

                if (t1 != null && t2 != null) {

                    System.out.println(counterName +
                            " bán combo thành công: "
                            + t1.getTicketId() + " & " + t2.getTicketId());

                } else {

                    if (t1 != null)
                        first.returnTicket(t1);

                    if (t2 != null)
                        second.returnTicket(t2);

                    System.out.println(counterName +
                            ": Không đủ vé, bán combo thất bại");
                }
            }
        }
    }

    @Override
    public void run() {

        while (true) {

            sellCombo();

            try {
                Thread.sleep(300);
            } catch (Exception e) {
            }
        }
    }
}