package com.bridgelabz.addressbooksystem;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
    ArrayList<Contact> contactList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    void addContact() {
        System.out.println("Enter the first name");
        String firstName = scanner.next().toLowerCase();
        if (contactList.stream().anyMatch(x -> x.getFirstName().toLowerCase().equals(firstName))) {
            System.out.println("Contact already exist");
            return;
        }
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        System.out.println("Enter last name: ");
        contact.setLastName(scanner.next());
        System.out.println("Enter the address: ");
        contact.setAddress(scanner.next());
        System.out.println("Enter the city: ");
        contact.setCity(scanner.next());
        System.out.println("Enter the state: ");
        contact.setState(scanner.next());
        System.out.println("Enter the zip code: ");
        contact.setZip(scanner.next());
        System.out.println("Enter phone number: ");
        contact.setPhoneNumber(scanner.next());
        System.out.println("Enter email: ");
        contact.setEmail(scanner.next());
        contactList.sort(Comparator.comparing(Contact::getFirstName));
        contactList.add(contact);
    }

    void writeAddressBook(ArrayList<Contact> arrayList,String addressBookName) throws IOException {
        System.out.println("Enter\n 1) To write to txt file\n 2) To write to CSV file\n3) To write to json file");
        int option = scanner.nextInt();
        switch (option){
            case 1:
                FileReaderWriter.writeTxt(arrayList, addressBookName);
                break;
            case 2:
                FileReaderWriter.writeCSV(arrayList, addressBookName);
                break;
            case 3:
                FileReaderWriter.writeJson(arrayList, addressBookName);
                break;
        }

    }

    void readAddressBook(String addressBookName) throws IOException {
        System.out.println("Select option \n1.read from text file \n2.read from csv file\n3) read from json");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                FileReaderWriter.readTxtFile(new File(FileReaderWriter.PATH.concat(addressBookName+".txt")));
                break;
            case 2:
                FileReaderWriter.readCSVFile(new File(FileReaderWriter.PATH.concat( addressBookName +".csv")));
                break;
            case 3:
                FileReaderWriter.readCSVJsonFile(new File(FileReaderWriter.PATH.concat( addressBookName +".json")));
                break;
        }
    }


    public void showDetails() {
        if(contactList.isEmpty()){
            System.out.println("No contacts to search in the addressBook");
            return;
        }
        contactList.sort(Comparator.comparing(Contact::getFirstName));
        contactList.forEach(System.out::println);
    }

    void editContact() {

        System.out.println("enter the first name of a person to edit");
        String firstName = scanner.next();
        for (Contact contact : contactList) {
            if (firstName.equals(contact.getFirstName())) {
                System.out.println("Edit the details of person: ");

                System.out.println("Edit first name: ");
                contact.setFirstName(scanner.next());

                System.out.println("Edit last name: ");
                contact.setLastName(scanner.next());

                System.out.println("Edit address: ");
                contact.setAddress(scanner.next());

                System.out.println("Edit city: ");
                contact.setCity(scanner.next());

                System.out.println("Edit state: ");
                contact.setState(scanner.next());

                System.out.println("Edit zip code: ");
                contact.setZip(scanner.next());

                System.out.println("Edit phone number:");
                contact.setPhoneNumber(scanner.next());

                System.out.println("Edit email: ");
                contact.setEmail(scanner.next());
            } else {
                System.out.println("person not found");
            }
        }

    }

    void deleteContact() {
        System.out.println("Enter the first name of contact you want to delete");
        String firstName = scanner.next();
        for (Contact contact : contactList) {
            if (firstName.equals(contact.getFirstName())) {
                contactList.remove(contact);
                System.out.println("contact deleted successfully");
            } else {
                System.out.println("contact not found");
            }
        }
    }

    void viewContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts to display");
            return;
        }
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    Enter option
                    1) To view by City
                    2) To view by State
                    3) To exit
                    """);
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter the city name to view");
                    String city = scanner.next().toLowerCase();
                    Map<String, List<Contact>> cityDictionary = new HashMap<>();
                    for (AddressBook addressBooks : AddressBookMainClass.addressBookMap.values()) {
                        List<Contact> contactsCityList = addressBooks.contactList.stream().filter(x -> x.getCity().toLowerCase().equals(city)).collect(Collectors.toList());
                        if (cityDictionary.containsKey(city)) {
                            cityDictionary.get(city).addAll(contactsCityList);
                        } else
                            cityDictionary.put(city, contactsCityList);
                    }

                    System.out.println("No of contacts in city " + city + " are " + cityDictionary.size());
                    System.out.println("Contacts in city " + city + " are:");
                    cityDictionary.values().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Enter the state name to view");
                    String state = scanner.next().toLowerCase();
                    Map<String, List<Contact>> stateDictionary = new HashMap<>();
                    for (AddressBook addressBooks : AddressBookMainClass.addressBookMap.values()) {
                        List<Contact> contactsStateList = addressBooks.contactList.stream().filter(x -> x.getState().toLowerCase().equals(state)).collect(Collectors.toList());
                        if (stateDictionary.containsKey(state)) {

                            stateDictionary.get(state).addAll(contactsStateList);
                        } else
                            stateDictionary.put(state, contactsStateList);
                    }

                    System.out.println("No of contacts in state " + state + " are " + stateDictionary.size());
                    System.out.println("Contacts in state " + state + " are:");
                    System.out.println(stateDictionary.values());
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    break;

            }
        }
    }

    void sortByCity(){
        if (contactList.isEmpty()) {
            System.out.println("No contacts in the addressBook");
            return;
        }
        contactList.sort(Comparator.comparing(Contact::getCity));
        contactList.forEach(System.out::println);
    }

    void sortByState(){
        if (contactList.isEmpty()) {
            System.out.println("No contacts in the addressBook");
            return;
        }
        contactList.sort(Comparator.comparing(Contact::getState));
        contactList.forEach(System.out::println);
    }

    void sortByZipCode(){
        if (contactList.isEmpty()) {
            System.out.println("No contacts in the addressBook");
            return;
        }
        contactList.sort(Comparator.comparing(Contact::getzip));
        contactList.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return  contactList +
                "}\n";
    }
}