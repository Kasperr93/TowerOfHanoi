package kasperek.solution;

import kasperek.utils.ConsoleInterfaces;

/**
 * @author Tomasz Kasperek
 * @version 1.0 12/07/2018
 * @since 1.0
 */

public class GameSolution {
    private int steps = 0;

    public void solveHanoi(int disk, String rodStart, String rodEnd, String auxiliaryRod) {
        if (disk > 0) {
            solveHanoi(disk - 1, rodStart, auxiliaryRod, rodEnd);
            ConsoleInterfaces.gameSolutionScreen(rodStart, rodEnd);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.getMessage();
            }

            solveHanoi(disk - 1, auxiliaryRod, rodEnd, rodStart);
            steps++;
        }
    }

    public void showSolveResult() {
        ConsoleInterfaces.showResultGame(steps);
    }
}