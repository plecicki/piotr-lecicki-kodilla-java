package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PizzaOrderTestSuite {

    @Test
    void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //Then
        Assertions.assertEquals(new BigDecimal(15.00), calculatedCost);
    }

    @Test
    void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        String calculatedDescription = pizzaOrder.getDescription();
        //Then
        Assertions.assertEquals("Pizza dough + cheese + tomato sauce", calculatedDescription);
    }

    @Test
    void testBasicPizzaWithOnionOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new OnionDecorator(pizzaOrder);
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //Then
        Assertions.assertEquals(new BigDecimal(19.00), calculatedCost);
    }

    @Test
    void testBasicPizzaWithOnionOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new OnionDecorator(pizzaOrder);
        //When
        String calculatedDescription = pizzaOrder.getDescription();
        //Then
        Assertions.assertEquals("Pizza dough + cheese + tomato sauce + onion", calculatedDescription);
    }

    @Test
    void testBasicPizzaWithOnionAndMushroomsOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //Then
        Assertions.assertEquals(new BigDecimal(21.00), calculatedCost);
    }

    @Test
    void testBasicPizzaWithOnionAndMushroomsOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        //When
        String calculatedDescription = pizzaOrder.getDescription();
        //Then
        Assertions.assertEquals("Pizza dough + cheese + tomato sauce + onion + mushrooms", calculatedDescription);
    }

    @Test
    void testBasicPizzaWithOnionAndMushroomsAndPineappleOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        pizzaOrder = new PineappleDecorator(pizzaOrder);
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //Then
        Assertions.assertEquals(new BigDecimal(24.00), calculatedCost);
    }

    @Test
    void testBasicPizzaWithOnionAndMushroomsAndPineappleOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        pizzaOrder = new PineappleDecorator(pizzaOrder);
        //When
        String calculatedDescription = pizzaOrder.getDescription();
        //Then
        Assertions.assertEquals("Pizza dough + cheese + tomato sauce + onion + mushrooms + pineapple", calculatedDescription);
    }

    @Test
    void testBasicPizzaWithOnionAndMushroomsAndPineappleOrderWithExpressDeliveryGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        pizzaOrder = new PineappleDecorator(pizzaOrder);
        pizzaOrder = new ExpressDecorator(pizzaOrder);
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //Then
        Assertions.assertEquals(new BigDecimal(29.00), calculatedCost);
    }

    @Test
    void testBasicPizzaWithOnionAndMushroomsAndPineappleOrderWithExpressDeliveryGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        pizzaOrder = new PineappleDecorator(pizzaOrder);
        pizzaOrder = new ExpressDecorator(pizzaOrder);
        //When
        String calculatedDescription = pizzaOrder.getDescription();
        //Then
        Assertions.assertEquals("Pizza dough + cheese + tomato sauce + onion + mushrooms + pineapple + Express delivery", calculatedDescription);
    }
}
