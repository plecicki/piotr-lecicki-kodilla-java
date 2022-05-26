package com.kodilla.good.patterns.challenges;

public class MailMessage implements CommunicationWithClient{

    private String contentOfMessage() {
        return "Thank you for buying products!";
    }

    public void send() {
        String textOfMessage = contentOfMessage();
        System.out.println("Sending mail... " + textOfMessage + "\n");
    }
}
