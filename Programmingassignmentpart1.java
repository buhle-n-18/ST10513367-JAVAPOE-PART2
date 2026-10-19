/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.programmingassignmentpart1;
import java.util.Scanner;
/**
 *
 * @author nyath
 */
public class Programmingassignmentpart1 {

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" REGISTRATION AND LOGIN FEATURE");
        System.out.println("=================================");

        // Start the registration section
        System.out.println("\n--- Registration ---");

         // Ask the user to enter their username
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // Ask the user to enter their password
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Ask the user to enter their South African cell phone number
        System.out.print("Enter South African cell phone number: ");
        String cellPhone = scanner.nextLine();

        Login user = new Login(username, password, cellPhone);

        // Display the individual validation messages required by the task.
        if (user.checkUserName()) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
        }

        if (user.checkPasswordComplexity()) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        }

        if (user.checkCellPhoneNumber()) {
            System.out.println("Cell phone number successfully added.");
        } else {
            System.out.println("Cell phone number is incorrectly formatted or does not contain international code.");
        }

        System.out.println("\n" + user.registerUser());

        if (user.checkUserName() && user.checkPasswordComplexity()
                && user.checkCellPhoneNumber()) {

             // Start the login section
            System.out.println("\n--- Login ---");

            System.out.print("Enter username: ");
            String enteredUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String enteredPassword = scanner.nextLine();

            boolean loginSuccessful = user.loginUser(enteredUsername, enteredPassword);

            System.out.println(user.returnLoginStatus(loginSuccessful));
        } else {
            System.out.println("\nRegistration was not successful, so login cannot continue.");
        }

        scanner.close();
    }
}

