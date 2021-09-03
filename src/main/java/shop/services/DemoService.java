package shop.services;

import org.springframework.stereotype.Service;
import shop.dao.interfaces.*;
import shop.entities.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Collection;
import java.util.List;


@Service
public class DemoService implements ApplicationContextAware{

    private ApplicationContext ctx;

    private ProductDao productDao;
    private UserDao userDao;
    private PurchaseDao purchaseDao;
    private TicketDao ticketDao;
    private CartDao cartDao;

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setPurchaseDao(PurchaseDao purchaseDao) {
        this.purchaseDao = purchaseDao;
    }

    @Autowired
    public void setTicketDao(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Autowired
    public void setCartDao(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }

    public void demo() {
        Product product1 = new Product("Мыло кусковое Palmolive Натурэль", "Подарите своей коже ощущение нежности с туалетным мылом Palmolive, которое содержит натуральный экстракт ромашки и витамин Е. Ромашка оказывает успокаивающее и противовоспалительное действие на кожу, так как богата витаминами, органическими кислотами и микроэлементами.", 69, "мыло", 120);
        Product product2 = new Product("Смартфон Xiaomi Redmi 9C", "В бюджетной линейке смартфонов Redmi появилась новинка — Redmi 9С c 3-модульной камерой, с помощью которой можно снимать все: от ярких и удивительных кадров в режиме макро до масштабных пейзажей. Основная камера на 13 Мп обеспечивает кристально чистое изображение каждый раз. ", 9990, "телефон", 50);
        product1 = productDao.addProduct(product1);
        product2 = productDao.addProduct(product2);
//        productDao.deleteProductById(product1.getProductID());
        Collection<Product> allProducts = productDao.getAllProducts();
        System.out.println(allProducts);

        User user1 = new User("Михаил", "Петров", "г. Москва, ул. Октябрьская, д. 87б, кв. 24", "+79099773451");
        User user2 = new User("Юлия", "Иванова", "МО, г. Серпухов, ул. Ленина, д.56, кв.20", "89035302875");
        User user3 = new User("Елена", "Смирнова", "МО, г. Люберцы, ул. Первомайская, д.20/2, кв.13", "+79284728172");
        user1 = userDao.addUser(user1);
        user2 = userDao.addUser(user2);
        user3 = userDao.addUser(user3);
        Collection<User> allUsers = userDao.getAllUsers();
        System.out.println(allUsers);

        user1 = (User) allUsers.toArray()[0];
        user3 = (User) allUsers.toArray()[2];

        Ticket ticket1 = new Ticket("Здравствуйте. Хочу перенести дату доставки на 26 сентября. Возможно ли это?", "средний", "new", user1.getId());
        Ticket ticket2 = new Ticket("Прошу перезвонить мне для согласования даты доставки.", "средний", "new", user3.getId());
        ticket1 = ticketDao.addTicket(ticket1);
        ticket2 = ticketDao.addTicket(ticket2);
        Collection<Ticket> allTickets = ticketDao.getAllTickets();
        System.out.println(allTickets);

        Integer purchaseNumber = purchaseDao.getPurchaseNumber();
        product1 = (Product) allProducts.toArray()[0];
        product2 = (Product) allProducts.toArray()[1];
        Cart cart1 = cartDao.updateCart(purchaseNumber, product1.getProductID(), product1.getPrice(), 2);
        cart1 = cartDao.updateCart(purchaseNumber, product2.getProductID(), product2.getPrice(), 1);
        Purchase purchase1 = new Purchase(purchaseNumber, "г. Москва", cartDao.getPaymentAmount(purchaseNumber), "new", user1.getId());
        purchaseDao.addPurchase(purchase1);
        Collection<Purchase> allPurchases = purchaseDao.getAllPurchases();
        System.out.println(allPurchases);
    }

}
