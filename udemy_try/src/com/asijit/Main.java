package com.asijit;
import java.util.Scanner;

public class Main {

    private static boolean isLoggedIn=false;

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("enter 1 for teacher or 2 for student");
        int userInput = input.nextInt();
        if (userInput == 1) {//teacher
            Teacher teacher = new Teacher();
            System.out.println("enter 1 to register or 2 to login");
            userInput = input.nextInt();
            if (userInput == 1)
            {//register
                boolean response=register(input,teacher);

                if (response) {
                    System.out.println("Registration succesful");
                } else {
                    System.out.println("Registration unsuccesful");
                }

            }
            else
            {//login
                boolean response=login(input,teacher);

                if (response) {
                    System.out.println("login succesful");
                    isLoggedIn=true;

                    System.out.println("how would you like to proceed.\n"+ "1. enter 1 to create a course\n"+"2. Enter anything to logout");
                    userInput=input.nextInt();

                    if(userInput==1)
                    {//course create
                        System.out.println("Enter the name of the course");
                        input.nextLine();
                        String name=input.nextLine();
                        System.out.println("enter the duration");
                        int duration =input.nextInt();
                        System.out.println("enter the subject");
                        input.nextLine();
                        String subject=input.nextLine();

                        response=teacher.createCousre(name,duration,subject);
                        if(response)
                        {
                            System.out.println("Course created successfully");
                        }else
                        {
                            System.out.println("some error occur");
                        }
                    }
                    else
                    {//logged out
                        isLoggedIn=false;
                        System.exit(0);
                    }
                } else {
                    System.out.println("login unsuccesful");
                }


            }
        }
        else {
            Student student = new Student();
            System.out.println("enter 1 to register or 2 to login");
            userInput = input.nextInt();
            if (userInput == 1) {

                boolean response = register(input,student);
                if (response) {
                    System.out.println("Registration succesful");
                } else {
                    System.out.println("Registration unsuccesful");
                }

            }else
            {
                boolean response = login(input,student);
                if (response) {
                    System.out.println("login succesful");
                    System.out.println("how would you like to proceed?\n"+"1. enter 1 to see all the courses\n"+"2. enter 2 to enroll\n"+"enter anything to logout");
                    userInput=input.nextInt();

                    if(userInput==1)
                    {//showcourses
                        String courses=student.viewCourses();
                        System.out.println(courses);
                    }
                } else {
                    System.out.println("login unsuccesful");
                }

            }
        }
    }

    public static boolean register(Scanner input, Teacher teacher)
    {
        System.out.println("Enter the name");
        input.nextLine();
        String name = input.nextLine();
        System.out.println("Enter the email");
        String email = input.nextLine();
        System.out.println("Enter the password");
        String password = input.nextLine();
        boolean response = teacher.register(name, email, password);

        return response;
    }

    public static boolean register(Scanner input, Student student)
    {
        System.out.println("Enter the name");
        input.nextLine();
        String name = input.nextLine();
        System.out.println("Enter the email");
        String email = input.nextLine();
        System.out.println("Enter the password");
        String password = input.nextLine();
        boolean response = student.register(name, email, password);

        return response;
    }


    public static boolean login(Scanner input, Teacher teacher)
    {
        System.out.println("Enter the name");
        input.nextLine();
        String name = input.nextLine();
        System.out.println("Enter the email");
        String email = input.nextLine();
        System.out.println("Enter the password");
        String password = input.nextLine();
        boolean response = teacher.login( email, password);

        return response;
    }

    public static boolean login(Scanner input, Student student)
    {
        System.out.println("Enter the name");
        input.nextLine();
        String name = input.nextLine();
        System.out.println("Enter the email");
        String email = input.nextLine();
        System.out.println("Enter the password");
        String password = input.nextLine();
        boolean response = student.login( email, password);

        return response;
    }

}