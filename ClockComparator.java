/**
 * @author Alex Perinetti
 * A class that implements comparator to compare two Clocks for a tree map of Clocks.
 */
import java.util.*;

public class ClockComparator implements Comparator<Clock>{
    /**
     * Comparator for a tree map of clocks
     * @param c1 Clock object
     * @param c2 Clock object
     */
    public int compare (Clock c1, Clock c2) {
        return c1.compareTo(c2);
    }
}
