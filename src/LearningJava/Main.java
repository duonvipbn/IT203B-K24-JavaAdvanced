package LearningJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        List<item> itemList = new ArrayList<>();

        while(true){
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them item");
            System.out.println("2. Hien thi danh sach");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    System.out.print("Nhap ten item: ");
                    String name = sc.nextLine();

                    item newItem = new item(name);
                    itemList.add(newItem);

                    System.out.println("Da them!");
                    break;

                case 2:
                    System.out.println("Danh sach item:");
                    for(item it : itemList){
                        System.out.println("- " + it.getName());
                    }
                    break;

                case 0:
                    System.out.println("Thoat chuong trinh.");
                    return;

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
}