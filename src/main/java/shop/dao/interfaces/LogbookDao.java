package shop.dao.interfaces;

import shop.entities.Logbook;
import shop.entities.Product;

import java.util.List;

public interface LogbookDao {
    Logbook addNote(Logbook note);
    Logbook getNoteById(Integer id);
    Logbook updateNote(Logbook note);
    List<Product> getCart(String userLogin);
    boolean deleteCart(String userLogin);
}
