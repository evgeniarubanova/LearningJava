package shop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.interfaces.ProductDao;
import shop.entities.Product;
import shop.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductDaoDataJpa implements ProductDao {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDaoDataJpa() {}

    @Override
    public Product getProductById(Integer id) {
        return productRepository.getById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return addProduct(product);
    }

    @Override
    public boolean deleteProductById(Integer id) {
        productRepository.deleteById(id);
        return true;
    }
}