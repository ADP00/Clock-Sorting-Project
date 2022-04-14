/**
 * @author Alex Perinetti
 * ActionListener to display the contents of the chosen file or quit the program
 */
import java.awt.event.*;
import java.io.File;
import java.util.*;

import javax.swing.*;

public class FileMenuHandler implements ActionListener {
    ClockGUI gui;
    /**
     * Takes in the ClockGUI object in order to display the file later.
     * @param gui ClockGUI
     */
    public FileMenuHandler(ClockGUI gui) {
        this.gui = gui;
    }
    /**
     * Decides what to do when the JMenuItems in the GUI are clicked
     * @param e ActionEvent
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Quit"))
            System.exit(0);
        else if (e.getActionCommand().equals("Open")) {
            //Get the file to use in the creating of the lists
            JFileChooser fChooser = new JFileChooser();
            fChooser.showOpenDialog(null);
            File file = fChooser.getSelectedFile();
            String path = file.getAbsolutePath();
            
            //Create the lists the same way as in the main method of Project 2
            //TreeMap now replaces the SortedClockList
            TextFileInput in = new TextFileInput(path);
            String line = in.readLine();
            StringTokenizer t;
            UnsortedClockList unsort = new UnsortedClockList();
            TreeMap<Clock, String> sort = new TreeMap<Clock, String>(new ClockComparator());
            
            int h, m, s;
            while (line != null) { // Creates and adds Clocks to the lists
                t = new StringTokenizer(line, ":");
                if (t.countTokens() != 3)
                    System.out.println(line);
                else {
                    //try catch block to deal with an IllegalClockException
                    try {    
                        h = Integer.parseInt(t.nextToken());
                        m = Integer.parseInt(t.nextToken());
                        s = Integer.parseInt(t.nextToken());
                        unsort.add(new Clock (h, m, s));
                        sort.put(new Clock (h, m, s), (new Clock(h,m,s)).toString());
                    } catch (IllegalClockException ice) {
                        System.out.println(line);
                    }
                }
                line = in.readLine();
            }
            gui.setLists(sort, unsort);
            gui.display(sort, unsort);
        }
    }

}
