package com.bridgelabz.addressbooksystem;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    ArrayList<Contact> contactList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    void addContact() {
        Contact contact = new Contact();
        System.out.println("Enter first name: ");
        contact.setFirstName(scanner.next());
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

    public void showDetails(ArrayList<Contact> contactList) {
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

    @Override
    public String toString() {
        return "AddressBook{" +
                "contactList=" + contactList +
                '}';
    }
}