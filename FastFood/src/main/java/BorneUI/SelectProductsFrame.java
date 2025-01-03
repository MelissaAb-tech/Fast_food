package BorneUI;
import order.OrderManager;
import product.burger.*;
import product.drink.DrinkFactory;
import product.dessert.DessertFactory;

public class SelectProductsFrame extends javax.swing.JPanel {
    private OrderManager order;
    
    /**
     * Creates new form SelectProductsFrame
     */
    public SelectProductsFrame(OrderManager order) {
        this.order = order;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        CheeseBurgerButton = new javax.swing.JButton();
        HamburgerButton = new javax.swing.JButton();
        VeggieButton = new javax.swing.JButton();
        BaconBurgerButton = new javax.swing.JButton();
        ChickenBurgerButton = new javax.swing.JButton();
        DoubleCheeseButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        CocaButton = new javax.swing.JButton();
        EauButton = new javax.swing.JButton();
        JusButton = new javax.swing.JButton();
        TheButton = new javax.swing.JButton();
        LimonadeButton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        GlaceButton = new javax.swing.JButton();
        TarteButton = new javax.swing.JButton();
        BrownieButton = new javax.swing.JButton();
        FondantButton = new javax.swing.JButton();
        MacaronButton = new javax.swing.JButton();
        DonutButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Menu");
        add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.GridLayout(3, 1));

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Burgers");
        jPanel2.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel5.setLayout(new java.awt.GridLayout(2, 3, 10, 10));

