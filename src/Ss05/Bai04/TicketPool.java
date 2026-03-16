package Ss05.Bai04;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {

    private String roomName;
    private Queue<Ticket> tickets = new LinkedList<>();
    private int nextNumber = 1;

    public TicketPool(String roomName, int initial) {

        this.roomName = roomName;

        for (int i = 0; i < initial; i++) {
            addOneTicket();
        }
    }

    private void addOneTicket() {

        String id = roomName + "-" + String.format("%03d", nextNumber++);
        tickets.add(new Ticket(id, roomName));
    }

    public synchronized Ticket sellTicket(String counterName) {

        while (tickets.isEmpty()) {

            try {

                System.out.println(counterName +
                        ": Hết vé phòng " + roomName + ", đang chờ...");

                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Ticket ticket = tickets.poll();

        System.out.println(counterName +
                " bán vé " + ticket.getTicketId());

        return ticket;
    }

    public synchronized void addTickets(int count) {

        for (int i = 0; i < count; i++) {
            addOneTicket();
        }

        System.out.println("Nhà cung cấp: Đã thêm "
                + count + " vé vào phòng " + roomName);

        notifyAll();
    }
}