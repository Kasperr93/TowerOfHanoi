package kasperek.solution;

import kasperek.utils.ConsoleInterfaces;

/**
 * @author Tomasz Kasperek
 * @version 1.1 12/12/2018
 * @since 1.0
 */

public class GameSolution {
    private int steps = 0;

    /**
     * The method is responsible for solve the Tower of Hanoi via recurrence and displaying step by step each move.
     *
     * @param disk         a number of disk to solve.
     * @param rodStart     from which rod a player have to move a disk.
     * @param rodEnd       to which rod a player have to move a disk.
     * @param auxiliaryRod auxiliary rod.
     */

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

    /**
     * The method displaying result after solve the Hanoi puzzle.
     */

    public void getSolutionResult() {
        ConsoleInterfaces.getGameResult(steps);
    }
}