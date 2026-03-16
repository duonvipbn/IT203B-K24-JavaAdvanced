package Ss09;

import java.util.Scanner;

public class ProductFactory {
    public static Product createProduct(int type, Scanner sc) {
        if(type != 1 || type != 2){
            System.out.println("Lua chon sai!");
            return null;
        }
        System.out.print("Nhap ID: ");
        String id = sc.nextLine();

        System.out.print("Nhap ten: ");
        String name = sc.nextLine();

        System.out.print("Nhap gia: ");
        double price = Double.parseDouble(sc.nextLine());

        if (type == 1) {
            System.out.print("Nhap weight: ");
            double weight = Double.parseDouble(sc.nextLine());
            return new PhysicalProduct(id, name, price, weight);
        } else if (type == 2) {
            System.out.print("Nhap size (MB): ");
            double size = Double.parseDouble(sc.nextLine());
            return new DigitalProduct(id, name, price, size);
        }

        return null;
    }
}