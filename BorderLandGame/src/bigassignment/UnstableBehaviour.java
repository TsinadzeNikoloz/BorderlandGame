/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bigassignment;
import java.util.Random;
/**
 *
 * @author ntsin
 */
public class UnstableBehaviour implements Behaviour{
    private Random rand = new Random();

    /**
     *
     * @param p
     * @param win
     */
    @Override
    public void fearChange(Player p, boolean win) {
      
        p.setFearLevel(p.getFearLevel() - 5 + rand.nextInt(10));
    }

    /**
     *
     * @param g
     * @param p
     * @return
     */
    @Override
    public boolean playsGame(Game g, Player p) {
        return rand.nextBoolean();
    }
}
