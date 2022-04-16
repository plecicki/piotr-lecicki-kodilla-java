package com.kodilla.rps.rpsobjects;

public class Paper implements ElementsRps{

    public int whoIDestroy(){
        return 1;
    }

    public int whoDestroyMe(){
        return 3;
    }

    @Override
    public String toString() {
        return "Paper";
    }

    @Override
    public int getMyIndex() {
        return 2;
    }
}
