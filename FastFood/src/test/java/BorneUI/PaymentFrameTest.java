/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorneUI;

/**
 *
 * @author conte
 */

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JOptionPaneFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import order.Order;
import order.OrderListManager;
import order.OrderManager;
import product.Product;
import product.burger.Burger;

import java.util.ArrayList;

public class PaymentFrameTest {

    private FrameFixture window;
    private Order order;
    private MainBorneUI mainMock;

    @BeforeEach
    public void setUp() {
        // Création d'une commande factice
        order = new Order();
        Product product = new Burger("Cheeseburger", 5.00);
        order.addProduct(product);

        // Mock de MainBorneUI
        OrderManager orderManager = new OrderManager(order);
        OrderListManager orderListManager = new OrderListManager(new ArrayList<>());
        mainMock = GuiActionRunner.execute(() -> new MainBorneUI(orderManager, orderListManager, "TestUser"));

        // Création de la fenêtre PaymentFrame
        PaymentFrame frame = GuiActionRunner.execute(() -> new PaymentFrame(mainMock, order));

        // Initialisation AssertJ-Swing
        window = new FrameFixture(frame);
        window.show(); // Affiche la fenêtre pour les tests
    }

    @AfterEach
    public void tearDown() {
        window.cleanUp(); // Nettoyage après chaque test
    }

    @Test
    public void testCashPaymentButton() {
        // Vérifie que la fenêtre PaymentFrame est visible
        assertTrue(window.target().isVisible(), "PaymentFrame devrait être visible au début.");

        // Clique sur le bouton "Especes"
        window.button(JButtonMatcher.withText("Especes")).click();

        // Vérifie qu'un message de succès est affiché
        JOptionPaneFixture dialog = window.optionPane();
        dialog.requireVisible();
        dialog.requireMessage("Paiement effectué avec succès via especes");
        dialog.okButton().click();

        // Vérifie que la fenêtre de résumé de commande s'affiche
       // assertTrue(window.robot().finder().find(OrderSummaryFrame.class).isShowing(),
       //         "OrderSummaryFrame devrait être affiché après un paiement.");

        // Vérifie que PaymentFrame est fermé
        assertFalse(window.target().isShowing(), "PaymentFrame devrait être fermé après un paiement.");
    }

    @Test
    public void testCardPaymentButton() {
        // Vérifie que la fenêtre PaymentFrame est visible
        assertTrue(window.target().isVisible(), "PaymentFrame devrait être visible au début.");

        // Clique sur le bouton "Carte Bancaire"
        window.button(JButtonMatcher.withText("Carte Bancaire")).click();

        // Vérifie qu'un message de succès est affiché
        JOptionPaneFixture dialog = window.optionPane();
        dialog.requireVisible();
        dialog.requireMessage("Paiement effectué avec succès via carte");
        dialog.okButton().click();

        // Vérifie que la fenêtre de résumé de commande s'affiche
//        assertTrue(window.robot().finder().find(OrderSummaryFrame.class).isShowing(),
        //        "OrderSummaryFrame devrait être affiché après un paiement.");

        // Vérifie que PaymentFrame est fermé
        assertFalse(window.target().isShowing(), "PaymentFrame devrait être fermé après un paiement.");
    }
}

