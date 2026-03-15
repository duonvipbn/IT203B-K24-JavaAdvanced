package Ss07.Bai01;

class EmailService {

    public void sendEmail(Customer customer, String message) {
        System.out.println("Đã gửi email đến " + customer.email + ": " + message);
    }
}