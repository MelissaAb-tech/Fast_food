package id.fastfood;

import BorneUI.MainBorneUI;
import KitchenUI.MainKitchenUI;
import order.*;

import java.util.ArrayList;

public class FastFood {

    public static void main(String[] args) {
        Order order = new Order();
        OrderManager orderManager = new OrderManager(order);
        OrderListManager orderListManager = new OrderListManager(new ArrayList<>());
        MainBorneUI mainBorneUI = new MainBorneUI(orderManager, orderListManager);
        MainKitchenUI mainKitchenUI = new MainKitchenUI(orderListManager);
        
        mainBorneUI.setVisible(true);
        mainKitchenUI.setVisible(true);
    }
}
