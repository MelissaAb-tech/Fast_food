package item;

import javax.swing.*;

public class Boisson extends Item {
    public Boisson(String name, double price) {
        super(name, price);
    }

    public void customize() {
        String[] options = { "Avec glaçons", "Sans glaçons" };
        int choice = JOptionPane.showOptionDialog(null, "Personnalisez votre " + getName(), "Personnalisation",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice != -1) {
            System.out.println(getName() + " personnalisé: " + options[choice]);
        }
    }
}
