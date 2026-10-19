/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programmingassignmentpart1;
import java.util.Scanner;

/**
 *
 * @author nyath
 */

public class QuickChatMenu {

    public static void start(Scanner scanner) {

        System.out.println("Welcome to QuickChat!");

        System.out.print("How many messages would you like to send? ");
        int numberOfMessages = scanner.nextInt();
        scanner.nextLine();

        int messagesProcessed = 0;

        while (true) {

            System.out.println("\nPlease choose an option:");
            System.out.println("1) Send Message");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                 case "1":
                  if (messagesProcessed >= numberOfMessages) {
                    System.out.println("You have reached your message limit.");
                    break;
                  }
                    System.out.print("Enter recipient cell phone number: ");
                    String recipient = scanner.nextLine();

                    System.out.print("Enter your message: ");
                    String messageText = scanner.nextLine();

                    Message newMessage = new Message(
                            messagesProcessed + 1,
                            recipient,
                            messageText
                    );

                    System.out.println(newMessage.checkRecipientCell());
                    System.out.println(newMessage.validateMessage());

                    if ("Message ready to send.".equals(newMessage.validateMessage())
                            && "Cell phone number successfully captured."
                                    .equals(newMessage.checkRecipientCell())) {

                        System.out.println("Choose an option:");
                        System.out.println("1) Send message");
                        System.out.println("2) Disregard message");
                        System.out.println("3) Store message");

                        String sendChoice = scanner.nextLine();

                        String sendResult = newMessage.sendMessage(sendChoice);
System.out.println(sendResult);

if ("3".equals(sendChoice)
        && "Message successfully stored.".equals(sendResult)) {
    System.out.println(newMessage.storeMessage("messages.json"));
    System.out.println(
            new java.io.File("messages.json").getAbsolutePath());
}
                        if ("1".equals(sendChoice)
                                || "2".equals(sendChoice)
                                || "3".equals(sendChoice)) {
                            messagesProcessed++;
                        }
                    }
                    break;

                case "2":
                    String sentMessages = Message.printMessages();

                    if (sentMessages.isEmpty()) {
                      System.out.println("No sent messages available.");
                    } else {
                      System.out.println(sentMessages);
                    }
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Please choose 1, 2 or 3.");
            }
        }

        
    }
}
