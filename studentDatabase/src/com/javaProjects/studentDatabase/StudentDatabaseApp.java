package com.javaProjects.studentDatabase;

import java.util.Scanner;

public class StudentDatabaseApp {
    public static void main(String[] args){
        // prompt for no of students
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of strudents to enroll:");
        int noOfStudents = in.nextInt();

        Student[] students = new Student[noOfStudents];

        // loop and create instances of student class
        for (int i=0; i<noOfStudents; i++){
            Student st = new Student();
            st.enroll();
            st.payTuition();
            System.out.println(st);
            students[i] = st;
        }

        for (Student stu:
             students) {
            System.out.println(stu);
        }

    }
}
