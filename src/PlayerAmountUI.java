import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by moggj_000 on 18/10/2016.
 */
public class PlayerAmountUI extends JFrame implements ActionListener {

    JButton button1 = new JButton("3");
    JButton button2 = new JButton("4");
    JButton button3 = new JButton("5");

    JPanel panel1 = new JPanel(new FlowLayout());
    JPanel panel2 = new JPanel();
    public PlayerAmountUI(){
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel1);
        add(panel2);
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        setSize(400, 200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if(source == button1)

        else if(source  == button2)

        else if(source  == button3)

    }
    public static void main(String[] args){
        PlayerAmountUI frame = new PlayerAmountUI();
    }
}
