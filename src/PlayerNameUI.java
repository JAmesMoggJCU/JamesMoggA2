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

    BorderLayout borderLayout = new BorderLayout();
    JLabel Message = new JLabel("Enter a name for player: " + playerNum);
    JTextArea nameInput = new JTextArea();
    JButton enterPlayerName = new JButton("Enter");
    static String name;


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
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterPlayerName) {
            name = nameInput.getText();
            instance.playersArray.add(new Players((PlayerNameUI.name)));
            while (instance.playersArray.get(playerNum).PlayerHand.size() <8) {
                instance.playersArray.get(playerNum).PlayerHand.add(instance.deckInstance.deckArray.remove(0));
            }

        }
        ++playerNum;
        if (playerNum == instance.playerAmmount) {
            JOptionPane.showMessageDialog(null, "Welcome to the game: " + name);
            JOptionPane.showMessageDialog(null, "Lets begin the game");
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Welcome to the game: " + name);
            nameInput.setText("");
            Message.setText("Please enter a name: " + playerNum);
        }
    }
}