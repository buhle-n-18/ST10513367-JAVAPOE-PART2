/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programmingassignmentpart1;

/**
 *
 * @author nyath
 */
public class Login {
    
    //Declarations
    private String username;
    private String password;
    private String cellPhone;

    public Login(String username, String password, String cellPhone) {
        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;
    }

    // Checks if the username contains an underscore and is 5 characters or less
    public boolean checkUserName() {
        return username != null
                && username.contains("_")
                && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);

            if (Character.isUpperCase(character)) {
                hasCapital = true;
            }

            if (Character.isDigit(character)) {
                hasNumber = true;
            }

            if (!Character.isLetterOrDigit(character)) {
                hasSpecial = true;
            }
        }

          // Return true only if all three requirements have been met
        return hasCapital && hasNumber && hasSpecial;
    }

    public boolean checkCellPhoneNumber() {
        // South African international format: +27 followed by exactly 9 digits.
        /*
 * Regular expression validation based on Java's regular expression
 * documentation.
 *
 * Oracle. 2026. Java SE 21 API Documentation:
 * java.util.regex package and String.matches().
 * Available at: https://docs.oracle.com/en/java/javase/21/docs/api/
 */
        String regex = "^\\+27[0-9]{9}$";
        return cellPhone != null && cellPhone.matches(regex);
    }

    public String registerUser() {
        
        // Check if the username is valid
        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        // Check if the password is valid
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

         // Check if the cellphone number is valid
        if (!checkCellPhoneNumber()) {
            return "Cell phone number is incorrectly formatted or does not contain international code.";
        }

        return "User registered successfully.";
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername != null
                && enteredPassword != null
                && enteredUsername.equals(username)
                && enteredPassword.equals(password);
    }

    public String returnLoginStatus() {
        if (loginUser(username, password)) {
            return "Welcome user, it is great to see you again.";
        }

        return "Username or password incorrect, please try again.";
    }

    // Overload used when the login result has already been checked.
    public String returnLoginStatus(boolean loginSuccessful) {
        if (loginSuccessful) {
            return "Welcome user, it is great to see you again.";
        }

        return "Username or password incorrect, please try again.";
    }
}

