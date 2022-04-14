/**
 * 
 * @author Alex Perinetti
 * An abstract class that points to the first and last objects of a list of ClockNodes.
 */
public abstract class ClockList {
    protected ClockNode first;
    protected ClockNode last;
    protected int length;
    /**
     * Constructor that creates a list with one empty node
     */
    public ClockList () {
        first = new ClockNode(null);
        last = first;
        length = 0;
    }
    /**
     * Adds one ClockNode to the end of the list
     * @param c Clock object
     */
    public void append (Clock c) {
        ClockNode cn = new ClockNode(c);
        last.next = cn;
        last = cn;
        length++;
    }
    
}
