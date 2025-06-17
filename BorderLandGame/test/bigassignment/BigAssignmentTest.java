/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package bigassignment;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.util.*;

/**
 *
 * @author ntsin
 */
public class BigAssignmentTest {
    
    private BorderlandManager manager;
    private File playersFile;
    private File gamesFile;
    private File arenaFile;

    @Before
    public void setUp() {
        playersFile = new File("players.txt");
        gamesFile = new File("games.txt");
        arenaFile = new File("arena.txt");

        manager = new BorderlandManager();
        manager.read(playersFile.getPath(), gamesFile.getPath(), arenaFile.getPath());
    }

    @Test
    public void testPlayerReading() {
        List<Player> players = manager.getPlayers();
        assertEquals(3, players.size());
        assertEquals("Maksud", players.get(0).getName());
        assertEquals(7, players.get(0).getMentalStat());
        assertEquals(5, players.get(0).getPhysicalStat());
    }

    @Test
    public void testArenaReading() {
        Arena arena = manager.getArena();
        assertNotNull(arena);
        assertEquals("Abandoned_Theme_Park", arena.getName()); 
    }

    @Test
    public void testGameReading() {
        List<Game> games = manager.getGames();
        assertFalse(games.isEmpty());
        assertEquals(games.get(0).getName(), "Bridge_Puzzle");
        assertEquals(games.get(0).getDifficultyLevel(), 6);
    }

    @Test
    public void testHazard() {
        Arena arena = manager.getArena();
        ArrayList<Player> players = manager.getPlayers();
        for (Game game : arena.getGames()) {
            for (Player player : players) {
                game.addPlayer(player);
            }
        }

        arena.activateHazard();
        assertEquals(manager.getPlayers().get(0).getFearLevel(), 3);
    }
    
    @Test
    public void testGame() {
        manager.getPlayers().get(0).setFearLevel(10);
        manager.getPlayers().get(1).setFearLevel(12);
        manager.getPlayers().get(2).setFearLevel(11);
        assertTrue(manager.isGameOver());
    }
    
    @Test
    public void testRunGameLoop() {
        manager.runGameLoop();

        assertTrue(manager.isGameOver());
    }

    
    @Test
    public void testGameOverCollectecd() {
        for (int i = 1; i <= 52; i++) {
            manager.getPlayers().get(0).addCard(new Card(1, i));
        }
        assertTrue(manager.isGameOver());
    }
    
    @Test
    public void testRandomGameSelection() {
        Arena arena = manager.getArena();
        GameMaster master = new GameMaster(arena);
        Game testGame = master.pickNextGame();
        assertNotNull(testGame);
        assertTrue(arena.getGames().contains(testGame));
    }
    
    @Test
    public void testTradeCardSuccess() {
        Player p1 = manager.getPlayers().get(0);
        Player p2 = manager.getPlayers().get(1);

        Card card = new Card(1, 1);
        p1.addCard(card);
        int t1 = p1.getTrust(), t2 = p2.getTrust();

        assertTrue(p1.tradeCardTo(p2, card));

        assertFalse(p1.getCards().contains(card));
        assertTrue(p2.getCards().contains(card));
        assertEquals(t1 + 10, p1.getTrust());
        assertEquals(t2 + 10, p2.getTrust());
    }
    
    @Test
    public void testRationalBehaviour() {
        Player p = new Player("p", 5, 5, 5, 10, 50, new RationalBehaviour());
        Behaviour b = p.getBehaviour();

        p.setFearLevel(5);
        b.fearChange(p, true);
        assertEquals(4, p.getFearLevel());

        b.fearChange(p, false);
        assertEquals(5, p.getFearLevel());

        assertTrue(b.playsGame(new MentalGame("g",  6), p));
        assertTrue(b.playsGame(new PhysicalGame("g", 6), p));
    }
    
     @Test
    public void testCheckBetrayal() {
        Player p = manager.getPlayers().get(0);
        p.setTrust(10);
        p.setFearLevel(2);
        p.setBehaviour(new RationalBehaviour());
        p.checkBetrayal();

        assertEquals(9, p.getFearLevel());
        assertTrue(p.getBehaviour() instanceof UnstableBehaviour);
    }

    @Test
    public void testBehaviourWillPlay() {
        Player p = manager.getPlayers().get(0);
        Behaviour r = new RationalBehaviour();
        Behaviour a = new AggresiveBehaviour();

        Game g1 = new MentalGame("mental", 1);
        Game g2 = new PhysicalGame("physical", 100);

        assertTrue(r.playsGame(g1, p));
        assertTrue(a.playsGame(g2, p));
       
    }

    
}
