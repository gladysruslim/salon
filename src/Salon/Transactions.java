package Salon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static Salon.Appointment.appointments;
import static Salon.Customer.customers;
import static Salon.Treatment.treatments;
import static Salon.Appointment.done;
import static Salon.Treatment.viewTreatment;


public class Transactions {
    static Scanner input = new Scanner(System.in);
    static ArrayList <Transactions> transactions = new ArrayList<>();

    private int time;
    private String cust;
    public String[] trm = new String[5];
    private int[] price = new int[5];
    private int total;
    static int jumlahtr;
    static String[] tr = new String[5];
    static int[] harga = new int[5];

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
            System.out.println("Chill Salon");
            System.out.println("Transactions Menu:");
            System.out.println("-----------------");
            System.out.println("1. Add Transactions");
            System.out.println("2. View Transactions");
            System.out.println("3. Update Transactions");
            System.out.println("4. Remove Transactions");
            System.out.println("5. Back to main menu");
            System.out.print("Choose : ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    addTransactions();
                    break;

                case 2:
                    viewTransactions();
                    break;

                case 3:
                    //update();
                    break;

                case 4:
                    //remove();
                    break;

                case 5:
                    return;

                case 6:
                    viewDone();
                    break;
            }
        }while(choose!= 5);
    }
    public static void viewDone()
    {
        int choose;
        System.out.println("Chill Salon");
        System.out.println("Waiting for payment List");
        System.out.println("Jumlah: " + done.size());
        System.out.println("==================================================================");
        for (int i=0; i< done.size(); i++)
        {
            System.out.printf(" | %-2d. | %-20s |", (i+1), done.get(i).getCust());
            System.out.println("");
        }
        System.out.println("==================================================================");
    }

    public static void addTransactions()
    {
        int choose;
        int pilihtr;

        int total = 0;

        do{
            viewDone();
            System.out.printf("Choose the customer to make transactions: ");
            choose= input.nextInt();
        }while(choose<0 || choose>done.size());


        do{
            System.out.printf("Total treatment [max 5] : ");
            jumlahtr = input.nextInt();
        }while(jumlahtr<=0 || jumlahtr>5);
        viewTreatment();

        for (int i=0; i<jumlahtr; i++)
        {
            System.out.println("Choose the customer's treatment: ");
            do{
                pilihtr = input.nextInt();
            }while(pilihtr<0 || pilihtr>treatments.size());
            tr[i]=treatments.get(pilihtr-1).getName();
            harga[i]= treatments.get(pilihtr-1).getPrice();
            total+=harga[i];
        }

        transactions.add(new Transactions(done.get(choose-1).getTime(), done.get(choose-1).getCust(), tr, harga, total));
    }

    public static void viewTransactions()
    {
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println("No. " + (i+1));
            System.out.println("Nama: " + transactions.get(i).getCust());
            System.out.printf("Waktu: %d .00" , transactions.get(i).getTime());
            System.out.println();
            for (int j = 0; j < jumlahtr ; j++) {
                System.out.printf("| %s | Rp. %d |", tr[j], harga[j]);
                System.out.println();
            }
            System.out.println("Total: Rp. " + transactions.get(i).getTotal());
            System.out.println();
        }
    }
}
