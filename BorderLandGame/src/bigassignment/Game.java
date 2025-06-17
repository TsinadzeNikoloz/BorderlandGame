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
public abstract class Game {

    /**
     *
     */
    protected String name;

    /**
     *
     */
    protected int difficultyLevel;

    /**
     *
     */
    protected ArrayList<Player> players;
    
    /**
     * Constructor for Game
     * @param n
     * @param d
     */
    public Game(String n, int d){
        this.name = n;
        this.difficultyLevel = d;
        players = new ArrayList<>();
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
     * @param n
     */
    public void setName(String n){
        this.name = n;
    }
    
    /**
     *
     * @return
     */
    public int getDifficultyLevel(){
        return this.difficultyLevel;
    }
    
    /**
     *
     * @param d
     */
    public void setDifficultyLevel(int d){
        this.difficultyLevel = d;
    }
    /**
     *
     * @param p
     */
    public void addPlayer(Player p){
        this.players.add(p);
    }
    
    /**
     * 
     * @param player
     * @param stat
     * @return boolean value, decides whether a player is winner or not in specific game.
     */
    protected boolean isWinner(Player player, int stat) {
        return stat > difficultyLevel;
    }
    
    /**
     * Not implementd class, for subclasses
     * @param manager
     * @return ArrayList<Player> 
     */
    public abstract ArrayList <Player> play(BorderlandManager manager);
}
