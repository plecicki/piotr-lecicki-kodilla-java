package com.kodilla.rps.rpsobjects;

public class Scissors implements ElementsRps{

    public int whoIDestroy(){
        return 2;
    }

    public int whoDestroyMe(){
        return 1;
    }

    @Override
    public String toString() {
        return "Scissors";
    }

    @Override
    public int getMyIndex() {
        return 3;
    }
}
