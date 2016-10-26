/**
 * Created by moggj_000 on 24/10/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class StartScreen extends JFrame implements ActionListener {
    static Launcher Linstance;
    FlowLayout flowLayout = new FlowLayout();
    JLabel Message = new JLabel("Welcome to the Mineral Super Trumps");
    JButton startButton = new JButton("Play Game");

    public static void getLauncher(Launcher launcherInstance){
        Linstance = launcherInstance;
    }
    public StartScreen() {
        super("Mineral Super Trumps");
        setLayout(flowLayout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(Message);
        add(startButton);
        startButton.addActionListener(this);
        getContentPane().setBackground(Color.GREEN);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            JOptionPane.showMessageDialog(null, "The Game will now begin");
            Linstance.startPlayerAmount();
            dispose();
        }
    }
}
