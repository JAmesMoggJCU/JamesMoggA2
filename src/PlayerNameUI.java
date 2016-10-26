import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by moggj_000 on 22/10/2016.
 */
public class PlayerNameUI extends JFrame implements ActionListener {
    static Game instance;
    static int playerNum = 0;
    static Launcher Linstance;

    BorderLayout borderLayout = new BorderLayout();
    JLabel Message = new JLabel("Enter a name for player: " + playerNum);
    JTextArea nameInput = new JTextArea();
    JButton enterPlayerName = new JButton("Enter");
    static String name;

    public static void getLauncher(Launcher launcherInstance) {
        Linstance = launcherInstance;
    }

    public PlayerNameUI(Game gameInstance) {
        super("Mineral Super Trumps");
        setLayout(borderLayout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(Message, borderLayout.NORTH);
        add(nameInput, borderLayout.CENTER);
        add(enterPlayerName, borderLayout.SOUTH);
        enterPlayerName.addActionListener(this);
        instance = gameInstance;
    }
    //holds what happens when a button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterPlayerName) {
            //gets the input from the players
            name = nameInput.getText();
            //includes the input to the players array in game
            instance.playersArray.add(new Players((PlayerNameUI.name)));
            //holds the number of 8 cards at the beginning of the game and removes them from deck
            while (instance.playersArray.get(playerNum).PlayerHand.size() <8) {
                instance.playersArray.get(playerNum).PlayerHand.add(instance.deckInstance.deckArray.remove(0));
            }

        }
        //holds the amount of players playing
        ++playerNum;
        if (playerNum == instance.playerAmmount) {
            JOptionPane.showMessageDialog(null, "Welcome to the game: " + name);
            JOptionPane.showMessageDialog(null, "Lets begin the game");
            //changes to the frame stated
            Linstance.startChangeCategory();
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Welcome to the game: " + name);
            nameInput.setText("");
            Message.setText("Please enter a name: " + playerNum);
        }
    }
}