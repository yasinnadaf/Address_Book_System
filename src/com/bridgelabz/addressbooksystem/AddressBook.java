package com.bridgelabz.addressbooksystem;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    ArrayList<Contact> arrayList = new ArrayList<>();
    Contact contact = new Contact();
    Scanner scanner = new Scanner(System.in);

    void addContact(){
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

        arrayList.add(contact);
    }
}
