package Ss07.Bai04;

class SMSNotification implements NotificationService {

    @Override
    public void send(String message, String recipient) {
        System.out.println("Gửi SMS: " + message);
    }
}