package kasperek.game;

import kasperek.utils.ConsoleInterfaces;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Tomasz Kasperek
 * @version 1.1.2 01/18/2018
 * @see Disk
 * @see Rod
 * @see ConsoleInterfaces
 * @see kasperek.utils.Utils
 * @since 0.1
 */

public class GameLogic {
    private Rod[] rods;
    private int steps;

    /**
     * The constructor which initializes table of Rod[] and the counter.
     */

    public GameLogic() {
        rods = new Rod[3];
        steps = 0;
    }

    public void setRods(Rod[] rods) {
        this.rods = rods;
    }

    /**
     * The method generating rods and disks for the game.
     *
     * @param numberOfDisk how many disks a player will want to resolve.
     */

    public void generateGame(int numberOfDisk) {
        rods[0] = new Rod("Rod A", new Stack<>());
        rods[1] = new Rod("Rod B", new Stack<>());
        rods[2] = new Rod("Rod C", new Stack<>());

        for (int i = numberOfDisk; i > 0; i--) {
            rods[0].getDisks().add(new Disk(i));
        }

        ConsoleInterfaces.displayGameOnConsole(rods);
    }

    /**
     * The method is responsible for gets a rod from which disk will be moved.
     *
     * @return the rod from which a player want to move.
     */

    public Rod readSourceRod() {
        var rodNumber = ConsoleInterfaces.getFirstMove();
        return rods[rodNumber - 1];
    }

    /**
     * The method is responsible for gets a rod to which disk will be moved.
     *
     * @return the rod to which a player want to move.
     */

    public Rod readDestinationRod() {
        var rodNumber = ConsoleInterfaces.getSecondMove();
        return rods[rodNumber - 1];
    }

    /**
     * The method is responsible for move a disk from one rod to another and increases the counter by one.
     *
     * @param fromRod the rod from which the disk will be moved.
     * @param toRod   the rod to which the disk will be moved.
     */

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

    /**
     * The method check that the game is over. When the game is over, the method displaying result, when user resolved
     * the puzzle.
     *
     * @return boolean value, which ending the game in Main method.
     */

    public boolean endGame() {
        if (rods[0].getDisks().isEmpty() && rods[1].getDisks().isEmpty()) {
            ConsoleInterfaces.getGameResult(steps);
            return true;
        }

        return false;
    }
}