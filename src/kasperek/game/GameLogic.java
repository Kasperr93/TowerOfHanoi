package kasperek.game;

import kasperek.utils.ConsoleInterfaces;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Tomasz Kasperek
 * @version 0.9 12/05/2018
 * @since 0.1
 */

public class GameLogic {
    private Rod[] rods = new Rod[3];
    private int steps = 0;

    public void generateGame(int numberOfDisk) {
        rods[0] = new Rod("Rod A", new Stack<>());
        rods[1] = new Rod("Rod B", new Stack<>());
        rods[2] = new Rod("Rod C", new Stack<>());

        for (int i = numberOfDisk; i > 0; i--) {
            rods[0].getDisks().add(new Disk(i));
        }

        ConsoleInterfaces.displayGame(rods);
    }

    public Rod firstStep() {
        var rodNumber = ConsoleInterfaces.getFirstMove();
        return rods[rodNumber - 1];
    }

    public Rod secondStep() {
        var rodNumber = ConsoleInterfaces.getSecondMove();
        return rods[rodNumber - 1];
    }

    public void doTheSelectMove(Rod fromRod, Rod toRod) {
        var fromDiskSize = 0;
        int toDiskSize;

        try {
            fromDiskSize = fromRod.getDisks().peek().getSize();
        } catch (EmptyStackException e) {
            ConsoleInterfaces.rodIsEmpty();
            doTheSelectMove(firstStep(), secondStep());
        }

        try {
            toDiskSize = toRod.getDisks().peek().getSize();
        } catch (EmptyStackException e) {
            toDiskSize = 0;
        }


        if (fromDiskSize < toDiskSize || toDiskSize == 0) {
            Disk movedDisk = fromRod.getDisks().pop();
            toRod.getDisks().push(movedDisk);

            steps++;
        } else {
            ConsoleInterfaces.notAllowedMove();
        }

        ConsoleInterfaces.displayGame(rods);
    }

    public boolean endGame() {
        if (rods[0].getDisks().isEmpty() && rods[1].getDisks().isEmpty()) {
            ConsoleInterfaces.showResultGame(steps);
            return true;
        }

        return false;
    }
}