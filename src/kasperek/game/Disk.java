package kasperek.game;

/**
 * @author Tomasz Kasperek
 * @version 0.2 11/28/2018
 * @since 0.1
 */

public class Disk {
    private int size;

    public Disk(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Disk size: " + size;
    }
}