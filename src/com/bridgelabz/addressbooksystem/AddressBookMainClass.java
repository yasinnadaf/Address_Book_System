package com.bridgelabz.addressbooksystem;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMainClass {
    static final String FAMILY_ADDRESSBOOK = "family address book";
    static final String PROFESSIONAL_ADDRESSBOOK = "Professional address book";
    public static void main(String[] args) {
        HashMap <String,AddressBook> addressBookMap = new HashMap<>();

        AddressBook familyAddressBook = new AddressBook();
        AddressBook professionalAddressBook = new AddressBook();

        Scanner scr = new Scanner(System.in);
        boolean exit = true;
        do {
            System.out.println("Enter options:\n1) To add contact\n2) To edit Contact\n3) To display Contacts\n4) To delete contact\n5) To exit");
            int option = scr.nextInt();
            switch (option) {
                case 1:
                    professionalAddressBook.addContact();
                    break;
                case 2:
                    professionalAddressBook.editContact();
                    break;
                case 3:
                    professionalAddressBook.showDetails(professionalAddressBook.contactList);
                    break;
                case 4:
                    professionalAddressBook.deleteContact();
                    break;
                case 5:
                    exit = false;
                default:
                    break;
            }
        }while(exit);

        addressBookMap.put(FAMILY_ADDRESSBOOK, familyAddressBook);
        addressBookMap.put(PROFESSIONAL_ADDRESSBOOK, professionalAddressBook);

    }
}
