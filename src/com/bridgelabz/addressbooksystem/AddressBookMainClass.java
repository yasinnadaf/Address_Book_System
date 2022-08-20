package com.bridgelabz.addressbooksystem;

public class AddressBookMainClass {
    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");
       AddressBook add = new AddressBook();
       add.addContact();
        System.out.println(add.contactList);
        add.editContact();

    }
}
