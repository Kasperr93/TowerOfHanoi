package kasperek.utils;

import kasperek.game.Rod;

/**
 * @author Tomasz Kasperek
 * @version 1.0 11/29/2018
 * @since 0.1
 */

public class ConsoleInterfaces {
    public static void welcomeScreen() {
        System.out.println("\033[1mHey! Let's play on Tower of Hanoi!\033[0m");
        System.out.println("\nPress:");
        System.out.println("\033[1m1\033[0m - If you knows the game rules and you want to start the game;");
        System.out.println("\033[1m2\033[0m - If you want to knows the game rules;");
        System.out.println("\033[1m3\033[0m - If you want see how to solution Tower of Hanoi;");
        System.out.println("\"\033[1mq\033[0m\" - If you want exit the program.\n");
    }

    public static void gameRulesScreen() {
        System.out.println("The Towers of Hanoi is an ancient puzzle played with three stacks and any number of " +
                "differently-sized disks.\nAt the start, all the disks are in the leftmost stack, with the largest " +
                "disk on the bottom and the smallest on the top.\nThe object is to get all the disks over " +
                "to the rightmost stack.\n");
        System.out.println("You can only move one disk per move, and you can only move the top disk on a stack.\n" +
                "The top disk of any stack can be moved to the top disk of any other stack, \nwith the restriction " +
                "that you can't move a larger disk on top of a smaller disk \n-- i.e., " +
                "disks can only be moved to empty stacks or on top of larger disks.\n");

        System.out.println("\033[1mPress 1 to back to the main menu.\033[0m\n");
    }

    public static void hanoiLegendScreen() {
        System.out.println("According to the legend of the Tower of Hanoi (originally the \"Tower of Brahma\" " +
                "in a temple in the Indian city of Benares), \nthe temple priests are to transfer " +
                "a tower consisting of 64 fragile disks of gold from one part of the temple to another, " +
                "one disk at a time. \nThe disks are arranged in order, no two of them the same size, " +
                "with the largest on the bottom and the smallest on top. \nBecause of their fragility, " +
                "a larger disk may never be placed on a smaller one, \nand there is only one intermediate " +
                "location where disks can be temporarily placed. \nIt is said that before the priests complete " +
                "their task the temple will crumble into dust and the world will vanish in a clap of thunder.\n");

        System.out.println("\033[1mPress 1 to back to the main menu.\033[0m\n");
    }

    public static void gameSolutionScreen(String fromRod, String toRod) {
        System.out.println("\033[1m" + fromRod + "\033[0m" + " move to " + "\033[1m" + toRod + "\033[0m" + ".");
    }

    public static void displayGame(Rod[] rods) {
        for (Rod rod : rods) {
            System.out.println(rod.toString());
        }

        System.out.println();
    }
}