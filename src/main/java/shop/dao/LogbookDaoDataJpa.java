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
    public Logbook getNoteById(Integer id) {
        return logbookRepository.findById(id).get();
    }

    @Override
    public Logbook updateNote(Logbook note) {
        return addNote(note);
    }

    @Override
    public List<Product> getCart(String userLogin) {
        List<Logbook> allCarts = logbookRepository.findAll();
        List<Product> cart = new ArrayList<>();
        for (Logbook oneCart : allCarts) {
            if (oneCart.getUserLogin().equals(userLogin)) {
                Product product = productRepository.findById(oneCart.getProductID()).get();
                cart.add(product);
            }
        }
        return cart;
    }

    @Override
    public boolean deleteCart(String userLogin) {
        List<Logbook> allCarts = logbookRepository.findAll();
        for (Logbook oneCart : allCarts) {
            if (oneCart.getUserLogin().equals(userLogin)) {
                logbookRepository.deleteById(oneCart.getId());
            }
        }
        return true;
    }


//    @Override
//    public Map<Integer, Integer> getPurchaseProducts(Integer purchaseID) {
//        Map<Integer, Integer> res = new HashMap<>();
//        logbookRepository.findAll()
//        return null;
//    }
}
