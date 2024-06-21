import javax.swing.*;
import java.awt.*;

import java.io.IOException;
import javax.imageio.ImageIO;

public class WinnerInterface extends JFrame {
    private JLabel messageLabel;
    String player1;

    public WinnerInterface(String ch) {
        // Créer la fenêtre
        setTitle("Jeu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 900); // Taille de la fenêtre
        setLocationRelativeTo(null); // Centrer la fenêtre

        // Charger l'image de fond
        try {
            Image backgroundImage = ImageIO.read(new java.io.File("image/cong11.png"));
            Image resizedImage = backgroundImage.getScaledInstance(900  , 900, Image.SCALE_SMOOTH);

            // Créer un JLabel avec l'image de fond
            JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
            setContentPane(backgroundLabel);
            backgroundLabel.setLayout(null); // Utiliser un layout absolu

            // Créer un label pour afficher le message
            messageLabel = new JLabel("");
            messageLabel.setHorizontalAlignment(JLabel.CENTER);
            messageLabel.setVerticalAlignment(JLabel.CENTER);
            messageLabel.setFont(messageLabel.getFont().deriveFont(40.0f)); // Augmenter la taille de la police
            messageLabel.setForeground(Color.GREEN); // Texte en vert par défaut

            // Ajouter le label du message au JLabel de l'image de fond
            messageLabel.setBounds(290, 610, 300, 100); // Positionnez le label
            backgroundLabel.add(messageLabel);
            player1=ch;


            setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void afficherMessage(String message) {
      
            messageLabel.setForeground(Color.white); // Texte en vert si le joueur a gagné
            System.out.println(message); // Afficher le message du joueur gagnant
       
        messageLabel.setText(message);
    }
   
}
