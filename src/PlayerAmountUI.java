import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by moggj_000 on 18/10/2016.
 */
public class PlayerAmountUI extends JFrame implements ActionListener {
    static Game instance;


    FlowLayout flow = new FlowLayout();
    JLabel status = new JLabel("Please select amount of players");
    JButton ThreePlayers = new JButton("3");
    JButton FourPlayers = new JButton("4");
    JButton FivePlayers = new JButton("5");

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
        instance = gameInstance;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == ThreePlayers) {
            instance.playerAmmount = 3;
            JOptionPane.showMessageDialog(null, "There will be 3 players");
            dispose();
        } else if (e.getSource() == FourPlayers) {
            instance.playerAmmount = 4;
            JOptionPane.showMessageDialog(null, "There will be 4 players");
            dispose();
        } else if (e.getSource() == FivePlayers) {
            instance.playerAmmount = 5;
            JOptionPane.showMessageDialog(null, "There will be 5 players");
            dispose();
        }
    }

}
