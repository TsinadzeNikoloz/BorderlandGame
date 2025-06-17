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
public interface Behaviour {
    Random rand = new Random();
    /**
     *
     * @param p
     * @param win
     */
    void fearChange(Player p, boolean win);

    /**
     *
     * @param g
     * @param p
     * @return
     */
    boolean playsGame(Game g, Player p);

    /**
     *
     * @param p
     * @param win
     */
    default void staminaChange(Player p, boolean win) { }
    
    /**
     *
     * @return random behaviour
     */
    

    static Behaviour randomBehaviour() {
        return switch (rand.nextInt(4)) {
            case 0 -> new RationalBehaviour();
            case 1 -> new AggresiveBehaviour();
            case 2 -> new CautiousBehaviour();
            default -> new UnstableBehaviour();
        };
    }
}
