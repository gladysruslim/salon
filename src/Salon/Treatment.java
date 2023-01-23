package Salon;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

import static Salon.Main.header;

public class Treatment {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Treatment> treatments = new ArrayList<>();
    private String name;
    private String type;
    private int price;
    private int duration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Treatment(String name, String type, int duration, int price)
    {
       this.setName(name);
       this.setType(type);
       this.setDuration(duration);
       this.setPrice(price);
    }

    public static void menuTreatment()
    {
        int choose;

        do{
            header();
            System.out.println("Treatment Menu:");
            System.out.println("-----------------");
            System.out.println("1. Add New Treatment");
            System.out.println("2. View Treatment and Price List");
            System.out.println("3. Update Treatment and Price List");
            System.out.println("4. Remove Treatment");
            System.out.println("5. Back to main menu");
            System.out.print("Choose : ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    addTreatment();
                    break;

                case 2:
                    viewTreatment();
                    break;

                case 3:
                    updateTreatment();
                    break;

                case 4:
                    removeTreatment();
                    break;

                case 5:
                    return;
            }
        }while(choose!= 5);
    }

    public static void addTreatment()
    {
        String name, type;
        int price, duration;

        if(treatments.size()==0)
        {
            treatments.add(new Treatment("Hair cut", "Haircuts & other", 60, 125000));
            treatments.add(new Treatment("Hair cut poni", "Haircuts & other", 30,50000));
            treatments.add(new Treatment("Wash and Blow", "Haircuts & other", 60, 85000));
            treatments.add(new Treatment("Hairdo", "Haircuts & other", 120,150000));
            treatments.add(new Treatment("Eyebrow's Threading", "Haircuts & other", 60,55000));
            treatments.add(new Treatment("Medicure", "Nails", 60,45000));
            treatments.add(new Treatment("Pedicure", "Nails", 60,55000));
            treatments.add(new Treatment("Nail art", "Nails", 120,100000));
            treatments.add(new Treatment("Reflexy/foot massage", "Nails", 60,70000));
            treatments.add(new Treatment("Hair mask", "Hair Treatment", 120,150000));
            treatments.add(new Treatment("Creambath", "Hair Treatment", 120,130000));
            treatments.add(new Treatment("Hair spa", "Hair Treatment", 120,180000));
            treatments.add(new Treatment("Smoothing", "Hair Treatment", 180,800000));
            treatments.add(new Treatment("Coloring", "Hair Treatment", 180,900000));
        }

        System.out.printf("Add new treatment? [ Yes | No ]: ");
        String answer = input.next();
        input.nextLine();

        if (answer.equals("Yes"))
        {
            do{
                System.out.printf("Input new treatment's name: ");
                name= input.nextLine();
            }while(name.length() > 50 );

            do{
                System.out.printf("Input new treatment's type: ");
                type= input.nextLine();
            }while(type.length() > 50);

            do{
                System.out.printf("Input new treatment's duration [in minute]: ");
                duration= input.nextInt();
            }while(duration<0 || duration > 600);

            do{
                System.out.printf("Input new treatment's price: Rp. ");
                price= input.nextInt();
            }while(price<0);

            treatments.add(new Treatment(name, type, duration, price));
            sort();

            input.nextLine();
            System.out.println("New Treatment Added!");
            System.out.printf("Press enter to continue...");
            input.nextLine();
        }
        else{
            return;
        }
    }

    public static void viewTreatment()
    {
        if(treatments.size()==0)
        {
            treatments.add(new Treatment("Hair cut", "Haircuts & other", 60, 125000));
            treatments.add(new Treatment("Hair cut poni", "Haircuts & other", 30,50000));
            treatments.add(new Treatment("Wash and Blow", "Haircuts & other", 60, 85000));
            treatments.add(new Treatment("Hairdo", "Haircuts & other", 120,150000));
            treatments.add(new Treatment("Eyebrow's Threading", "Haircuts & other", 60,55000));
            treatments.add(new Treatment("Medicure", "Nails", 60,45000));
            treatments.add(new Treatment("Pedicure", "Nails", 60,55000));
            treatments.add(new Treatment("Nail art", "Nails", 120,100000));
            treatments.add(new Treatment("Reflexy/foot massage", "Nails", 60,70000));
            treatments.add(new Treatment("Hair mask", "Hair Treatment", 120,150000));
            treatments.add(new Treatment("Creambath", "Hair Treatment", 120,130000));
            treatments.add(new Treatment("Hair spa", "Hair Treatment", 120,180000));
            treatments.add(new Treatment("Smoothing", "Hair Treatment", 180,800000));
            treatments.add(new Treatment("Coloring", "Hair Treatment", 180,900000));
            sort();
        }

        header();
        System.out.println("Treatment and Price List");
        System.out.println("==============================================");
        System.out.println("Jumlah treatment: " + treatments.size());

        System.out.printf("| %-2s | %-20s | %-20s | %-10s | %-11s |", "No.", "Treatment Name", "Treatment Type", "Duration", "Price");
        System.out.println();
        for(int i=0; i < treatments.size(); i++)
        {
            System.out.printf("| %-2d. | %-20s | %-20s | %-4d menit | Rp. %-7d |", (i+1), treatments.get(i).getName(), treatments.get(i).getType(), treatments.get(i).getDuration(), treatments.get(i).getPrice());
            System.out.println(" ");
        }

        System.out.printf("Press enter to continue...");
        input.nextLine();
    }

    private static void sort() {

        for (int i = 0; i < treatments.size(); i++) {
            for (int j = 0; j < treatments.size() - 1; j++) {
                if (treatments.get(j).getType().compareTo(treatments.get(j+1).getType()) > 0) {
                    Treatment temp = treatments.get(j);
                    treatments.set(j, treatments.get(j+1));
                    treatments.set(j+1, temp);
                }
            }
        }
    }

    public static void updateTreatment()
    {
        String name, type;
        int price, duration;
        viewTreatment();
        System.out.printf("Input which treatment to update[1 - %d]: ",(treatments.size()));
        int up = input.nextInt();
        input.nextLine();

        do{
            System.out.printf("Input new treatment's name: ");
            name= input.nextLine();
            treatments.get(up-1).setName(name);
        }while(name.length() > 50 );

        do{
            System.out.printf("Input new treatment's type: ");
            type= input.nextLine();
            treatments.get(up-1).setType(type);
        }while(type.length() > 50);

        do{
            System.out.printf("Input new treatment's duration [Minute]: ");
            duration= input.nextInt();
            treatments.get(up-1).setDuration(duration);
        }while(duration<0 || duration > 600);

        do{
            System.out.printf("Input new treatment's price: Rp. ");
            price= input.nextInt();
            treatments.get(up-1).setPrice(price);
        }while(price<0);

        sort();

        input.nextLine();
        System.out.println("Treatment's detail updated!");
        System.out.printf("Press enter to continue...");
        input.nextLine();
    }

    public static void removeTreatment()
    {
        viewTreatment();
        System.out.printf("Input which treatments to remove[1 - %d]: ",(treatments.size()));
        int del = input.nextInt();
        input.nextLine();
        System.out.printf("Are you sure to remove the treatment? [Yes | No]: ");
        String ans = input.nextLine();
        if(ans.equals("Yes"))
        {
            treatments.remove(del - 1);
            System.out.println("The treatment removed");
            System.out.printf("Press enter to continue...");
            input.nextLine();
        }
        else {
            System.out.println("Remove treatment canceled");
            System.out.printf("Press enter to continue...");
            input.nextLine();
            return;
        }
    }
}