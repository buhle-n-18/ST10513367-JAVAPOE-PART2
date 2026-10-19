/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.programmingassignmentpart1;


import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void testValidUsername() {

        Login login = new Login(
                "kyl_1",
                "Ch&!!sec@ke99!",
                "+27838968976"
        );

        assertTrue(login.checkUserName());
    }

    @Test
    public void testInvalidUsername() {

        Login login = new Login(
                "kyle!!!!!!!",
                "Ch&!!sec@ke99!",
                "+27838968976"
        );

        assertFalse(login.checkUserName());
    }

    @Test
    public void testValidPassword() {

        Login login = new Login(
                "kyl_1",
                "Ch&!!sec@ke99!",
                "+27838968976"
        );

        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testInvalidPassword() {

        Login login = new Login(
                "kyl_1",
                "password",
                "+27838968976"
        );

        assertFalse(login.checkPasswordComplexity());
    }

    @Test
    public void testValidCellPhoneNumber() {

        Login login = new Login(
                "kyl_1",
                "Ch&!!sec@ke99!",
                "+27838968976"
        );

        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    public void testInvalidCellPhoneNumber() {

        Login login = new Login(
                "kyl_1",
                "Ch&!!sec@ke99!",
                "08966553"
        );

        assertFalse(login.checkCellPhoneNumber());
    }

    @Test
    public void testSuccessfulLogin() {

        Login login = new Login(
                "kyl_1",
                "Ch&!!sec@ke99!",
                "+27838968976"
        );

        boolean result = login.loginUser(
                "kyl_1",
                "Ch&!!sec@ke99!"
        );

        assertTrue(result);
    }

    @Test
    public void testUnsuccessfulLogin() {

        Login login = new Login(
                "kyl_1",
                "Ch&!!sec@ke99!",
                "+27838968976"
        );

        boolean result = login.loginUser(
                "kyl_1",
                "wrongpassword"
        );

        assertFalse(result);
    }

    @Test
    public void testSuccessfulRegistration() {

        Login login = new Login(
                "kyl_1",
                "Ch&!!sec@ke99!",
                "+27838968976"
        );

        assertEquals(
                "User registered successfully.",
                login.registerUser()
        );
    }
}