package Ss01;

import java.io.IOException;

public class Bai04 {

    public static void main(String[] args) {
        try {
            processUserData();
        } catch (IOException e) {
            System.out.printf("Main bat duoc loi: %s", e.getMessage());
        }
    }


    public static void processUserData() throws IOException {
        saveToFile();
    }

    public static void saveToFile() throws IOException {
        throw new IOException("Loi ghi file: Khong the luu du lieu!");
    }
}