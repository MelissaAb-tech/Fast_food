import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AcceuilPanel extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private List<Compte> comptes = new ArrayList<>(); // Liste des comptes

    public AcceuilPanel() {
        // Chargement des comptes depuis le fichier
        chargerComptesDepuisFichier("comptes.txt");

        // Paramétrer la fenêtre principale
        setTitle("Programme de fidélité");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Utilisation du CardLayout pour gérer les différents écrans
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Créer les différentes pages
        JPanel fidelityPanel = createFidelityPanel();
        ChoicePanel choicePanel = new ChoicePanel(); // Utilisation de la nouvelle classe ChoicePanel

        // Ajouter les panneaux au CardLayout
        mainPanel.add(fidelityPanel, "fidelityPanel");
        mainPanel.add(choicePanel, "choicePanel");

        // Ajouter le panneau principal à la fenêtre
        add(mainPanel);

        // Afficher la première page
        cardLayout.show(mainPanel, "fidelityPanel");
    }

    // Page de demande de code de fidélité
    private JPanel createFidelityPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));

        JLabel label = new JLabel("Avez-vous un compte de fidélité ?");
        panel.add(label);

        JTextField codeField = new JTextField(10); // Longueur logique du texte
        panel.add(codeField);

        // Créer un panel pour les boutons avec FlowLayout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0)); // 10px de marge entre les boutons

        // Bouton pour soumettre le code de fidélité
        JButton submitButton = new JButton("Soumettre");
        submitButton.setPreferredSize(new Dimension(100, 30)); // Réduire la taille du bouton "Soumettre"
        buttonPanel.add(submitButton);

        // Bouton "Passer" pour ignorer le code de fidélité
        JButton skipButton = new JButton("Passer");
        skipButton.setPreferredSize(new Dimension(100, 30)); // Réduire la taille du bouton "Passer"
        buttonPanel.add(skipButton);

        // Ajouter le panel des boutons au panel principal
        panel.add(buttonPanel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String code = codeField.getText();

                // Vérifier si le code de fidélité existe dans la liste des comptes
                if (verifierCompte(code)) {
                    cardLayout.show(mainPanel, "choicePanel"); // Passer à la page du choix des
                    // articles
                } else {
                    JOptionPane.showMessageDialog(null, "Code de fidélité invalide !");
                }
            }
        });

        // Action pour le bouton "Passer"
        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "choicePanel"); // Passer à la page du choix des
                // articles
            }
        });

        return panel;
    }

    // Méthode pour charger les comptes depuis un fichier
    private void chargerComptesDepuisFichier(String cheminFichier) {
        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] donnees = ligne.split(",");
                if (donnees.length == 2) {
                    comptes.add(new Compte(donnees[0], donnees[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors du chargement des comptes.");
        }
    }

    // Méthode pour vérifier si un compte existe par le code de fidélité
    private boolean verifierCompte(String codeFidelite) {
        for (Compte compte : comptes) {
            if (compte.verifierCode(codeFidelite)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AcceuilPanel().setVisible(true);
            }
        });
    }
}
