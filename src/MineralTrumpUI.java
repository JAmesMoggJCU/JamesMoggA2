import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by moggj_000 on 12/10/2016.
 */
public class MineralTrumpUI extends JFrame implements ActionListener {
    static Game instance;
    static int playerLoop = 0;
    static Launcher Linstance;
    BorderLayout borderLayout = new BorderLayout();
    JLabel playerName = new JLabel("The current player is: " + instance.playersArray.get(playerLoop).Name);
    JLabel statusMessage = new JLabel("The type for the current round is: " + instance.roundType);
    JPanel contentPane = new JPanel();
    public ArrayList<JButton> buttons = new ArrayList<JButton>();
    JButton passButton = new JButton("Pass");

    public static void getLauncher(Launcher launcherInstance) {
        Linstance = launcherInstance;
    }

    public void getCardButtons() {
        for (int x = 0; x < instance.playersArray.get(playerLoop).PlayerHand.size(); x++) {
            String filePath = "F:\\JCU\\programming 2\\assignment part 2\\images\\" + instance.playersArray.get(playerLoop).PlayerHand.get(x).fileName;
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(135, 189, Image.SCALE_DEFAULT));
            buttons.add(new JButton(imageIcon));
            buttons.get(x).addActionListener(this);
            contentPane.add(buttons.get(x));
        }
    }
    public void gameOverCheck() {
        if (instance.playersArray.size() == 1) {
            JOptionPane.showMessageDialog(null, "The game is now over");
            JOptionPane.showMessageDialog(null, "Congratulations Winners: ");
            dispose();
        }
    }
    public void emptyHandCheck() {
        if (instance.playersArray.get(playerLoop).PlayerHand.size() == 0) {

        }
    }
    public void playerLoopReset() {
        if (playerLoop == instance.playersArray.size() - 1) {
            playerLoop = -1;
        }
    }
    public MineralTrumpUI(Game gameInstance) {
        super("Mineral Super Trumps");
        setLayout(borderLayout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(playerName, borderLayout.NORTH);
        add(statusMessage, borderLayout.SOUTH);
        add(contentPane, borderLayout.CENTER);
        instance = gameInstance;
        JOptionPane.showMessageDialog(null, "It is npw " + instance.playersArray.get(playerLoop).Name + "'s tuen");
        getCardButtons();
        contentPane.add(passButton);
        passButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!((JButton) e.getSource()).getText().contains("Pass")) {
            System.out.println("you clicked a card");
        } else if (e.getSource() == passButton) {
            playerLoopReset();
            statusMessage.setText("You have chosen to pass");
            ++playerLoop;
            JOptionPane.showMessageDialog(null, "It is now " + instance.playersArray.get(playerLoop).Name + "'s turn");
            playerName.setText("The current player is: " + instance.playersArray.get(playerLoop).Name);
        }
    }
}


