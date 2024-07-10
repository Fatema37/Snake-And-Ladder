package org.Queue;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Dice dice = new Dice(1);
        Player p1 = new Player("Fatema",1);
        Player p2 = new Player("Hasan",2);
        Queue<Player> allPlayer = new LinkedList<>();
        allPlayer.offer(p1);
        allPlayer.offer(p2);
        Jumper snake1 = new Jumper(10,2);
        Jumper snake2 = new Jumper(99,12);
        List<Jumper> snakes = new ArrayList<>();
        snakes.add(snake1);
        snakes.add(snake2);
        Jumper ladder1 = new Jumper(5,25);
        Jumper ladder2 = new Jumper(40,89);
        List<Jumper> ladders = new ArrayList<>();
        ladders.add(ladder1);
        ladders.add(ladder2);
        Map<String, Integer> playerCurrentPosition = new HashMap<>();
        playerCurrentPosition.put("Fatema",0);
        playerCurrentPosition.put("Hasan" ,0);
        GameBoard gameBoard = new GameBoard(dice,allPlayer,snakes,ladders,playerCurrentPosition,100);
        gameBoard.startGame();


    }
}