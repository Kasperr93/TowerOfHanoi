package kasperek.tests;

import kasperek.game.GameLogic;
import kasperek.utils.ConsoleInterfaces;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameLogicTest {

    @Test
    public void shouldGenerateGame() {
        GameLogic gl = new GameLogic();
        gl.generateGame(3);


//        ConsoleInterfaces.welcomeScreen();
//        ConsoleInterfaces.gameRulesScreen();
//        ConsoleInterfaces.hanoiLegendScreen();
//        ConsoleInterfaces.gameSolutionScreen("Rod A", "Rod B");
//        ConsoleInterfaces.showResultGame(30);
    }
}