package Salon;

import java.util.ArrayList;
import java.util.Scanner;

public class StaffData {

    static ArrayList<StaffData> StaffDatas = new ArrayList<>();
    private String IdStaff;
    private String NameStaff;
    private String AddressStaff;
    private String NoHpStaff;
    private int AgeStaff;
    private String GenderStaff;
    static Scanner scan = new Scanner(System.in);


    public String getAddressStaff() {
        return AddressStaff;
    }

    public void setAddressStaff(String address) {
        this.AddressStaff = address;
    }

    public String getNoHpStaff() {
        return NoHpStaff;
    }

    public void setNoHpStaff(String noHp) {
        this.NoHpStaff = noHp;
    }

    public String getIdStaff() {
        return IdStaff;
    }

    public void setIdStaff(String idStaff) {
        this.IdStaff = idStaff;
    }

    public String getNameStaff() {
        return NameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.NameStaff = nameStaff;
    }

    public int  getAgeStaff() {
        return AgeStaff;
    }

    public void setAgeStaff(int ageStaff) {
        AgeStaff = ageStaff;
    }

    public String getGenderStaff() {
        return GenderStaff;
    }

    public void setGenderStaff(String genderStaff) {
        GenderStaff = genderStaff;
    }

    public static void menuStaff(){
        int n;
        System.out.println("Chill Salon");
        System.out.println("Staff Menu:");
        System.out.println("-----------------");
        System.out.println("1. Add New Staff");
        System.out.println("2. View Staff's Data");
        System.out.println("3. Update Staff Data");
        System.out.println("4. Remove Staff Data");
        System.out.println("5. Back to main menu");
        System.out.print("Choose : ");
        n = scan.nextInt();
        scan.nextLine();
        do
        {
            switch (n)
            {
                case 1:
                    AddStaff();
                    break;
                case 2:
                    ViewStaff();
                    break;
                case 3:
                    UpdateStaff();
                    break;
                case 4:
                    RemoveStaff();
                    break;
                case 5:
                    return;
            }
        } while(n < 1 || n > 5);
        menuStaff();
    }

    public static void main(String[] args)
    {
        menuStaff();
    }


    public static void AddStaff()
    {
        StaffDatas.add(new StaffData());
        String TempIdStaff = "ST"+(long)(Math.random()*50000L);
        String TempNameStaff;
        do
        {
            System.out.print("Masukkan nama staff [4 - 20 Letters]: ");
            TempNameStaff = scan.nextLine();
        }
        while(TempNameStaff.length()<4 || TempNameStaff.length() > 20);
        String TempHpStaff;
        do
        {
            System.out.print("Masukkan No. Hp [10 - 13 Letters]: ");
            TempHpStaff = scan.nextLine();
        }
        while(TempHpStaff.length()<10 || TempHpStaff.length()>13);
        String TempAddressStaff;
        do
        {
            System.out.print("Masukkan Alamat [5 - 20 letters]: ");
            TempAddressStaff = scan.nextLine();
        }
        while(TempAddressStaff.length()<5||TempAddressStaff.length()>20);
        String TempGenderStaff;
        do
        {
            System.out.print("Masukkan Gender [F for Female or M for Male]: ");
            TempGenderStaff = scan.nextLine();
        }
        while(!TempGenderStaff.equals("F") && !TempGenderStaff.equals("M"));
        int TempAgeStaff;

        do
        {
            System.out.print("Masukkan Umur: ");
            TempAgeStaff = scan.nextInt();
        }
        while(TempAgeStaff < 17);

        StaffDatas.get(StaffDatas.size()-1).setNameStaff(TempNameStaff);
        StaffDatas.get(StaffDatas.size()-1).setIdStaff(TempIdStaff);
        StaffDatas.get(StaffDatas.size()-1).setAddressStaff(TempAddressStaff);
        StaffDatas.get(StaffDatas.size()-1).setNoHpStaff(TempHpStaff);
        StaffDatas.get(StaffDatas.size()-1).setGenderStaff(TempGenderStaff);
        StaffDatas.get(StaffDatas.size()-1).setAgeStaff(TempAgeStaff);
        System.out.println("Successfully Added!");
        scan.nextLine();
        return;
    }

