/**
 * 
 * @author Alex Perinetti
 * Class that points to the first and last objects of an unsorted linked list of ClockNodes
 */
public class UnsortedClockList extends ClockList {
    /**
     * Calls super constructor
     */
    public UnsortedClockList () {
        super();
    }
    /**
     * Calls append from super class
     * @param c Clock object to be part of the data of the added ClockNode.
     */
    public void add (Clock c) {
        append(c);
    }
}
