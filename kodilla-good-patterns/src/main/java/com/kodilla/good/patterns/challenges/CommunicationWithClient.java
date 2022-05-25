package com.kodilla.good.patterns.challenges;

public class CommunicationWithClient {

    public static void sendSMS() {
        System.out.println("SMS was sent");
    }

    public static void sendMail() {
        System.out.println("Mail was sent");
    }

    public static void thanks(Product product) {
        System.out.println("Thank you for buying product");
        System.out.println(product);
        System.out.println("See you next time!\n");
    }

    public static void communicate(Product product) {
        sendSMS();
        sendMail();
        thanks(product);
    }
}
