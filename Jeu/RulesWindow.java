import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RulesWindow extends JFrame {

    public RulesWindow() {
        super("Les regles du jeu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 900);

        // Chargez l'image de fond
        BufferedImage backgroundImage = null;
        try {
            backgroundImage = ImageIO.read(new File("image/regles.png")); // Remplacez "votre_image.jpg" par le chemin de votre image
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Créez un JLabel avec l'image de fond
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        setContentPane(backgroundLabel);

        // Assurez-vous de rendre la fenêtre visible
        setVisible(true);
    }

   
}
