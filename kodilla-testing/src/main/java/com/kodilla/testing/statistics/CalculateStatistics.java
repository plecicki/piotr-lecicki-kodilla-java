package com.kodilla.testing.statistics;

public class CalculateStatistics {
    private Statistics statistics;

    private int numberOfUsers;
    private int numberOfPosts;
    private int numberOfComments;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public CalculateStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        numberOfUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();
        if (numberOfUsers != 0) {
            averagePostsPerUser = (double)numberOfPosts/(double)numberOfUsers;
            averageCommentsPerUser = (double)numberOfComments/(double)numberOfUsers;
        } else {
            System.out.println("2x Division by 0 (Number of users: 0)");
        }
        if (numberOfPosts != 0) {
            averageCommentsPerPost = (double)numberOfComments/(double)numberOfPosts;
        } else {
            System.out.println("Division by 0 (Number of posts: 0)");
        }
    }

    public void showStatistics() {
        System.out.println("Number of Users: " + numberOfUsers);
        System.out.println("Number of Posts: " + numberOfPosts);
        System.out.println("Number of Comments: " + numberOfComments);
        if (numberOfUsers != 0) {
            System.out.println("Average number of posts per user: " + averagePostsPerUser);
            System.out.println("Average number of comments per user: " + averageCommentsPerUser);
        } else {
            System.out.println("Average number of posts per user: Division by 0");
            System.out.println("Average number of comments per user: Division by 0");
        }
        if (numberOfPosts != 0) {
            System.out.println("Average number of comments per post: " + averageCommentsPerPost);
        } else {
            System.out.println("Average number of comments per post: Division by 0");
        }
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }
}
