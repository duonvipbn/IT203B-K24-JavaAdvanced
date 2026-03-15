package Ss05.Bai01;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {

    private String roomName;
    private Queue<Ticket> tickets = new LinkedList<>();
    private int nextNumber = 1;

    public TicketPool(String roomName, int initialTickets) {
        this.roomName = roomName;

        for (int i = 0; i < initialTickets; i++) {
            addTicketInternal();
        }
    }

    private void addTicketInternal() {
        String id = roomName + "-" + String.format("%03d", nextNumber++);
        tickets.add(new Ticket(id));
    }

    public synchronized Ticket sellTicket() {
        if (tickets.isEmpty()) {
            return null;
        }
        return tickets.poll();
    }

    public synchronized void addTickets(int count) {

        for (int i = 0; i < count; i++) {
            addTicketInternal();
        }

        System.out.println("Nhà cung cấp: Đã thêm " + count + " vé vào phòng " + roomName);
    }

    public synchronized int remainingTickets() {
        return tickets.size();
    }
}