package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.statistics.CalculateStatistics;
import com.kodilla.testing.statistics.Statistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@DisplayName(
        "Forum Statistics Tests"
)
@ExtendWith(MockitoExtension.class)
public class ForumStatisticTestSuite {

    @Mock
    private Statistics statisticsMock;

    private List<String> generateNUsers(int n) {
        List<String> nUsers = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            nUsers.add("User " + n);
        }
        return nUsers;
    }

    private static int testCounter = 0;

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Test number: " + testCounter);
    }

    @DisplayName(
            "Number of posts: 0"
    )
    @Test
    void postsCount0(){
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        List<String> users = generateNUsers(10);

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(20);

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, calculateStatistics.getNumberOfUsers());
        assertEquals(0, calculateStatistics.getNumberOfPosts());
        assertEquals(20, calculateStatistics.getNumberOfComments());
        assertEquals(0.0, calculateStatistics.getAveragePostsPerUser());
        assertEquals(2.0, calculateStatistics.getAverageCommentsPerUser());
        assertEquals(0.0, calculateStatistics.getAverageCommentsPerPost());
    }

    @DisplayName(
            "Number of posts: 100"
    )
    @Test
    void postsCount1000(){
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        List<String> users = generateNUsers(10);

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(20);

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, calculateStatistics.getNumberOfUsers());
        assertEquals(1000, calculateStatistics.getNumberOfPosts());
        assertEquals(20, calculateStatistics.getNumberOfComments());
        assertEquals(100.0, calculateStatistics.getAveragePostsPerUser());
        assertEquals(2.0, calculateStatistics.getAverageCommentsPerUser());
        assertEquals(0.02, calculateStatistics.getAverageCommentsPerPost());
    }

    @DisplayName(
            "Number of comments: 0"
    )
    @Test
    void commentsCount0(){
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        List<String> users = generateNUsers(10);

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(5);
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, calculateStatistics.getNumberOfUsers());
        assertEquals(5, calculateStatistics.getNumberOfPosts());
        assertEquals(0, calculateStatistics.getNumberOfComments());
        assertEquals(0.5, calculateStatistics.getAveragePostsPerUser());
        assertEquals(0.0, calculateStatistics.getAverageCommentsPerUser());
        assertEquals(0.0, calculateStatistics.getAverageCommentsPerPost());
    }

    @DisplayName(
            "Number of comments < Number of posts"
    )
    @Test
    void lessCommentsThanPosts(){
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        List<String> users = generateNUsers(10);

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(20);
        when(statisticsMock.commentsCount()).thenReturn(10);

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, calculateStatistics.getNumberOfUsers());
        assertEquals(20, calculateStatistics.getNumberOfPosts());
        assertEquals(10, calculateStatistics.getNumberOfComments());
        assertEquals(2.0, calculateStatistics.getAveragePostsPerUser());
        assertEquals(1.0, calculateStatistics.getAverageCommentsPerUser());
        assertEquals(0.5, calculateStatistics.getAverageCommentsPerPost());
    }

    @DisplayName(
            "Number of comments > Number of posts"
    )
    @Test
    void moreCommentsThanPosts(){
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        List<String> users = generateNUsers(10);

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(20);

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, calculateStatistics.getNumberOfUsers());
        assertEquals(10, calculateStatistics.getNumberOfPosts());
        assertEquals(20, calculateStatistics.getNumberOfComments());
        assertEquals(1.0, calculateStatistics.getAveragePostsPerUser());
        assertEquals(2.0, calculateStatistics.getAverageCommentsPerUser());
        assertEquals(2.0, calculateStatistics.getAverageCommentsPerPost());
    }

    @DisplayName(
            "Number of users: 0"
    )
    @Test
    void usersCount0(){
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        List<String> users = new ArrayList<>();

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(5);
        when(statisticsMock.commentsCount()).thenReturn(20);

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, calculateStatistics.getNumberOfUsers());
        assertEquals(5, calculateStatistics.getNumberOfPosts());
        assertEquals(20, calculateStatistics.getNumberOfComments());
        assertEquals(0.0, calculateStatistics.getAveragePostsPerUser());
        assertEquals(0.0, calculateStatistics.getAverageCommentsPerUser());
        assertEquals(4.0, calculateStatistics.getAverageCommentsPerPost());
    }

    @DisplayName(
            "Number of users: 100"
    )
    @Test
    void usersCount100(){
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        List<String> users = generateNUsers(100);

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(5);
        when(statisticsMock.commentsCount()).thenReturn(20);

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(100, calculateStatistics.getNumberOfUsers());
        assertEquals(5, calculateStatistics.getNumberOfPosts());
        assertEquals(20, calculateStatistics.getNumberOfComments());
        assertEquals(0.05, calculateStatistics.getAveragePostsPerUser());
        assertEquals(0.2, calculateStatistics.getAverageCommentsPerUser());
        assertEquals(4.0, calculateStatistics.getAverageCommentsPerPost());
    }
}
