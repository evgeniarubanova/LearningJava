package shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.dao.interfaces.CartDao;
import shop.dao.interfaces.ProductDao;
import shop.dao.interfaces.PurchaseDao;
import shop.entities.Cart;
import shop.entities.Product;

@Controller
@RequestMapping(value = "product")
public class ProductController {
    private ProductDao productDao;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productDao.getProductById(id));
        return "product";
    }

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
