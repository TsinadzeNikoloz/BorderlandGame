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
public class Player {
    private String name;
    private int mentalStat;
    private int physicalStat;
    private int fearLevel;
    private int stamina;
    private int trust;
    private Behaviour behaviour;
    private ArrayList<Card> cards;
    
    /**
     * COnstructor for Player
     * @param n
     * @param m
     * @param p
     * @param f
     * @param s
     * @param t
     * @param b
     */
    public Player(String n, int m, int p, int f, int s, int t, Behaviour b){
        this.name = n;
        this.mentalStat = m;
        this.physicalStat = p;
        this.fearLevel = f;
        this.stamina = s;
        this.trust = t;
        this.behaviour = b;
        this.cards = new ArrayList<>();
    }
    
    /**
     * Gets name
     * @return
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Sets name
     * @param n
     */
    public void setName(String n){
        this.name = n;
    }
    
    /**
     * gets mental stat
     * @return
     */
    public int getMentalStat(){
        return this.mentalStat;
    }
    
    /**
     *sets mental stat
     * @param m
     */
    public void setMentalStat(int m){
        this.mentalStat = m;
    }
    
    /**
     * gets physical stat
     * @return
     */
    public int getPhysicalStat(){
        return this.physicalStat;
    }
    
    /**
     * sets physical stat
     * @param p
     */
    public void setPhysicalStat(int p){
        this.physicalStat = p;
    }
    
    /**
     * gets fear level
     * @return
     */
    public int getFearLevel(){
        return this.fearLevel;
    }
    
    /**
     * sets fear level
     * @param f
     */
    public void setFearLevel(int f){
        this.fearLevel = f;
    }
    
    /**
     * gets stamina
     * @return
     */
    public int getStamina(){
        return this.stamina;
    }
    
    /**
     * sets stamina
     * @param s
     */
    public void setStamina(int s){
        this.stamina = s;
    }
    
    /**
     * gets trust
     * @return
     */
    public int getTrust(){
        return this.trust;
    }
    
    /**
     * sets trust
     * @param t
     */
    public void setTrust(int t){
        this.trust = t;
    }
    
    /**
     *
     * @return
     */
    public Behaviour getBehaviour() {
        return this.behaviour; 
    }
    
    /**
     *
     * @param b
     */
    public void setBehaviour(Behaviour b) {
        this.behaviour = b; 
    }
    /**
     * gets all cards
     * @return
     */
    public ArrayList<Card> getCards(){
        return this.cards;
    }

    /**
     * adds card to cards
     * @param c
     */
    public void addCard(Card c){
        this.cards.add(c);
    }
    
    /**
     *
     */
    public void checkBetrayal() {
        if (trust < 25) {
            this.setFearLevel(9);
            behaviour = new UnstableBehaviour();
        }
    }
    
    /**
     * checks if a player has all cards from deck
     * @return
     */
    public boolean hasAllCards() {
        return cards.size() == 52;
    }
    
    /**
     *
     * @param p
     * @param card
     * @return
     */
    public boolean tradeCardTo(Player p, Card card) {
        if (!cards.remove(card)) {
            return false;
        }
        p.cards.add(card);

        this.trust = this.trust + 10;
        p.setTrust(p.getTrust() + 10);
        return true;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", mentalStat=" + mentalStat + ", physicalStat=" + physicalStat + ", fearLevel=" + fearLevel + ", stamina= " + stamina + ",trust= " + trust +  ",Card amount=" + getCards().size() + '}';
    }

}
