/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author conte
 */
public abstract class MenuFactoryTest {
    protected abstract MenuFactory getMenuFactory();

    @Test
    public void testGetMenu() {
        // Créer une instance de MenuFactory
        MenuFactory menuFactory = getMenuFactory();
        
        // Obtenez le menu généré par la factory
        Menu menu = menuFactory.getMenu();
        
        // Vérifiez que le nom du menu est correctement défini
        assertNotNull("Le nom du menu ne doit pas être nul", menu.getName());
        
        // Vérifiez que le prix du menu est bien défini
        assertTrue(menu.getPrice() > 0);
        
        // Vérifiez que le menu contient au moins un produit
        assertTrue( menu.getProducts().size() > 0);
    }
}
