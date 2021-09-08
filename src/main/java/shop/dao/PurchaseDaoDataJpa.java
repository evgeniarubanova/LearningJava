package shop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.interfaces.PurchaseDao;
import shop.entities.Purchase;
import shop.repositories.ProductRepository;
import shop.repositories.PurchaseRepository;

import java.util.List;

@Service
public class PurchaseDaoDataJpa implements PurchaseDao {

    private PurchaseRepository purchaseRepository;

    @Autowired
    public void setPurchaseRepository(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public PurchaseDaoDataJpa() {}

    @Override
    public Purchase getPurchaseById(Integer id) {
        return purchaseRepository.getById(id);
    }

    @Override
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase addPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase updatePurchase(Purchase purchase) {
        return addPurchase(purchase);
    }

    @Override
    public boolean deletePurchaseById(Integer id) {
        purchaseRepository.deleteById(id);
        return true;
    }

    @Override
    public Integer getPurchaseNumber() {
        List<Purchase> allPurchases = getAllPurchases();
        Integer number = allPurchases.get(allPurchases.size()-1).getPurchaseID();
        return number + 1;
    }
}
