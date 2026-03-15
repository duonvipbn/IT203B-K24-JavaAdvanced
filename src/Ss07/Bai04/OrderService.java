package Ss07.Bai04;

class OrderService {

    private OrderRepository orderRepository;
    private NotificationService notificationService;

    public OrderService(OrderRepository orderRepository,
                        NotificationService notificationService) {
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
    }

    public void createOrder(Order order, String recipient) {

        orderRepository.save(order);

        notificationService.send(
                "Đơn hàng " + order.orderId + " đã được tạo",
                recipient
        );
    }
}