package kasperek.game.test;

import kasperek.game.Disk;
import kasperek.game.GameLogic;
import kasperek.game.Rod;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Tomasz Kasperek
 * @version 1.0.1 04/16/2019
 * @see GameLogic
 * @since 1.0
 */

public class GameLogicTest {
    private static Rod[] rods;
    private static GameLogic game;

    /**
     * The method is responsibility for the prepare tests.
     */

    @BeforeClass
    public static void setUpBeforeClass() {
        rods = new Rod[3];
        rods[0] = new Rod("Rod A", new Stack<>());
        rods[1] = new Rod("Rod B", new Stack<>());
        rods[2] = new Rod("Rod C", new Stack<>());

        rods[0].getDisks().add(new Disk(3));
        rods[0].getDisks().add(new Disk(2));
        rods[0].getDisks().add(new Disk(1));

        game = new GameLogic();
    }

    /**
     * The method is responsibility for clearing all data after each test.
     */

    @Before
    public void setUpBeforeTest() {
        rods[0] = new Rod("Rod A", new Stack<>());
        rods[1] = new Rod("Rod B", new Stack<>());
        rods[2] = new Rod("Rod C", new Stack<>());

        rods[0].getDisks().add(new Disk(3));
        rods[0].getDisks().add(new Disk(2));
        rods[0].getDisks().add(new Disk(1));

        game = new GameLogic();
    }

    /**
     * Test <code>shouldGenerateGame</code> checks that the game was created.
     */

    @Test
    public void shouldGenerateGame() {

        // When
        game.generateGame(1);

        // Then
        assertNotNull(game);
    }

    /**
     * Test <code>shouldMoveDiskToAntherRod</code> checks that the rod was moved.
     */

    @Test
    public void shouldMoveDiskToAntherRod() {

        // Given
        game.generateGame(3);
        game.setRods(rods);

        // When
        game.doSelectedMove(rods[0], rods[2]);

        // Then
        assertEquals(2, rods[0].getDisks().size());
        assertEquals(0, rods[1].getDisks().size());
        assertEquals(1, rods[2].getDisks().size());
    }

    /**
     * Test <code>shouldCheckRodIsEmpty</code> checks that the rod is empty.
     */

    @Test
    public void shouldCheckRodIsEmpty() {

        // Given
        final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

        game.setRods(rods);

        System.setErr(new PrintStream(errContent));


        // When
        game.doSelectedMove(rods[2], rods[1]);

        // Then
        assertEquals(3, rods[0].getDisks().size());
        assertEquals(0, rods[1].getDisks().size());
        assertEquals(0, rods[2].getDisks().size());
        assertEquals("\nThe rod is empty. Try again.\n\n", errContent.toString());
    }

    /**
     * Test <code>shouldDisallowMoveBiggerDiskToSmaller</code> checks that the validator disallow the not allowed move.
     */

    @Test
    public void shouldDisallowMoveBiggerDiskToSmaller() {

        // Given
        final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

        game.setRods(rods);

        System.setErr(new PrintStream(errContent));

        // When
        game.doSelectedMove(rods[0], rods[1]);
        game.doSelectedMove(rods[0], rods[1]);

        // Then
        assertEquals(2, rods[0].getDisks().size());
        assertEquals(1, rods[1].getDisks().size());
        assertEquals(0, rods[2].getDisks().size());
        assertEquals("\nThe move isn't allowed. Try again.\n", errContent.toString());
    }
}