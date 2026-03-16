package Ss09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDatabase db = ProductDatabase.getInstance();

        while (true) {
            System.out.println("\n------ QUAN LY SAN PHAM ------");
            System.out.println("1. Them moi");
            System.out.println("2. Xem danh sach");
            System.out.println("3. Cap nhat");
            System.out.println("4. Xoa");
            System.out.println("5. Thoat");
            System.out.print("Chon: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("1. Physical | 2. Digital");
                    int type = Integer.parseInt(sc.nextLine());
                    
                    Product p = ProductFactory.createProduct(type, sc);
                    if (p != null) {
                        db.addProduct(p);
                        System.out.println("Them thanh cong!");
                    }
                    break;

                case 2:
                    for (Product pr : db.getAll()) {
                        pr.displayInfo();
                    }
                    break;

                case 3:
                    System.out.print("Nhap ID can sua: ");
                    String idUpdate = sc.nextLine();
                    Product update = db.findById(idUpdate);

                    if (update != null) {
                        System.out.print("Nhap ten moi: ");
                        update.setName(sc.nextLine());

                        System.out.print("Nhap gia moi: ");
                        update.setPrice(Double.parseDouble(sc.nextLine()));

                        System.out.println("Cap nhat thanh cong!");
                    } else {
                        System.out.println("Khong tim thay!");
                    }
                    break;

                case 4:
                    System.out.print("Nhap ID can xoa: ");
                    String idDelete = sc.nextLine();
                    db.delete(idDelete);
                    System.out.println("Da xoa!");
                    break;

                case 5:
                    System.out.println("Thoat...");
                    return;

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
}