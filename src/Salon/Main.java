package Salon;

import java.util.Scanner;

import static Salon.Appointment.menuAppointment;
import static Salon.Customer.*;
import static Salon.EquipmentData.MenuEquipment;
import static Salon.StaffData.menuStaff;
import static Salon.SuppliesData.MenuSupplies;
import static Salon.Transactions.menuTransactions;
import static Salon.Treatment.menuTreatment;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void header()
    {
        System.out.println("\n" +
                "█▀▀ █░█ █ █░░ █░░   █▀ ▄▀█ █░░ █▀█ █▄░█\n" +
                "█▄▄ █▀█ █ █▄▄ █▄▄   ▄█ █▀█ █▄▄ █▄█ █░▀█");
    }

    public static void main(String[] args) {
        int choose;

        do{
            System.out.println();
            header();
            System.out.println("Open from 9.00 until 19.00 WIB");
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
            System.out.println();
            switch (choose) {
                case 1:
                    menuCustomer();
                    break;

                case 2:
                    menuStaff();
                    break;

                case 3:
                    menuTreatment();
                    break;

                case 4:
                    menuAppointment();
                    break;

                case 5:
                    menuTransactions();
                    break;

                case 6:
                    MenuEquipment();
                    break;

                case 7:
                    MenuSupplies();
                    break;

                case 8:
                    System.exit(0);
                    break;
            }
        }while(choose!= 8);
    }
}
