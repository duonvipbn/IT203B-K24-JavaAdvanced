package Ss07.BaiThucHanh01;


public class OrderProcessor {
    private final Database db;
    private final EmailSender emailSender;
    private final PaymentMethod paymentMethod;
    private final Notification notification;

    public OrderProcessor(Database db, EmailSender emailSender, PaymentMethod paymentMethod, Notification notification){
        this.db = db;
        this.emailSender = emailSender;
        this.paymentMethod = paymentMethod;
        this.notification = notification;
    }

    public void processOrder(Order order, String paymentType) {
        // 1. Lưu vào Database
        Database db = new Database();
        db.save(order);

        // 2. Xử lý thanh toán
        paymentMethod.pay("Dang thuc hien thanh toan");


        // 3. Gửi thông báo
        EmailSender emailSender = new EmailSender();
        emailSender.sendEmail(order.getCustomerEmail(), "Đơn hàng của bạn đã được xử lý thành công!");
    }
}



