package kasperek.game;

/**
 * @author Tomasz Kasperek
 * @version 1.0.1 03/13/2019
 * @since 0.1
 */

public class Disk {
    private int size;

    /**
     * @param size sets up a disk size.
     */

    public Disk(int size) {
        this.size = size;
    }

    /**
     * @return gets a disk size.
     */

    int getSize() {
        return size;
    }


    /**
     * Override toString, who return personalized String with a disk size.
     *
     * @return a disk size.
     */

    @Override
    public String toString() {
        return "Disk size: " + size;
    }
}