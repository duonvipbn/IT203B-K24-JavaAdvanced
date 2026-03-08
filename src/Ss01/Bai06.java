package Ss01;

import java.time.LocalDate;


class User {
    private String name;
    private String email;
    private int age;

    public void setName(String name) throws InvalidNameException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidNameException("Ten khong duoc null hoac rong");
        }
        this.name = name.trim();
    }

    public void setEmail(String email) throws InvalidEmailException {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new InvalidEmailException("Email khong hop le: " + email);
        }
        this.email = email;
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Tuoi khong the am: " + age);
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}

public class Bai06 {
    private static void logError(String errorMessage) {
        System.out.printf("[ERROR] %tF %s%n", LocalDate.now(), errorMessage);
    }

    public static void main(String[] args) {
        User user = new User();

        try {
            user.setName(null);
        } catch (InvalidNameException e) {
            logError("Loi set ten: " + e.getMessage());
        }

        if (user.getName() != null) {
            System.out.println("Ten nguoi dung: " + user.getName());
        } else {
            System.out.println("Ten nguoi dung: (chua co ten)");
        }

        try {
            user.setEmail("test@example.com");
        } catch (InvalidEmailException e) {
            logError("Loi set email: " + e.getMessage());
        }

        try {
            user.setEmail("invalid-email");
        } catch (InvalidEmailException e) {
            logError("Loi set email: " + e.getMessage());
        }

        try {
            user.setAge(-5);
        } catch (InvalidAgeException e) {
            logError("Loi set tuoi: " + e.getMessage());
        }

        try {
            user.setAge(25);
        } catch (InvalidAgeException e) {
            logError("Loi set tuoi: " + e.getMessage());
        }

        System.out.println("Thong tin cuoi cung:");
        System.out.println("Ten: " + (user.getName() != null ? user.getName() : "null"));
        System.out.println("Email: " + (user.getEmail() != null ? user.getEmail() : "null"));
        System.out.println("Tuoi: " + user.getAge());
    }
}