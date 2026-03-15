package Ss07.Bai04;

public class Main {

    public static void main(String[] args) {

        // Case 1: File + Email
        OrderRepository repo1 = new FileOrderRepository();
        NotificationService notify1 = new EmailService();

        OrderService service1 = new OrderService(repo1, notify1);

        System.out.println("Tạo đơn hàng ORD001");
        service1.createOrder(new Order("ORD001"), "a@example.com");


        System.out.println();

        // Case 2: Database + SMS
        OrderRepository repo2 = new DatabaseOrderRepository();
        NotificationService notify2 = new SMSNotification();

        OrderService service2 = new OrderService(repo2, notify2);

        System.out.println("Tạo đơn hàng ORD002");
        service2.createOrder(new Order("ORD002"), "0123456789");
    }
}