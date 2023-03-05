import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMethods {


    HashMap<String,ArrayList> multipleAddressBook = new HashMap<>();

    public ArrayList<AddressBook> addContact(){

        Scanner sc = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);
        ArrayList<AddressBook> temp = new ArrayList<>();


        System.out.println("Enter First Name ");
        String name = sc.next();

        System.out.println("Enter Last Name");
        String lastName = sc.next();

        System.out.println("Enter Address ");
        String address = scn.nextLine();

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
        temp.add(adr);
        return temp;


    }

    public void edit(ArrayList<AddressBook> x){
        Scanner sc = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Name of Contact to edit");

        String check = sc.next();

        for(int i = 0; i<x.size(); i++){
            String Check1 = x.get(i).getName();
            if(Check1.equals(check)){
                System.out.println("To edit details you have to Enter number associated with Attribute");
                System.out.println(" Name - 1\n Last Name - 2\n Address - 3\n City - 4\n State - 5\n Email - 6\n Zip - 7\n Phone - 8");
                int num = sc.nextInt();
                switch(num){
                    case 1:
                        System.out.println("Enter new Name");
                        x.get(i).setName(sc.next());
                        break;
                    case 2:
                        System.out.println("Enter new Last Name");
                        x.get(i).setLastName(sc.next());
                        break;
                    case 3:
                        System.out.println("Enter new Address");
                        x.get(i).setAddress(scn.nextLine());
                        break;
                    case 4:
                        System.out.println("Enter new City");
                        x.get(i).setCity(sc.next());
                        break;
                    case 5:
                        System.out.println("Enter new State");
                        x.get(i).setState(sc.next());
                        break;
                    case 6:
                        System.out.println("Enter new Email Address");
                        x.get(i).setEmail(sc.next());
                        break;
                    case 7:
                        System.out.println("Enter new Zip code");
                        x.get(i).setZip(sc.nextInt());
                        break;
                    case 8:
                        System.out.println("Enter new Phone Number");
                        x.get(i).setPhone(sc.nextLong());
                        break;
                    default:
                        System.out.println("Invalid Input");
                        edit(x);
                }
                System.out.println("Updated Address book : "+x);
                break;
            }else{
                System.out.println("Name Not found in address book");
            }

        }

    }

    public void remove(ArrayList<AddressBook> x){
        System.out.println("Enter Name of contact to be deleted from address book");
        Scanner sc = new Scanner(System.in);
        String check = sc.next();
        for(int i = 0; i<x.size(); i++){
            String Check1 = x.get(i).getName();
            if(Check1.equals(check)){
                x.remove(i);
                System.out.println(check+" Contact deleted");
            }else{
                System.out.println("Contact Name not found Please enter valid name");
                remove(x);
            }
        }

        System.out.println(x);
    }
    public void contactManagement(String x){

        ArrayList l = multipleAddressBook.get(x);

        Scanner sc =  new Scanner(System.in);

        System.out.println("\n\nTo Add new contact to Address book press 1\nTo edit contact press 2\nTo delete contact from address book press 3\nTo close this Address book Enter 4");
        int check = sc.nextInt();
        if(check == 1) {
            ArrayList<AddressBook> temp = addContact();
            multipleAddressBook.get(x).add(temp);
            contactManagement(x);
        }else if(check == 2) {
            edit(l);
            contactManagement(x);
        }else if(check == 3) {
            remove(l);
            contactManagement(x);
        }else if(check == 4){
            System.out.println("This Address book closed");
            addressBookManagement();
            } else{
            System.out.println("Invalid Input");
            contactManagement(x);

        }
    }

    public void multipleAddressBook(){
        Scanner sc =  new Scanner(System.in);
        System.out.println("Please Enter Address book name");
        String addressBookName = sc.nextLine();
        multipleAddressBook.put(addressBookName,addContact());
    }
    public void addressBookManagement(){
        System.out.println("To create new Address Book press 1\nTo Edit Existing Address book press 2\nTo view Address book press 3\nTo close system press 4");
        Scanner sc = new Scanner(System.in);
        int check = sc.nextInt();
        if(check == 1){
            multipleAddressBook();
            addressBookManagement();
        } else if (check == 2) {
            System.out.println("Enter Address Book Name");
            Scanner scn = new Scanner(System.in);
            String checkName = scn.nextLine();
            contactManagement(checkName);
            addressBookManagement();
        } else if (check == 3) {
            System.out.println("\nTo print all address book press 1\nTo print specific address book press 2 ");
            Scanner scn = new Scanner(System.in);
            int check2 = scn.nextInt();
            if(check2 == 1) {
                System.out.println(multipleAddressBook);
            } else if (check2 == 2) {
                System.out.println("Enter Address book Name");
                Scanner scnn = new Scanner(System.in);
                String checkName = scnn.nextLine();
                System.out.println(multipleAddressBook.get(checkName));
            }else {
                System.out.println("Invalid Input");
            }
            addressBookManagement();
        }else{
            System.out.println("System Closed");
            System.exit(0);
        }
    }
}

