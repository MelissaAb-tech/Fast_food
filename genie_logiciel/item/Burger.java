package item;

import javax.swing.*;

public class Burger extends Item {
    public Burger(String name, double price) {
        super(name, price);
    }

    public void customize() {
        String[] options = { "Sans fromage", "Sans oignons", "Sans bacon", "Sans sauce", "Sans tomate" };
        int choice = JOptionPane.showOptionDialog(null, "Personnalisez votre " + getName(), "Personnalisation",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice != -1) {
            System.out.println(this.getName() + " personnalisé: " + options[choice]);
        }
    }
}
