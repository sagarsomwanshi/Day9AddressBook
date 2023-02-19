import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
    ArrayList<AddressBook> ContactInfo = new ArrayList<>();
    public void addContact(){
        Scanner sc = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);


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
        ContactInfo.add(adr);


    }
    public void edit(){
        System.out.println("Enter Name of Contact to edit");
        Scanner sc = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);
        String check = sc.next();

        for(int i = 0; i<ContactInfo.size(); i++){
            String Check1 = ContactInfo.get(i).getName();
           if(Check1.equals(check)){
                System.out.println("To edit details you have to Enter number associated with Attribute");
                System.out.println(" Name - 1\n Last Name - 2\n Address - 3\n City - 4\n State - 5\n Email - 6\n Zip - 7\n Phone - 8");
                int num = sc.nextInt();
                switch(num){
                    case 1:
                        System.out.println("Enter new Name");
                        ContactInfo.get(i).setName(sc.next());
                        break;
                    case 2:
                        System.out.println("Enter new Last Name");
                        ContactInfo.get(i).setLastName(sc.next());
                        break;
                    case 3:
                        System.out.println("Enter new Address");
                        ContactInfo.get(i).setAddress(scn.nextLine());
                        break;
                    case 4:
                        System.out.println("Enter new City");
                        ContactInfo.get(i).setCity(sc.next());
                        break;
                    case 5:
                        System.out.println("Enter new State");
                        ContactInfo.get(i).setState(sc.next());
                        break;
                    case 6:
                        System.out.println("Enter new Email Address");
                        ContactInfo.get(i).setEmail(sc.next());
                        break;
                    case 7:
                        System.out.println("Enter new Zip code");
                        ContactInfo.get(i).setZip(sc.nextInt());
                        break;
                    case 8:
                        System.out.println("Enter new Phone Number");
                        ContactInfo.get(i).setPhone(sc.nextLong());
                        break;
                }
               System.out.println("Updated Address book : "+ContactInfo);
                break;
            }else{
                System.out.println("Name Not found in address book");
            }

        }


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
        System.out.println("To edit address book press 1");
        int check = sc.nextInt();
        if(check == 1) {
            adm.edit();
        }


    }


}
