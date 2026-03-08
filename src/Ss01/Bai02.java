package Ss01;

import java.util.Scanner;

public class Bai02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhap tong so nguoi dung: ");
            String inputNguoi = scanner.nextLine();
            int tongSoNguoi = Integer.parseInt(inputNguoi);

            System.out.print("Nhap so luong nhom muon chia: ");
            String inputNhom = scanner.nextLine();
            int soNhom = Integer.parseInt(inputNhom);

            int soNguoiMoiNhom = tongSoNguoi / soNhom;

            System.out.printf("Moi nhom co %d nguoi", soNguoiMoiNhom);

        } catch (NumberFormatException e) {
            System.out.printf("Loi: Phai nhap so nguyen");
        } catch (ArithmeticException e) {
            System.out.printf("Loi: Khong the chia cho 0!");
        } finally {
            scanner.close();
        }

    }
}