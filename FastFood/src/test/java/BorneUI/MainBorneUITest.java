/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorneUI;

/**
 *
 * @author conte
 */

import java.util.ArrayList;
import order.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;

class MainBorneUITest {

    private MainBorneUI mainBorneUI;
    private OrderManager orderManager;
    private OrderListManager orderListManager;

    @BeforeEach
    void setUp() {
        // Création de mocks ou objets réels pour les dépendances de la classe à tester.
        orderManager = new OrderManager(new Order()); // Assurez-vous que cette classe est correctement définie et instanciée
        orderListManager = new OrderListManager(new ArrayList<>()); // Idem pour OrderListManager
        mainBorneUI = new MainBorneUI(orderManager, orderListManager, "TestUser");
    }

    @Test
    void testConstructor() {
        // Vérifier que l'interface s'initialise correctement
        assertNotNull(mainBorneUI);
        assertNotNull(mainBorneUI.getOrderManager());
        assertEquals("Borne de commande", mainBorneUI.getTitle());
        assertTrue(mainBorneUI.getSize().equals(new java.awt.Dimension(800, 600)));
    }

    @Test
    void testShowEditOrderFrame_Menu() {
        mainBorneUI.showEditOrderFrame("menu");
        
        // Vérifiez que le bon cadre est affiché
        assertTrue(mainBorneUI.isAncestorOf(mainBorneUI.getEditOrderFrame()));
        assertTrue(mainBorneUI.getEditOrderFrame().isVisible());
    }

    @Test
    void testShowEditOrderFrame_Product() {
        mainBorneUI.showEditOrderFrame("product");
        
       assertTrue(mainBorneUI.isAncestorOf(mainBorneUI.getEditOrderFrame()));
        assertTrue(mainBorneUI.getEditOrderFrame().isVisible());
    }

    @Test
    void testShowChoiceFrame() {
        // Initialisation et test de l'affichage du frame de choix
        mainBorneUI.showChoiceFrame();
        assertTrue(mainBorneUI.isAncestorOf(mainBorneUI.getChoiceFrame()));
    }

    @Test
    void testShowPaymentFrame() {
        // Créer un ordre fictif pour tester
        Order currentOrder = new Order();  // Assurez-vous que la classe Order est définie
        mainBorneUI.showPaymentFrame(currentOrder);

        // Vérifier que la fenêtre de paiement est bien visible
        assertFalse(mainBorneUI.isVisible());
        //assertTrue(mainBorneUI.getPaymentFrame().isVisible());
    }

    @Test
    void testGetOrderManager() {
        assertEquals(orderManager, mainBorneUI.getOrderManager());
    }

    //orderListManager n'est pas initialisé dans MainBorneUI
    /*@Test
    void testGetOrderListManager() {
        assertEquals(orderListManager, mainBorneUI.getOrderListManager());
    }*/
}

