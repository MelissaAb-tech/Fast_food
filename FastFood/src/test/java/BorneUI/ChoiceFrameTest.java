/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorneUI;

/**
 *
 * @author conte
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;

import javax.swing.*;

class ChoiceFrameTest {
    private FrameFixture window;

    @BeforeEach
    void setUp() {
        // Embed ChoiceFrame in a JFrame for testing
        JFrame testFrame = GuiActionRunner.execute(() -> {
            JFrame frame = new JFrame();
            frame.setContentPane(new ChoiceFrame(null, "John Doe"));
            frame.pack(); // Adjust size to fit components
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            return frame;
        });
        window = new FrameFixture(testFrame);
        window.show(); // Display the window for testing
    }

    @AfterEach
    void tearDown() {
        window.cleanUp(); // Cleanup resources after each test
    }

    @Test
    void testWelcomeMessage() {
        // Verify that the welcome message is correct
        String welcomeMessage = window.label("jLabel2").text();
        assertEquals("Bienvenue John Doe", welcomeMessage, "The welcome message is incorrect.");
    }

    @Test
    void testMenuButtonExists() {
        // Verify that the "Menu" button exists and is visible
        window.button("MenuButton").requireVisible();
    }

    @Test
    void testProductButtonExists() {
        // Verify that the "Products" button exists and is visible
        window.button("ProductButton").requireVisible();
    }
    
}

