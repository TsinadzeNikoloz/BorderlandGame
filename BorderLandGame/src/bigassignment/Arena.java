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
public class Arena {
    private String name;
    private ArrayList<Game> games;
    private String environmentalHazard;
    
    /**
     * Constructor
     * @param n
     * @param e
     */
    public Arena(String n, String e){
        this.name = n;
        this.environmentalHazard = e;
        this.games = new ArrayList<>();
    }
    
    /**
     *
     * @return
     */
    public String getName(){
        return this.name;
    }
    
    /**
     *
     * @param g
     */
    public void addGame(Game g){
        this.games.add(g);
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Game> getGames(){
        return this.games;
    }
    
    /**
     * Hazard activation logic
     */
    public void activateHazard(){
        for(Game game : games){
            for(Player player : game.players){
                if(player.getFearLevel() < 10){
                    player.setFearLevel(player.getFearLevel()+1);
                }
            }
        }
    }
}
