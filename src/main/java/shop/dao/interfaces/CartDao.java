package shop.dao.interfaces;

import shop.entities.Cart;

import java.util.List;

public interface CartDao {
    Cart getCartById(Integer id);
    List<Cart> getAllCarts();
    Cart addCart(Cart cart);
    Cart updateCart(Integer purchaseID, Integer productID, int price, int number);
    int getPaymentAmount(Integer purchaseID);
    boolean deleteCartById(Integer id);
}
