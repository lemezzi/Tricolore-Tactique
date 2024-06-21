import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;

public class StartGameWindow extends JFrame {
    private JTextField joueur1Field;
    private JTextField joueur2Field;
    private JLabel joueur1Label;
    private JLabel joueur2Label;
    String player1;
    String player2;
    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }



    public StartGameWindow() { 
        setTitle("Débuter un jeu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Créez un JPanel personnalisé avec une image de fond
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("image/arigne.jpg"); // Remplacez "background.jpg" par le nom de votre image de fond
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        backgroundPanel.setLayout(new GridLayout(4, 2, 10, 10));
        backgroundPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel labelJoueur1 = new JLabel("Nom du Joueur 1 : ");
labelJoueur1.setForeground(Color.blue);
labelJoueur1.setFont(new Font("Arial", Font.BOLD, 18)); // Vous pouvez ajuster la police et la taille ici
        joueur1Field = new JTextField();
        JLabel labelJoueur2 = new JLabel("Nom du Joueur 2 : ");
        labelJoueur2.setFont(new Font("Arial", Font.BOLD, 18)); // Vous pouvez ajuster la police et la taille ici
        labelJoueur2.setForeground(Color.red);

        joueur2Field = new JTextField();


        joueur1Label = new JLabel("");
        joueur1Label.setForeground(Color.BLUE);
        joueur2Label = new JLabel("");
        joueur2Label.setForeground(Color.RED);



        JButton startButton = new JButton("Démarrer le jeu");
        startButton.setForeground(Color.RED);
        startButton.setFont(new Font("Arial", Font.PLAIN, 20));
        startButton.setPreferredSize(new Dimension(200, 50)); // Ajustez la taille selon vos préférences

        // Personnalisez davantage le bouton si nécessaire, par exemple, en modifiant la couleur, la bordure, etc.
        startButton.setBackground(Color.BLUE);
        startButton.setForeground(Color.WHITE);
        startButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        startButton.setForeground(Color.RED); // Définit la couleur du texte en rouge
        startButton.setFocusPainted(false);        
        startButton.setFont(new Font("Arial", Font.PLAIN, 22));

        JButton regles = new JButton("Règles du jeu");
regles.setForeground(Color.RED);
regles.setFont(new Font("Arial", Font.PLAIN, 20));
regles.setPreferredSize(new Dimension(200, 50));

// Personnalisez davantage le bouton si nécessaire, par exemple, en modifiant la couleur, la bordure, etc.
regles.setBackground(Color.gray);
regles.setForeground(Color.blue);
regles.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Réduisez les marges ici
regles.setFocusPainted(false);
regles.setFont(new Font("Arial", Font.PLAIN, 22));












        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Créez une seule instance de GameInterface en dehors de la boucle
                String player1 = joueur1Field.getText();
                String player2 = joueur2Field.getText();
                System.out.println(player1);
                System.out.println(player2);
                GameInterface f = new GameInterface(player1,player2);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
                dispose();



                joueur1Label.setText("Joueur 1 : " + player1);
                joueur2Label.setText("Joueur 2 : " + player2);
        
                // Vous pouvez choisir de démarrer la phase de jeu ici, par exemple :
                // f.startPhase1();
            }
        });

        regles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Créez une seule instance de GameInterface en dehors de la boucle
              
                RulesWindow f = new RulesWindow();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);



          
        
                // Vous pouvez choisir de démarrer la phase de jeu ici, par exemple :
                // f.startPhase1();
            }
        });

        backgroundPanel.add(labelJoueur1);
        backgroundPanel.add(joueur1Field);
        backgroundPanel.add(labelJoueur2);
        backgroundPanel.add(joueur2Field);
        



        backgroundPanel.add(regles);

        backgroundPanel.add(startButton);
        backgroundPanel.add(joueur1Label);
        backgroundPanel.add(joueur2Label);

        getContentPane().add(backgroundPanel);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                StartGameWindow startGameWindow = new StartGameWindow();
               
                startGameWindow.setVisible(true);
       
                
            }
        });
    }
}
