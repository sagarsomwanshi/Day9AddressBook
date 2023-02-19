import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {


    public static void main(String[] args) {
        AddressbookMethods adm =  new AddressbookMethods();
        System.out.println("Enter How many contacts you want to add");
        Scanner sc =  new Scanner(System.in);
        int totalContact = sc.nextInt();
        for(int i = 1; i<=totalContact; i++) {
            adm.addContact();
           if(i<totalContact) {
               System.out.println("Enter next contact details");
           }
        }
        System.out.println(adm.ContactInfo);


        System.out.println("\n\nTo edit address book press 1\nTo delete contact from address book press 2\nTo close the address book press 3");
        int check = sc.nextInt();
        if(check == 1) {
            adm.edit();
        } else if (check == 2) {
            adm.remove();
        }else{
            System.out.println("Address book closed");
        }

    }
}
