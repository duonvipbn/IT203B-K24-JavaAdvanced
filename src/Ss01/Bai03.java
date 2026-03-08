package Ss01;

public class Bai03 {
    public static void main(String[] args) {
        UserBai03 user = new UserBai03();

        try {
            user.setAge(5);

        } catch (IllegalArgumentException e) {
            System.out.printf(e.getMessage());
            return;
        }
        System.out.printf("Tuoi cua nguoi dung la: %d", user.getAge());
    }
}