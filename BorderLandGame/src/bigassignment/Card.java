/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bigassignment;

/**
 *
 * @author ntsin
 */
public class Card {
    private int suit;
    private int number;
    
    /**
     *
     * @param s
     * @param n
     */
    public Card(int s, int n){
        this.number = n;
        this.suit = s;
    }
    
    /**
     *
     * @return
     */
    public int getNumber() {
        return this.number;
    }
    
    /**
     *
     * @return
     */
    public int getSuit() {
        return this.suit;
    }
    
    /**
     *
     * @param n
     */
    public void getNumber(int n) {
        this.number=n;
    }

    /**
     *
     * @param s
     */
    public void getSuit(int s) {
        this.suit = s;
    }
}
