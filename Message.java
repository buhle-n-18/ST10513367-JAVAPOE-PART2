/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programmingassignmentpart1;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author nyath
 */

public class Message {

    // Sets the maximum number of characters allowed in a message.
    private static final int MAX_MESSAGE_LENGTH = 250;
    private static int totalMessagesSent = 0;

    private final String messageID;
    private final int messageNumber;
    private final String recipient;
    private final String messageText;
    private String messageHash;
    private String status;

    private static final List<Message> sentMessages = new ArrayList<>();

    public Message(int messageNumber, String recipient, String messageText) {
        this.messageID = generateMessageID();
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
        this.status = "Pending";
    }

    private String generateMessageID() {
        Random random = new Random();
        long number = 1_000_000_000L
                + (long) (random.nextDouble() * 9_000_000_000L);
        return String.valueOf(number);
    }

    public boolean checkMessageID() {
        return messageID != null && messageID.length() <= 10;
    }

    public String checkRecipientCell() {
        if (recipient == null
                || !recipient.matches("\\+[1-9][0-9]{7,14}")) {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }

        return "Cell phone number successfully captured.";
    }

    public String validateMessage() {
        if (messageText == null || messageText.trim().isEmpty()) {
            return "Please enter a message.";
        }

        if (messageText.length() > MAX_MESSAGE_LENGTH) {
            int excess = messageText.length() - MAX_MESSAGE_LENGTH;
            return "Message exceeds 250 characters by " + excess
                    + "; please reduce the size.";
        }

        return "Message ready to send.";
    }

    public String createMessageHash() {
        String firstTwoDigits = messageID.substring(0, 2);

        String text = messageText == null ? "" : messageText.trim();
        String[] words = text.isEmpty() ? new String[0] : text.split("\\s+");

        String firstWord = words.length > 0
                ? words[0].replaceAll("[^a-zA-Z0-9]", "")
                : "";

        String lastWord = words.length > 0
                ? words[words.length - 1].replaceAll("[^a-zA-Z0-9]", "")
                : "";

        return (firstTwoDigits + ":" + messageNumber + ":"
                + firstWord + lastWord).toUpperCase();
    }

    public String sendMessage(String choice) {
        if (!"Message ready to send.".equals(validateMessage())) {
            return validateMessage();
        }

        if (!"Cell phone number successfully captured."
                .equals(checkRecipientCell())) {
            return checkRecipientCell();
        }

        if ("1".equals(choice)) {
            status = "Sent";
            totalMessagesSent++;
            sentMessages.add(this);
            return "Message successfully sent.";
        }

        if ("2".equals(choice)) {
            status = "Disregarded";
            return "Press 0 to delete the message.";
        }

        if ("3".equals(choice)) {
            status = "Stored";
            return "Message successfully stored.";
        }

        return "Invalid option. Please select 1, 2 or 3.";
    }

    public static String printMessages() {
        StringBuilder result = new StringBuilder();

        for (Message message : sentMessages) {
            result.append(message.toString()).append("\n");
        }

        return result.toString();
    }

    public int returnTotalMessages() {
        return totalMessagesSent;
    }

    public String storeMessage(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            String json = "{"
                    + "\"messageID\":\"" + escapeJson(messageID) + "\","
                    + "\"messageHash\":\"" + escapeJson(messageHash) + "\","
                    + "\"recipient\":\"" + escapeJson(recipient) + "\","
                    + "\"message\":\"" + escapeJson(messageText) + "\","
                    + "\"status\":\"" + escapeJson(status) + "\""
                    + "}";
            writer.write(json + System.lineSeparator());
            return "Message successfully stored.";
        } catch (IOException e) {
            return "Message could not be stored: " + e.getMessage();
        }
    }

    private String escapeJson(String value) {
        if (value == null) {
            return "";
        }

        return value.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    @Override
    public String toString() {
        return "Message ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipient
                + "\nMessage: " + messageText
                + "\nStatus: " + status;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getStatus() {
        return status;
    }

    public static int getTotalMessagesSent() {
        return totalMessagesSent;
    }
}
