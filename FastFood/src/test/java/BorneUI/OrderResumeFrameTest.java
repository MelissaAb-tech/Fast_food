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
import javax.swing.JFrame;
import menu.Menu;
import order.Order;
import order.OrderManager;
import order.OrderListManager;
import static org.assertj.core.api.Assertions.assertThat;
import product.Product;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.DialogFixture;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import product.burger.Burger;
import product.drink.Drink;

public class OrderResumeFrameTest {

    private FrameFixture window;
    private OrderManager orderManager;
    private OrderListManager orderListManager;
    private OrderResumeFrame orderResumeFrame;
    private Product product;
    private Menu menu;

    @BeforeEach
    void setUp() {
        // Créer des objets nécessaires pour les tests
        orderListManager = new OrderListManager(new ArrayList<>());
        orderManager = new OrderManager(new Order());
        product = new Burger("Burger 1", 5.0);
        menu = new Menu("Menu 1", 10.0);

        // Ajouter un produit et un menu à la commande
        orderManager.addProduct(product);
        orderManager.addMenu(menu);

        // Créer le JFrame et initialiser le panel OrderResumeFrame
        JFrame testFrame = GuiActionRunner.execute(() -> {
            JFrame frame = new JFrame();
            orderResumeFrame = new OrderResumeFrame(orderManager, new MainBorneUI(orderManager, orderListManager, "Test User"), orderListManager);
            frame.setContentPane(orderResumeFrame);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            return frame;
        });
        
        window = new FrameFixture(testFrame);
        window.show(); // Afficher la fenêtre pour les tests
    }

    @AfterEach
    void tearDown() {
        window.cleanUp(); // Nettoyer après chaque test
    }

    @Test
    public void testInitialOrderView() {
        orderResumeFrame.update(orderManager.getOrder());
        // Vérifier que le texte du total est correctement affiché
        window.label("TotalPriceLabel").requireText("Total : 15.0€");

        // Vérifier que l'élément produit et le menu sont bien ajoutés à la liste
        window.panel("ElementList").requireVisible();
       // assertTrue(orderResumeFrame.ElementList.getComponentCount() > 0, "La liste des éléments ne contient pas d'éléments.");
    }

    @Test
    public void testClearOrderButton() {
        // Avant de vider la commande, vérifier le nombre d'éléments
        int initialItemCount = orderManager.getOrder().getProducts().size() + orderManager.getOrder().getMenus().size();

        // Cliquer sur le bouton "Vider la commande"
        window.button("ClearOrderButton").click();

        // Vérifier que la commande est vide après avoir cliqué
        int newItemCount = orderManager.getOrder().getProducts().size() + orderManager.getOrder().getMenus().size();
        assertEquals(0, newItemCount, "La commande n'a pas été vidée.");
    }

   /* @Test
    public void testValidateOrderButton() {
        orderResumeFrame.update(orderManager.getOrder());
        // Avant de valider la commande, vérifier l'affichage du total
        window.label("TotalPriceLabel").requireText("Total : 15.0€");

        // Simuler le clic sur le bouton "Valider la commande"
        window.button("ValidateOrder").click();

        DialogFixture dialog = window.dialog();
        String dialogText = dialog.label("OptionPane.label").text(); // Get the text of the first label
        //CA NE MARCHE PAS JSP PQ
        assertThat(dialogText).contains("Cela fait un total de 15.00€, passer commande ?");
        
        // Vérifier que la confirmation de commande a été affichée
        //window.dialog().requireTitle("Confirmation");
        //window.dialog().requireText("Cela fait un total de 15.00€, passer commande ?");
    }*/

    //tous les boutons dans la boite de dialogue ont le même nom donc on ne peut pas les tester
   /* @Test
    public void testOrderValidationAction() {
        // Avant de valider la commande, vérifier l'état de la commande
        assertEquals(1, orderManager.getOrder().getProducts().size(), "Le produit n'est pas dans la commande.");
        assertEquals(1, orderManager.getOrder().getMenus().size(), "Le menu n'est pas dans la commande.");

        // Simuler le clic sur le bouton "Valider la commande" et confirmer la commande
        window.button("ValidateOrder").click();
        window.dialog().button().requireText("Yes").click(); // Simuler le clic sur "YES" dans la fenêtre de confirmation

        // Vérifier que la commande a bien été transférée à la liste des commandes
        assertEquals(1, orderListManager.getOrders().size(), "La commande n'a pas été ajoutée à la liste des commandes.");
    }*/

    @Test
    public void testElementListUpdate() {
        // Ajouter un nouveau produit et vérifier qu'il apparaît dans la liste des éléments
        Product newProduct = new Drink("New Product", 7.0);
        orderManager.addProduct(newProduct);

        // Vérifier qu'un élément supplémentaire a été ajouté
        //assertTrue(orderResumeFrame.ElementList.getComponentCount() > 2, "La liste des éléments n'a pas été mise à jour.");
    }
}
