package shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import shop.dao.interfaces.CartDao;
import shop.dao.interfaces.LogbookDao;
import shop.dao.interfaces.ProductDao;
import shop.dao.interfaces.PurchaseDao;
import shop.entities.Cart;
import shop.entities.Product;

@Controller
@RequestMapping(value = "cart")
public class CartController {

    private CartDao cartDao;
    private LogbookDao logbookDao;
    private ProductDao productDao;
    private PurchaseDao purchaseDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getCart(Model model) {
        Integer purchaseID = purchaseDao.getPurchaseNumber();
        model.addAttribute("cart", logbookDao.getCart(purchaseID));
        return "cart";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String addToCart(@PathVariable("id") int productID, Model model) {
        Product product = productDao.getProductById(productID);
        Integer purchaseID = purchaseDao.getPurchaseNumber();
        Cart cart = cartDao.updateCart(purchaseID, product.getProductID(), product.getPrice(), 1);
        model.addAttribute("cart", logbookDao.getCart(purchaseID));
        return "cart";
    }

    @Autowired
    public void setCartDao(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    @Autowired
    public void setLogbookDao(LogbookDao logbookDao) {
        this.logbookDao = logbookDao;
    }

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Autowired
    public void setPurchaseDao(PurchaseDao purchaseDao) {
        this.purchaseDao = purchaseDao;
    }
}