    public static void ViewStaff()
    {
        if (StaffDatas.size()==0)
        {
            System.out.println("No Staff Here!");
        }
        else
        {
            System.out.println("======================================================================================================");
            System.out.printf("%-5s %-20s %-10s %-20s %-15s %-5s %-7s\n", "No.", "Name", "ID", "Address", "No.Hp", "Age", "Gender");
            System.out.println("======================================================================================================");
            for(int i = 0; i < StaffDatas.size();i++)
            {
                System.out.printf("%-5d %-20s %-10s %-20s %-15s %-5s %-7s\n", i+1, StaffDatas.get(i).getNameStaff(), StaffDatas.get(i).getIdStaff(), StaffDatas.get(i).getAddressStaff(), StaffDatas.get(i).getNoHpStaff(), StaffDatas.get(i).getAgeStaff(), StaffDatas.get(i).getGenderStaff());
            }
            System.out.print("======================================================================================================");
            scan.nextLine();
        }
        return;
    }

    public static void UpdateStaff()
    {

        if(StaffDatas.size()==0)
        {
            System.out.println("No Staff Here!");
            scan.nextLine();
            menuStaff();
        }
        else
        {
            System.out.println("======================================================================================================");
            System.out.printf("%-5s %-20s %-10s %-20s %-15s %-5s %-7s\n", "No.", "Name", "ID", "Address", "No.Hp", "Age", "Gender");
            System.out.println("======================================================================================================");
            for(int i = 0; i < StaffDatas.size();i++)
            {
                System.out.printf("%-5d %-20s %-10s %-20s %-15s %-5s %-7s\n", i+1, StaffDatas.get(i).getNameStaff(), StaffDatas.get(i).getIdStaff(), StaffDatas.get(i).getAddressStaff(), StaffDatas.get(i).getNoHpStaff(), StaffDatas.get(i).getAgeStaff(), StaffDatas.get(i).getGenderStaff());
            }
            System.out.print("======================================================================================================");
            int U;
            do
            {
                System.out.printf("Input which data to update[1 - %d]: ", StaffDatas.size());
                U = scan.nextInt();
                scan.nextLine();
            }
            while(U > StaffDatas.size()|| U < 1);
            String TempNameStaff;
            do
            {
                System.out.print("Update nama staff [More than 4 - 20]: ");
                TempNameStaff = scan.nextLine();
            }
            while(TempNameStaff.length()<4 || TempNameStaff.length() > 20);
            String TempHpStaff;
            do
            {
                System.out.print("Update No. Hp [More than 12 Digit]: ");
                TempHpStaff = scan.nextLine();
            }
            while(TempHpStaff.length()<12);
            String TempAddressStaff;
            do
            {
                System.out.print("Update Alamat: [5 - 20 letters]: ");
                TempAddressStaff = scan.nextLine();
            }
            while(TempAddressStaff.length()<5||TempAddressStaff.length()>20);
            System.out.println("Successfully Updated!");
            scan.nextLine();
            StaffDatas.get(U-1).setNameStaff(TempNameStaff);
            StaffDatas.get(U-1).setAddressStaff(TempAddressStaff);
            StaffDatas.get(U-1).setNoHpStaff(TempHpStaff);
        }
        return;
    }

    public static void RemoveStaff()
    {

        if(StaffDatas.size()==0)
        {
            System.out.println("No Staff Here!");
            scan.nextLine();
            menuStaff();
        }
        else
        {
            System.out.println("======================================================================================================");
            System.out.printf("%-5s %-20s %-10s %-20s %-15s %-5s %-7s\n", "No.", "Name", "ID", "Address", "No.Hp", "Age", "Gender");
            System.out.println("======================================================================================================");
            for(int i = 0; i < StaffDatas.size();i++)
            {
                System.out.printf("%-5d %-20s %-10s %-20s %-15s %-5s %-7s\n", i+1, StaffDatas.get(i).getNameStaff(), StaffDatas.get(i).getIdStaff(), StaffDatas.get(i).getAddressStaff(), StaffDatas.get(i).getNoHpStaff(), StaffDatas.get(i).getAgeStaff(), StaffDatas.get(i).getGenderStaff());
            }
            System.out.print("======================================================================================================");
            int R;
            do
            {
                System.out.printf("Input which data to remove[1 - %d]: ", StaffDatas.size());
                R = scan.nextInt();
                scan.nextLine();
            }
            while(R > StaffDatas.size()|| R < 1);
            StaffDatas.remove(R-1);
            System.out.println("Successfully deleted!");
            scan.nextLine();
        }
        return;
    }
}
