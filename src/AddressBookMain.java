import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {


    public static void main(String[] args) {
        AddressbookMethods adm =  new AddressbookMethods();
        adm.addressBookManagement(adm.ContactInfo);
        System.out.println("To Add new Address book  enter 1\nTo close system enter 2");
        Scanner sc =  new Scanner(System.in);
        int check = sc.nextInt();
        if (check == 1){
            ArrayList<AddressBook> AddressBook2 = new ArrayList<>();
            adm.addressBookManagement(AddressBook2);
        }
            System.out.println("Address book system closed");
    }
}
