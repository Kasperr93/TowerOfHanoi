package kasperek.game;

import kasperek.utils.ConsoleInterfaces;

import java.util.Stack;

/**
 * @author Tomasz Kasperek
 * @version 0.1 11/29/2018
 * @since 0.1
 */

public class GameLogic {
    private Rod[] rods = new Rod[3];

    public void generateGame(int numberOfDisk) {
        rods[0] = new Rod("Rod A", new Stack<>());
        rods[1] = new Rod("Rod B", new Stack<>());
        rods[2] = new Rod("Rod C", new Stack<>());

        for (int i = numberOfDisk; i > 0; i--) {
            rods[0].getDisks().add(new Disk(i));
        }

        ConsoleInterfaces.displayGame(rods);
    }


}