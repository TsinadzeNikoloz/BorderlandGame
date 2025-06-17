/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bigassignment;

/**
 *
 * @author ntsin
 */
public class AggresiveBehaviour implements Behaviour {

    /**
     *
     * @param p
     * @param win
     */
    @Override
    public void fearChange(Player p, boolean win) {
    }

    /**
     *
     * @param g
     * @param p
     * @return
     */
    @Override
    public boolean playsGame(Game g, Player p) {
        return true;
    }

    /**
     *
     * @param p
     * @param win
     */
    @Override
    public void staminaChange(Player p, boolean win) {
        if (!win) p.setStamina(p.getStamina() - 1);
    }
}
