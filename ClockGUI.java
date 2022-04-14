/**
 * @author Alex Perinetti
 * A class that creates the GUI to display a SortedClockList and an UnsortedClockList
 */
import java.awt.*;
import java.util.*;

import javax.swing.*;

public class ClockGUI {
    private JFrame frame;
    private TextArea sort = new TextArea();
    private TextArea unsort = new TextArea();
    //These member variables will allow to search these lists in the EditMenuHandler
    public TreeMap<Clock, String> sortedList;
    public UnsortedClockList unsortedList;
    /**
     * Creates the base GUI to display at the start
     */
    public ClockGUI() {
        //Creates the JFrame.
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create JMenu
        JMenuBar bar = new JMenuBar();
        frame.setJMenuBar(bar);
        JMenu fileMenu = new JMenu("file");
        bar.add(fileMenu);
        JMenu editMenu = new JMenu("edit");
        bar.add(editMenu);
        
        //Adds FileMenuHandler to JMenuItems
        FileMenuHandler fmh = new FileMenuHandler(this);
        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(fmh);
        fileMenu.add(openItem);
        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(fmh);
        fileMenu.add(quitItem);
        
        //Adds EditMenuHandler to the search item
        EditMenuHandler emh = new EditMenuHandler(this);
        JMenuItem searchItem = new JMenuItem("Search");
        searchItem.addActionListener(emh);
        editMenu.add(searchItem);
        
        //Display
        frame.setVisible(true);
        frame.setSize(400, 400);
        
        //sets textareas to the gui so that they can be manipulated later
        //without declaring new ones. This makes sure that there are only two textareas.
        frame.setLayout(new GridLayout(1,2));
        Container con = frame.getContentPane();
        con.add(unsort);
        con.add(sort);
    }
    /**
     * Displays the two ClockLists on the JFrame
     * @param sorted TreeMap for sorted list of Clocks
     * @param unsorted UnsortedClockList object
     */
    public void display (TreeMap<Clock, String> sorted, UnsortedClockList unsorted) {
        //Resets the content of
        unsort.setText("");
        sort.setText("");
        
        unsort.append("Unsorted List:\n");
        sort.append("Sorted List:\n");
        
        ClockNode un = unsorted.first.next;
        while (un != null) { //Adds the string data from the nodes of unsortedList
            unsort.append(un.data.toString() + "\n");
            un = un.next;
        }
        
        //Adds the string data from the tree map
        Set<Clock> set = sorted.keySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Clock key = (Clock)i.next();
            sort.append(key.toString() + "\n");
        }
        
        frame.setVisible(true);
        frame.setSize(400, 400);
    }
    /**
     * This sets the member variables separated form the display function, which will allow the
     * edit handler to access them and display without changing the lists themselves. This will
     * allow for multiple searches using the same lists.
     * @param sorted
     * @param unsorted
     */
    public void setLists (TreeMap<Clock, String> sorted, UnsortedClockList unsorted) {
        sortedList = sorted;
        unsortedList = unsorted;
    }
}
