package Salon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static Salon.Customer.viewCust;
import static Salon.Customer.customers;
import static Salon.Treatment.treatments;
import static Salon.Treatment.viewTreatment;

public class Appointment {
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static ArrayList<Appointment> done = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    private int time;
    private int sum;
    private String trt;
    private String cust;
    private int price;
    private int totalPrice;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTrt() {
        return trt;
    }

    public void setTrt(String trt) {
        this.trt = trt;
    }

    public String getCust() {
        return cust;
    }

    public void setCust(String cust) {
        this.cust = cust;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }


    public Appointment(String cust, String trt, int time, int sum, int price, int totalPrice)
    {
        this.setCust(cust);
        this.setTrt(trt);
        this.setTime(time);
        this.setSum(sum);
        this.setPrice(price);
        this.setTotalPrice(totalPrice);
    }

    public static void menuAppointment()
    {
        int choose;

        do{
            System.out.println("Chill Salon");
            System.out.println("Call 02126052004 to make appointment");
            System.out.println("Appointment Menu:");
            System.out.println("-----------------");
            System.out.println("1. Add Appointment");
            System.out.println("2. View Appointment List");
            System.out.println("3. Update Appointment List");
            System.out.println("4. Remove Appointment");
            System.out.println("5. Back to main menu");
            System.out.print("Choose : ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    add();
                    break;

                case 2:
                    viewAppointment();
                    break;

                case 3:
                    update();
                    break;

                case 4:
                    remove();
                    break;

                case 5:
                    return;
            }
        }while(choose!= 5);
    }

    public static void add()
    {
        int choose;
        int time;
        int cust;
        int sum = 0;
        int price;
        int totalPrice = 0;

        if(sum + 60 >= 600)
        {
            System.out.println("The slot is full");
        }
        else {
            viewCust();
            if(customers.size()!=0)
            {
                do{
                    System.out.printf("Customer number: ");
                    cust = input.nextInt();
                }while (cust < 0 || cust > customers.size());

                viewTreatment();
                do{
                    System.out.printf("Choose treatment number: ");
                    choose = input.nextInt();
                    //   appointments.get(choose-1).setTreatment(treatments.get(choose-1));
                }while(choose<0 || choose>treatments.size());

                sum += treatments.get(choose-1).getDuration();
                price= treatments.get(choose-1).getPrice();
                totalPrice+=price;

                do{
                    System.out.printf("Choose time to make appointment [9 - 19] WIB: ");
                    time= input.nextInt();
                }while(time < 9 || time > 19 );


                appointments.add(new Appointment(customers.get(cust-1).getName(), treatments.get(choose-1).getName(), time, sum, price, totalPrice));
            }
            else
            {
                System.out.println("please add customer first!");
                return;
            }
        }
    }

    public static void viewAppointment()
    {
        if(appointments.isEmpty())
        {
            System.out.println("No appointemnt!");
        }
        else
        {
            System.out.println("Chill Salon");
            System.out.println("Appointment List");
            System.out.println("Jumlah appointment: " + appointments.size());
            System.out.println("==================================================================");
            for (int i=0; i< appointments.size(); i++)
            {
                System.out.printf(" | %-2d. | %-20s | %-20s | %d.00 WIB |", (i+1), appointments.get(i).getCust(),appointments.get(i).getTrt(), appointments.get(i).getTime());
                System.out.println("");
            }
            System.out.println("==================================================================");
        }
    }

    public static void update()
    {
        int trt, time;
        viewAppointment();
        System.out.printf("Input which appointment to update[1 - %d]: ",(appointments.size()));
        int up = input.nextInt();
        input.nextLine();

        do{
            viewTreatment();
            System.out.printf("Choose new appointment's treatment: ");
            trt= input.nextInt();
            appointments.get(up-1).setTrt(treatments.get(trt-1).getName());
        }while(trt <0 || trt >treatments.size());

        do{
            System.out.printf("Input new appointment's time [ 9-19 ] WIB: ");
            time= input.nextInt();
            appointments.get(up-1).setTime(time);
        }while(time < 9 || time > 19);
    }

    public static void remove()
    {
        viewAppointment();
        System.out.printf("Choose which appointment has done[1 - %d]: ",(appointments.size()));
        int del = input.nextInt();
        input.nextLine();
        done.add(appointments.get(del-1));
        appointments.remove(del - 1);
        System.out.println("The treatment done, waiting for payment...");
        System.out.println("Press enter to continue...");
        input.nextLine();
    }
}
