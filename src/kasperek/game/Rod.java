package kasperek.game;

import kasperek.utils.Utils;

import java.util.Stack;

/**
 * @author Tomasz Kasperek
 * @version 1.0 12/12/2018
 * @since 0.1
 */

public class Rod {
    private String name;
    private Stack<Disk> disks;

    /**
     * @param name  sets up a rod name.
     * @param disks sets up disks on a rod.
     */

    public Rod(String name, Stack<Disk> disks) {
        this.name = name;
        this.disks = disks;
    }

    /**
     * @return gets disks form a rod.
     */

    public Stack<Disk> getDisks() {
        return disks;
    }

    /**
     * Override toString, who return personalized String with rods list.
     *
     * @return rods list.
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" |- ");

        for (int i = 0; i < this.getDisks().size(); i++) {
            sb.append(this.disks.get(i).getSize()).append(" - ");
        }

        return Utils.removeLastSeparator(sb, "-");
    }
}