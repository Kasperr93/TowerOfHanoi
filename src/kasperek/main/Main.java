package kasperek.main;

import kasperek.game.GameLogic;
import kasperek.utils.ConsoleInterfaces;

/**
 * @author Tomasz Kasperek
 * @version 0.9 12/05/2018
 * @since 0.1
 */

public class Main {

    public static void main(String[] args) {
        GameLogic game = new GameLogic();

        var choice = ConsoleInterfaces.welcomeScreen();

        switch (choice) {
            case "1":
                game.generateGame(ConsoleInterfaces.howManyDisk());

                while (!game.endGame()) {
                    game.doTheSelectMove(game.firstStep(), game.secondStep());
                }

                break;
            case "2":
                ConsoleInterfaces.gameRulesScreen();
                break;
            case "3":
                ConsoleInterfaces.hanoiLegendScreen();
                break;
            case "4":
//                game
                break;
        }
    }
}