        CheeseBurgerButton.setText("CheeseBurger 4.50€");
        CheeseBurgerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CheeseBurgerButtonMouseClicked(evt);
            }
        });
        jPanel5.add(CheeseBurgerButton);

        HamburgerButton.setText("Hamburger 4.00€");
        HamburgerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HamburgerButtonMouseClicked(evt);
            }
        });
        jPanel5.add(HamburgerButton);

        VeggieButton.setText("Veggie 3.50€");
        VeggieButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VeggieButtonMouseClicked(evt);
            }
        });
        jPanel5.add(VeggieButton);

        BaconBurgerButton.setText("BaconBurger 5.00€");
        BaconBurgerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BaconBurgerButtonMouseClicked(evt);
            }
        });
        jPanel5.add(BaconBurgerButton);

        ChickenBurgerButton.setText("ChickenBurger 5.50€");
        ChickenBurgerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChickenBurgerButtonMouseClicked(evt);
            }
        });
        jPanel5.add(ChickenBurgerButton);

        DoubleCheeseButton.setText("DoubleCheese 6.00€");
        DoubleCheeseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DoubleCheeseButtonMouseClicked(evt);
            }
        });
        jPanel5.add(DoubleCheeseButton);

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Boissons");
        jPanel6.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel7.setLayout(new java.awt.GridLayout(2, 3, 10, 10));

        CocaButton.setText("Coca 2.00€");
        CocaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CocaButtonMouseClicked(evt);
            }
        });
        jPanel7.add(CocaButton);

        EauButton.setText("Eau 1.00€");
        EauButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EauButtonMouseClicked(evt);
            }
        });
        jPanel7.add(EauButton);

        JusButton.setText("Jus 2.50€");
        JusButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JusButtonMouseClicked(evt);
            }
        });
        jPanel7.add(JusButton);

        TheButton.setText("Thé 2.00€");
        TheButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TheButtonMouseClicked(evt);
            }
        });
        jPanel7.add(TheButton);

        LimonadeButton.setText("Limonade 2.50€");
        LimonadeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LimonadeButtonMouseClicked(evt);
            }
        });
        jPanel7.add(LimonadeButton);

        jPanel6.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel6);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Desserts");
        jPanel8.add(jLabel4, java.awt.BorderLayout.PAGE_START);

        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel9.setLayout(new java.awt.GridLayout(2, 3, 10, 10));

        GlaceButton.setText("Glace 3.00€");
        GlaceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GlaceButtonMouseClicked(evt);
            }
        });
        jPanel9.add(GlaceButton);

        TarteButton.setText("Tarte 2.50€");
        TarteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TarteButtonMouseClicked(evt);
            }
        });
        jPanel9.add(TarteButton);

        BrownieButton.setText("Brownie 2.00€");
        BrownieButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BrownieButtonMouseClicked(evt);
            }
        });
        jPanel9.add(BrownieButton);

        FondantButton.setText("Fondant 2.00€");
        FondantButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FondantButtonMouseClicked(evt);
            }
        });
        jPanel9.add(FondantButton);

        MacaronButton.setText("Macaron 3.00€");
        MacaronButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MacaronButtonMouseClicked(evt);
            }
        });
        jPanel9.add(MacaronButton);

        DonutButton.setText("Donut 3.00€");
        DonutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DonutButtonMouseClicked(evt);
            }
        });
        jPanel9.add(DonutButton);

        jPanel8.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel8);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void CheeseBurgerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheeseBurgerButtonMouseClicked
        this.order.addProduct(new CheeseBurgerFactory().getBurger());
    }//GEN-LAST:event_CheeseBurgerButtonMouseClicked

    private void HamburgerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HamburgerButtonMouseClicked
        this.order.addProduct(new HamburgerFactory().getBurger());
    }//GEN-LAST:event_HamburgerButtonMouseClicked

    private void VeggieButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VeggieButtonMouseClicked
        this.order.addProduct(new VeggieFactory().getBurger());
    }//GEN-LAST:event_VeggieButtonMouseClicked

    private void BaconBurgerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BaconBurgerButtonMouseClicked
        this.order.addProduct(new BaconBurgerFactory().getBurger());
    }//GEN-LAST:event_BaconBurgerButtonMouseClicked

    private void ChickenBurgerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChickenBurgerButtonMouseClicked
        this.order.addProduct(new ChickenBurgerFactory().getBurger());
    }//GEN-LAST:event_ChickenBurgerButtonMouseClicked

    private void DoubleCheeseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DoubleCheeseButtonMouseClicked
        this.order.addProduct(new DoubleCheeseFactory().getBurger());
    }//GEN-LAST:event_DoubleCheeseButtonMouseClicked

    private void CocaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CocaButtonMouseClicked
        this.order.addProduct(new DrinkFactory().getCoca());
    }//GEN-LAST:event_CocaButtonMouseClicked

    private void EauButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EauButtonMouseClicked
        this.order.addProduct(new DrinkFactory().getEau());
    }//GEN-LAST:event_EauButtonMouseClicked

    private void JusButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JusButtonMouseClicked
        this.order.addProduct(new DrinkFactory().getJus());
    }//GEN-LAST:event_JusButtonMouseClicked

    private void TheButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TheButtonMouseClicked
        this.order.addProduct(new DrinkFactory().getThe());
    }//GEN-LAST:event_TheButtonMouseClicked

    private void LimonadeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LimonadeButtonMouseClicked
        this.order.addProduct(new DrinkFactory().getLimonade());
    }//GEN-LAST:event_LimonadeButtonMouseClicked

    private void GlaceButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GlaceButtonMouseClicked
        this.order.addProduct(new DessertFactory().getGlace());
    }//GEN-LAST:event_GlaceButtonMouseClicked

    private void TarteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TarteButtonMouseClicked
        this.order.addProduct(new DessertFactory().getTarte());
    }//GEN-LAST:event_TarteButtonMouseClicked

    private void BrownieButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BrownieButtonMouseClicked
        this.order.addProduct(new DessertFactory().getBrownie());
    }//GEN-LAST:event_BrownieButtonMouseClicked

    private void FondantButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FondantButtonMouseClicked
        this.order.addProduct(new DessertFactory().getFondant());
    }//GEN-LAST:event_FondantButtonMouseClicked

    private void MacaronButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MacaronButtonMouseClicked
        this.order.addProduct(new DessertFactory().getMacaron());
    }//GEN-LAST:event_MacaronButtonMouseClicked

    private void DonutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DonutButtonMouseClicked
        this.order.addProduct(new DessertFactory().getDonut());
    }//GEN-LAST:event_DonutButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BaconBurgerButton;
    private javax.swing.JButton BrownieButton;
    private javax.swing.JButton CheeseBurgerButton;
    private javax.swing.JButton ChickenBurgerButton;
    private javax.swing.JButton CocaButton;
    private javax.swing.JButton DonutButton;
    private javax.swing.JButton DoubleCheeseButton;
    private javax.swing.JButton EauButton;
    private javax.swing.JButton FondantButton;
    private javax.swing.JButton GlaceButton;
    private javax.swing.JButton HamburgerButton;
    private javax.swing.JButton JusButton;
    private javax.swing.JButton LimonadeButton;
    private javax.swing.JButton MacaronButton;
    private javax.swing.JButton TarteButton;
    private javax.swing.JButton TheButton;
    private javax.swing.JButton VeggieButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
