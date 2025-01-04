/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorneUI;

/**
 *
 * @author conte
 */

import java.awt.event.WindowAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.assertj.swing.fixture.DialogFixture;
import org.assertj.swing.finder.WindowFinder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.Test;
import org.assertj.swing.fixture.FrameFixture;


import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CreateAccountFrameTest {
    private FrameFixture window;

    @BeforeEach
    void setUp() {
        // Create and show the frame for testing
        CreateAccountFrame frame = new CreateAccountFrame();
        frame.setName("frame0");
        window = new FrameFixture(frame);
        window.show(); // Show the frame for the test
    }

    @AfterEach
    void tearDown() {
        window.cleanUp(); // Clean up resources after each test
    }

    @Test
    void testInvalidName() {
        // Simulate entering an invalid name (empty name)
        JTextComponentFixture nameField = window.textBox("NameInput");
        nameField.enterText(""); // Leave the name field empty
        
        // Click the "Create" button
        window.button(JButtonMatcher.withText("Créer")).click();
        
        // Use DialogFixture to check for the error message
        DialogFixture dialog = window.dialog();
        
        String dialogText = dialog.label("OptionPane.label").text(); // Get the text of the first label
        
        // Check if the error message is as expected
        assertThat(dialogText).contains("Le nom rentré n'est pas valide");
}
   /* @Test
    void testValidAccountCreation() throws IOException {
        // Simulate entering a valid name
        String validName = "John Doe";
        JTextComponentFixture nameField = window.textBox("NameInput");
        nameField.enterText(validName);

        // Simulate clicking the "Create" button
        window.button(JButtonMatcher.withText("Créer")).click();

        // Use DialogFixture to check for the success message
        DialogFixture dialog = window.dialog();
        String dialogText = dialog.label("OptionPane.label").text(); // Assuming the success message is in a JLabel
        assertTrue(dialogText.contains("Compte créé avec succès !"));
        
        // Verify that the new account was added to the file (data/comptes.txt)
        File file = new File("data/comptes.txt");
        assertTrue(file.exists(), "The account file should exist");

        // Verify that the name and account number are saved correctly
        // You need to adjust the account number because it's randomly generated
        // Use a regex to match the account number dynamically
        String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
        // Check if the content contains the name and any 5-digit number
        assertTrue(content.contains(validName), "Account name should be present in the file");
        assertTrue(content.matches(".*" + validName + ",\\d{5}.*"), "Account line should match the format with a valid number");
    }*/

    @Test
    void testCancelButtonWithListener() throws InterruptedException {
    // Créer un listener pour vérifier que la fenêtre est fermée
        AtomicBoolean isClosed = new AtomicBoolean(false);
        window.target().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
            isClosed.set(true);
        }
    });

    // Cliquer sur le bouton "Annuler"
    window.button(JButtonMatcher.withText("Annuler")).click();

    // Attendre que la fenêtre soit fermée
    Thread.sleep(500);

    // Vérifier si la fenêtre a bien été fermée
    assertTrue(isClosed.get(), "La fenêtre n'a pas été fermée.");
}

}

