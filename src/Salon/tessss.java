package Salon;

import java.util.ArrayList;
import java.util.Scanner;

import static Salon.Customer.customers;
import static Salon.Customer.viewCust;
import static Salon.Main.header;
import static Salon.Treatment.treatments;
import static Salon.Treatment.viewTreatment;

public class tessss {
    static ArrayList<tessss> app = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    private int time;
    private int sum;
    private String[] trt = new String[6];
    private static int jumlahtr;
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

    public String[] getTrt() {
        return trt;
    }

    public void setTrt(String[] trt) {
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


    public tessss(String cust, String[] trt, int time, int sum, int price, int totalPrice)
    {
        this.setCust(cust);
        this.setTrt(trt);
        this.setTime(time);
        this.setSum(sum);
        this.setPrice(price);
        this.setTotalPrice(totalPrice);
    }

    public static void menu()
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
                    //updateAppointment();
                    break;

                case 4:
                    //removeAppointment();
                    break;

                case 5:
                    return;
            }
        }while(choose!= 5);
    }

    public static void addAppointment()
    {
        int choose = 0;
        int time;
        int cust;
        int sum = 0;
        int price = 0;
        int totalPrice = 0;
        String[] tr = new String[6];

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

                do{
                    System.out.printf("Masukkan jumlah treatment [max 6]: ");
                    jumlahtr= input.nextInt();
                }while(jumlahtr<0 || jumlahtr>6);


                viewTreatment();
                for (int i = 0; i < jumlahtr; i++) {
                    do{
                        System.out.printf("Choose treatment number [customer can ask more treatment on the spot if the staff is available]: ");
                        choose = input.nextInt();
                        tr[i]= treatments.get(choose-1).getName();
                    }while(choose<0 || choose>treatments.size());

                    sum += treatments.get(choose-1).getDuration();
                    price= treatments.get(choose-1).getPrice();
                    totalPrice+=price;
                }

                do{
                    System.out.printf("Choose time to make appointment [9 - 19] WIB: ");
                    time= input.nextInt();
                }while(time < 9 || time > 19 );


                app.add(new tessss(customers.get(cust-1).getName(), tr, time, sum, price, totalPrice));
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
        if(app.isEmpty())
        {
            System.out.println("No appointment!");
            System.out.printf("Press enter to continue...");
            input.nextLine();
        }
        else
        {
            header();
            System.out.println("Appointment List");
            System.out.println("Jumlah appointment: " + app.size());
            System.out.println("==================================================================");
            for (int i=0; i< app.size()-1; i++)
            {
                System.out.printf(" | %-2d. | %-20s | %d.00 WIB |", (i+1), app.get(i).getCust(), app.get(i).getTime());
                for (int j=0; j< jumlahtr; j++)
                {
                    System.out.println(app.get(i).getTrt());
                }
                System.out.println("");
            }
            System.out.println("==================================================================");
            System.out.printf("Press enter to continue...");
            input.nextLine();
        }
    }

    public static void main(String[] args) {
        menu();
    }
}


