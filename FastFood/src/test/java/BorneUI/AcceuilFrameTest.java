/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorneUI;

/**
 *
 * @author conte
 */

import java.awt.Frame;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import order.OrderListManager;
import order.OrderManager;
import user.Compte;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTextField;
import order.Order;

public class AcceuilFrameTest {

    private acceuilFrame acceuilFrame;
    private OrderManager orderManager;
    private OrderListManager orderListManager;
    private File testFile;
    private File invalidTestFile;
    @BeforeEach
    void setUp() throws IOException {
        // Initialize dependencies
        orderManager = new OrderManager(new Order());
        orderListManager = new OrderListManager(new ArrayList<>());

        // Create test instance of acceuilFrame
        acceuilFrame = new acceuilFrame(orderManager, orderListManager);

        // Create a temporary test file for account data
        testFile = File.createTempFile("test_comptes", ".txt");
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("Alice,123456\n");
            writer.write("Bob,654321\n");
        }
        invalidTestFile = new File("invalid_comptes_test.txt");
        invalidTestFile.deleteOnExit(); // Suppression automatique après le test

        // Ajout d'un contenu non valide au fichier
        String invalidContent = "InvalidData\n12345OnlyOneField";
        java.nio.file.Files.writeString(invalidTestFile.toPath(), invalidContent);
    }

    @Test
    void testVerifierCompte() throws Exception {
        // Obtenir la méthode privée
        Method chargerComptesMethod = acceuilFrame.getClass().getDeclaredMethod("chargerComptesDepuisFichier", String.class);
        chargerComptesMethod.setAccessible(true);

        // Appeler la méthode avec le fichier de test
        chargerComptesMethod.invoke(acceuilFrame, testFile.getAbsolutePath());

        // Obtenir la méthode privée `verifierCompte`
        Method verifierCompteMethod = acceuilFrame.getClass().getDeclaredMethod("verifierCompte", String.class);
        verifierCompteMethod.setAccessible(true); // Permet d'accéder à une méthode privée

        // Appeler la méthode et vérifier les résultats
        String result1 = (String) verifierCompteMethod.invoke(acceuilFrame, "123456");
        assertEquals("Alice", result1, "Le compte avec le code 123456 devrait retourner 'Alice'.");

        String result2 = (String) verifierCompteMethod.invoke(acceuilFrame, "000000");
        assertNull(result2, "Un code invalide devrait retourner null.");
    }
    @Test
    void testChargerComptesDepuisFichier() throws Exception {
        

        // Obtenir la méthode privée
        Method chargerComptesMethod = acceuilFrame.getClass().getDeclaredMethod("chargerComptesDepuisFichier", String.class);
        chargerComptesMethod.setAccessible(true);

        // Appeler la méthode avec le fichier de test
        chargerComptesMethod.invoke(acceuilFrame, testFile.getAbsolutePath());

        // Obtenir la liste des comptes via réflexion
        var field = acceuilFrame.getClass().getDeclaredField("comptes");
        field.setAccessible(true);
        List<Compte> comptes = (List<Compte>) field.get(acceuilFrame);

        // Vérifier que les comptes ont été chargés correctement
        assertNotNull(comptes, "La liste des comptes ne devrait pas être nulle.");
        assertEquals(2, comptes.size(), "Le fichier contient deux comptes.");
        assertEquals("Alice", comptes.get(0).getNomUtilisateur(), "Le premier compte devrait être Alice.");
    }

      @Test
    void testVerifierCompteWithInvalidFile() throws Exception {
        // Obtenir la méthode privée
        Method chargerComptesMethod = acceuilFrame.getClass().getDeclaredMethod("chargerComptesDepuisFichier", String.class);
        chargerComptesMethod.setAccessible(true);

        // Appeler la méthode avec le fichier invalide
        chargerComptesMethod.invoke(acceuilFrame, invalidTestFile.getAbsolutePath());

        // Vérifier que les comptes n'ont pas été chargés
        Field comptesField = acceuilFrame.getClass().getDeclaredField("comptes");
        comptesField.setAccessible(true); // Accès au champ privé
        @SuppressWarnings("unchecked")
        List<Compte> comptes = (List<Compte>) comptesField.get(acceuilFrame);

        assertNotNull(comptes, "La liste des comptes ne doit pas être null.");
        assertTrue(comptes.isEmpty(), "La liste des comptes doit être vide pour un fichier invalide.");
    }

    @Test
    void testVerifierCompteWithEmptyCode() throws Exception {
        // Charger les comptes à partir du fichier de test
        Method chargerComptesMethod = acceuilFrame.getClass().getDeclaredMethod("chargerComptesDepuisFichier", String.class);
        chargerComptesMethod.setAccessible(true);
        chargerComptesMethod.invoke(acceuilFrame, testFile.getAbsolutePath());

        // Vérifier que l'appel avec un code vide retourne null
        Method verifierCompteMethod = acceuilFrame.getClass().getDeclaredMethod("verifierCompte", String.class);
        verifierCompteMethod.setAccessible(true); // Accès à la méthode privée

        String result = (String) verifierCompteMethod.invoke(acceuilFrame, ""); // Code vide
        assertNull(result, "Un code vide devrait retourner null.");
    }
