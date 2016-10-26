import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by moggj_000 on 18/10/2016.
 */
public class PlayerAmountUI extends JFrame implements ActionListener {
    //brings the instance of game and launcher
    static Game instance;
    static Launcher Linstance;

    FlowLayout flow = new FlowLayout();
    JLabel status = new JLabel("Please select amount of players");
    JButton ThreePlayers = new JButton("3");
    JButton FourPlayers = new JButton("4");
    JButton FivePlayers = new JButton("5");
    //links the frame to the launcher
    public static void getLauncher(Launcher launcherInstance) {
        Linstance = launcherInstance;
    }

    public PlayerAmountUI(Game gameInstance){
        super("Mineral Super Trumps");
        setLayout(flow);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(status);
        add(ThreePlayers);
        add(FourPlayers);
        add(FivePlayers);

        ThreePlayers.addActionListener(this);
        FourPlayers.addActionListener(this);
        FivePlayers.addActionListener(this);
        getContentPane().setBackground(Color.CYAN);

    }
    //holds what is done when a player presses a button
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == ThreePlayers) {
            instance.playerAmmount = 3; // when only certaina mount of players chosen sent to the game to hold
            JOptionPane.showMessageDialog(null, "There will be 3 players");
            Linstance.startPlayerName();
            dispose();
        } else if (e.getSource() == FourPlayers) {
            instance.playerAmmount = 4;// when only certaina mount of players chosen sent to the game to hold
            JOptionPane.showMessageDialog(null, "There will be 4 players");
            Linstance.startPlayerName();
            dispose();
        } else if (e.getSource() == FivePlayers) {
            instance.playerAmmount = 5;// when only certaina mount of players chosen sent to the game to hold
            JOptionPane.showMessageDialog(null, "There will be 5 players");
            Linstance.startPlayerName();//linked to the launcher and starts the frame stated
            dispose();
        }
    }

}
