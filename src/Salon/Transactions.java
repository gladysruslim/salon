package Salon;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import static Salon.Appointment.appointments;
import static Salon.Customer.*;
import static Salon.Main.header;
import static Salon.Treatment.treatments;
import static Salon.Appointment.done;
import static Salon.Treatment.viewTreatment;


public class Transactions {
    static Scanner input = new Scanner(System.in);
    static ArrayList <Transactions> transactions = new ArrayList<>();

    private int time;
    private String cust;
    public String[] trm = new String[6];
    private int[] price = new int[6];
    private int total;
    static int jumlahtr;
    static String[] tr = new String[6];
    static int[] harga = new int[6];

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getCust() {
        return cust;
    }

    public void setCust(String cust) {
        this.cust = cust;
    }

    public String[] getTrm() {
        return trm;
    }

    public void setTrm(String[] trm) {
        this.trm = trm;
    }

    public int[] getPrice() {
        return price;
    }

    public void setPrice(int[] price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Transactions(int time, String cust, String[] trm, int[] price, int total)
    {
        this.setTime(time);
        this.setCust(cust);
        this.setTrm(trm);
        this.setPrice(price);
        this.setTotal(total);
    }

    public static void menuTransactions()
    {
        int choose;

        do{
            header();
            System.out.println("Transactions Menu:");
            System.out.println("-----------------");
            System.out.println("1. Waiting for payment list");
            System.out.println("2. Payment Transactions [Automatic add to transactions list]");
            System.out.println("3. View Transactions List");
            System.out.println("4. Update Transactions [FOR OWNER]");
            System.out.println("5. Remove Transactions [FOR OWNER]");
            System.out.println("6. Back to main menu");
            System.out.print("Choose : ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    viewDone();
                    break;

                case 2:
                    payment();
                    break;

                case 3:
                    viewTransactionList();
                    break;

                case 4:
                    updateTransactions();
                    break;

                case 5:
                    removeTransactions();
                    break;

                case 6:
                    return;
            }
        }while(choose!= 6);
    }
    public static void viewDone()
    {
        if(done.isEmpty())
        {
            System.out.println("There is 0 customer done");
            System.out.println("Press enter to continue...");
            input.nextLine();
        }
        else{
            int choose;
            header();
            System.out.println("Waiting for payment List");
            System.out.println("Jumlah: " + done.size());
            System.out.println("==============================");
            for (int i=0; i< done.size(); i++)
            {
                System.out.printf("| %-2d. | %-20s |", (i+1), done.get(i).getCust());
                System.out.println("");
            }
            System.out.println("==============================");
            System.out.printf("Press enter to continue...");
            input.nextLine();
        }
    }

    public static void payment()
    {
        int choose;
        int pilihtr;
        String status;

        int total = 0;

        if(done.isEmpty())
        {
            System.out.println("There is no customer data to payment!");
            System.out.println("Please input the customer that has done the treatment in appointment menu first");
        }
        else {
            int noCust = 0;
            do{
                viewDone();
                System.out.printf("Choose the customer to make transactions: ");
                choose= input.nextInt();
            }while(choose<0 || choose>done.size());


            do{
                System.out.printf("Total treatment [max 6] : ");
                jumlahtr = input.nextInt();
            }while(jumlahtr<=0 || jumlahtr>6);

            for (int i = 0; i < customers.size(); i++) {
                for (int j = 0; j < done.size(); j++) {
                    if(customers.get(i).getName().equals(done.get(j).getCust()))
                    {
                        noCust=i;
                    }
                }
            }

            customers.get(noCust).point += custPoint();
            if(customers.get(noCust).point > 100)
            {
                customers.get(noCust).setStatus("Gold");
            }
            else if(customers.get(noCust).point >500)
            {
                customers.get(noCust).setStatus("Platinum");
            }

            viewTreatment();

            for (int i=0; i<jumlahtr; i++)
            {
                System.out.printf("Choose the customer's treatment: ");
                do{
                    pilihtr = input.nextInt();
                }while(pilihtr<0 || pilihtr>treatments.size());
                tr[i]=treatments.get(pilihtr-1).getName();
                harga[i]= treatments.get(pilihtr-1).getPrice();
                total+=harga[i];
            }

            input.nextLine();

            transactions.add(new Transactions(done.get(choose-1).getTime(), done.get(choose-1).getCust(), tr, harga, total));

            viewBill();
            do{
                System.out.printf("Input payment Status [LUNAS] : ");
                status = input.nextLine();
                if(!status.equals("LUNAS"))
                {
                    System.out.println("Tidak menerima kredit!");
                }
            }while(!status.equals("LUNAS"));

            done.remove(choose-1);

            System.out.println("Transaksi Selesai!");
            System.out.println("Press enter to continue...");
            input.nextLine();
        }

    }

    public static void viewBill()
    {
        System.out.println();
        System.out.println("Nama: " + transactions.get(transactions.size()-1).getCust());
        System.out.printf("Waktu: %d.00 WIB" , transactions.get(transactions.size()-1).getTime());
        System.out.println();
        for (int j = 0; j < jumlahtr ; j++) {
                System.out.printf("| %-20s | Rp. %-15d |", tr[j], harga[j]);
                System.out.println();
            }
            System.out.println("Total: Rp. " + transactions.get(transactions.size()-1).getTotal());
            System.out.println();
    }


    public static void viewTransactionList()
    {
        if(transactions.isEmpty())
        {
            System.out.println("There is no transactions");
            System.out.printf("Press enter to continue...");
            input.nextLine();
        }
        else {
            header();
            System.out.println("Transactions List");
            System.out.println("Jumlah transactions: " + transactions.size());
            System.out.println("=============================================");
            System.out.printf("| %-3s | %-20s | %-12s |", "No", "Customer Name", "Total Income");
            System.out.println();
            for (int i=0; i< transactions.size(); i++)
            {
                System.out.printf("| %-2d. | %-20s | Rp. %-8s |", (i+1), transactions.get(i).getCust(),transactions.get(i).getTotal());
                System.out.println("");
            }
            System.out.println("=============================================");
            System.out.printf("Press enter to continue...");
            input.nextLine();
        }
    }

    public static void updateTransactions()
    {
        String password;
        int cust;
        int totalBaru;
        if(transactions.isEmpty())
        {
            System.out.println("There is no transactions");
        }
        else
        {
            System.out.println("Transactions list only can be update or remove by owner");
            System.out.printf("If you are owner, input password: ");
            password=input.nextLine();
            if(password.equals("Saya Owner"))
            {
                viewTransactionList();
                System.out.printf("Input which transactions to update[1 - %d | input 0 to return]: ",(transactions.size()));
                int up = input.nextInt();
                input.nextLine();

                if(up==0)
                {
                    return;
                }
                else{
                    do{
                        viewCust();
                        System.out.printf("Choose customer: ");
                        cust= input.nextInt();
                        transactions.get(up-1).setCust(customers.get(cust-1).getName());
                    }while(cust<0 || cust > customers.size());

                    do{
                        System.out.printf("Input new total: ");
                        totalBaru= input.nextInt();
                        transactions.get(up-1).setTotal(totalBaru);
                    }while(totalBaru < 0);

                    System.out.println("The transactions list updated!");
                    System.out.printf("Press enter to continue...");
                    input.nextLine();
                }
            }
            else {
                System.out.println("You are not owner!");
                System.out.printf("Press enter to continue...");
                input.nextLine();
            }
        }
    }

    public static void removeTransactions()
    {
        String password;

        if(transactions.isEmpty())
        {
            System.out.println("There is no transactions");
        }
        else
        {
            System.out.println("Transactions list only can be update or remove by owner");
            System.out.printf("If you are owner, input password: ");
            password=input.nextLine();
            if(password.equals("Saya Owner"))
            {
                viewTransactionList();
                System.out.printf("Input which transactions to remove[1 - %d | input 0 to return]: ",(transactions.size()));
                int del = input.nextInt();
                input.nextLine();

                if(del==0)
                {
                    return;
                }
                else{
                    transactions.remove(del - 1);
                    System.out.println("The transactions removed!");
                    System.out.println("Press enter to continue...");
                    input.nextLine();
                }
            }
            else{
                System.out.println("You are not owner!");
                System.out.printf("Press enter to continue...");
                input.nextLine();
            }
        }

    }

}
