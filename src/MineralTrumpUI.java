import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Created by moggj_000 on 12/10/2016.
 */
public class MineralTrumpUI implements ItemListener {
    JPanel cards; //panel with CardLayout
    final static String BUTTONPANEL = "Cards with JButtons";
    final static String TEXTPANEL = "Cards with JTextField";

    public void addComponentToPane(Container pane){
        JPanel comboBoxPane = new JPanel();//FlowLayout
        String comboBoxItems[] = {BUTTONPANEL, TEXTPANEL};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);

        //Create cards
        JPanel card1 = new JPanel();
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));

        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));
        //panel that conatian the cards
        cards = new JPanel(new CardLayout());
        cards.add(card1, BUTTONPANEL);
        cards.add(card2, TEXTPANEL);

        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }
    public void itemStateChanged(ItemEvent evt){
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
    private static void ShowGUI(){
        // set up the Window
        JFrame frame = new JFrame("Mineral Super Trumps");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Content pane
        MineralTrumpUI MinTrump = new MineralTrumpUI();
        MinTrump.addComponentToPane(frame.getContentPane());

        //Display Window
        frame.pack();
        frame.setVisible(true);

    }
    public static void main(String[] args){
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ShowGUI();
            }
        });
    }
}


