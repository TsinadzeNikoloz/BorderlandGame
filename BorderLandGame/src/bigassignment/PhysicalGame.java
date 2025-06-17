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
public class PhysicalGame extends Game {

    /**
     * Constructor for class
     * @param n
     * @param d
     */
    public PhysicalGame(String n, int d) {
        super(n, d);
    }
    
    /**
     * Play logic implementaiton
     * @param manager
     */
    @Override
    public ArrayList<Player> play(BorderlandManager manager){
        ArrayList<Player> winners = new ArrayList<>();
        for(Player player : players){
            if(player.getFearLevel() < 10){
                if(player.hasAllCards()){
                    this.players.remove(player);
                }
                if(isWinner(player, player.getPhysicalStat())){
                    manager.giveRandomCard(player);
                    player.setFearLevel(player.getFearLevel()-1);
                }
                else{
                    player.setFearLevel(player.getFearLevel()+1);
                }
            }
        }
        return winners;
    }
}
