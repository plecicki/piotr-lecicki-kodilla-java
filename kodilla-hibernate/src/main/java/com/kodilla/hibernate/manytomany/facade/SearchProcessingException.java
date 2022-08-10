package com.kodilla.hibernate.manytomany.facade;

public class SearchProcessingException extends Exception{

    public static String ERR_NOTHING_FOUND = "Can't find anything";

    public SearchProcessingException(String message) {
        super(message);
    }
}
