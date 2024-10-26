import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoicePanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public ChoicePanel() {
        // Initialisation de la disposition du panel (GridLayout)
        setLayout(new GridLayout(4, 2)); // 4 lignes, 2 colonnes
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Créer une image pour "Choisir un menu"
        ImageIcon menuIcon = new ImageIcon("images/menu.jpg"); // Remplace par le chemin correct
        Image menuImage = menuIcon.getImage().getScaledInstance(270, 200, Image.SCALE_SMOOTH); // Redimensionner
        menuIcon = new ImageIcon(menuImage); // Mettre à jour l'ImageIcon avec l'image redimensionnée
        JLabel menuImageLabel = new JLabel(menuIcon);
        menuImageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Créer un bouton pour "Choisir un menu"
        JButton menuButton = new JButton("Choisir un menu");
        menuButton.setPreferredSize(new Dimension(150, 30)); // Définir une taille préférée
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // cardLayout.show(mainPanel, "articlesPanel"); // Passer à la page du choix des
                // articles
            }
        });

        // Créer une image pour "Choisir des produits individuels"
        ImageIcon productIcon = new ImageIcon("images/articles.jpg"); // Remplace par le chemin correct
        Image produitsImage = productIcon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH); // Redimensionner
        productIcon = new ImageIcon(produitsImage); // Mettre à jour l'ImageIcon avec l'image redimensionnée
        JLabel productImageLabel = new JLabel(productIcon);
        productImageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Créer un bouton pour "Choisir des produits individuels"
        JButton productButton = new JButton("Choisir des produits individuels");
        productButton.setPreferredSize(new Dimension(150, 30)); // Définir une taille préférée
        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Afficher le panel des articles lors du clic sur ce bouton
                FastFoodUI fastFoodPanel = new FastFoodUI();

                // Ajouter cette nouvelle instance au CardLayout avec un nom unique
                mainPanel.add(fastFoodPanel, "newFastFoodPanel");

                // Afficher la nouvelle page FastFoodUI
                cardLayout.show(mainPanel, "newFastFoodPanel");

            }
        });

        JLabel Jlabelplus = new JLabel("");
        JLabel Jlabelplus2 = new JLabel("");
        JLabel Jlabelplus3 = new JLabel("");
        JLabel Jlabelplus4 = new JLabel("");
        // Ajouter les images et les boutons au panel
        add(Jlabelplus3);
        add(Jlabelplus4);
        add(menuImageLabel);
        add(productImageLabel);
        add(Jlabelplus);
        add(Jlabelplus2);
        add(menuButton);
        add(productButton);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChoicePanel().setVisible(true);
            }
        });
    }
}