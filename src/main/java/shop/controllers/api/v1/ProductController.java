package shop.controllers.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import shop.dao.interfaces.ProductDao;
import shop.dto.ProductDto;
import shop.entities.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {
    private ProductDao productDao;

    @GetMapping(value = "/{id}")
    public ProductDto getProduct(@PathVariable("id") Integer id) {
        Product product = productDao.getProductById(id);
        ProductDto productDto = new ProductDto(product.getProductID(), product.getTitle(), product.getDescription(), product.getPrice());
        return productDto;
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ProductDto> getAllProducts() {
        final Collection<Product> allProducts = productDao.getAllProducts();
        final List<ProductDto> result = new ArrayList<>(allProducts.size());
        for (Product product : allProducts) {
            result.add(new ProductDto(product.getProductID(),
                    product.getTitle(),
                    product.getDescription(),
                    product.getPrice()));
        }
        return result;
    }

    @PutMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto updateProduct(@PathVariable int id, @RequestBody ProductDto productDto) {
        productDto.setProductID(id);
        Product product = productDao.getProductById(id);
        productDao.updateProduct(new Product(productDto.getProductID(), productDto.getTitle(), productDto.getDescription(), productDto.getPrice(), product.getCategory(), product.getStockBalance()));
        return productDto;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable("id") Integer id) {
        productDao.deleteProductById(id);
    }

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
