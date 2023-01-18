
public class Salon {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Gladys", "081374512696");
        Customer customer2 = new Customer("Athalia", "081383920322");
        customer1.show();
        customer2.show();
    }
}

class Customer
{
    private String id;
    private String name;
    private String phone;
    private int point;
    private String status;
    int TotalTreatment;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        if (phone.length() < 12 || phone.length() > 13)
        {
            throw new IllegalArgumentException("Harap input nomor telepon yang benar");
        }
        this.phone = phone;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer(String name, String phone)
    {
        id = " " + (int) (Math.random() * 4000);
        this.setName(name);
        this.setPhone(phone);
    }

    void show(){
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("belajarrr");

    }



}

//class transactions {
//    public void doTransactions()
//    {
//        int TotalTreatment;
//        Customer customer1 = new Customer();
//
//        if(TotalTreatment == 1)
//        {
//            customer1.setPoint()+=10;
//        }
//        System.out.println("testt");
//        System.out.println("halo");
//        System.out.println("iniiii");
//
//    }
//}