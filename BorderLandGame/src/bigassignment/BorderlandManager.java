/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bigassignment;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author ntsin
 */
public class BorderlandManager {
    private ArrayList<Player> players = new ArrayList<>();
    private Arena arena;
    private ArrayList<Game> games = new ArrayList<>();
    private ArrayList<Card> allCards = new ArrayList<>();

    /**
     * Combines the three reading methods
     * @param playersFile
     * @param gamesFile
     * @param arenaFile
     */
    public void read(String playersFile, String gamesFile, String arenaFile) {
        readPlayers(playersFile);
        readArena(arenaFile);
        readGames(gamesFile);
        
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     *
     * @return
     */
    public ArrayList<Game> getGames() {
        return games;
    }

    /**
     *
     * @return
     */
    public Arena getArena() {
        return arena;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Card> getCards() {
        return allCards;
    }

    /**
     * Reading player logic
     * 
     */
    private void readPlayers(String fileName) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while (scanner.hasNext()) {
                String name = scanner.next();
                int mental = scanner.nextInt();
                int physical = scanner.nextInt();
                Behaviour b = Behaviour.randomBehaviour();
                players.add(new Player(name, mental, physical, 0, 10, 100, b));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading players file: " + e.getMessage());
        }
    }
    
    
    /**
     * Reading games logic
     * 
     */
    private void readGames(String fileName) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while (scanner.hasNext()) {
                String name = scanner.next();
                String type = scanner.next().toLowerCase();
                int difficulty = scanner.nextInt();

                Game game = switch (type) {
                    case "mental" -> new MentalGame(name, difficulty);
                    case "physical" -> new PhysicalGame(name, difficulty);
                    default -> throw new IllegalStateException("Ilegal game type in input : " + type);
                };

                games.add(game);
                if (arena != null) arena.addGame(game);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading games file: " + e.getMessage());
        }
    }
    
    /**
     * Reading arena logic
     * 
     */
    private void readArena(String fileName) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            String name = scanner.next();
            String hazard = scanner.next();
            arena = new Arena(name, hazard);
        } catch (FileNotFoundException e) {
            System.err.println("Error reading arena file: " + e.getMessage());
        }
    }
    
    /**
     * Seting up deck logic
     */
    public void setupDecks() {
        int numDecks = players.size() / 2;

        for (int i = 0; i < numDecks; i++) {
            for (int j = 1; j <=4; j++) {
                for (int k = 1; k <= 13; k++) {
                    allCards.add(new Card(j, k));
                }
            }
        }
    }
    
    /**
     * Logic for giving random cards to palyers
     * @param player
     */
    public void giveRandomCard(Player player) {
        if (allCards.isEmpty()) {
            return;
        }

        Card card = allCards.remove(0);  
        player.addCard(card);
    }

    /**
     * checking if games is finished
     * @return
     */
    public boolean isGameOver() {
        boolean allInactive = true;

        for (Player player : players) {
            if (player.getFearLevel() < 10) {
                allInactive = false;
            }
        }
        boolean noCardsLeft = allCards.isEmpty();
        if(allInactive){
            System.out.println("All players are inactive, game ends");
        }
        if(noCardsLeft){
            System.out.println("No more cards left, game ends");
        }
        return allInactive || noCardsLeft;
    }
    
    /**
     * game logic implemantation
     */
    public void runGameLoop() {
        if (allCards.isEmpty()) {
            setupDecks();
        }
        GameMaster master = new GameMaster(arena);
        int round = 1;
        while (!isGameOver()) {
            System.out.println("--- Round " + round + " ---");
            master.activateHazard();

            Game game = master.pickNextGame();
            if (game == null) break;
            
            game.players.clear();
            for (Player p : players) {
                if (p.getFearLevel() < 10 && !p.hasAllCards() && p.getBehaviour().playsGame(game, p))  {
                    game.addPlayer(p);
                    p.setTrust(p.getTrust() - 5);
                }
                p.checkBetrayal();
            }
            
            System.out.println("Playing: " + game.name);
            ArrayList<Player> winners = game.play(this);
            for (Player p : winners){
                p.setTrust(p.getTrust() + 10);
            }
            
            for (int i = 0; i + 1 < winners.size(); i ++) {
                Player p1 = winners.get(i);
                Player p2 = winners.get(i+1);
                if (!p1.getCards().isEmpty()) {
                    Card c = p1.getCards().get(0);
                    p1.tradeCardTo(p2, c);
                }
            }   

            System.out.println("Players after this round:");
            for (Player p : players) {
                System.out.println("  " + p);
            }
            round++; 
            System.out.println("Cards left=" + allCards.size());
            
            for (Player p : players) {
                if (p.hasAllCards()) {
                    System.out.println(p.getName() + " has escaped the Borderland!");
                }
            }
        }

        System.out.println("--- Game Over ---");
       
    }

}

