package com.bridgelabz.addressbooksystem;

import java.sql.SQLOutput;
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

    void editContact(){

        System.out.println("enter the first name of a person to edit");
        String firstName = scanner.next();
        if(firstName.equals(contact.getFirstName())){
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
        }

        else{
            System.out.println("person not found");
        }


    }
}
