package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {
    
    private static Logger logger;
    
    @BeforeAll
    public static void createLoggerObject() {
        logger = Logger.INSTANCE;
    }
    
    @Test
    public void checkLogText() {
        //Given
        //When
        logger.log("123456789");
        String lastLogText = logger.getLastLog();
        //Then
        Assertions.assertEquals("123456789", lastLogText);
    }
}
