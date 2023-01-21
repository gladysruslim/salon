package Salon;

import java.util.Scanner;

import static Salon.Customer.*;
import static Salon.Treatment.menuTreatment;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choose;

        do{
            System.out.println("Chill Salon");
            System.out.println("-----------------");
            System.out.println("Category:");
            System.out.println("1. Customer Data");
            System.out.println("2. Staff Data");
            System.out.println("3. Treatment");
            System.out.println("4. Appointment");
            System.out.println("5. Transactions");
            System.out.println("6. Equipment");
            System.out.println("7. Supplies");
            System.out.println("8. Exit");
            System.out.print("Choose : ");
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    menuCustomer();
                    break;

                case 2:
                    //menuStaff();
                    break;

                case 3:
                    menuTreatment();
                    break;

                case 4:
                   // menuAppointment();
                    break;

                case 5:
                    // menuTransactions();
                    break;

                case 6:
                    // menuEquipment();
                    break;

                case 7:
                    // menuSupplies();
                    break;

                case 8:
                    System.exit(0);
                    break;
            }
        }while(choose!= 8);
    }
}
