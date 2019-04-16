package kasperek.utils;

import kasperek.game.Rod;
import kasperek.main.Main;

/**
 * @author Tomasz Kasperek
 * @version 1.2.4 04/16/2019
 * @since 0.1
 */

public class ConsoleInterfaces {

    /**
     * The method is responsibility for display the welcome screen, gets the user choice and validate this value.
     *
     * @return the user selection.
     */

    public static String welcomeScreen() {
        System.out.println("\033[1m\nHey! Let's play on Tower of Hanoi!\033[0m");
        System.out.println("\nType:");
        System.out.println("\033[1m1\033[0m - If you know the game rules and you want to start the game;");
        System.out.println("\033[1m2\033[0m - If you want to know the game rules;");
        System.out.println("\033[1m3\033[0m - If you want to know the Hanoi legend;");
        System.out.println("\033[1m4\033[0m - If you want to see how to solution Tower of Hanoi;");
        System.out.println("\"\033[1mq\033[0m\" - If you want to exit the program.\n");

        var userChoice = Utils.readLine();

        while (!Utils.validateUserValue(userChoice)) {
            System.err.println("\nInvalid value. Try again.\n");
            userChoice = Utils.readLine();
        }

        return userChoice;
    }

    /**
     * The method display the rules of the game.
     */

    public static void gameRulesScreen() {
        System.out.println("\nThe Towers of Hanoi is an ancient puzzle played with three stacks and any number of " +
                "differently-sized disks.\nAt the start, all the disks are in the leftmost stack, with the largest " +
                "disk on the bottom and the smallest on the top.\nThe object is to get all the disks over " +
                "to the rightmost stack.\n");
        System.out.println("You can only move one disk per move, and you can only move the top disk on a stack.\n" +
                "The top disk of any stack can be moved to the top disk of any other stack, \nwith the restriction " +
                "that you can't move a larger disk on top of a smaller disk \n-- i.e., " +
                "disks can only be moved to empty stacks or on top of larger disks.\n");

        System.out.println("\033[1mType 1 to back to the main menu.\033[0m\n");

        while (!Utils.readLine().equals("1")) {
            System.err.println("\nInvalid value. Try again.\n");
        }

        Main.main(null);
    }

    /**
     * The method display the legend of the Tower of Hanoi.
     */

    public static void legendOfHanoiScreen() {
        System.out.println("\nAccording to the legend of the Tower of Hanoi (originally the \"Tower of Brahma\" " +
                "in a temple in the Indian city of Benares), \nthe temple priests are to transfer " +
                "a tower consisting of 64 fragile disks of gold from one part of the temple to another, " +
                "one disk at a time. \nThe disks are arranged in order, no two of them the same size, " +
                "with the largest on the bottom and the smallest on top. \nBecause of their fragility, " +
                "a larger disk may never be placed on a smaller one, \nand there is only one intermediate " +
                "location where disks can be temporarily placed. \nIt is said that before the priests complete " +
                "their task the temple will crumble into dust and the world will vanish in a clap of thunder.\n");

        System.out.println("\033[1mType 1 to back to the main menu.\033[0m\n");

        while (!Utils.readLine().equals("1")) {
            System.err.println("\nInvalid value. Try again.\n");
        }

        Main.main(null);
    }

    /**
     * The method display the solution, how to solve the Tower of Hanoi puzzle.
     *
     * @param fromRod from which rod the user have to move.
     * @param toRod   to which rod the user have to move.
     */

    public static void gameSolutionScreen(String fromRod, String toRod) {
        System.out.println("\nFrom \033[1mRod " + fromRod + "\033[0m" + " move to " + "\033[1mRod " + toRod + "\033[0m" + ".");
    }

    /**
     * The method is responsible for gets the number of disk to solve the Tower of Hanoi puzzle.
     *
     * @return number of disk to solve.
     */

    public static int getNumbersDisk() {
        System.out.println("\nHow many disks do you want to solve?\n");
        var choice = Utils.readLine();
        var correctValue = false;

        while (!correctValue) {
            if (!Utils.isNumber(choice)) {
                System.err.println("\nThis isn't a number. Try again\n");
                choice = Utils.readLine();
            } else if (!Utils.validateUserValue(Integer.valueOf(choice))) {
                System.err.println("\nThe number can't be less than 3.\n");
                choice = Utils.readLine();
            } else {
                correctValue = true;
            }
        }

        return Integer.valueOf(choice);
    }

    /**
     * The method is responsible for displays result after each step who will do the user.
     *
     * @param rods list of rods with disks.
     */

    public static void displayGameOnConsole(Rod[] rods) {
        System.out.println();

        for (Rod rod : rods) {
            System.out.println(rod.toString());
        }

        System.out.println();
    }

    /**
     * The method gets the move from the user, from which rod the user want to move the disk.
     *
     * @return rod number, from which user want to move the disk.
     */

    public static int getMove(boolean firstStep) {
        if (firstStep)
            System.out.println("From which rod do you want to move the disk?");
        else
            System.out.println("\nTo which rod do you want to move the disk?");
        System.out.println("Type 1, 2 or 3:\n");

        String userChoice = Utils.readLine();
        var correctValue = false;

        while (!correctValue) {
            if (!Utils.isNumber(userChoice)) {
                System.err.println("This isn't a number. Try again.\n");
                userChoice = Utils.readLine();
            } else if (Integer.valueOf(userChoice) < 1 || Integer.valueOf(userChoice) > 3) {
                System.err.println("The rod doesn't exist. Try again.\n");
                userChoice = Utils.readLine();
            } else {
                correctValue = true;
            }
        }

        return Integer.valueOf(userChoice);
    }

    /**
     * The method display the error in the console that the rod is empty.
     */

    public static void rodIsEmpty() {
        System.err.println("\nThe rod is empty. Try again.\n");
    }

    /**
     * The method display the error in the console that the move is not allowed.
     */

    public static void notAllowedMove() {
        System.err.println("\nThe move isn't allowed. Try again.\n");
    }

    /**
     * The method display summary of the game.
     *
     * @param steps how many steps did the user to solve the puzzle.
     */

    public static void getGameResult(int steps) {
        System.out.println("\nCongratulations! You ended the Tower of Hanoi. You needed " + steps + " steps to solve " +
                "the Hanoi puzzle. \nDo have you to start again with more number of puzzles? :)\n");
    }

    /**
     * The method display the question about the again game, gets the user choice and validate this value.
     */

    public static void playAgain() {
        System.out.println("Do you want to start again?");
        System.out.println("Type:\n1 - if you want to start again;\n\"q\" - if you want to exit the program.\n");

        var userChoice = Utils.readLine();
        var correctValue = false;

        while (!correctValue) {
            if (userChoice.equalsIgnoreCase("q"))
                Runtime.getRuntime().exit(0);
            else if (userChoice.equals("1")) {
                correctValue = true;
                Main.main(new String[0]);
            } else {
                System.err.println("\nInvalid value. Try again.\n");
                userChoice = Utils.readLine();
            }
        }
    }
}