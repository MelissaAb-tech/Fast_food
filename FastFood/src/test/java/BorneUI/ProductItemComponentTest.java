/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorneUI;

/**
 *
 * @author conte
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import order.OrderManager;
import product.Product;
import product.burger.Burger;

import javax.swing.*;
import order.Order;

public class ProductItemComponentTest {

    private FrameFixture window;
    private OrderManager order; // Mock de l'OrderManager
    private Product product;

    @BeforeEach
    public void setUp() {
        // Crée un produit factice
        product = new Burger("Cheeseburger", 5.00);

        // Mock d'OrderManager
        order=new OrderManager(new Order());

        // Crée une instance de ProductItemComponent
        ProductItemComponent component = GuiActionRunner.execute(() -> new ProductItemComponent(product, order));

        // Initialisation AssertJ-Swing
        JFrame frame = GuiActionRunner.execute(() -> {
            JFrame testFrame = new JFrame();
            testFrame.add(component);
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
    public void testProductDisplay() {
        // Vérifie que l'étiquette affiche correctement la description et le prix du produit
        String expectedText = "Cheeseburger() 5,00€";
        window.label().requireText(expectedText);
    }

    @Test
    public void testRemoveProductButton() {
        // Clique sur le bouton "Supprimer"
        window.button(JButtonMatcher.withText("Supprimer")).click();

        // Vérifie que la méthode removeProduct a été appelée sur le mock avec le produit correct
        assertEquals(0, order.getOrder().getProducts().size(), "Le produit devrait être supprimé après le clic.");
    }
}
