import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class GameInterface extends JFrame{
    JButton button1,button2,button3,button4,button5,button6,button7,button8,button9;
    String player1;
    String player2;
    public GameInterface(String ch1,String ch2){
        player1=ch1;
        player2=ch2;
        setTitle("Grille de Boutons");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(700, 500);

        JPanel centerPanel = new JPanel(new GridLayout(3, 3));
        add(centerPanel, BorderLayout.CENTER);

        button1 = new JButton("");
        button1.setBackground(Color.white);
        centerPanel.add(button1);
        button1.addActionListener(new Ecouteur(1,0,0,player1,player2));
        button2 = new JButton("");
        button2.setBackground(Color.white);
        centerPanel.add(button2);
        button2.addActionListener(new Ecouteur(2,1,0,player1,player2));
        button3 = new JButton("");
        button3.setBackground(Color.white);
        centerPanel.add(button3);
        button3.addActionListener(new Ecouteur(3,2,0,player1,player2));
        button4 = new JButton("");
        button4.setBackground(Color.white);
        centerPanel.add(button4);
        button4.addActionListener(new Ecouteur(4,0,1,player1,player2));
        button5 = new JButton("");
        button5.setBackground(Color.white);
        centerPanel.add(button5);
        button5.addActionListener(new Ecouteur(5,1,1,player1,player2));
        button6 = new JButton("");
        button6.setBackground(Color.white);
        centerPanel.add(button6);
        button6.addActionListener(new Ecouteur(6,2,1,player1,player2));
        button7 = new JButton("");
        button7.setBackground(Color.white);
        centerPanel.add(button7);
        button7.addActionListener(new Ecouteur(7,0,2,player1,player2));
        button8 = new JButton("");
        button8.setBackground(Color.white);
        centerPanel.add(button8);
        button8.addActionListener(new Ecouteur(8,1,2,player1,player2));
        button9 = new JButton("");
        button9.setBackground(Color.white);
        centerPanel.add(button9);
        button9.addActionListener(new Ecouteur(9,2,2,player1,player2));
        
}
}
