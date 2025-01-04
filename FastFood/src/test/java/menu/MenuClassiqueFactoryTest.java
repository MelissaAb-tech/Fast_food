/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

/**
 *
 * @author conte
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author conte
 */
public class MenuClassiqueFactoryTest extends MenuFactoryTest {

    @Override
    protected MenuFactory getMenuFactory() {
        return new MenuClassiqueFactory(); // Renvoie l'instance de MenuClassiqueFactory
    }

    @Test
    public void testMenuClassiqueSpecific() {
        // Test spécifique à MenuClassiqueFactory (par exemple, vérifier les produits)
        Menu menu = getMenuFactory().getMenu();

        // Vérifiez le nom du menu
        assertEquals("Menu classique", menu.getName(), "Le nom du menu ne correspond pas");

        // Vérifiez le prix du menu
        assertEquals(10.0, menu.getPrice(), 0.01, "Le prix du menu ne correspond pas");

        // Vérifiez qu'il y a trois produits (un hamburger, une boisson, un dessert)
        assertEquals(3, menu.getProducts().size(), "Le nombre de produits dans le menu est incorrect");

        // Vérifiez que les produits sont de types corrects
        assertTrue(menu.getProducts().get(0) instanceof product.burger.Burger, "Le premier produit n'est pas un hamburger");
        assertTrue(menu.getProducts().get(1) instanceof product.drink.Drink, "Le deuxième produit n'est pas une boisson");
        assertTrue(menu.getProducts().get(2) instanceof product.dessert.Dessert, "Le troisième produit n'est pas un dessert");
    }
}

