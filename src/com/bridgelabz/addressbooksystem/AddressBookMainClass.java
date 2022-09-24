package com.bridgelabz.addressbooksystem;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMainClass {
    static final String FAMILY_ADDRESSBOOK = "family address book";
    static final String PROFESSIONAL_ADDRESSBOOK = "Professional address book";
    static HashMap <String,AddressBook> addressBookMap = new HashMap<>();
    public static void main(String[] args) {

        AddressBook familyAddressBook = new AddressBook();
        AddressBook professionalAddressBook = new AddressBook();

        Scanner scr = new Scanner(System.in);
        boolean exit = true;
        do {
            System.out.println("Enter options:\n1) To add contact\n2) To add family contact\n3) To edit Contact\n4) To display Contacts\n5) To delete contact\n6) To search contact\n7) print contact\n8) To exit");
            int option = scr.nextInt();
            switch (option) {
                case 1:
                    professionalAddressBook.addContact();
                    break;
                case 2:
                    familyAddressBook.addContact();
                    break;
                case 3:
                    professionalAddressBook.editContact();
                    break;
                case 4:
                    professionalAddressBook.showDetails();
                    break;
                case 5:
                    professionalAddressBook.deleteContact();
                    break;
                case 6:
                    professionalAddressBook.searchContact();
                    break;
                case 7:
                    professionalAddressBook.printContacts();
                    break;
                case 8:
                    exit = false;
                default:
                    break;
            }
        }while(exit);

        addressBookMap.put(FAMILY_ADDRESSBOOK, familyAddressBook);
        addressBookMap.put(PROFESSIONAL_ADDRESSBOOK, professionalAddressBook);

        System.out.println(addressBookMap.toString());

    }
}
