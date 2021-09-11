//package shop.controllers.api.v1;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import shop.dao.interfaces.ProductDao;
//
//@RestController
//@RequestMapping(value = "/api/v1/shop")
//public class ShopController {
//    private ProductDao productDao;
//
//    @RequestMapping(value = "/shop", method = RequestMethod.GET)
//    public String getAllProducts(Model model) {
//        model.addAttribute("allProducts", productDao.getAllProducts());
//        return "shop";
//    }
//
//    @Autowired
//    public void setProductDao(ProductDao productDao) {
//        this.productDao = productDao;
//    }
//}
