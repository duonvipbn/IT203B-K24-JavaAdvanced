package Ss01;

import java.io.FileNotFoundException;
import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

public class BaiThucHanh01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhap ten: ");
            String name = scanner.nextLine();

            System.out.print("Nhap tuoi: ");
            String ageInput = scanner.nextLine();

            System.out.print("Nhap email: ");
            String email = scanner.nextLine();

            registerUser(name, ageInput, email);

            String userData = "Ten: " + name + ", Tuoi: " + ageInput + ", Email: " + email;
            saveUserToFile(userData);

            System.out.println("Thanh cong!");

        } catch (NumberFormatException e) {
            System.out.println("Loi: tuoi phai la so");
        } catch (InvalidAgeException e) {
            System.out.println("Loi: "+ e.getMessage());
        } catch (InvalidEmailException e) {
            System.out.println("Loi email: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Loi : " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    public static void registerUser(String name, String ageInput, String email) throws InvalidAgeException, InvalidEmailException {

        int age = Integer.parseInt(ageInput);

        if (age < 18) {
            throw new InvalidAgeException("Tuoi phai tren 18");
        }

        if (!email.contains("@")) {
            throw new InvalidEmailException("Email phai chua @");
        }

    }

    public static void saveUserToFile(String userData) throws FileNotFoundException {
        throw new FileNotFoundException("Khong tim thay file");
    }
}