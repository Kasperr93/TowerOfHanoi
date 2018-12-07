package kasperek.utils;

import kasperek.game.Rod;
import kasperek.main.Main;

/**
 * @author Tomasz Kasperek
 * @version 1.1.1 12/07/2018
 * @since 0.1
 */

public class ConsoleInterfaces {
    public static String welcomeScreen() {
        System.out.println("\033[1m\nHey! Let's play on Tower of Hanoi!\033[0m");
        System.out.println("\nType:");
        System.out.println("\033[1m1\033[0m - If you knows the game rules and you want to start the game;");
        System.out.println("\033[1m2\033[0m - If you want to knows the game rules;");
        System.out.println("\033[1m3\033[0m - If you want to knows the Hanoi legend;");
        System.out.println("\033[1m4\033[0m - If you want to see how to solution Tower of Hanoi;");
        System.out.println("\"\033[1mq\033[0m\" - If you want exit the program.\n");

        var userChoice = Utils.readLine();

        while (!Utils.validateUserValue(userChoice)) {
            System.err.println("\nInvalid value. Try again.\n");
            userChoice = Utils.readLine();
        }

        return userChoice;
    }

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

    public static void hanoiLegendScreen() {
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

    public static void gameSolutionScreen(String fromRod, String toRod) {
        System.out.println("\nFrom \033[1mRod " + fromRod + "\033[0m" + " move to " + "\033[1mRod " + toRod + "\033[0m" + ".");
    }

    public static int howManyDisk() {
        System.out.println("\nHow many disks do you want to solve?\n");
        var choice = Utils.readLine();
        var correctValue = false;

        while (!correctValue) {
            if (!Utils.isNumber(choice)) {
                System.err.println("\nThis is not a number. Try again\n");
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

    public static void displayGame(Rod[] rods) {
        System.out.println();

        for (Rod rod : rods) {
            System.out.println(rod.toString());
        }

        System.out.println();
    }

    public static int getFirstMove() {
        System.out.println("From which rod do you wanna move to the disk?");
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

    public static int getSecondMove() {
        System.out.println("\nTo which rod do you wanna move to the disk?");
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

    public static void rodIsEmpty() {
        System.err.println("\nThe rod is empty. Try again.\n");
    }

    public static void notAllowedMove() {
        System.err.println("\nThe move isn't allowed. Try again.");
    }

    public static void showResultGame(int steps) {
        System.out.println("\nCongratulations! You end the Tower of Hanoi. You needed a " + steps + " steps to solve " +
                "the Hanoi puzzle. \nMaybe you have to start again with more number of puzzles? :)\n");
    }

    public static void againGame() {
        System.out.println("Do you want start again?");
        System.out.println("Type:\n1 - if you want start again;\n\"q\" - if you want exit the program.\n");

        var userChoice = Utils.readLine();
        var correctValue = false;

        while (!correctValue) {
            if (userChoice.equalsIgnoreCase("q"))
                System.exit(0);
            else if (userChoice.equals("1")) {
                correctValue = true;
                Main.main(null);
            } else {
                System.err.println("\nInvalid value. Try again.\n");
                userChoice = Utils.readLine();
            }
        }
    }
}