@Test
void testJButton1ActionPerformedWithValidCode() throws Exception {
    // Charger les comptes
    Method chargerComptesMethod = acceuilFrame.getClass().getDeclaredMethod("chargerComptesDepuisFichier", String.class);
    chargerComptesMethod.setAccessible(true);
    chargerComptesMethod.invoke(acceuilFrame, "valid_comptes.txt"); // Assurez-vous que ce fichier contient un code valide

    // Accéder et configurer le champ texte
    Field textFieldField = acceuilFrame.getClass().getDeclaredField("jTextField1");
    textFieldField.setAccessible(true);
    JTextField textField = (JTextField) textFieldField.get(acceuilFrame);
    textField.setText("12345"); // Exemple de code valide

    // Accéder au bouton "Soumettre" et simuler un clic
    Field buttonField = acceuilFrame.getClass().getDeclaredField("jButton1");
    buttonField.setAccessible(true);
    JButton submitButton = (JButton) buttonField.get(acceuilFrame);
    submitButton.doClick();

    // Vérifier que MainBorneUI est visible
    boolean found = false;
    for (Frame frame : Frame.getFrames()) {
        if (frame instanceof MainBorneUI && frame.isVisible()) {
            found = true;
            break;
        }
    }
    assertTrue(found);
}

@Test
void testJButton1ActionPerformedWithInvalidCode() throws Exception {
    // Charger les comptes
    Method chargerComptesMethod = acceuilFrame.getClass().getDeclaredMethod("chargerComptesDepuisFichier", String.class);
    chargerComptesMethod.setAccessible(true);
    chargerComptesMethod.invoke(acceuilFrame, "valid_comptes.txt");

    // Accéder et configurer le champ texte
    Field textFieldField = acceuilFrame.getClass().getDeclaredField("jTextField1");
    textFieldField.setAccessible(true);
    JTextField textField = (JTextField) textFieldField.get(acceuilFrame);
    textField.setText("invalidCode");

    // Accéder au bouton "Soumettre" et simuler un clic
    Field buttonField = acceuilFrame.getClass().getDeclaredField("jButton1");
    buttonField.setAccessible(true);
    JButton submitButton = (JButton) buttonField.get(acceuilFrame);
    submitButton.doClick();

    // Vérifier si une boîte de dialogue d'erreur a été affichée
    // (Vous pouvez observer manuellement ou utiliser un framework de test Swing pour valider)
    // Pour ce test, assurez-vous que JOptionPane est utilisé correctement
}
@Test
void testJButton2ActionPerformed() throws Exception {
    // Accéder au bouton "Passer"
    Field buttonField = acceuilFrame.getClass().getDeclaredField("jButton2");
    buttonField.setAccessible(true);
    JButton skipButton = (JButton) buttonField.get(acceuilFrame);

    // Simuler un clic
    skipButton.doClick();

    // Vérifier que MainBorneUI est visible pour "nouveau client !"
    boolean found = false;
    for (Frame frame : Frame.getFrames()) {
        if (frame instanceof MainBorneUI && frame.isVisible()) {
            MainBorneUI ui = (MainBorneUI) frame;
            if ("nouveau client !".equals(ui.getUserName())) {
                found = true;
                break;
            }
        }
    }
    assertTrue(found);
}
/*@Test
void testNewAccountButtonMouseClicked() throws Exception {
    // Accéder au bouton "Nouveau compte"
    Field buttonField = acceuilFrame.getClass().getDeclaredField("NewAccountButton");
    buttonField.setAccessible(true);
    JButton newAccountButton = (JButton) buttonField.get(acceuilFrame);

    // Simuler un clic
    newAccountButton.doClick();

    // Vérifier que CreateAccountFrame est visible
    boolean found = false;
    for (Frame frame : Frame.getFrames()) {
        if (frame instanceof CreateAccountFrame && frame.isVisible()) {
            found = true;
            break;
        }
    }
    assertTrue(found);
}*/
@Test
void testJTextField1ActionPerformed() throws Exception {
    // Accéder au champ texte
    Field textFieldField = acceuilFrame.getClass().getDeclaredField("jTextField1");
    textFieldField.setAccessible(true);
    JTextField textField = (JTextField) textFieldField.get(acceuilFrame);

    // Simuler une action dans le champ texte
    textField.postActionEvent();

    // Vérifier qu'aucune exception n'est levée
    assertDoesNotThrow(() -> textField.postActionEvent());
}

}
