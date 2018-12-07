package kasperek.main;

import kasperek.game.GameLogic;
import kasperek.solution.GameSolution;
import kasperek.utils.ConsoleInterfaces;

/**
 * @author Tomasz Kasperek
 * @version 1.0 12/07/2018
 * @since 0.1
 */

public class Main {

    public static void main(String[] args) {
        GameLogic game = new GameLogic();
        GameSolution solution;

        var choice = ConsoleInterfaces.welcomeScreen();

        switch (choice) {
            case "1":
                game.generateGame(ConsoleInterfaces.howManyDisk());

                while (!game.endGame()) {
                    game.doTheSelectMove(game.firstStep(), game.secondStep());
                }

                ConsoleInterfaces.againGame();
                break;
            case "2":
                ConsoleInterfaces.gameRulesScreen();
                break;
            case "3":
                ConsoleInterfaces.hanoiLegendScreen();
                break;
            case "4":
                solution = new GameSolution();
                solution.solveHanoi(ConsoleInterfaces.howManyDisk(), "A", "B", "C");
                solution.showSolveResult();

                ConsoleInterfaces.againGame();
                break;
        }
    }
}