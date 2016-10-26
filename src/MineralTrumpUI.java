import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Color;

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
    JLabel centerPile;
    public ArrayList<JButton> buttons = new ArrayList<JButton>();
    JButton passButton = new JButton("Pass");

    // links the frame to the launch controller
    public static void getLauncher(Launcher launcherInstance) {
        Linstance = launcherInstance;
    }
    //draws a card from the deck and removes it adding it to the players hand
    public void drawCard(){
        try {
            instance.playersArray.get(playerLoop).PlayerHand.add(instance.deckInstance.deckArray.get(0));
            instance.deckInstance.deckArray.remove(0);
        }catch (IndexOutOfBoundsException c) {
            JOptionPane.showMessageDialog(null, "There are no more cards in the deck");
        }
    }
    //this holds the images of different cards as icons inside a button
    public void getCardButtons() {
        for (int x = 0; x < instance.playersArray.get(playerLoop).PlayerHand.size(); x++) {
            String filePath = "F:\\JCU\\programming 2\\assignment part 2\\images\\" + instance.playersArray.get(playerLoop).PlayerHand.get(x).fileName;
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT));
            buttons.add(new JButton(imageIcon));
            buttons.get(x).addActionListener(this);
            contentPane.add(buttons.get(x));
        }
    }
    //creates the center cardpile and holds the image of what is played
    public void centerCardPilePane(){
        try {
            int topCardIndex = instance.centerCards.size() - 1;
            String filePath = "F:\\JCU\\programming 2\\assignment part 2\\images\\" + instance.centerCards.get(topCardIndex).fileName;
            ImageIcon imageIcon =new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT));
            centerPile = new JLabel(imageIcon);
            add(centerPile, borderLayout.AFTER_LINE_ENDS);
        }catch (Exception e){
            centerPile = new JLabel("   Bottom of Pile  ");
            add(centerPile, borderLayout.AFTER_LINE_ENDS);
        }
    }
    //reses the loop of players so it returns from 1 to the amount of players playing
    public void playerLoopReset() {
        if (playerLoop == instance.playersArray.size() - 1) {
            playerLoop = -1;
        }
    }
    //starts a new round on the frame for players
    public void newRound() {
        if (instance.outCounter == instance.playerAmmount - 1) {
            JOptionPane.showMessageDialog(null, "The current round has ended. The new round will start now");
            for (int i = 0; i < instance.playersArray.size(); i++) {
                instance.playersArray.get(i).inorOut = Boolean.TRUE;
            }
            Linstance.startChangeCategory(); //changes the category of the rounds
            instance.outCounter = 0;
        }
    }
    //holds the GUI infomation of placment for this frame
    public MineralTrumpUI(Game gameInstance) {
        super("Mineral Super Trumps");
        setLayout(borderLayout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(playerName, borderLayout.NORTH);
        add(statusMessage, borderLayout.SOUTH);
        add(contentPane, borderLayout.CENTER);
        instance = gameInstance;
        centerCardPilePane();
        getCardButtons();
        contentPane.add(passButton);
        passButton.addActionListener(this);
        getContentPane().setBackground(Color.WHITE);
    }
    //runs the action events of when users press a button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!((JButton) e.getSource()).getText().contains("Pass")) {
            System.out.println("you clicked a card");
        } else if (e.getSource() == passButton) {
            drawCard();
            instance.playersArray.get(playerLoop).inorOut = Boolean.FALSE;
            playerLoopReset();
            ++playerLoop;
            ++instance.outCounter;
            statusMessage.setText("You have chosen to pass");
            JOptionPane.showMessageDialog(null, "It is now " + instance.playersArray.get(playerLoop).Name + "'s turn");
            playerName.setText("The current player is: " + instance.playersArray.get(playerLoop).Name);
            //removes the frame
            dispose();
            //launches the stated frame
            Linstance.startMineralTrump();
        }
    }
}


