/**
 * 
 * @author Alex Perinetti
 *
 */
public class ClockNode {
    protected Clock data;
    protected ClockNode next;
    /**
     * Creates a new node with the data set to the Clock c
     * @param c Clock object
     */
    public ClockNode (Clock c) {
        data = c;
    }
}
