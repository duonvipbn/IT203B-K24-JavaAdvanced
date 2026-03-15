package Ss07.BaiThucHanh01;

class EmailSender implements  Notification {
    @Override
    public void sendEmail(String email, String message) {
        System.out.println("Đã gửi Email tới: " + email);
    }
}