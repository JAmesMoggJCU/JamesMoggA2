/**
 * Created by moggj_000 on 24/10/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChangeCategoryUI extends JFrame implements ActionListener {
    static Game instance;
    static Launcher Linstance;
    FlowLayout flowLayout = new FlowLayout();
    JLabel Message = new JLabel("Please select a category: ");
    JButton hardnessButton = new JButton("Hardness");
    JButton specificGravityButton = new JButton("Specific Gravity");
    JButton cleavageButton = new JButton("Cleavage");
    JButton crustalAbundanceButton = new JButton("Crustal Abundance");
    JButton economicValueButton = new JButton("Economic Value");

    public static void getLauncher(Launcher launcherInstance) {
        Linstance = launcherInstance;
    }

    public ChangeCategoryUI(Game gameInstance){
        super("Mineral Super Trumps");
        setLayout(flowLayout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        instance = gameInstance;
        add(Message);
        add(hardnessButton);
        add(specificGravityButton);
        add(cleavageButton);
        add(crustalAbundanceButton);
        add(economicValueButton);
        hardnessButton.addActionListener(this);
        specificGravityButton.addActionListener(this);
        cleavageButton.addActionListener(this);
        crustalAbundanceButton.addActionListener(this);
        economicValueButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == hardnessButton){
            instance.roundType = "hardness";
            JOptionPane.showMessageDialog(null, "The new category is: " + instance.roundType);
            Linstance.startMineralTrump();
            dispose();
        } else if (e.getSource() == specificGravityButton){
            instance.roundType = "specific gravity";
            JOptionPane.showMessageDialog(null, "The new category is: " + instance.roundType);
            Linstance.startMineralTrump();
            dispose();
        }else if (e.getSource() == cleavageButton) {
            instance.roundType = "cleavage";
            JOptionPane.showMessageDialog(null, "The new category is: " + instance.roundType);
            Linstance.startMineralTrump();
            dispose();
        }else if (e.getSource() == crustalAbundanceButton) {
        instance.roundType = "crustal abundance";
        JOptionPane.showMessageDialog(null, "The new category is: " + instance.roundType);
            Linstance.startMineralTrump();
        dispose();
    }else if (e.getSource() == economicValueButton) {
        instance.roundType = "economic value";
        JOptionPane.showMessageDialog(null, "The new category is: " + instance.roundType);
            Linstance.startMineralTrump();
        dispose();
    }
    }
}