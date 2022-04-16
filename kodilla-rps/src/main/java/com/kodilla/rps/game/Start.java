package com.kodilla.rps.game;

import java.util.Scanner;

public class Start {
    private int maxPoints;
    private String playerName;

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        this.playerName = sc.next();
        System.out.println("Hello " + this.playerName + "!!!");

        boolean checkStr = true;
        String max = null;
        while (checkStr) {
            System.out.print("Enter maximum number of points: ");
            max = sc.next();

            int forIterates = 0;
            for (int i = 0; i < max.length(); i++) {
                char c = max.charAt(i);
                if (c >= '0' && c <= '9') {
                    forIterates++;
                }
            }
            if (forIterates == max.length()) {
                checkStr = false;
            } else {
                System.out.println("Incorrect value");
            }
        }

        this.maxPoints = Integer.parseInt(max);
        new Game(0, 0, this.maxPoints).choiceOption();

    }
}
