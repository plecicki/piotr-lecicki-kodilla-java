package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BigmacTestSuite {

    @Test
    void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("Wheat")
                .burgers(3)
                .sauce("Tomato ketchup")
                .ingredient("Salad")
                .ingredient("Tomato")
                .ingredient("Bacon")
                .ingredient("Radish")
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        Assertions.assertEquals("Wheat", bigmac.getBun());
        Assertions.assertEquals(3, bigmac.getBurgers());
        Assertions.assertEquals("Tomato ketchup", bigmac.getSauce());
        Assertions.assertEquals(4, howManyIngredients);
    }
}
