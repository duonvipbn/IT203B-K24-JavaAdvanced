package Ss01;

public class Bai05 {
    private int age;

    public static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Tuoi khong the am! (gia tri nhap: " + age + ")");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        Bai05 user = new Bai05();

        try {
            user.setAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("Bat duoc ngoai le: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            user.setAge(25);
            System.out.println("Tuoi da dat: " + user.getAge());
        } catch (InvalidAgeException e) {
            System.out.println("Bat duoc ngoai le: " + e.getMessage());
        }

        try {
            user.setAge(0);
            System.out.println("Tuoi da dat: " + user.getAge());
        } catch (InvalidAgeException e) {
            System.out.println("Bat duoc ngoai le: " + e.getMessage());
        }
    }
}