package com.bridgelabz.addressbooksystem;

import java.util.Scanner;

public class ContactDetails {

       private String firstName;
       private String lastName;
       private String address;
       private String city;
       private String state;
       private int zip;
       private long phoneNumber;
       private String email;

       public String getFirstName() {
           return firstName;
       }

       public void setFirstName(String firstName) {
           this.firstName = firstName;
       }

       public String getLastName(){
           return lastName;
       }

       public void setLastName(String lastName) {
           this.lastName = lastName;
       }

       public String getAddress(){
           return address;
       }

       public void setAddress(String address) {
           this.address = address;
       }

       public String getCity(){
           return city;
       }

       public void setCity(String city) {
           this.city = city;
       }

       public String getState(){
           return state;
       }

       public void setState(String state) {
           this.state = state;
       }

       public int getzip(){
           return zip;
       }

       public void setZip(int zip) {
           this.zip = zip;
       }

       public long getPhoneNumber() {
           return phoneNumber;
       }

       public void setPhoneNumber(long phoneNumber) {
           this.phoneNumber = phoneNumber;
       }

       public String getEmail() {
           return email;
       }

       public void setEmail(String email) {
           this.email = email;
       }
       Scanner sc = new Scanner(System.in);
       public void createContacts() {
           System.out.print(" Enter First Name : ");
           setFirstName(sc.nextLine());
           System.out.print(" Enter Last Name : ");
           setLastName(sc.nextLine());
           System.out.print(" Enter Address : ");
           setAddress(sc.nextLine());
           System.out.print(" Enter city : ");
           setCity(sc.nextLine());
           System.out.print(" Enter State : ");
           setState(sc.nextLine());
           System.out.print(" Enter Zip Code : ");
           setZip(sc.nextInt());
           System.out.print(" Enter Phone Number : ");
           setPhoneNumber(sc.nextLong());
           System.out.print(" Enter Email : ");
           setEmail(sc.nextLine());
       }
   }