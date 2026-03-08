package Ss01;

import java.util.Scanner;
import java.util.Calendar;

public class Bai01 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhap nam sinh: ");
            String input = scanner.nextLine();

            int namSinh = Integer.parseInt(input);

            int namHienTai = Calendar.getInstance().get(Calendar.YEAR);
            int tuoi = namHienTai - namSinh;
            if (tuoi < 0){
                System.out.printf("Nam sinh phai thap hon nam hien tai ");
            } else {
                System.out.printf("Dang ky thanh cong");
            }


        } catch (NumberFormatException e){
            System.out.printf("Phai nhap so nguyen");
        }finally {
            scanner.close();
        }

    }

}