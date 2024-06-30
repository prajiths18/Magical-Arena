
// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
public class Magical_Arena_Unit_Test_Case {
    private static  Player playerA;
    private static Player playerB;
    public static void MatchBegin() {
        setUp();
        testPlayerInitialization();
        testAttackAndDefense();
        testTurnBasedAttack();
        testPlayerDeath();

    }
    
    //@BeforeEach
    public static void setUp() {
        playerA = new Player("Player A", 50, 5, 10);
        playerB = new Player("Player B", 100, 10, 5);
    }

    //@Test
    public static void testPlayerInitialization() {
        assertEquals("Player A", playerA.getName());
        assertEquals(50, playerA.getHealth());
        assertEquals(5, playerA.getStrength());
        assertEquals(10, playerA.getAttack());
        
        assertEquals("Player B", playerB.getName());
        assertEquals(100, playerB.getHealth());
        assertEquals(10, playerB.getStrength());
        assertEquals(5, playerB.getAttack());
    }

    //@Test
    public static void testAttackAndDefense() {
        playerA.setFixedAttackRoll(4);
        playerB.setFixedDefenseRoll(6);

        playerA.attack(playerB);
        
        assertEquals(100, playerB.getHealth());
    }

   // @Test
    public static void testTurnBasedAttack() {
        playerA.setFixedAttackRoll(5);
        playerB.setFixedDefenseRoll(2);
        playerA.attack(playerB);

        playerB.setFixedAttackRoll(4);
        playerA.setFixedDefenseRoll(3);
        playerB.attack(playerA);
        
        assertEquals(70, playerB.getHealth());
        assertEquals(45, playerA.getHealth());
    }

 //   @Test
    public static void testPlayerDeath() {
        playerA.setFixedAttackRoll(6);
        playerB.setFixedDefenseRoll(1);

        while (playerB.isAlive()) {
            playerA.attack(playerB);
        }
        
        assertFalse(playerB.isAlive());
        assertEquals(-30, playerB.getHealth());
        System.out.printf("%s wins the match!%n", playerA.isAlive() ? playerA.getName() : playerB.getName());
    }
}