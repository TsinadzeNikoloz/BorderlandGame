/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bigassignment;

/**
 *
 * @author ntsin
 */
public class CautiousBehaviour implements Behaviour {

    /**
     *
     * @param p
     * @param win
     */
    @Override
    public void fearChange(Player p, boolean win) {
         if(win){
            p.setFearLevel(p.getFearLevel() - 1);
        } else{
            p.setFearLevel(p.getFearLevel() + 1);
        }
    }

    /**
     *
     * @param g
     * @param p
     * @return
     */
    @Override
    public boolean playsGame(Game g, Player p) {
        return g.isWinner(p, Math.max(p.getPhysicalStat(), p.getMentalStat()));
    }
}
