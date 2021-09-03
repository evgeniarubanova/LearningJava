package shop.dao.interfaces;

import shop.entities.Product;

import java.util.List;

public interface ProductDao {
    Product getProductById(Integer id);
    List<Product> getAllProducts();
    Product addProduct(Product product);
    Product updateProduct(Product product);
    boolean deleteProductById(Integer id);
}