package Salon;

import java.util.ArrayList;
import java.util.Scanner;
public class SuppliesData {
    static ArrayList<SuppliesData> SuppliesDatas = new ArrayList<>();
    private String SuppliesName;
    private String SuppliesCode;
    private int SuppliesStock;
    static Scanner scan = new Scanner(System.in);
    public String getSuppliesName() {
        return SuppliesName;
    }

    public void setSuppliesName(String SuppliesName) {
        this.SuppliesName = SuppliesName;
    }

    public String getSuppliesCode() {
        return SuppliesCode;
    }

    public void setSuppliesCode(String SuppliesCode) {
        this.SuppliesCode = SuppliesCode;
    }

    public int getSuppliesStock() {
        return SuppliesStock;
    }

    public void setSuppliesStock(int SuppliesStock) {
        this.SuppliesStock = SuppliesStock;
    }


    public static void MenuSupplies()
    {
        int n;
        System.out.println("Chill Salon");
        System.out.println("Supplies Menu:");
        System.out.println("-----------------");
        System.out.println("1. Add New Supplies");
        System.out.println("2. View Supplies Data");
        System.out.println("3. Update Supplies Data");
        System.out.println("4. Remove Supplies Data");
        System.out.println("5. Back to main menu");
        System.out.print("Choose : ");
        n = scan.nextInt();
        scan.nextLine();
        do
        {
            switch (n)
            {
                case 1:
                    AddSupplies();
                    break;
                case 2:
                    ViewSupplies();
                    break;
                case 3:
                    UpdateSupplies();
                    break;
                case 4:
                    RemoveSupplies();
                    break;
                case 5:
                    return;
            }
        } while(n < 1 || n > 5);
        MenuSupplies();
    }


    public static void main(String[] args) {

        MenuSupplies();
    }

    public static void AddSupplies()
    {
        SuppliesDatas.add(new SuppliesData());
        String TempSuppliesCode = "SP" + (long)(Math.random()*50000L);
        String TempSuppliesName;

        do
        {
            System.out.print("Masukkan nama Supplies [4 - 20 Letters]: ");
            TempSuppliesName = scan.nextLine();
        }
        while(TempSuppliesName.length()<4 || TempSuppliesName.length()>20);

        int TempSuppliesStock;
        do
        {
            System.out.print("Masukkan jumlah Supplies [more than 0]: ");
            TempSuppliesStock = scan.nextInt();
        }
        while(TempSuppliesStock < 1);

        SuppliesDatas.get(SuppliesDatas.size()-1).setSuppliesName(TempSuppliesName);
        SuppliesDatas.get(SuppliesDatas.size()-1).setSuppliesCode(TempSuppliesCode);
        SuppliesDatas.get(SuppliesDatas.size()-1).setSuppliesStock(TempSuppliesStock);

        System.out.println("Successfully Added!");
        scan.nextLine();
        return;
    }

    public static void ViewSupplies()
    {
        if (SuppliesDatas.size()==0)
        {
            System.out.println("No Supplies Here!");
        }
        else
        {
            System.out.println("======================================================================================================");
            System.out.printf("%-5s %-30s %-20s %-20s \n", "No.", "Supplies Name", "Code", "Stock");
            System.out.println("======================================================================================================");
            for(int i = 0; i < SuppliesDatas.size();i++)
            {
                System.out.printf("%-5s %-30s %-20s %-20s \n", i+1, SuppliesDatas.get(i).getSuppliesName(), SuppliesDatas.get(i).getSuppliesCode(), SuppliesDatas.get(i).getSuppliesStock());
            }
            System.out.println("======================================================================================================");
            scan.nextLine();
        }
        return;
    }

    public static void UpdateSupplies()
    {
        if(SuppliesDatas.size()==0)
        {
            System.out.println("No Supplies Here!");
            scan.nextLine();
            MenuSupplies();
        }
        else
        {
            System.out.println("======================================================================================================");
            System.out.printf("%-5s %-30s %-20s %-20s \n", "No.", "Supplies Name", "Code", "Stock");
            System.out.println("======================================================================================================");
            for(int i = 0; i < SuppliesDatas.size();i++)
            {
                System.out.printf("%-5s %-30s %-20s %-20s \n", i+1, SuppliesDatas.get(i).getSuppliesName(), SuppliesDatas.get(i).getSuppliesCode(), SuppliesDatas.get(i).getSuppliesStock());
            }
            System.out.println("======================================================================================================");
            int U;
            do
            {
                System.out.printf("Input which data to update[1 - %d]: ", SuppliesDatas.size());
                U = scan.nextInt();
                scan.nextLine();
            }
            while(U > SuppliesDatas.size()|| U < 1);
            String TempSuppliesName;

            do
            {
                System.out.print("Masukkan nama Supplies [4 - 20 Letters]: ");
                TempSuppliesName = scan.nextLine();
            }
            while(TempSuppliesName.length()<4 || TempSuppliesName.length()>20);

            int TempSuppliesStock;
            do
            {
                System.out.print("Masukkan jumlah Supplies [more than 0]: ");
                TempSuppliesStock = scan.nextInt();
            }
            while(TempSuppliesStock < 1);
            System.out.println("Successfully Updated!");
            SuppliesDatas.get(U-1).setSuppliesName(TempSuppliesName);
            SuppliesDatas.get(U-1).setSuppliesStock(TempSuppliesStock);
            scan.nextLine();
        }
        return;
    }

    public static void RemoveSupplies()
    {
        if(SuppliesDatas.size()==0)
        {
            System.out.println("No Supplies Here!");
            scan.nextLine();
            MenuSupplies();
        }
        else {
            System.out.println("======================================================================================================");
            System.out.printf("%-5s %-30s %-20s %-20s \n", "No.", "Supplies Name", "Code", "Stock");
            System.out.println("======================================================================================================");
            for (int i = 0; i < SuppliesDatas.size(); i++) {
                System.out.printf("%-5s %-30s %-20s %-20s \n", i + 1, SuppliesDatas.get(i).getSuppliesName(), SuppliesDatas.get(i).getSuppliesCode(), SuppliesDatas.get(i).getSuppliesStock());
            }
            System.out.println("======================================================================================================");
            int R;
            do {
                System.out.printf("Input which data to remove[1 - %d]: ", SuppliesDatas.size());
                R = scan.nextInt();
                scan.nextLine();
            }
            while (R > SuppliesDatas.size() || R < 1);
            SuppliesDatas.remove(R - 1);
            System.out.println("Successfully deleted!");
            scan.nextLine();
        }
        return;
    }
}
