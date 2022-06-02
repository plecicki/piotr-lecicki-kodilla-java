package com.kodilla.spring.portfolio;

import com.kodilla.spring.reader.Reader;
import com.kodilla.spring.reader.ReaderConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.getToDoList().getTasks().add("Set up new computers");
        board.getInProgressList().getTasks().add("Call to XYZ");
        board.getDoneList().getTasks().add("Check daily offers");

        //Then
        Assertions.assertEquals("Set up new computers",
                board.getToDoList().getTasks().get(0));
        Assertions.assertEquals("Call to XYZ",
                board.getInProgressList().getTasks().get(0));
        Assertions.assertEquals("Check daily offers",
                board.getDoneList().getTasks().get(0));
    }
}
