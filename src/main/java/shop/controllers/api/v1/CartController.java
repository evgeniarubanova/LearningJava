package shop.controllers.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import shop.dao.interfaces.LogbookDao;
import shop.dto.LogbookDto;
import shop.entities.Logbook;
import shop.entities.Product;
import shop.repositories.LogbookRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/cart")
public class CartController {

    private LogbookDao logbookDao;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getCart(@RequestParam String userLogin) {
        List<Product> cart = logbookDao.getCart(userLogin);
        return cart;
    }

    @PostMapping(value = "/add",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public LogbookDto addToCart(@RequestParam String userLogin, @RequestBody LogbookDto logbookDto) {
        logbookDao.addNote(
                new Logbook(userLogin, logbookDto.getProductID(), logbookDto.getCount())
        );
        return logbookDto;
    }

    @PutMapping(value = "/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public LogbookDto updateCart(@RequestParam Integer id, @RequestBody LogbookDto logbookDto) {
        logbookDto.setId(id);
        logbookDao.updateNote(
                new Logbook(
                        logbookDto.getId(),
                        logbookDto.getUserLogin(),
                        logbookDto.getProductID(),
                        logbookDto.getCount()));
        return logbookDto;
    }

    @DeleteMapping(value = "/delete")
    public void deleteCart(@RequestParam String login) {
        logbookDao.deleteCart(login);
    }

    @Autowired
    public void setLogbookDao(LogbookDao logbookDao) {
        this.logbookDao = logbookDao;
    }
}
