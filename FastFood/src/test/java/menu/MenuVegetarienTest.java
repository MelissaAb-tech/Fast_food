/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
/**
 *
 * @author conte
 */
public class MenuVegetarienTest extends MenuFactoryTest{
    @Override
    protected MenuFactory getMenuFactory() {
        return new MenuVegetarienFactory();  // Renvoie l'instance de MenuClassiqueFactory
    }
    @Test
    public void testMenuClassiqueSpecific() {
        // Test spécifique à MenuClassiqueFactory (par exemple, vérifier les produits)
        Menu menu = getMenuFactory().getMenu();

        // Vérifiez le nom du menu
        assertEquals("Menu végétarien", menu.getName());

        // Vérifiez le prix du menu
        assertEquals(11.0, menu.getPrice(), 0.01);

        // Vérifiez qu'il y a trois produits (un hamburger, une boisson, un dessert)
        assertEquals(3, menu.getProducts().size());

        // Vérifiez que les produits sont de types corrects
        assertTrue(menu.getProducts().get(0) instanceof product.burger.Burger);
        assertTrue(menu.getProducts().get(1) instanceof product.drink.Drink);
        assertTrue(menu.getProducts().get(2) instanceof product.dessert.Dessert);
    }
}
