package kasperek.game;

import java.util.Stack;

/**
 * @author Tomasz Kasperek
 * @version 0.2 11/28/2018
 * @since 0.1
 */

public class Rod {
    private String name;
    private Stack<Disk> disks;

    public Rod(String name, Stack<Disk> disks) {
        this.name = name;
        this.disks = disks;
    }

    public String getName() {
        return name;
    }


    public Stack<Disk> getDisks() {
        return disks;
    }

    @Override
    public String toString() {
        return "Rod name: " + name + ", Number of disk: " + disks.size() + " Disk list: " + disks.toString();
    }
}