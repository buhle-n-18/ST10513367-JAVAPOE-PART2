/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.programmingassignmentpart1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nyath
 */
public class MessageTest {

    @Test
    public void testMessageIDIsValid() {
        Message message = new Message(
                1, "+27815780081", "Hello there"
        );

        assertTrue(message.checkMessageID());
        assertEquals(10, message.getMessageID().length());
    }

    @Test
    public void testValidRecipientCell() {
        Message message = new Message(
                1, "+27815780081", "Hello there"
        );

        assertEquals(
                "Cell phone number successfully captured.",
                message.checkRecipientCell()
        );
    }

    @Test
    public void testInvalidRecipientCell() {
        Message message = new Message(
                1, "0815780081", "Hello there"
        );

        assertTrue(
                message.checkRecipientCell().contains("incorrectly formatted")
        );
    }

    @Test
    public void testValidMessage() {
        Message message = new Message(
                1, "+27815780081", "Hello there"
        );

        assertEquals(
                "Message ready to send.",
                message.validateMessage()
        );
    }

    @Test
    public void testEmptyMessage() {
        Message message = new Message(
                1, "+27815780081", ""
        );

        assertEquals(
                "Please enter a message.",
                message.validateMessage()
        );
    }

    @Test
    public void testMessageHashIsCreated() {
        Message message = new Message(
                1, "+27815780081", "Hello there"
        );

        assertNotNull(message.getMessageHash());
        assertFalse(message.getMessageHash().isEmpty());
    }
}