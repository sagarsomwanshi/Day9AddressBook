import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
    ArrayList<AddressBook> ContactInfo = new ArrayList<>();
    public void addContact(){
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter First Name ");
        String name = sc.next();

        System.out.println("Enter Last Name");
        String lastName = sc.next();

        System.out.println("Enter Address ");
        String address = sc.next();

        System.out.println("Enter City Name");
        String city = sc.next();

        System.out.println("Enter State Name");
        String state = sc.next();

        System.out.println("Enter Email Id");
        String email = sc.next();

        System.out.println("Enter ZIP code");
        int zip = sc.nextInt();

        System.out.println("Enter Phone Number");
        long phone = sc.nextLong();

        AddressBook adr = new AddressBook(name,lastName,address,city,state,email,zip,phone);
        ContactInfo.add(adr);


    }
    public static void main(String[] args) {
        AddressBookMain adm =  new AddressBookMain();
        System.out.println("Enter How many contacts you want to add");
        Scanner sc =  new Scanner(System.in);
        int totalContact = sc.nextInt();
        for(int i = 1; i<=totalContact; i++) {
            adm.addContact();
            System.out.println("Enter next contact details");
        }


        System.out.println(adm.ContactInfo);
    }


}
