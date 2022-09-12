package com.bridgelabz.addressbooksystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    ArrayList<Contact> contactList = new ArrayList<>();
    Map<String,Contact> cityContactList = new HashMap<>();
    Map<String,Contact> stateContactList  = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

    void addContact() {
        System.out.println("Enter first name: ");
        String firstName = scanner.next();
        for(Contact contacts : contactList){
            if(contacts.getFirstName().equals(firstName)){
                System.out.println("contact already exists");
                return;
            }
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
        contact.setZip(scanner.nextInt());
        System.out.println("Enter phone number: ");
        contact.setPhoneNumber(scanner.nextLong());
        System.out.println("Enter email: ");
        contact.setEmail(scanner.next());

        contactList.add(contact);
    }

    public void showDetails() {
        for(Contact contact : this.contactList){
            System.out.println(contact.toString());
        }
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
                contact.setZip(scanner.nextInt());

                System.out.println("Edit phone number:");
                contact.setPhoneNumber(scanner.nextInt());

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

    void searchContact(){
        if(contactList.isEmpty()){
            System.out.println("No contact to search in addressbook");
            return;
        }
        boolean exit = false;
        while (!exit){
            System.out.println("""
                Enter option
                1) To search by City
                2) To search by State
                3) To exit
                """);
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    System.out.println("Enter the city to search contact");
                    String city = scanner.next();
                    for(Contact contacts : contactList){
                        if(contacts.getCity().contains(city)){
                            System.out.println(contacts);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter the city to search contact");
                    String state = scanner.next();
                    for (Contact contacts : contactList){
                        if(contacts.getState().contains(state)){
                            System.out.println(contacts);
                        }
                    }
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }

    void viewContact(){
        System.out.println("\n1)View by City \\n2.View by State");
        switch (scanner.nextInt()) {
            case 1:
                viewContactByCity();
                break;
            case 2:
                viewContactByState();
                break;
            default:
                viewContact();
                break;
        }
    }

    void viewContactByCity(){
        System.out.println("Enter City:");
        String city = scanner.next();
        for (String key : cityContactList.keySet()) {
            if (key.equals(city)){
                System.out.println(cityContactList.get(city));
            }
        }
    }

    void viewContactByState(){
        System.out.println("Enter State:");
        String state = scanner.next();
        for (String key : stateContactList.keySet()) {
            if (key.equalsIgnoreCase(state)){
                System.out.println(stateContactList.get(state));
            }
        }
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "contactList=" + contactList +
                '}';
    }
}