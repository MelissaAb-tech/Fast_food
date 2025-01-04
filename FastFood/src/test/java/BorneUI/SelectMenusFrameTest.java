/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorneUI;

/**
 *
 * @author conte
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import order.OrderManager;
import menu.*;


import javax.swing.*;
import order.Order;

public class SelectMenusFrameTest {

    private FrameFixture window;
    private OrderManager manager;

    @BeforeEach
    public void setUp() {
        // Initialisation de l'OrderManager
        manager = new OrderManager(new Order());

        // Création d'une instance de SelectMenusFrame
        SelectMenusFrame selectMenusFrame = GuiActionRunner.execute(() -> new SelectMenusFrame(manager));

        // Initialisation AssertJ-Swing
        JFrame frame = GuiActionRunner.execute(() -> {
            JFrame testFrame = new JFrame();
            testFrame.add(selectMenusFrame);
            testFrame.pack();
            return testFrame;
        });

        window = new FrameFixture(frame);
        window.show(); // Affiche la fenêtre pour les tests
    }

    @AfterEach
    public void tearDown() {
        window.cleanUp(); // Nettoyage après chaque test
    }

    @Test
    public void testAddMenuClassique() {
        // Clique sur le bouton "Menu Classique"
        window.button(JButtonMatcher.withText("Menu Classique 10€")).click();

        // Vérifie que le menu classique a été ajouté à la commande
        assertEquals(1, manager.getOrder().getMenus().size(), "Un menu devrait être ajouté.");
        assertEquals(Menu.class, manager.getOrder().getMenus().get(0).getClass(),
            "Le menu ajouté devrait être un MenuClassique.");
    }

    @Test
    public void testAddMenuVegetarien() {
        // Clique sur le bouton "Menu Végétarien"
        window.button(JButtonMatcher.withText("Menu Végétarien 11€")).click();

        // Vérifie que le menu végétarien a été ajouté à la commande
        assertEquals(1, manager.getOrder().getMenus().size(), "Un menu devrait être ajouté.");
        assertEquals(Menu.class, manager.getOrder().getMenus().get(0).getClass(),
            "Le menu ajouté devrait être un MenuVegetarien.");
    }

    @Test
    public void testAddMenuDouble() {
        // Clique sur le bouton "Menu Double"
        window.button(JButtonMatcher.withText("Menu Double 15€")).click();

        // Vérifie que le menu double a été ajouté à la commande
        assertEquals(1, manager.getOrder().getMenus().size(), "Un menu devrait être ajouté.");
        assertEquals(Menu.class, manager.getOrder().getMenus().get(0).getClass(),
            "Le menu ajouté devrait être un MenuDouble.");
    }
}


