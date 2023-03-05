package main.service;

import main.model.OrderModel;
import main.model.ShoppingCartModel;

import java.util.List;

public interface UserService {

    void saveOrder(String username, OrderModel orderModel);
    void removeOrder(String username, Integer id);
    List<OrderModel> getOrderList(String username);


    void setCart(String username, ShoppingCartModel shoppingCartModel);
    void removeCart(String username);
    ShoppingCartModel getShoppingCart(String username);


    void updateShippingAddress(String username, String shippingAddress);
    String getShippingAddress(String username);
    void updateBilling(String username, String billingAddress);
    String getBillingAddress(String username);
    void updateEmail(String username, String email);
    String getEmail(String username);
}
