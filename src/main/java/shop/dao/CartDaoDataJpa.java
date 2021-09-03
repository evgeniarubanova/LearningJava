package shop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.interfaces.CartDao;
import shop.entities.Cart;
import shop.entities.Logbook;
import shop.repositories.CartRepository;
import shop.repositories.LogbookRepository;
import shop.repositories.ProductRepository;

import java.util.List;

@Service
public class CartDaoDataJpa implements CartDao {

    private CartRepository cartRepository;
    private LogbookRepository logbookRepository;
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setLogbookRepository(LogbookRepository logbookRepository) {
        this.logbookRepository = logbookRepository;
    }

    @Autowired
    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public CartDaoDataJpa() {}

    @Override
    public Cart getCartById(Integer id) {
        return cartRepository.getById(id);
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCart(Integer purchaseID, Integer productID, int price, int number) {
        Logbook note = new Logbook(purchaseID, productID, number);
        logbookRepository.save(note);
        int oldPurchase = 0;
        try {
            oldPurchase = cartRepository.findById(purchaseID).get().getPurchaseAmount();
        } catch (Exception e) {
            e.getStackTrace();
        }
        Cart cart = new Cart(purchaseID, price * number + oldPurchase);
        return addCart(cart);
    }

    @Override
    public int getPaymentAmount(Integer purchaseID) {
        List<Logbook> purchaseProducts = logbookRepository.getAllByPurchaseID(purchaseID);
        int amount = 0;
        for (Logbook p : purchaseProducts) {
            amount += productRepository.findById(p.getProductID()).get().getPrice();
        }
        return amount;
//        return cartRepository.getById(purchaseID).getPurchaseAmount();
    }

    @Override
    public boolean deleteCartById(Integer id) {
        cartRepository.deleteById(id);
        return true;
    }
}
