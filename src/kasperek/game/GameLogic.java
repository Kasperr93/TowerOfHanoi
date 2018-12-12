package kasperek.game;

import kasperek.utils.ConsoleInterfaces;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Tomasz Kasperek
 * @version 1.0.1 12/12/2018
 * @since 0.1
 */

public class GameLogic {
    private Rod[] rods;
    private int steps;

    public GameLogic() {
        rods = new Rod[3];
        steps = 0;
    }

    public void generateGame(int numberOfDisk) {
        rods[0] = new Rod("Rod A", new Stack<>());
        rods[1] = new Rod("Rod B", new Stack<>());
        rods[2] = new Rod("Rod C", new Stack<>());

        for (int i = numberOfDisk; i > 0; i--) {
            rods[0].getDisks().add(new Disk(i));
        }

        ConsoleInterfaces.displayGameOnConsole(rods);
    }

    public Rod readSourceRod() {
        var rodNumber = ConsoleInterfaces.getFirstMove();
        return rods[rodNumber - 1];
    }

    public Rod readDestinationRod() {
        var rodNumber = ConsoleInterfaces.getSecondMove();
        return rods[rodNumber - 1];
    }

    public void doSelectedMove(Rod fromRod, Rod toRod) {
        var fromDiskSize = 0;
        int toDiskSize;

        try {
            fromDiskSize = fromRod.getDisks().peek().getSize();
        } catch (EmptyStackException e) {
            ConsoleInterfaces.rodIsEmpty();
            return;
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

        ConsoleInterfaces.displayGameOnConsole(rods);
    }

    public boolean endGame() {
        if (rods[0].getDisks().isEmpty() && rods[1].getDisks().isEmpty()) {
            ConsoleInterfaces.getGameResult(steps);
            return true;
        }

        return false;
    }
}