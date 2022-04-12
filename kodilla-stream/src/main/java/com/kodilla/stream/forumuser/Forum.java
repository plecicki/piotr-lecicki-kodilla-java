package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        userList.add(new ForumUser(1, "Dragon123", 'M', LocalDate.of(1999,10,18), 0));
        userList.add(new ForumUser(2, "User123", 'F', LocalDate.of(1980,6,22), 2));
        userList.add(new ForumUser(3, "KungFu", 'M', LocalDate.of(1999,3,30), 10));
        userList.add(new ForumUser(4, "Chair", 'F', LocalDate.of(1988,7,11), 6));
        userList.add(new ForumUser(5, "StepsToHeaven", 'M', LocalDate.of(1987,9,6), 60));
        userList.add(new ForumUser(6, "Epic", 'F', LocalDate.of(2011,4,1), 40));
        userList.add(new ForumUser(7, "Fantastic", 'M', LocalDate.of(1955,9,4), 33));
        userList.add(new ForumUser(8, "Cat111", 'F', LocalDate.of(2005,10,18), 5));
        userList.add(new ForumUser(9, "DataReader", 'M', LocalDate.of(1940,4,2), 1));
        userList.add(new ForumUser(10, "ForumSpecialist", 'F', LocalDate.of(1970,10,5), 0));
        userList.add(new ForumUser(11, "Anonymous", 'M', LocalDate.of(2000,6,10), 45));
        userList.add(new ForumUser(12, "Guest123", 'F', LocalDate.of(1950,4,30), 20));
        userList.add(new ForumUser(13, "Owner", 'M', LocalDate.of(2015,6,25), 5));
        userList.add(new ForumUser(14, "Strong", 'F', LocalDate.of(1976,10,4), 6));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }
}
