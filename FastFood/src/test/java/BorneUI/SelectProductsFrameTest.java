/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorneUI;

/**
 *
 * @author conte
 */


import javax.swing.JFrame;
import order.Order;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import order.OrderManager;
import product.burger.CheeseBurgerFactory;
import product.burger.HamburgerFactory;
import product.burger.VeggieFactory;
import product.burger.BaconBurgerFactory;
import product.burger.ChickenBurgerFactory;
import product.burger.DoubleCheeseFactory;
import product.drink.DrinkFactory;
import product.dessert.DessertFactory;

public class SelectProductsFrameTest {

    private FrameFixture window;
    private OrderManager orderManager;

    @BeforeEach
    public void setUp() {
        // Initialisation de l'OrderManager
        orderManager = new OrderManager(new Order());

        // Création d'une instance de SelectProductsFrame
        SelectProductsFrame selectProductsFrame = GuiActionRunner.execute(() -> new SelectProductsFrame(orderManager));

        // Initialisation AssertJ-Swing
        JFrame frame = GuiActionRunner.execute(() -> {
            JFrame testFrame = new JFrame();
            testFrame.add(selectProductsFrame);
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
    public void testAddCheeseBurger() {
        // Clique sur le bouton "CheeseBurger"
        window.button(JButtonMatcher.withText("CheeseBurger 4.50€")).click();

        // Vérifie que le CheeseBurger a été ajouté à la commande
        assertEquals(1, orderManager.getOrder().getProducts().size(), "Un produit devrait être ajouté.");
        assertEquals("Cheeseburger", orderManager.getOrder().getProducts().get(0).getName(),
            "Le produit ajouté devrait être un CheeseBurger.");
    }

    @Test
    public void testAddHamburger() {
        // Clique sur le bouton "Hamburger"
        window.button(JButtonMatcher.withText("Hamburger 4.00€")).click();

        // Vérifie que l'Hamburger a été ajouté à la commande
        assertEquals(1, orderManager.getOrder().getProducts().size(), "Un produit devrait être ajouté.");
        assertEquals("Hamburger", orderManager.getOrder().getProducts().get(0).getName(),
            "Le produit ajouté devrait être un Hamburger.");
    }

    @Test
    public void testAddVeggieBurger() {
        // Clique sur le bouton "Veggie"
        window.button(JButtonMatcher.withText("Veggie 3.50€")).click();

        // Vérifie que le VeggieBurger a été ajouté à la commande
        assertEquals(1, orderManager.getOrder().getProducts().size(), "Un produit devrait être ajouté.");
        assertEquals("Veggie", orderManager.getOrder().getProducts().get(0).getName(),
            "Le produit ajouté devrait être un VeggieBurger.");
    }

    @Test
    public void testAddBaconBurger() {
        // Clique sur le bouton "BaconBurger"
        window.button(JButtonMatcher.withText("BaconBurger 5.00€")).click();

        // Vérifie que le BaconBurger a été ajouté à la commande
        assertEquals(1, orderManager.getOrder().getProducts().size(), "Un produit devrait être ajouté.");
        assertEquals("BaconBurger", orderManager.getOrder().getProducts().get(0).getName(),
            "Le produit ajouté devrait être un BaconBurger.");
    }

    @Test
    public void testAddChickenBurger() {
        // Clique sur le bouton "ChickenBurger"
        window.button(JButtonMatcher.withText("ChickenBurger 5.50€")).click();

        // Vérifie que le ChickenBurger a été ajouté à la commande
        assertEquals(1, orderManager.getOrder().getProducts().size(), "Un produit devrait être ajouté.");
        assertEquals("ChickenBurger", orderManager.getOrder().getProducts().get(0).getName(),
            "Le produit ajouté devrait être un ChickenBurger.");
    }

    @Test
    public void testAddDoubleCheese() {
        // Clique sur le bouton "DoubleCheese"
        window.button(JButtonMatcher.withText("DoubleCheese 6.00€")).click();

        // Vérifie que le DoubleCheese a été ajouté à la commande
        assertEquals(1, orderManager.getOrder().getProducts().size(), "Un produit devrait être ajouté.");
        assertEquals("DoubleCheese", orderManager.getOrder().getProducts().get(0).getName(),
            "Le produit ajouté devrait être un DoubleCheese.");
    }

    @Test
    public void testAddCoca() {
        // Clique sur le bouton "Coca"
        window.button(JButtonMatcher.withText("Coca 2.00€")).click();

        // Vérifie que le Coca a été ajouté à la commande
        assertEquals(1, orderManager.getOrder().getProducts().size(), "Un produit devrait être ajouté.");
        assertEquals("Coca", orderManager.getOrder().getProducts().get(0).getName(),
            "Le produit ajouté devrait être un Coca.");
    }

    @Test
    public void testAddEau() {
        // Clique sur le bouton "Eau"
        window.button(JButtonMatcher.withText("Eau 1.00€")).click();

        // Vérifie que l'Eau a été ajoutée à la commande
        assertEquals(1, orderManager.getOrder().getProducts().size(), "Un produit devrait être ajouté.");
        assertEquals("Eau", orderManager.getOrder().getProducts().get(0).getName(),
            "Le produit ajouté devrait être de l'Eau.");
    }

    @Test
    public void testAddJus() {
        // Clique sur le bouton "Jus"
        window.button(JButtonMatcher.withText("Jus 2.50€")).click();

        // Vérifie que le Jus a été ajouté à la commande
        assertEquals(1, orderManager.getOrder().getProducts().size(), "Un produit devrait être ajouté.");
        assertEquals("Jus", orderManager.getOrder().getProducts().get(0).getName(),
            "Le produit ajouté devrait être un Jus.");
    }

    @Test
    public void testAddGlace() {
        // Clique sur le bouton "Glace"
        window.button(JButtonMatcher.withText("Glace 3.00€")).click();

        // Vérifie que la Glace a été ajoutée à la commande
        assertEquals(1, orderManager.getOrder().getProducts().size(), "Un produit devrait être ajouté.");
        assertEquals("Glace", orderManager.getOrder().getProducts().get(0).getName(),
            "Le produit ajouté devrait être une Glace.");
    }

    @Test
    public void testAddTarte() {
        // Clique sur le bouton "Tarte"
        window.button(JButtonMatcher.withText("Tarte 2.50€")).click();

        // Vérifie que la Tarte a été ajoutée à la commande
        assertEquals(1, orderManager.getOrder().getProducts().size(), "Un produit devrait être ajouté.");
        assertEquals("Tarte", orderManager.getOrder().getProducts().get(0).getName(),
            "Le produit ajouté devrait être une Tarte.");
    }
}

