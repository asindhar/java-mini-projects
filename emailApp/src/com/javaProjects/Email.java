package com.javaProjects;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 8;
    private String department;
    private String email;
    private int mailboxCapacity = 1000;
    private String alternateEmail;
    private String emailSuffix = "amanCompany.com";

    // Constructor to initialize firstName and lastName
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("User created: " + this.firstName + " " + this.lastName);

        // Call method to ask department and return department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        // Call method to generate random password and return password
        this.password = setPassword(this.defaultPasswordLength);
        System.out.println("Generated Password: " + this.password);

        // Generate email from collected elements: firstname.lastname@department.company.com
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + emailSuffix;
        //System.out.println("Generated Email: " + this.email);
    }

    // Ask for the department
    private String setDepartment(){
        System.out.println("Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter code: ");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();
        if (deptChoice == 1) { return "sales"; }
        else if (deptChoice == 2) { return  "dev"; }
        else if (deptChoice == 3) { return "acct"; }
        else { return ""; }
    }

    // Generate a random password
    private String setPassword(int passwordLength){
        // char options to choose for password
        String passwordSet = "abcdefghijklmnopqrstuvqxyz123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()";
        char[] password = new char[passwordLength];

        // loop until desired password length and get random char from passwordSet
        for (int i=0; i < passwordLength; i++) {
            int randNum = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(randNum);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    // Change the password
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "Full Name: " + firstName + " " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Email capacity: " + mailboxCapacity + " mb";
    }
}
