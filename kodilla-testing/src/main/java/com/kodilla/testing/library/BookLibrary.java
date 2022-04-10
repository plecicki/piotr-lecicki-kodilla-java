package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    private LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<Book>();
        if (titleFragment.length() < 3) return bookList;
        List<Book> resultList = libraryDatabase
                .listBooksWithCondition(titleFragment);
        if (resultList.size() > 20) return bookList;
        bookList = resultList;
        return bookList;
    }

    public List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
        List<Book> handBookList = new ArrayList<Book>();
        LibraryUser dataBaseUser1 = new LibraryUser("Piotr", "Lecicki", "12345678910");
        LibraryUser dataBaseUser2 = new LibraryUser("Marek", "Kowalski", "10987654321");
        LibraryUser dataBaseUser3 = new LibraryUser("Grzegorz", "Grillowy", "12345678999");

        if (libraryUser.getPeselId() == dataBaseUser1.getPeselId()) {

        }
        else if (libraryUser.getPeselId() == dataBaseUser2.getPeselId()) {
            handBookList.add(new Book("Title", "Author", 1500));
        }

        List<Book> resultList = libraryDatabase
                .listBooksInHandsOf(libraryUser);

        if (libraryUser.getPeselId() == dataBaseUser3.getPeselId()) {
            for (int n = 1; n <= 5; n++) {
                handBookList.add(new Book("Title " + n, "Author " + n, 1970 + n));
            }
            return  handBookList;
        }

        handBookList = resultList;
        return handBookList;
    }
}
