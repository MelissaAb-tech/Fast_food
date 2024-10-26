import javax.swing.*;
import java.awt.*;
import order.OrderManager;
import item.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent; 

public class FastFoodUI extends JFrame {
    private JList<String> orderList;
    private DefaultListModel<String> orderModel;
    private JLabel totalLabel;
    private OrderManager orderManager;

    public FastFoodUI() {
        super("QuickBite - Commande rapide");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1350, 720);

        orderManager = new OrderManager();

        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JPanel menuPanel = createMenuPanel();
        JPanel orderPanel = createOrderPanel();

        mainPanel.add(menuPanel);
        mainPanel.add(orderPanel);

        add(mainPanel);
        setVisible(true);
    }

    private JPanel createMenuPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Menu"));

        panel.add(createCategoryPanel("Burgers", new Item[] {
                new Burger("Cheeseburger", 4.5),
                new Burger("Hamburger", 4.0),
                new Burger("Veggie", 3.5),
                new Burger("BaconBurger", 5.0),
                new Burger("ChickenBurger", 5.5),
                new Burger("DoubleCheeseburger", 6.0)
        }));

        panel.add(createCategoryPanel("Boissons", new Item[] {
                new Boisson("Cola", 2.0),
                new Boisson("Eau", 1.0),
                new Boisson("Jus", 2.5),
                new Boisson("The", 2.0), // Nouvelle boisson
                new Boisson("Limonade", 2.5), // Nouvelle boisson
        }));

        panel.add(createCategoryPanel("Desserts", new Item[] {
                new Dessert("Glace", 3.0),
                new Dessert("Tarte", 2.5),
                new Dessert("Brownie", 2.0),
                new Dessert("Fondant", 2.0),
                new Dessert("Macaron", 3.0),
                new Dessert("Donut", 3.0)
        }));

        return panel;
    }

    private JPanel createCategoryPanel(String category, Item[] items) {
        JPanel panel = new JPanel(new GridLayout((items.length + 2) / 3, 3, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder(category));

        for (Item item : items) {
            JPanel itemPanel = new JPanel(new BorderLayout());
            itemPanel.setBorder(BorderFactory.createLineBorder(Color.blue, 1)); // Contour noir de 2 pixels
            // Afficher l'image de l'article
            ImageIcon icon = new ImageIcon("images/" + item.getName().toLowerCase().replace(" ", "") + ".jpg");
            Image scaledImage = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

            // Ajouter un MouseListener à l'image
            imageLabel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    addToOrder(item); // Ajouter l'article à la commande lorsque l'image est cliquée
                }
            });

            itemPanel.add(imageLabel, BorderLayout.NORTH); // Ajouter l'image en haut

            // Panneau pour le nom de l'article
            JLabel nameLabel = new JLabel(item.getName() + " - " + String.format("%.2f €", item.getPrice()),
                    SwingConstants.CENTER);
            itemPanel.add(nameLabel, BorderLayout.CENTER); // Nom centré

            // Ajouter le sous-panel à la catégorie
            panel.add(itemPanel); // Ajouter le panneau de l'article au panel principal
        }

        return panel;
    }

    private void addToOrder(Item item) {
        orderModel.addElement(item.getName() + " - " + item.getPrice() + " €");
        orderManager.addItem(item);
        updateTotalLabel();
    }

    private JPanel createOrderPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Votre commande"));

        orderModel = new DefaultListModel<>();
        orderList = new JList<>(orderModel);
        panel.add(new JScrollPane(orderList), BorderLayout.CENTER);

        totalLabel = new JLabel("Total : 0.00 €");
        panel.add(totalLabel, BorderLayout.NORTH);

        JButton deleteButton = new JButton("Supprimer l'élément");
        deleteButton.addActionListener(e -> removeFromOrder());
        panel.add(deleteButton, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton clearButton = new JButton("Vider la commande");
        clearButton.addActionListener(e -> clearOrder());
        buttonPanel.add(clearButton);

        JButton validateButton = new JButton("Valider la commande");
        validateButton.addActionListener(e -> validateOrder());
        buttonPanel.add(validateButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    }

    private void removeFromOrder() {
        int selectedIndex = orderList.getSelectedIndex();
        if (selectedIndex != -1) {
            orderManager.removeItem(selectedIndex);
            orderModel.remove(selectedIndex);
            updateTotalLabel();
        } else {
            JOptionPane.showMessageDialog(this, "Sélectionnez un élément à supprimer !", "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearOrder() {
        orderManager.clearOrder();
        orderModel.clear();
        updateTotalLabel();
    }

    private void validateOrder() {
        if (orderModel.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Votre commande est vide !", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, orderManager.getOrderSummary(), "Commande validée",
                    JOptionPane.INFORMATION_MESSAGE);
            clearOrder();
        }
    }

    private void updateTotalLabel() {
        totalLabel.setText(String.format("Total : %.2f €", orderManager.getTotalPrice()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FastFoodUI::new);
    }
}
