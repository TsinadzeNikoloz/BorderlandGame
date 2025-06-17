/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bigassignment;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author ntsin
 */
public class GameMaster {
    private Arena arena;
    private Random random;

    /**
     *
     * @param arena
     */
    public GameMaster(Arena arena) {
        this.arena = arena;
        this.random = new Random();
    }
    
    /**
     *
     * @return
     */
    public Arena getArena() {
        return arena;
    }

    /**
     * Logic for picking next game randomly
     * @return
     */
    public Game pickNextGame() {
        ArrayList<Game> games = arena.getGames();
        if (games.isEmpty()) return null;
        int index = random.nextInt(games.size());
        return games.get(index);
    }

    /**
     * hazard activation implementd in arena.
     */
    public void activateHazard() {
        arena.activateHazard();
    }

    
}
