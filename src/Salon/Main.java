package Salon;

import java.util.Scanner;

import static Salon.Customer.*;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choose;

        do{
            System.out.println("Chill Salon");
            System.out.println("-----------------");
            System.out.println("1. Add New Customer");
            System.out.println("2. View Customer's Data");
            System.out.println("3. Update Customer Data");
            System.out.println("4. Remove Customer Data");
            System.out.println("5. Exit");
            System.out.print("Choose : ");
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    add();
                    break;

                case 2:
                    view();
                    break;

                case 3:
                    update();
                    break;

                case 4:
                    remove();
                    break;

                case 5:
                    System.exit(0);
                    break;
            }
        }while(choose!= 5);
    }
}
