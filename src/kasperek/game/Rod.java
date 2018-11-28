package kasperek.game;

import java.util.Deque;
import java.util.List;

/**
 * @author Tomasz Kasperek
 * @version 0.1 11/27/2018
 * @since 0.1
 */

public class Rod {
    private List<Deque<Disk>> ringsOnStake;
    private String name;

    public Rod(List<Deque<Disk>> ringsOnStake, String name) {
        this.ringsOnStake = ringsOnStake;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}