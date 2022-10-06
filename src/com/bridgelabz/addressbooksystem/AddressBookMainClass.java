package com.bridgelabz.addressbooksystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMainClass {
    static HashMap <String,AddressBook> addressBookMap = new HashMap<>();
    public static ArrayList<String>  addressBooks = new ArrayList<>();
    static AddressBook addressBook;
    static String addressBookName;
    static String currentAddressBook;
   static Scanner scr = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        boolean exit = false;
        while (!exit) {
            System.out.println("Enter options:\n1) To add contact\n2) To edit Contact\n3) To view contact\n4) To delete contact\n5) To add or select addressbook \n6)To display Contacts\n7) To exit");
            int option = scr.nextInt();
            switch (option) {
                case 1:
                    try {
                        addressBookMap.get(currentAddressBook).addContact();
                    }catch (Exception e){
                        System.out.println("\nNo AddressBook Found\n");
                    }
                    break;
                case 2:
                    try {
                        addressBookMap.get(currentAddressBook).editContact();
                    }catch (Exception e){
                        System.out.println("\nNo AddressBook Found\n");
                    }
                    break;
                case 3:
                    try {
                        addressBookMap.get(currentAddressBook).viewContacts();
                    }catch (Exception e){
                        System.out.println("\nNo AddressBook Found\n");
                    }
                    break;
                case 4:
                    try {
                        addressBookMap.get(currentAddressBook).deleteContact();
                    }catch (Exception e){
                        System.out.println("\nNo AddressBook Found\n");
                    }
                    break;
                case 5:
                    chooseAddressBook();
                    break;
                case 6:
                    try {
                        addressBookMap.get(currentAddressBook).showDetails();
                    }catch (Exception e){
                        System.out.println("\nNo AddressBook Found\n");
                    }
                    break;
                case 7:
                    exit = true;
                default:
                    break;
            }
        }
        System.out.println(addressBooks);
        System.out.println(addressBookMap.toString());
    }

        static void chooseAddressBook() {
            System.out.println("""
        Press 1 to add AddressBook
        Press 2 to select AddressBook""");

            int option = scr.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter address book name");
                    addressBookName = scr.next().toLowerCase();
                    if (addressBookMap.containsKey(addressBookName)) {
                        System.out.println("\nAddress book already exist\n");
                        chooseAddressBook();
                    } else {
                        addressBook = new AddressBook();
                        addressBookMap.put(addressBookName, addressBook);
                        currentAddressBook = addressBookName;
                    }
                    addressBooks.add(addressBookName);
                    break;
                case 2:
                    System.out.println("Enter address book name");
                    addressBookName = scr.next().toLowerCase();
                    if (!addressBookMap.containsKey(addressBookName)) {
                        System.out.println("\nAddressBook not Found\n");
                        chooseAddressBook();
                    } else
                        currentAddressBook = addressBookName;
                    break;
                default:
                    break;
            }
        }

    }

