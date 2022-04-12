package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        Forum theForum = new Forum();
        Map<Integer, ForumUser> theResultMapOfUsers = theForum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> (forumUser.getDateOfBirth().getYear() < 2002) ||
                        ((forumUser.getDateOfBirth().getYear() == 2002) &&
                                (forumUser.getDateOfBirth().getMonthValue() < 4)) ||
                        ((forumUser.getDateOfBirth().getYear() == 2002) &&
                                (forumUser.getDateOfBirth().getMonthValue() == 4) &&
                                (forumUser.getDateOfBirth().getDayOfMonth() <= 13)))
                .filter(forumUser -> forumUser.getPostsCount() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserID, forumUser -> forumUser));

        theResultMapOfUsers.entrySet().stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .forEach(System.out::println);
    }
}
