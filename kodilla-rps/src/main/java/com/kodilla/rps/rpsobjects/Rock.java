package com.kodilla.rps.rpsobjects;

public class Rock implements ElementsRps{

    public int whoIDestroy(){
        return 3;
    }

    public int whoDestroyMe(){
        return 2;
    }

    @Override
    public String toString() {
        return "Rock";
    }

    @Override
    public int getMyIndex() {
        return 1;
    }
}
