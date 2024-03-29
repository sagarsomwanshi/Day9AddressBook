import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMethods {


    HashMap<String, ArrayList> multipleAddressBook = new HashMap<>();


    public ArrayList<AddressBook> addContact() {

        Scanner sc = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);
        ArrayList<AddressBook> addContactTemp = new ArrayList<>();
        String lastName = null, email = null, address = null, city = null, state = null;
        int zip = 0;
        long phone = 0;
        System.out.println("Enter how many contacts you want to add");
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {


            System.out.println("Enter First Name ");
            String name = sc.next();
            boolean update = addContactTemp.stream().anyMatch(x -> x.getName().equalsIgnoreCase(name));
            if (update) {
                System.out.println("Already Exists");
                addContact();
            } else {

                System.out.println("Enter Last Name");
                lastName = sc.next();

                System.out.println("Enter Address ");
                address = scn.nextLine();

                System.out.println("Enter City Name");
                city = sc.next();

                System.out.println("Enter State Name");
                state = sc.next();

                System.out.println("Enter Email Id");
                email = sc.next();

                System.out.println("Enter ZIP code");
                zip = sc.nextInt();

                System.out.println("Enter Phone Number");
                phone = sc.nextLong();
            }


            AddressBook contact = new AddressBook(name, lastName, address, city, state, email, zip, phone);
            addContactTemp.add(contact);
        }
        return addContactTemp;

    }

    public void edit(String addressBookName) {
        Scanner sc = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);

        ArrayList<AddressBook> editTemp = multipleAddressBook.get(addressBookName);
        System.out.println("Enter name of Contact to edit");
        String inputName = sc.next();

        for (int i = 0; i < editTemp.size(); i++) {
            String nameCheck = editTemp.get(i).getName();
            if (nameCheck.equalsIgnoreCase(inputName)) {
                System.out.println("To edit details you have to Enter number associated with Attribute");
                System.out.println(" Name - 1\n Last Name - 2\n Address - 3\n City - 4\n State - 5\n Email - 6\n Zip - 7\n Phone - 8");
                int num = sc.nextInt();
                switch (num) {
                    case 1:
                        System.out.println("Enter new Name");
                        editTemp.get(i).setName(sc.next());
                        break;
                    case 2:
                        System.out.println("Enter new Last Name");
                        editTemp.get(i).setLastName(sc.next());
                        break;
                    case 3:
                        System.out.println("Enter new Address");
                        editTemp.get(i).setAddress(scn.nextLine());
                        break;
                    case 4:
                        System.out.println("Enter new City");
                        editTemp.get(i).setCity(sc.next());
                        break;
                    case 5:
                        System.out.println("Enter new State");
                        editTemp.get(i).setState(sc.next());
                        break;
                    case 6:
                        System.out.println("Enter new Email Address");
                        editTemp.get(i).setEmail(sc.next());
                        break;
                    case 7:
                        System.out.println("Enter new Zip code");
                        editTemp.get(i).setZip(sc.nextInt());
                        break;
                    case 8:
                        System.out.println("Enter new Phone Number");
                        editTemp.get(i).setPhone(sc.nextLong());
                        break;
                    default:
                        System.out.println("Invalid Input");
                        edit(addressBookName);
                }
                System.out.println("Updated Address book : " + editTemp);
                break;
            } else {
                System.out.println("Name Not found in address book");
            }

        }
        multipleAddressBook.put(addressBookName, editTemp);

    }

    public void remove(String addressBookName) {

        ArrayList<AddressBook> removeTemp = new ArrayList<>();
        removeTemp = multipleAddressBook.get(addressBookName);
        System.out.println("Enter Name of contact to be deleted from address book");
        Scanner sc = new Scanner(System.in);
        String inputName = sc.next();
        for (int i = 0; i < removeTemp.size(); i++) {
            String nameCheck = removeTemp.get(i).getName();
            if (nameCheck.equals(inputName)) {
                removeTemp.remove(i);
                System.out.println(inputName + " Contact deleted");
            } else {
                System.out.println("Contact Name not found Please enter valid name");
                remove(addressBookName);
            }
        }

        System.out.println(removeTemp);
        multipleAddressBook.put(addressBookName, removeTemp);

    }

    public void contactManagement(String addressBookName) throws IOException {


        Scanner sc = new Scanner(System.in);

        System.out.println("\n\nTo edit contact press 1\nTo delete contact from address book press 2\nTo close this Address book Enter 3");
        int check = sc.nextInt();
        switch (check) {
            case 1:
                edit(addressBookName);
                contactManagement(addressBookName);
                break;
            case 2:
                remove(addressBookName);
                contactManagement(addressBookName);
                break;
            case 3:
                System.out.println("This Address book closed");
                addressBookManagement();
                break;
            default:
                System.out.println("Invalid Input");
                contactManagement(addressBookName);

        }
    }

    public void multipleAddressBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Address book name");
        String addressBookName = sc.nextLine();
        if (multipleAddressBook.containsKey(addressBookName)) {
            System.out.println("Address Book already exist please Enter new Name");
            multipleAddressBook();
        } else {
            multipleAddressBook.put(addressBookName, addContact());
        }
    }

    public void addressBookManagement() throws IOException {
        System.out.println("\n\nTo create new Address Book press 1\nTo Edit Existing Address book press 2\nTo view Address book press 3\nTo search any contact press 4\nTo count contact press 5\nTo Sort Address Book press 6\nTo sort by zip press 7\nTo save to file press 8\nTo read file press 9\nTo close system press 10");
        Scanner sc = new Scanner(System.in);
        int optionCheck = sc.nextInt();
        switch (optionCheck) {
            case 1:
                multipleAddressBook();
                addressBookManagement();
                break;
            case 2:
                System.out.println("Enter Address book Name");
                Scanner scn = new Scanner(System.in);
                String addressBookName = scn.nextLine();
                contactManagement(addressBookName);
                addressBookManagement();
                break;
            case 3:
                System.out.println("\nTo print all address book press 1\nTo print specific address book press 2 ");
                Scanner scc = new Scanner(System.in);
                int printOptionCheck = scc.nextInt();
                switch (printOptionCheck) {
                    case 1:
                        System.out.println(multipleAddressBook);
                        break;
                    case 2:
                        System.out.println("Enter Address book Name");
                        String checkName = scc.nextLine();
                        System.out.println(multipleAddressBook.get(checkName));
                    default:
                        System.out.println("Invalid Input");
                }
                addressBookManagement();
                break;
            case 4:
                search();
                addressBookManagement();
            case 5:
                contactCount();
                addressBookManagement();
                break;
            case 6 :
                alphabeticalSort();
                addressBookManagement();
                break;
            case 7:
                zipSort();
                addressBookManagement();
                break;
            case 8 :
                writeToFile();
                addressBookManagement();
            case 9 :
                readFile();
                addressBookManagement();
            default:
                System.out.println("System Closed");
                System.exit(0);
        }
    }

    public void search() {

        System.out.println("1 : Search by city name \n2: Search by state name");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option){
            case 1 :
                System.out.println("Enter city Name");

                String city = sc.next();

                for (String key : multipleAddressBook.keySet()) {
                    ArrayList<AddressBook> temp = multipleAddressBook.get(key);
                    temp.stream().filter(a -> a.getCity().equalsIgnoreCase(city)).forEach(y -> System.out.println("Address book Name : "+key + "\n"+y + "\n"));
                }
                break;
            case 2 :
                System.out.println("Enter State Name");

                String state = sc.next();

                for (String key : multipleAddressBook.keySet()) {
                    ArrayList<AddressBook> temp = multipleAddressBook.get(key);
                    temp.stream().filter(a -> a.getState().equalsIgnoreCase(state)).forEach(y -> System.out.println("Address book Name : "+key + "\n"+y + "\n"));
                }
                break;
        }




    }
    public void contactCount() {

        System.out.println("1 : Total contacts count of city \n2: Total contacts count of  state");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option){
            case 1 :
                System.out.println("Enter city Name");

                String city = sc.next();

                for (String key : multipleAddressBook.keySet()) {
                    ArrayList<AddressBook> temp = multipleAddressBook.get(key);
                    System.out.println(temp.stream().filter(a -> a.getCity().equalsIgnoreCase(city)).count());
                }
                break;
            case 2 :
                System.out.println("Enter State Name");

                String state = sc.next();

                for (String key : multipleAddressBook.keySet()) {
                    ArrayList<AddressBook> temp = multipleAddressBook.get(key);
                    System.out.println(temp.stream().filter(a -> a.getState().equalsIgnoreCase(state)).count());
                }
                break;
        }

    }

    public void alphabeticalSort(){

        for (String key : multipleAddressBook.keySet()) {
            ArrayList<AddressBook> temp = multipleAddressBook.get(key);
            List sortedList = temp.stream().sorted((f, s)-> f.getName().compareTo(s.getName())).collect(Collectors.toList());
            System.out.println("Address book : "+key+"\nAfter Sorting Alphabetically : " +sortedList);
        }
    }
    public void zipSort(){

        for (String key : multipleAddressBook.keySet()) {
            ArrayList<AddressBook> temp = multipleAddressBook.get(key);
            List zipSortedList = temp.stream().sorted((f,s)-> Long.valueOf(f.getZip()).compareTo(Long.valueOf(s.getZip()))).collect(Collectors.toList());
            System.out.println("Address book : "+key+"\nAfter Sorting Alphabetically : " +zipSortedList);
        }
    }
    public void writeToFile() throws IOException {
        BufferedWriter toFile = new BufferedWriter(new FileWriter("C:\\Users\\sagar somwanshi\\IdeaProjects\\Day9AddressBook\\src\\addressbook.txt"));
        for(Map.Entry<String,ArrayList>entry : multipleAddressBook.entrySet()){
            toFile.write(entry.getKey() + ":" +entry.getValue());
        }
        toFile.flush();
        toFile.close();
    }
    public void readFile() throws IOException {
        BufferedReader fromFile = new BufferedReader(new FileReader("C:\\Users\\sagar somwanshi\\IdeaProjects\\Day9AddressBook\\src\\addressbook.txt"));
        String r;
        while(( r= fromFile.readLine()) != null){
            System.out.println(r);
        }
        fromFile.close();
    }
}

