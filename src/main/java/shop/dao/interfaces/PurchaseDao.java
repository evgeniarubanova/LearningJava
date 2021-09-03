package shop.dao.interfaces;

import shop.entities.Purchase;

import java.util.List;

public interface PurchaseDao {
    Purchase getPurchaseById(Integer id);
    List<Purchase> getAllPurchases();
    Purchase addPurchase(Purchase purchase);
    Purchase updatePurchase(Purchase purchase);
    boolean deletePurchaseById(Integer id);
    Integer getPurchaseNumber();
}