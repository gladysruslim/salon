package Salon;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Customer> customers = new ArrayList<>();
    public String id;
    public String name;
    public String address;
    public String phone;
    public String status;
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

    public Customer(String id, String name, String address, String phone){
        this.setId(id);
        this.setName(name);
        this.address = address;
        this.setPhone(phone);
        this.status = status;
        this.point=point;
    }

    static void cls() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }

    public static void menuCustomer()
    {
        int choose;

        do{
            System.out.println("Chill Salon");
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
                    add();
                    break;

                case 2:
                    viewCust();
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
        if(customers.size() == 0)
        {
            customers.add(new Customer("0001", "Gladys Ruslim", "Menaggio barat 3", "081374512696"));
            customers.add(new Customer("0002", "Athalia Yechiel", "Banjar no 1", "087884616651"));
            customers.add(new Customer("0003", "Marvel Jonathan", "Bekasi raya", "081372595054"));
            customers.add(new Customer("0004", "Delvin Setiamin", "Poris Indah", "08126607314"));
        }
        String id, name, address, phone;
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

        System.out.println("New customer added!");

        customers.add(new Customer(id, name, address, phone));
    }

    public static void viewCust()
    {
        if(customers.size() == 0)
        {
            customers.add(new Customer("0001", "Gladys Ruslim", "Padang", "081374512696"));
            customers.add(new Customer("0002", "Athalia Yechiel", "Banjar no 1", "087884616651"));
            customers.add(new Customer("0003", "Marvel Jonathan", "Bekasi raya", "081372595054"));
            customers.add(new Customer("0004", "Delvin Setiamin", "Poris Indah", "08126607314"));
        }

        System.out.println("Jumlah customer: " + customers.size());
        if (customers.isEmpty()) {
            System.out.println("No data!");
        } else {
            for (int i = 0; i < customers.size(); i++) {
                System.out.println("No. " + (i+1));
                System.out.println("ID: " + customers.get(i).getId());
                System.out.println("Nama: " + customers.get(i).getName());
                System.out.println("Alamat: " + customers.get(i).getAddress());
                System.out.println("Phone: " + customers.get(i).getPhone());
                System.out.println();
            }
        }
    }

    public static void update()
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

        }
    }

    public static void remove()
    {
        if (customers.isEmpty()) {
            System.out.println("No data!");
        } else {
            System.out.printf("Input which data to remove[1 - %d]: ",(customers.size()));
            int del = input.nextInt();
            customers.remove(del-1);

            System.out.println("The customer data removed");

        }
    }



}
