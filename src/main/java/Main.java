import entities.Product;
import entities.Purchase;
import entities.Ticket;
import entities.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws SQLException {
        DbWorker db = new DbWorker();
        db.init();

        //Операции с продуктами
        db.createProduct(new Product("Мыло кусковое Palmolive Натурэль", "Подарите своей коже ощущение нежности с туалетным мылом Palmolive, которое содержит натуральный экстракт ромашки и витамин Е. Ромашка оказывает успокаивающее и противовоспалительное действие на кожу, так как богата витаминами, органическими кислотами и микроэлементами.", 69, "мыло", 120));
        db.createProduct(new Product("Смартфон Xiaomi Redmi 9C", "В бюджетной линейке смартфонов Redmi появилась новинка — Redmi 9С c 3-модульной камерой, с помощью которой можно снимать все: от ярких и удивительных кадров в режиме макро до масштабных пейзажей. Основная камера на 13 Мп обеспечивает кристально чистое изображение каждый раз. ", 9990, "телефон", 50));
        db.createProduct(new Product("Стул кухонный Амабель", "Данная модель выполнена из прочного пластика, имеет несколько цветовых вариантов и отлично впишется в любой интерьер.", 500, "телефон", 60));
        db.deleteProductByTitle("Мыло кусковое Palmolive Натурэль");
        db.updateProductPriceByTitle("Смартфон Xiaomi Redmi 9C", 10370);
        List<Product> products = db.readProducts();
        System.out.println("\nPRODUCT:\n" + products);

        //Операции с пользователями
        User user1 = new User("Михаил", "Петров", "г. Москва, ул. Октябрьская, д. 87б, кв. 24", "+79099773451");
        User user2 = new User("Юлия", "Иванова", "МО, г. Серпухов, ул. Ленина, д.56, кв.20", "89035302875");
        User user3 = new User("Елена", "Смирнова", "МО, г. Люберцы, ул. Первомайская, д.20/2, кв.13", "+79284728172");
        db.createUser(user1);
        db.createUser(user2);
        db.createUser(user3);
        List<User> users = db.readUsers();
        db.updateUserAddress(users.get(0).getId(), "г. Москва, ул. Колхозная, д. 45А, кв. 78");
        db.deleteUserByID(users.get(1).getId());
        users = db.readUsers();
        System.out.println("\nCUSTOMER:\n" + users);

        //Операции с тикетами
        Ticket ticket1 = new Ticket("Здравствуйте. Хочу перенести дату доставки на 26 сентября. Возможно ли это?", "средний", "new", users.get(1).getId());
        Ticket ticket2 = new Ticket("Прошу перезвонить мне для согласования даты доставки.", "средний", "new", users.get(0).getId());
        db.createTicket(ticket1);
        db.createTicket(ticket2);
        List<Ticket> tickets = db.readTickets();
        db.updateTicketStatus(tickets.get(0).getTicketID(), "in work");
        db.deleteTicketByID(tickets.get(1).getTicketID());
        tickets = db.readTickets();
        System.out.println("\nTICKET:\n" + tickets);

        //Операции с покупками
        List<Purchase> purchases = db.readPurchases();
        int purchaseID = purchases.size() + 1;
        int number1 = 2;
        int number2 = 1;
        db.putInTheBasket(purchaseID, products.get(0).getId(), number1);
        db.putInTheBasket(purchaseID, products.get(1).getId(), number2);

        Map<Integer, Integer> basket = db.getBasket(purchaseID);
        int paymentAmount = 0;
        for (Map.Entry entry : basket.entrySet()) {
            int price = db.getPriceByProductID((Integer) entry.getKey());
            paymentAmount += price * (Integer) entry.getValue();
        }

        db.createPurchase(new Purchase(users.get(1).getAddress(),
                paymentAmount, "new order", users.get(1).getId()));
        db.createPurchase(new Purchase(users.get(0).getAddress(),
                paymentAmount, "new order", users.get(0).getId()));

        purchases = db.readPurchases();
        db.updatePurchaseStatus(purchases.get(0).getPurchaseID(), "in work");
        db.deletePurchaseByID(purchases.get(1).getPurchaseID());
        purchases = db.readPurchases();
        System.out.println("\nPURCHASE:\n" + purchases);

        //Обновляем БД после совершения покупки
        db.updateProductStockBalance(products.get(0).getId(), products.get(0).getStockBalance() - number1);
        db.updateProductStockBalance(products.get(1).getId(), products.get(1).getStockBalance() - number2);

        List<Product> newProducts = db.readProducts();
        System.out.println("\nТаблица PRODUCT после совершения покупки:\n" + newProducts);

    }
}