/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorneUI;

/**
 *
 * @author conte
 */
import org.assertj.swing.annotation.GUITest;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import order.*;
import BorneUI.MainBorneUI;
import javax.swing.JFrame;
import java.util.ArrayList;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.junit.jupiter.api.AfterEach;


public class EditOrderFrameTest {

    private FrameFixture window;
    private OrderManager orderManager;
    private MainBorneUI main;
    private OrderListManager orderListManager;

    @BeforeEach
    void setUp() {
        // Créez les objets nécessaires avec les bons arguments
        orderManager = new OrderManager(new Order());  // Assurez-vous d'utiliser les bons arguments
        main = new MainBorneUI(orderManager, new OrderListManager(new ArrayList<>()), "parametre1");  // Passer les bons arguments
        orderListManager = new OrderListManager(new ArrayList<Order>());

        // Créez la fenêtre EditOrderFrame
        EditOrderFrame editOrderFrame = new EditOrderFrame(orderManager, main, orderListManager);

        JFrame testFrame = GuiActionRunner.execute(() -> {
            JFrame frame = new JFrame();
            frame.setContentPane(editOrderFrame);
            frame.pack(); // Adjust size to fit components
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            return frame;
        });
        // Créez un FrameFixture avec le JFrame
        window = new FrameFixture(testFrame);
        window.show();
    }
    @AfterEach
    void tearDown() {
        window.cleanUp(); // Cleanup resources after each test
    }
    /*@Test
public void testShowSelectMenusFrame() {
    // Récupérer EditOrderFrame directement à partir de la fenêtre de test
   EditOrderFrame editOrderFrame = (EditOrderFrame) window.robot().finder().find(new GenericTypeMatcher<EditOrderFrame>(EditOrderFrame.class) {
        @Override
        protected boolean isMatching(EditOrderFrame component) {
            return component != null;
        }
    });

    // Appel de showSelectMenusFrame() pour afficher le SelectMenusFrame
    editOrderFrame.showSelectMenusFrame();

    // Vérifier que SelectMenusFrame est visible
    window.panel(new GenericTypeMatcher<SelectMenusFrame>(SelectMenusFrame.class) {
        @Override
        protected boolean isMatching(SelectMenusFrame component) {
            return component != null && component.isVisible();
        }
    }).requireVisible();

    // Vérifier que SelectProductsFrame n'est pas visible
    window.panel(new GenericTypeMatcher<SelectProductsFrame>(SelectProductsFrame.class) {
        @Override
        protected boolean isMatching(SelectProductsFrame component) {
            return component == null || !component.isVisible();
        }
    }).requireNotVisible();
}
 @Test
    public void testShowSelectProductsFrame() {
        // Appel de showSelectProductsFrame() pour afficher le SelectProductsFrame
        EditOrderFrame editOrderFrame = (EditOrderFrame) window.robot().finder().find(new GenericTypeMatcher<EditOrderFrame>(EditOrderFrame.class) {
        @Override
        protected boolean isMatching(EditOrderFrame component) {
            return component != null;
        }
    });
        editOrderFrame.showSelectProductsFrame();

        // Vérifier que SelectProductsFrame est visible
        window.panel(new GenericTypeMatcher<SelectProductsFrame>(SelectProductsFrame.class) {
            @Override
            protected boolean isMatching(SelectProductsFrame component) {
                return component != null && component.isVisible();
            }
        }).requireVisible();

        // Vérifier que SelectMenusFrame n'est pas visible
        window.panel(new GenericTypeMatcher<SelectMenusFrame>(SelectMenusFrame.class) {
            @Override
            protected boolean isMatching(SelectMenusFrame component) {
                return component == null || !component.isVisible();
            }
        }).requireNotVisible();
    }

    @Test
    public void testInitialSelectionIsSelectProductsFrame() {
        // Vérifier que l'écran par défaut est SelectProductsFrame
        EditOrderFrame editOrderFrame = (EditOrderFrame) window.robot().finder().find(new GenericTypeMatcher<EditOrderFrame>(EditOrderFrame.class) {
        @Override
        protected boolean isMatching(EditOrderFrame component) {
            return component != null;
        }
    });
        editOrderFrame.showSelectProductsFrame(); // Déclenche l'affichage de SelectProductsFrame

        // Vérifier que SelectProductsFrame est visible au lancement
        window.panel(new GenericTypeMatcher<SelectProductsFrame>(SelectProductsFrame.class) {
            @Override
            protected boolean isMatching(SelectProductsFrame component) {
                return component != null && component.isVisible();
            }
        }).requireVisible();
    }

    @Test
    public void testOrderResumeFrameIsAlwaysVisible() {
        // Vérifier que OrderResumeFrame est toujours visible lors de l'affichage de chaque frame
        EditOrderFrame editOrderFrame = (EditOrderFrame) window.robot().finder().find(new GenericTypeMatcher<EditOrderFrame>(EditOrderFrame.class) {
        @Override
        protected boolean isMatching(EditOrderFrame component) {
            return component != null;
        }
    });

        // Afficher SelectMenusFrame
        editOrderFrame.showSelectMenusFrame();
        window.panel(new GenericTypeMatcher<OrderResumeFrame>(OrderResumeFrame.class) {
            @Override
            protected boolean isMatching(OrderResumeFrame component) {
                return component != null && component.isVisible();
            }
        }).requireVisible();

        // Afficher SelectProductsFrame
        editOrderFrame.showSelectProductsFrame();
        window.panel(new GenericTypeMatcher<OrderResumeFrame>(OrderResumeFrame.class) {
            @Override
            protected boolean isMatching(OrderResumeFrame component) {
                return component != null && component.isVisible();
            }
        }).requireVisible();
    }*/
}
