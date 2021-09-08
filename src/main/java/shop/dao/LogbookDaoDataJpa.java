package shop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.interfaces.LogbookDao;
import shop.entities.Logbook;
import shop.entities.Product;
import shop.repositories.LogbookRepository;
import shop.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogbookDaoDataJpa implements LogbookDao {

    private LogbookRepository logbookRepository;
    private ProductRepository productRepository;

    @Autowired
    public void setLogbookRepository(LogbookRepository logbookRepository) {
        this.logbookRepository = logbookRepository;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public LogbookDaoDataJpa() {}

    @Override
    public Logbook addNote(Logbook note) {
        return logbookRepository.save(note);
    }

    @Override
    public List<Product> getCart(Integer purchaseID) {
        List<Logbook> allCarts = logbookRepository.findAll();
        List<Product> cart = new ArrayList<>();
        for (Logbook oneCart : allCarts) {
            if (oneCart.getPurchaseID().equals(purchaseID)) {
                Product product = productRepository.findById(oneCart.getProductID()).get();
                cart.add(product);
            }
        }
        return cart;
    }

//    @Override
//    public Map<Integer, Integer> getPurchaseProducts(Integer purchaseID) {
//        Map<Integer, Integer> res = new HashMap<>();
//        logbookRepository.findAll()
//        return null;
//    }
}
