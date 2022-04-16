package com.kodilla.rps.game;

import com.kodilla.rps.rpsobjects.ElementsRps;
import com.kodilla.rps.rpsobjects.Paper;
import com.kodilla.rps.rpsobjects.Rock;
import com.kodilla.rps.rpsobjects.Scissors;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private int playerPoints;
    private int computerPoints;
    private int maxPoints;

    private ElementsRps yourChoice;

    public Game(int playerPoints, int computerPoints, int maxPoints) {
        this.playerPoints = playerPoints;
        this.computerPoints = computerPoints;
        this.maxPoints = maxPoints;
    }

    public void gamePoints(ElementsRps yourChoice, int computerChoice){
        if(yourChoice.whoDestroyMe() == computerChoice){
            this.computerPoints += 1;
            System.out.println("Computer won round");
            choiceOption();
        } else if(yourChoice.whoIDestroy() == computerChoice){
            this.playerPoints += 1;
            System.out.println("You won round");
            choiceOption();
        } else {
            System.out.println("Draw round");
            choiceOption();
        }
    }

    public void choiceOption(){
        if (playerPoints < maxPoints && computerPoints < maxPoints){
            boolean whileCondition = true;
            while(whileCondition) {
                System.out.println("Choose one of option and press Enter");
                System.out.println("1 - play rock");
                System.out.println("2 - play paper");
                System.out.println("3 - play scissors");
                System.out.println("x - finish game");
                System.out.println("n - restart game");
                System.out.println("YOU [" + playerPoints + " : " + computerPoints + "] COMP ||| MAX: " + maxPoints);
                Scanner choice = new Scanner(System.in);
                char choiceChar = choice.next().charAt(0);
                if (choiceChar == '1' || choiceChar == '2' ||
                        choiceChar == '3' || choiceChar == 'x' ||
                        choiceChar == 'n') {
                    whileCondition = false;
                    runAfterChoice(choiceChar);
                } else {
                    System.out.println("Bad choice. Choose again: ");
                }
            }
        } else {
            if (playerPoints >= maxPoints) {
                System.out.println("YOU [" + playerPoints + " : " + computerPoints + "] COMP ||| MAX: " + maxPoints);
                System.out.println("YOU WIN");
                questionAfterGame();
            } else if (computerPoints >= maxPoints) {
                System.out.println("YOU [" + playerPoints + " : " + computerPoints + "] COMP ||| MAX: " + maxPoints);
                System.out.println("YOU LOSE");
                questionAfterGame();
            }
        }
    }

    public void randomComputerChoice(ElementsRps yourChoice){
        //25% to player win
        //25% to draw
        //50% to computer win
        Random rand = new Random();
        int int_random = rand.nextInt(4);
        int returnedInt = 0;

        if (int_random == 0 || int_random == 1){
            returnedInt = yourChoice.whoDestroyMe();
        } else if (int_random == 2) {
            returnedInt = yourChoice.whoIDestroy();
        } else {
            returnedInt = yourChoice.getMyIndex();
        }

        if (returnedInt == 1){
            System.out.println("Computer play: ROCK");
        } else if (returnedInt == 2){
            System.out.println("Computer play: PAPER");
        } else if (returnedInt == 3){
            System.out.println("Computer play: SCISSORS");
        }
        gamePoints(yourChoice, returnedInt);
    }

    public void runAfterChoice(char chosenOption){
        if (chosenOption == '1' || chosenOption == '2' || chosenOption == '3'){
            if (chosenOption == '1'){
                yourChoice = new Rock();
                System.out.println("You play: ROCK");
                randomComputerChoice(yourChoice);
            } else if (chosenOption == '2'){
                yourChoice = new Paper();
                System.out.println("You play: PAPER");
                randomComputerChoice(yourChoice);
            } else if (chosenOption == '3'){
                yourChoice = new Scissors();
                System.out.println("You play: SCISSORS");
                randomComputerChoice(yourChoice);
            }
        } else if (chosenOption == 'x') {
            System.out.println("Are you sure to finish game?");
            System.out.println("Enter \"Y\" or \"y\" to confirm or");
            System.out.println("enter something else to reject");
            Scanner reset = new Scanner(System.in);
            char decision = reset.next().charAt(0);
            if (decision == 'Y' || decision == 'y'){
                System.out.println("Finishing Game...");
                //Finish
            } else {
                choiceOption();
            }
        } else if (chosenOption == 'n') {
            System.out.println("Are you sure to restart game?");
            System.out.println("Enter \"Y\" or \"y\" to confirm or");
            System.out.println("enter something else to reject");
            Scanner reset = new Scanner(System.in);
            char decision = reset.next().charAt(0);
            if (decision == 'Y' || decision == 'y'){
                System.out.println("Restarting Game...");
                new Start().startGame();
            } else {
                choiceOption();
            }
        }
    }

    public void questionAfterGame() {
        boolean choiceEnd = true;
        while (choiceEnd){
            System.out.println("Choose one of options: ");
            System.out.println("n - Restart game");
            System.out.println("x - Finish game");
            System.out.print("Your choice: ");

            Scanner choiceFinish = new Scanner(System.in);
            char endOption = choiceFinish.next().charAt(0);

            if (endOption == 'n'){
                choiceEnd = false;
                new Start().startGame();
            } else if (endOption == 'x'){
                choiceEnd = false;
                //Finish
            } else {
                System.out.println("Incorrect option. Choose again");
            }
        }

    }
}
