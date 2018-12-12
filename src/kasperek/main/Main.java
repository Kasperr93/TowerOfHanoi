package kasperek.main;

import kasperek.game.GameLogic;
import kasperek.solution.GameSolution;
import kasperek.utils.ConsoleInterfaces;

/**
 * @author Tomasz Kasperek
 * @version 1.0.1 12/12/2018
 * @since 0.1
 */

public class Main {

    public static void main(String[] args) {
        GameLogic game = new GameLogic();
        GameSolution solution;

        var userChoice = ConsoleInterfaces.welcomeScreen();

        switch (userChoice) {
            case "1":
                game.generateGame(ConsoleInterfaces.getNumbersDisk());

                while (!game.endGame()) {
                    game.doSelectedMove(game.readSourceRod(), game.readDestinationRod());
                }

                ConsoleInterfaces.playAgain();
                break;
            case "2":
                ConsoleInterfaces.gameRulesScreen();
                break;
            case "3":
                ConsoleInterfaces.legendOfHanoiScreen();
                break;
            case "4":
                solution = new GameSolution();
                solution.solveHanoi(ConsoleInterfaces.getNumbersDisk(), "A", "B", "C");
                solution.getSolutionResult();

                ConsoleInterfaces.playAgain();
                break;
        }
    }
}