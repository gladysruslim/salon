package Salon;

import java.util.ArrayList;
import java.util.Scanner;

import static Salon.Main.header;
import static Salon.Transactions.jumlahtr;

public class Customer {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Customer> customers = new ArrayList<>();
    private String id, name, address, phone, status;
    public int point;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone.length() < 11 || phone.length() > 13)
        {
            throw new IllegalArgumentException("Harap input nomor telepon yang benar");
        }
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Customer(String id, String name, String address, String phone, String status, int point){
        this.setId(id);
        this.setName(name);
        this.address = address;
        this.setPhone(phone);
        this.setStatus(status);
        this.setPoint(point);
    }

    public static void menuCustomer()
    {
        int choose;

        do{
            header();
            System.out.println("Customer Menu:");
            System.out.println("-----------------");
            System.out.println("1. Add New Customer");
            System.out.println("2. View Customer's Data");
            System.out.println("3. Update Customer Data");
            System.out.println("4. Remove Customer Data");
            System.out.println("5. Back to main menu");
            System.out.print("Choose : ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    addCust();
                    break;

                case 2:
                    viewCust();
                    break;

                case 3:
                    updateCust();
                    break;

                case 4:
                    removeCust();
                    break;

                case 5:
                    return;
            }
        }while(choose!= 5);
    }

    public static void addCust()
    {
        if(customers.size() == 0)
        {
            customers.add(new Customer("0001", "Gladys Ruslim", "Menaggio barat 3", "081374512696", "Silver", 0));
            customers.add(new Customer("0002", "Athalia Yechiel", "Banjar no 1", "087884616651", "Silver", 0));
            customers.add(new Customer("0003", "Marvel Jonathan", "Bekasi raya", "081372595054", "Silver", 0));
            customers.add(new Customer("0004", "Delvin Setiamin", "Poris Indah", "08126607314", "Silver", 0));
        }

        String id, name, address, phone, status;
        int point = 0;
        id = " " + (int) (Math.random() * 4000);
        do {
            System.out.print("Input Customer's name [5..20] : ");
            name= input.nextLine();
        } while ((name.length() < 5 || name.length() > 20));

        do {
            System.out.print("Input Customer's address [5..30] : ");
            address = input.nextLine();
        } while ((address.length() < 5 || address.length() > 30));

        do {
            System.out.print("Input Customer's phone [11..13] : ");
            phone = input.nextLine();
        } while ((phone.length() < 11 || phone.length() > 13));

        status = "Silver";

        customers.add(new Customer(id, name, address, phone, status, point));

        System.out.println("New customer added!");
        System.out.println("Press enter to continue...");
        input.nextLine();
    }

    public static void viewCust()
    {
        if(customers.size() == 0)
        {
            customers.add(new Customer("0001", "Gladys Ruslim", "Menaggio barat 3", "081374512696", "Silver", 0));
            customers.add(new Customer("0002", "Athalia Yechiel", "Banjar no 1", "087884616651", "Silver", 0));
            customers.add(new Customer("0003", "Marvel Jonathan", "Bekasi raya", "081372595054", "Silver", 0));
            customers.add(new Customer("0004", "Delvin Setiamin", "Poris Indah", "08126607314", "Silver", 0));
        }

        if (customers.isEmpty()) {
            System.out.println("No data!");
        } else {
            header();
            System.out.println("Jumlah customer: " + customers.size());
            System.out.println("================================================================================================================");
            System.out.printf("| %s | %-5s | %-25s | %-25s | %-14s | %-10s | %-5s |", "No.", "ID", "Nama Customer", "Alamat", "Telepon", "Status Member", "Point");
            System.out.println();
            System.out.println("===============================================================================================================");
            for (int i = 0; i < customers.size(); i++) {
                System.out.printf("| %-2d. | %-5s | %-25s | %-25s | %-14s | %-13s | %-5d |", (i+1), customers.get(i).getId(), customers.get(i).getName(), customers.get(i).getAddress(), customers.get(i).getPhone(), customers.get(i).getStatus(), customers.get(i).getPoint());
                System.out.println();
            }
            System.out.println("================================================================================================================");
        }
        System.out.println("Press enter to continue...");
        input.nextLine();
    }

    public static void updateCust()
    {
        if (customers.isEmpty()) {
            System.out.println("No data!");
        } else {
            viewCust();
            System.out.printf("Input which data to update[1 - %d]: ",(customers.size()));
            int up = input.nextInt();
            input.nextLine();
            String name, address, phone;

            do {
                System.out.print("Input New Customer's name [5..20] : ");
                name = input.nextLine();
                customers.get(up-1).setName(name);
            } while ((name.length() < 5 || name.length() > 20));

            do {
                System.out.print("Input New Customer's address [5..30] : ");
                address = input.nextLine();
                customers.get(up-1).setAddress(address);
            } while ((address.length() < 5 || address.length() > 30));

            do {
                System.out.print("Input New Customer's phone [11..13] : ");
                phone = input.nextLine();
                customers.get(up-1).setPhone(phone);
            } while ((phone.length() < 11 || phone.length() > 13));

            System.out.println("The customer data updated");
            System.out.println("Press enter to continue...");
            input.nextLine();

        }
    }

    public static void removeCust()
    {
        if (customers.isEmpty()) {
            System.out.println("No data!");
        } else {
            viewCust();
            System.out.printf("Input which data to remove[1 - %d]: ",(customers.size()));
            int del = input.nextInt();
            customers.remove(del-1);

            System.out.println("The customer data removed");
            System.out.println("Press enter to continue...");
            input.nextLine();
        }
    }

    public static int custPoint()
    {
        int point = 0;

        if(jumlahtr < 3)
        {
            point+=10;
        }
        else{
            point+=20;
        }
        return point;
    }
}
