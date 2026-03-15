package Ss06.Bai03;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int count) {

        this.roomName = roomName;

        for (int i = 1; i <= count; i++) {

            String id = roomName + "-" + String.format("%03d", i);

            tickets.add(new Ticket(id, roomName));
        }
    }

    public Ticket takeTicket() {

        for (Ticket t : tickets) {

            if (!t.isSold()) {

                t.setSold(true);
                return t;
            }
        }

        return null;
    }

    public void returnTicket(Ticket ticket) {

        if (ticket != null) {
            ticket.setSold(false);
        }
    }
}