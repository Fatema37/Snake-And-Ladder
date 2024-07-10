package org.Queue;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GameBoard {
    private Dice dice;
    private Queue<Player> nextTurn;
    private List<Jumper> snakes;
    private List<Jumper> ladder;
    private Map<String,Integer> playerCurrentPosition;
    int boardSize;


    public GameBoard(Dice dice, Queue<Player> nextTurn, List<Jumper> snakes, List<Jumper> ladder, Map<String, Integer> playerCurrentPosition, int boardSize) {
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.snakes = snakes;
        this.ladder = ladder;
        this.playerCurrentPosition = playerCurrentPosition;
        this.boardSize = boardSize;
    }

    public void startGame(){
        while(nextTurn.size()>1){
            Player player = nextTurn.poll();
            int currPosition = playerCurrentPosition.get(player.getPlayerName());
            int diceValue = dice.rollDice();
            int nextCell = currPosition+diceValue;
            if(nextCell>boardSize){
                nextTurn.offer(player);
            }
            else if(nextCell==boardSize){
                System.out.println(player.getPlayerName()+" won the game");
            }

            else {
                int[] nextPosition = new int[1];
                boolean[] b = new boolean[1];
                nextPosition[0] = nextCell;
                snakes.forEach(v->{
                    if(v.getStartPoint()==nextCell){
                        nextPosition[0] = v.getEndPoint();
                    }
                });
                if(nextPosition[0]!=nextCell){
                    System.out.println(player.getPlayerName()+" Bitten by snake present at " +nextCell);
                }

                ladder.forEach(v->{
                    if(v.getStartPoint()==nextCell){
                        nextPosition[0] = v.getEndPoint();
                        b[0] = true;
                    }
                });
                if(nextPosition[0]!=nextCell && b[0]){
                    System.out.println(player.getPlayerName()+" Got the ladder at position " +nextCell);
                }

                if(nextCell==boardSize){
                    System.out.println(player.getPlayerName()+" won the game");
                }
                else{
                    playerCurrentPosition.put(player.getPlayerName(), nextPosition[0]);
                    System.out.println(player.getPlayerName()+ " is at position " +nextPosition[0]);
                    nextTurn.offer(player);
                }
            }
        }


    }
}
