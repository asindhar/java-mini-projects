package com.javaProjects.studentDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int schoolYear;
    private static int id = 1000;
    private String studentID;
    private final List<String> courses;
    private static int courseCost = 600; // $ 600
    private int tutionBalance;


    public Student(){
        // prompt user to enter name and year
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Student First Name: ");
        this.firstName = in.nextLine();

        System.out.println("\nEnter Student Last Name: ");
        this.lastName = in.nextLine();

        System.out.println("\nSchool Year codes\n1 for Freshmen\n2 for Sophmore\n3 for Junior\n4 for Senior\nEnter Student School Year: ");
        this.schoolYear = in.nextInt();

        // create student id
        setStudentID();

        // initialize courses array list
        this.courses = new ArrayList<>();

//        System.out.println("Student created: " + this.firstName + " " + this.lastName +
//                            "\nSchool year: " + schoolYear + "\n" +
//                            "Student ID: " + studentID);
    }

    private void setStudentID(){
        // increment id
        id++;

        // school year + id
        this.studentID = Integer.toString(schoolYear) + Integer.toString(id);
    }

    public void enroll(){
        System.out.println("\nAvailable Courses:\nHistory 101\nMathematics 101\nEnglish 101\nComputer Science 101");
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("\nPlease enter courses to enroll (Q to quit):");
            String course = in.nextLine();
            if (!course.equals("Q")) {
                courses.add(course);
                tutionBalance += courseCost;
            } else {
                break;
            }
        }
//        System.out.println("Enrolled courses");
//        for (String course: courses){
//            System.out.println(course);
//        }
//        System.out.println("Tution Due: " + tutionBalance);
    }

    public void viewBalance(){
        System.out.println("Your current tuition balance: " + tutionBalance);
    }

    public void payTuition(){
        viewBalance();
        System.out.println("Enter your payment: ");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tutionBalance -= payment;
        System.out.println("Thank you for payment of $ " + payment);
        viewBalance();
    }

    @Override
    public String toString(){
        StringBuilder courses = new StringBuilder();
        for (String course: this.courses){
            courses.append(course);
            courses.append(", ");
        }
        return "\n{" +
                "\nName: " + firstName + " " + lastName +
                "\nSchool Year: " + schoolYear +
                "\nStudentID: " + studentID +
                "\nCourses enrolled: " + courses.toString() +
                "\nTuition Balance: " + tutionBalance +
                "\n}\n";
    }
}
