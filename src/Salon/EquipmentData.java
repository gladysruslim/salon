package Salon;
import java.util.ArrayList;
import java.util.Scanner;

import static Salon.Main.header;

public class EquipmentData {
    static ArrayList<EquipmentData> EquipmentDatas = new ArrayList<>();
    private String EquipmentName;
    private String EquipmentCode;
    private int EquipmentStock;
    static Scanner scan = new Scanner(System.in);
    public String getEquipmentName() {
        return EquipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        EquipmentName = equipmentName;
    }

    public String getEquipmentCode() {
        return EquipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        EquipmentCode = equipmentCode;
    }

    public int getEquipmentStock() {
        return EquipmentStock;
    }

    public void setEquipmentStock(int equipmentStock) {
        EquipmentStock = equipmentStock;
    }


    public static void MenuEquipment()
    {
        int n;
        header();
        System.out.println("Equipment Menu:");
        System.out.println("-----------------");
        System.out.println("1. Add New Equipment");
        System.out.println("2. View Equipment Data");
        System.out.println("3. Update Equipment Data");
        System.out.println("4. Remove Equipment Data");
        System.out.println("5. Back to main menu");
        System.out.print("Choose : ");
        n = scan.nextInt();
        scan.nextLine();
        do
        {
            switch (n)
            {
                case 1:
                    AddEquipment();
                    break;
                case 2:
                    ViewEquipment();
                    break;
                case 3:
                    UpdateEquipment();
                    break;
                case 4:
                    RemoveEquipment();
                    break;
                case 5:
                    return;
            }
        } while(n < 1 || n > 5);
        MenuEquipment();
    }

    public static void AddEquipment()
    {
        EquipmentDatas.add(new EquipmentData());
        String TempEquipmentCode = "EQ" + (long)(Math.random()*50000L);
        String TempEquipmentName;

        do
        {
            System.out.print("Masukkan nama equipment [4 - 20 Letters]: ");
            TempEquipmentName = scan.nextLine();
        }
        while(TempEquipmentName.length()<4 || TempEquipmentName.length()>20);

        int TempEquipmentStock;
        do
        {
            System.out.print("Masukkan jumlah equipment [more than 0]: ");
            TempEquipmentStock = scan.nextInt();
        }
        while(TempEquipmentStock < 1);

        EquipmentDatas.get(EquipmentDatas.size()-1).setEquipmentName(TempEquipmentName);
        EquipmentDatas.get(EquipmentDatas.size()-1).setEquipmentCode(TempEquipmentCode);
        EquipmentDatas.get(EquipmentDatas.size()-1).setEquipmentStock(TempEquipmentStock);

        System.out.println("Successfully Added!");
        scan.nextLine();
        return;
    }

    public static void ViewEquipment()
    {
        if (EquipmentDatas.size()==0)
        {
            System.out.println("No Equipment Here!");
        }
        else
        {
            System.out.println("======================================================================================================");
            System.out.printf("%-5s %-30s %-20s %-20s \n", "No.", "Equipment Name", "Code", "Stock");
            System.out.println("======================================================================================================");
            for(int i = 0; i < EquipmentDatas.size();i++)
            {
                System.out.printf("%-5s %-30s %-20s %-20s \n", i+1, EquipmentDatas.get(i).getEquipmentName(), EquipmentDatas.get(i).getEquipmentCode(), EquipmentDatas.get(i).getEquipmentStock());
            }
            System.out.println("======================================================================================================");
            scan.nextLine();
        }
        return;
    }

    public static void UpdateEquipment()
    {
        if(EquipmentDatas.size()==0)
        {
            System.out.println("No Equipment Here!");
            scan.nextLine();
            MenuEquipment();
        }
        else
        {
            System.out.println("======================================================================================================");
            System.out.printf("%-5s %-30s %-20s %-20s \n", "No.", "Equipment Name", "Code", "Stock");
            System.out.println("======================================================================================================");
            for(int i = 0; i < EquipmentDatas.size();i++)
            {
                System.out.printf("%-5s %-30s %-20s %-20s \n", i+1, EquipmentDatas.get(i).getEquipmentName(), EquipmentDatas.get(i).getEquipmentCode(), EquipmentDatas.get(i).getEquipmentStock());
            }
            System.out.println("======================================================================================================");
            int U;
            do
            {
                System.out.printf("Input which data to update[1 - %d]: ", EquipmentDatas.size());
                U = scan.nextInt();
                scan.nextLine();
            }
            while(U > EquipmentDatas.size()|| U < 1);
            String TempEquipmentName;

            do
            {
                System.out.print("Masukkan nama equipment [4 - 20 Letters]: ");
                TempEquipmentName = scan.nextLine();
            }
            while(TempEquipmentName.length()<4 || TempEquipmentName.length()>20);

            int TempEquipmentStock;
            do
            {
                System.out.print("Masukkan jumlah equipment [more than 0]: ");
                TempEquipmentStock = scan.nextInt();
            }
            while(TempEquipmentStock < 1);
            System.out.println("Successfully Updated!");
            EquipmentDatas.get(U-1).setEquipmentName(TempEquipmentName);
            EquipmentDatas.get(U-1).setEquipmentStock(TempEquipmentStock);
            scan.nextLine();
        }
        return;
    }

    public static void RemoveEquipment()
    {
        if(EquipmentDatas.size()==0)
        {
            System.out.println("No Equipment Here!");
            scan.nextLine();
            MenuEquipment();
        }
        else {
            System.out.println("======================================================================================================");
            System.out.printf("%-5s %-30s %-20s %-20s \n", "No.", "Equipment Name", "Code", "Stock");
            System.out.println("======================================================================================================");
            for (int i = 0; i < EquipmentDatas.size(); i++) {
                System.out.printf("%-5s %-30s %-20s %-20s \n", i + 1, EquipmentDatas.get(i).getEquipmentName(), EquipmentDatas.get(i).getEquipmentCode(), EquipmentDatas.get(i).getEquipmentStock());
            }
            System.out.println("======================================================================================================");
            int R;
            do {
                System.out.printf("Input which data to remove[1 - %d]: ", EquipmentDatas.size());
                R = scan.nextInt();
                scan.nextLine();
            }
            while (R > EquipmentDatas.size() || R < 1);
            EquipmentDatas.remove(R - 1);
            System.out.println("Successfully deleted!");
            scan.nextLine();
        }
        return;
    }
}
