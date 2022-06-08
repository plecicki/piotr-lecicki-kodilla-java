package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {

        //Given
        Library library = new Library("School library");

        Book book1 = new Book("Harry Potter", "J. K. Rowling", LocalDate.of(1985, 5, 12));
        Book book2 = new Book("JavaFX tutorial", "Rafal Kowalski", LocalDate.of(1999, 9, 14));
        Book book3 = new Book("Swing tutorial", "Jan Nowak", LocalDate.of(2005, 8, 25));
        Book book4 = new Book("Spring Basics", "George Spring", LocalDate.of(2010, 2, 12));
        Book book5 = new Book("Clean code", "Robert C. Martin", LocalDate.of(1980, 4, 30));

        Set<Book> books = new HashSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        library.setBooks(books);

        Library shallowClone = null;
        try {
            shallowClone = library.shallowCopy();
            shallowClone.setName("Public library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClone = null;
        try {
            deepClone = library.deepCopy();
            deepClone.setName("Underground library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(book3);

        //Then
        System.out.println(library);
        System.out.println(shallowClone);
        System.out.println(deepClone);
        Assertions.assertEquals(4, library.getBooks().size());
        Assertions.assertEquals(4, shallowClone.getBooks().size());
        Assertions.assertEquals(5, deepClone.getBooks().size());
        Assertions.assertEquals(library.getBooks(), shallowClone.getBooks());
        Assertions.assertNotEquals(library.getBooks(), deepClone.getBooks());
    }
}
