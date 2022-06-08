package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User piotr = new Millenials("Piotr");
        User grzegorz = new YGeneration("Grzegorz");
        User monika = new ZGeneration("Monika");

        //When
        String piotrShare = piotr.sharePost();
        System.out.println("Piotr share: " + piotrShare);
        String grzegorzShare = grzegorz.sharePost();
        System.out.println("Grzegorz share: " + grzegorzShare);
        String monikaShare = monika.sharePost();
        System.out.println("Monika share: " + monikaShare);

        //Then
        Assertions.assertEquals("SNAPCHAT", piotrShare);
        Assertions.assertEquals("FACEBOOK", grzegorzShare);
        Assertions.assertEquals("TWITTER", monikaShare);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User piotr = new Millenials("Piotr");

        //When
        String piotrShare = piotr.sharePost();
        System.out.println("Piotr share before changing: " + piotrShare);
        piotr.setSocialPublisher(new TwitterPublisher());
        piotrShare = piotr.sharePost();
        System.out.println("Piotr share after changing: " + piotrShare);

        //Then
        Assertions.assertEquals("TWITTER", piotrShare);
    }
}
