/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorneUI;


import javax.swing.JFrame;
import menu.Menu;
import order.Order;
import order.OrderManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuItemComponentTest {

    private FrameFixture window;
    private Menu menu;
    private OrderManager order;

    @BeforeEach
    void setUp() {
        // Créer un menu et un OrderManager avec un ordre vide
        menu = new Menu("Menu", 10.0);
        order = new OrderManager(new Order());
        order.addMenu(menu);
        // Créer et afficher le JFrame contenant MenuItemComponent pour les tests
        JFrame testFrame = GuiActionRunner.execute(() -> {
            JFrame frame = new JFrame();
            frame.setContentPane(new MenuItemComponent(menu, order));
            frame.pack(); // Ajuster la taille du frame pour s'adapter aux composants
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            return frame;
        });

        // Créer la fenêtre pour l'interaction avec le test
        window = new FrameFixture(testFrame);
        window.show(); // Afficher la fenêtre pour les tests
    }

    @AfterEach
    void tearDown() {
        window.cleanUp(); // Nettoyer après chaque test
    }

    @Test
    public void testConstructor() {
        // Vérifier que le texte de la description du menu est affiché correctement
        window.textBox().requireText(menu.getDescription());

        // Vérifier que le bouton "Supprimer" est bien présent et visible
        window.button("Supprimer").requireVisible();
    }

    @Test
    public void testSupprimerMenu() {
        // Compter le nombre d'éléments dans la commande avant la suppression
        int initialOrderSize = order.getOrder().getMenus().size();

        // Cliquer sur le bouton "Supprimer"
        window.button("Supprimer").click();

        // Vérifier que le menu a bien été supprimé de la commande
        int newOrderSize = order.getOrder().getMenus().size();
        assertEquals(initialOrderSize-1, newOrderSize, "Le menu n'a pas été supprimé correctement.");
    }
}
