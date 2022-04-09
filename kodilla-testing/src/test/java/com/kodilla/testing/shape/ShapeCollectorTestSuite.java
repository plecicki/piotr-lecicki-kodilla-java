package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName(
        "Shapes tests"
)
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Tests: Start");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("Tests: Finish");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Test number: " + testCounter);
    }

    @Nested
    @DisplayName("Tests for square")
    class TestSquares {

        @Test
        public void testAddShape() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square(5);
            //When
            shapeCollector.addFigure(square);
            //Then
            assertEquals(square, shapeCollector.getFigure(0));
        }

        @Test
        public void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square(5);
            //When
            shapeCollector.addFigure(square);
            shapeCollector.removeFigure(square);
            //Then
            assertTrue(shapeCollector.getShapes().isEmpty());
        }
    }

    @Nested
    @DisplayName("Tests for triangle")
    class TestTriangles {

        @Test
        public void testAddShape() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape triangle = new Triangle(5, 3);
            //When
            shapeCollector.addFigure(triangle);
            //Then
            assertEquals(triangle, shapeCollector.getFigure(0));
        }

        @Test
        public void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape triangle = new Triangle(5, 3);
            //When
            shapeCollector.addFigure(triangle);
            shapeCollector.removeFigure(triangle);
            //Then
            assertTrue(shapeCollector.getShapes().isEmpty());
        }
    }

    @Nested
    @DisplayName("Tests for circle")
    class TestCircle {

        @Test
        public void testAddShape() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle(5);
            //When
            shapeCollector.addFigure(circle);
            //Then
            assertEquals(circle, shapeCollector.getFigure(0));
        }

        @Test
        public void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle(5);
            //When
            shapeCollector.addFigure(circle);
            shapeCollector.removeFigure(circle);
            //Then
            assertTrue(shapeCollector.getShapes().isEmpty());
        }
    }

    @Nested
    @DisplayName("Tests for Getting and Showing")
    class TestGetAndShow {

        @Test
        public void testGetShape() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square1 = new Square(5);
            Shape triangle1 = new Triangle(3, 5);
            //When
            shapeCollector.addFigure(square1);
            shapeCollector.addFigure(triangle1);
            //Then
            assertEquals(triangle1, shapeCollector.getFigure(1));
        }

        @Test
        public void testShowShapes() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square1 = new Square(5);
            Shape square2 = new Square(4);
            Shape triangle1 = new Triangle(3, 5);
            Shape circle1 = new Circle(5);
            //When
            shapeCollector.addFigure(square1);
            shapeCollector.addFigure(square2);
            shapeCollector.addFigure(triangle1);
            shapeCollector.addFigure(circle1);

            List<Shape> result = new ArrayList<>();
            result.add(square1);
            result.add(square2);
            result.add(triangle1);
            result.add(circle1);
            String stringResult = result.get(0).getShapeName() + " " + result.get(1).getShapeName() + " " +
                    result.get(2).getShapeName() + " " + result.get(3).getShapeName() + " ";
            //Then
            assertEquals(stringResult, shapeCollector.showFigures());
        }
    }
}
