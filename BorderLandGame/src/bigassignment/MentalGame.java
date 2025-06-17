/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bigassignment;

import java.util.ArrayList;

/**
 *
 * @author ntsin
 */
public class MentalGame extends Game {

    /**
     * Constructor for class
     * @param n
     * @param d
     */
    public MentalGame(String n, int d) {
        super(n, d);
    }
    
    /**
     * Play logic implemantition
     * @param manager
     */
    @Override
    public ArrayList <Player> play(BorderlandManager manager){
        ArrayList<Player> winners = new ArrayList<>();
        for(Player player : players){
            if(player.getFearLevel()<10){
                if(player.hasAllCards()){
                    this.players.remove(player);
                }
                if(isWinner(player, player.getMentalStat())){
                    manager.giveRandomCard(player);
                    player.setFearLevel(player.getFearLevel()-1);
                    winners.add(player);
                }
                else{
                    player.setFearLevel(player.getFearLevel()+1);
                }
            }

        }
        return winners;
    }
}
