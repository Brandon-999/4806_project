package main.service;

import main.model.OrderModel;
import main.model.ShoppingCartModel;
import main.model.UserModel;
import main.repository.ShoppingCartRepository;
import main.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepo;
    private final ShoppingCartRepository shoppingCartRepo;

    /*private final OrderRepository orderRepository;*/

    public UserServiceImpl(UserRepository userRepo, ShoppingCartRepository shoppingCartRepo){
        this.userRepo = userRepo;
        this.shoppingCartRepo = shoppingCartRepo;

        /*this.orderRepository = orderRepository;*/     //I'm not sure if this is needed
    }



    /**
     * Try to add an Order object associated with a user.
     * If a user with the provided username does not exist, nothing will happen.
     * @param username the user you wish to add the order to
     * @param orderModel The OrderModel that you want to add to the user's order list.
     */
    @Override
    public void saveOrder(String username, OrderModel orderModel) {
        UserModel userModel = userRepo.findByName(username);
        if(userModel != null){
            OrderModel order = orderRepo.save(orderModel);
            userModel.setShoppingCart(shoppingCart);
        }
        userRepo.save(userModel);
    }


    /**
     * Remove an order with the provided ID from the associated user.
     * The method gets the current order list, updates it and then sets the order list.
     * The order and user repo are updated.
     * @param username the user you wish to remove the order from
     * @param id The id of the OrderModel that you want to remove to the user's order list.
     */
    @Override
    public void removeOrder(String username, Integer id) {
        UserModel userModel = userRepo.findByName(username);
        OrderModel orderModel = orderRepo.findById(id);
        List<OrderModel> orderList = userModel.getOrderList();
        orderList.removeIf(order -> order.getId().equals(id));
        userModel.setOrderList(orderList);
        orderRepo.delete(orderModel);
        userRepo.save(userModel);
    }

    /**
     * Get all order objects currently associated with a user
     * @param username the user whose orders you are retrieving
     * @return a list of all OrderModels associated with the user
     */
    @Override
    public List<OrderModel> getOrderList(String username) {
        UserModel userModel = userRepo.findByName(username);
        return userModel.getOrderList();
    }

    /**
     * Try to set the shopping cart object associated with a user.
     * If a user with the provided username does not exist, nothing will happen.
     * @param username the user you wish to associate the shoppingCartModel with
     * @param shoppingCartModel the ShoppingCartModel that will be added to the shoppingCartRepo
     *                          and associated with the user.
     */
    @Override
    public void setCart(String username, ShoppingCartModel shoppingCartModel) {
        UserModel userModel = userRepo.findByName(username);
        if(userModel != null){
            ShoppingCartModel shoppingCart = shoppingCartRepo.save(shoppingCartModel);
            userModel.setShoppingCart(shoppingCart);
        }
        userRepo.save(userModel);
    }

    /**
     * Remove the shopping cart associated with a user.
     * Set the shopping cart for the user to null.
     * Remove the shopping cart from the shoppingCartRepo
     * @param username the user whose shopping cart is being removed
     */
    @Override
    public void removeCart(String username,) {
        UserModel userModel = userRepo.findByName(username);
        ShoppingCartModel shoppingCart = userModel.getShoppingCart();
        userModel.setShoppingCart(null);
        shoppingCartRepo.delete(shoppingCartModel);
        userRepo.save(userModel);
    }

    /**
     * Get the shopping cart object currently associated with a user
     * @param username the user whose shopping cart you are retrieving
     * @return ShoppingCartModel object associated with user
     */
    @Override
    public ShoppingCartModel getShoppingCart(String username) {
        UserModel userModel = userRepo.findByName(username);
        return userModel.getShoppingCart();
    }

    /**
     * Replace the shipping address of a user
     * @param username the user whose shipping address you are updating
     * @param shippingAddress the new shipping address that will be associated with the user
     */
    @Override
    public void updateShippingAddress(String username, String shippingAddress) {
        UserModel userModel = userRepo.findByName(username);
        userModel.setShippingAddress(shippingAddress);
    }

    /**
     * Get the shipping address associated with a user. Retrieved using username.
     * @param username
     * @return shipping address of user as a String
     */
    @Override
    public String getShippingAddress(String username) {
        UserModel userModel = userRepo.findByName(username);
        return userModel.getShippingAddress();
    }

    /**
     * Replace the billing address of a user
     * @param username the user whose billing address you are updating
     * @param billingAddress the new billing address that will be associated with the user
     */
    @Override
    public void updateBilling(String username, String billingAddress) {
        UserModel userModel = userRepo.findByName(username);
        userModel.setBillingAddress(billingAddress);
    }

    /**
     * Get the billing address associated with a user. Retrieved using username.
     * @param username
     * @return billing address of user as a String
     */
    @Override
    public String getBillingAddress(String username) {
        UserModel userModel = userRepo.findByName(username);
        return userModel.getBillingAddress();
    }

    /**
     * Replace the email address of a user
     * @param username the user whose email you are updating
     * @param email the new email address that will be associated with the user
     */
    @Override
    public void updateEmail(String username, String email) {
        UserModel userModel = userRepo.findByName(username);
        userModel.setEmail(email);
    }

    /**
     * Get the email address associated with a user. Retrieved using username.
     * @param username
     * @return email of user as a String
     */
    @Override
    public String getEmail(String username) {
        UserModel userModel = userRepo.findByName(username);
        return userModel.getEmail();
    }


}
