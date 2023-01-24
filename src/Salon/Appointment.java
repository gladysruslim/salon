package Salon;

import java.util.ArrayList;
import java.util.Scanner;

import static Salon.Customer.viewCust;
import static Salon.Customer.customers;
import static Salon.Main.header;
import static Salon.Treatment.treatments;
import static Salon.Treatment.viewTreatment;

public class Appointment {
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static ArrayList<Appointment> done = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    private int time;
    private String date;
    private int sum;
    private String trt;
    private String cust;
    private int price;
    private int totalPrice;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

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


    public Appointment(String cust, String trt, String date, int time, int sum, int price, int totalPrice)
    {
        this.setCust(cust);
        this.setTrt(trt);
        this.setDate(date);
        this.setTime(time);
        this.setSum(sum);
        this.setPrice(price);
        this.setTotalPrice(totalPrice);
    }

    public static void menuAppointment()
    {
        int choose;

        do{
            header();
            System.out.println("Call 02126052004 to make appointment");
            System.out.println("Appointment Menu:");
            System.out.println("-----------------");
            System.out.println("1. Add Appointment");
            System.out.println("2. View Appointment List");
            System.out.println("3. Update Appointment List");
            System.out.println("4. Move appointment to done list");
            System.out.println("5. Back to main menu");
            System.out.print("Choose : ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    addAppointment();
                    break;

                case 2:
                    viewAppointment();
                    break;

                case 3:
                    updateAppointment();
                    break;

                case 4:
                    removeAppointment();
                    break;

                case 5:
                    return;
            }
        }while(choose!= 5);
    }

    public static void addAppointment()
    {
        int choose;
        int time;
        int cust;
        int sum = 0;
        int price;
        int totalPrice = 0;
        String date;

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
                    System.out.printf("Choose treatment number [customer can ask more treatment on the spot if the staff is available]: ");
                    choose = input.nextInt();
                    //   appointments.get(choose-1).setTreatment(treatments.get(choose-1));
                }while(choose<0 || choose>treatments.size());
                input.nextLine();

                sum += treatments.get(choose-1).getDuration();
                price= treatments.get(choose-1).getPrice();
                totalPrice+=price;

                do{
                    System.out.printf("Masukkan tanggal transaksi [dd-mm-yyyy]: ");
                    date = input.nextLine();
                }while(date.length()!=10);

                do{
                    System.out.printf("Choose time to make appointment [9 - 19] WIB: ");
                    time= input.nextInt();
                }while(time < 9 || time > 19 );


                appointments.add(new Appointment(customers.get(cust-1).getName(), treatments.get(choose-1).getName(), date, time, sum, price, totalPrice));
                input.nextLine();
                System.out.println("New appointments added!");
                System.out.printf("Press enter to continue...");
                input.nextLine();
            }
            else
            {
                System.out.println("please add customer first!");
                System.out.printf("Press enter to continue...");
                input.nextLine();
                return;
            }
        }
    }

    public static void viewAppointment()
    {
        if(appointments.isEmpty())
        {
            System.out.println("No appointment!");
            System.out.printf("Press enter to continue...");
            input.nextLine();
        }
        else
        {
            header();
            System.out.println("Appointment List");
            System.out.println("Jumlah appointment: " + appointments.size());
            System.out.println("==============================================================================");
            System.out.printf("| %-2s | %-20s | %-20s | %-10s | %-9s |", "No.", "Name", "Treatment[1]", "Date", "Time");
            System.out.println();
            System.out.println("==============================================================================");
            for (int i=0; i< appointments.size(); i++)
            {
                System.out.printf("| %-2d. | %-20s | %-20s | %-10s | %d.00 WIB |", (i+1), appointments.get(i).getCust(), appointments.get(i).getTrt(), appointments.get(i).getDate(), appointments.get(i).getTime());
                System.out.println("");
            }
            System.out.println("==============================================================================");
            System.out.printf("Press enter to continue...");
            input.nextLine();
        }
    }

    public static void updateAppointment()
    {
        int trt, time;
        if(appointments.isEmpty())
        {
            System.out.println("There is no appointment");
        }
        else
        {
            viewAppointment();
            System.out.printf("Are you want to update appointment? [Yes | No]: ");
            String ans = input.next();
            if(ans.equals("No"))
            {
                return;
            }
            else {
                System.out.printf("Input which appointment to update[1 - %d]: ",(appointments.size()));
                int up = input.nextInt();
                input.nextLine();

                do{
                    viewTreatment();
                    System.out.printf("Choose one appointment's treatment : ");
                    trt= input.nextInt();
                    appointments.get(up-1).setTrt(treatments.get(trt-1).getName());
                }while(trt <0 || trt >treatments.size());

                do{
                    System.out.printf("Input new appointment's time [ 9-19 ] WIB: ");
                    time= input.nextInt();
                    appointments.get(up-1).setTime(time);
                }while(time < 9 || time > 19);

                input.nextLine();
                System.out.println("The appointment's details updated!");
                System.out.printf("Press enter to continue...");
                input.nextLine();
            }
        }

    }

    public static void removeAppointment()
    {
        if(appointments.isEmpty())
        {
            System.out.println("There is no appointment");
        }
        else{
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
}
