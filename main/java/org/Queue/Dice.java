package org.Queue;

import java.util.Random;

public class Dice {
    private int NumberOfDice;


    public Dice(int NumberOfDice) {
       this.NumberOfDice = NumberOfDice;
    }

    public int rollDice(){
        return ((int ) (Math.random()*(6*NumberOfDice - 1*NumberOfDice)))+1 ;

    }
}
