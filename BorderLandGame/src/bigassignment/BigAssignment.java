/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bigassignment;

/**
 *
 * @author ntsin
 */
public class BigAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        BorderlandManager manager = new BorderlandManager();
        manager.read("players.txt", "games.txt", "arena.txt");
        manager.runGameLoop();
    }
}


