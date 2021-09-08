package shop.dao.interfaces;

import shop.entities.Logbook;
import shop.entities.Product;

import java.util.List;

public interface LogbookDao {
    Logbook addNote(Logbook note);
    List<Product> getCart(Integer purchaseID);
}
