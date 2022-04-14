/**
 * @author Alex Perinetti
 * ActionListener to display only certain elements of the chosen file
 */

import java.awt.event.*;
import java.util.*;

import javax.swing.JOptionPane;

public class EditMenuHandler implements ActionListener{
    ClockGUI gui;
    
    public EditMenuHandler (ClockGUI gui) {
        this.gui = gui;
    }
    
    public void actionPerformed (ActionEvent e) {
        //Gets the correct valid for hours
        int h = 0;
        boolean valid = false;
        while (!valid) {
            h = Integer.parseInt(JOptionPane.showInputDialog("Enter a valid value for hours (0-23):"));
            if (h >= 0 && h <= 23)
                valid = true;
        }
        
        //Gets the lists from the gui object
        TreeMap<Clock, String> sort = gui.sortedList;
        UnsortedClockList unsort = gui.unsortedList;
        
        //Creates empty lists to store new data
        TreeMap<Clock, String> newSort = new TreeMap<Clock, String>(new ClockComparator());
        UnsortedClockList newUnsort = new UnsortedClockList();
        
        //Adds the Clocks with the correct hour values to the new unsorted list
        ClockNode node = unsort.first.next;
        while (node != null) {
            if (node.data.getHours() <= h)
                newUnsort.append(node.data);
            node = node.next;
        }
        
        Set<Clock> set = sort.keySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Clock key = (Clock)i.next();
            if (key.getHours() <= h)
                newSort.put(key, key.toString());
        }
        
        gui.display(newSort, newUnsort);
    }
}
