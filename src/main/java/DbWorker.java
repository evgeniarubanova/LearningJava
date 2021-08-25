import entities.Product;
import entities.Purchase;
import entities.Ticket;
import entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbWorker {

    private Connection connection;

    public void init() throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5433/VTBshop11";
        String user = "postgres";
        String pass = "qwerty123";
        this.connection = DriverManager.getConnection(dbUrl, user, pass);
    }

    public void createProduct(Product p) throws SQLException {
        final PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO Product(title, description, price, category, stock_balance) VALUES(?, ?, ?, ?, ?);");

        preparedStatement.setString(1, p.getTitle());
        preparedStatement.setString(2, p.getDescription());
        preparedStatement.setInt(3, p.getPrice());
        preparedStatement.setString(4, p.getCategory());
        preparedStatement.setInt(5, p.getStockBalance());

        preparedStatement.execute();
    }

    public List<Product> readProducts() throws SQLException {
        final Statement statement = connection.createStatement();
        final ResultSet resultSet = statement.executeQuery("SELECT * FROM Product;");

        List<Product> result = new ArrayList<>();
        while (resultSet.next()) {
            final String title = resultSet.getString("title");
            final String text = resultSet.getString("description");
            final int price = resultSet.getInt("price");
            final String category = resultSet.getString("category");
            final int stockBalance = resultSet.getInt("stock_balance");
            final int id = resultSet.getInt("product_id");

            final Product product = new Product(title, text, price, category, stockBalance, id);
            result.add(product);
        }
        return result;
    }

    public int getPriceByProductID(int productID) throws SQLException {
        final PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT * FROM Product WHERE product_id=?;");

        preparedStatement.setInt(1, productID);
        final ResultSet resultSet = preparedStatement.executeQuery();

        int price = 0;
        if (resultSet.next()) {
            final int res = resultSet.getInt("price");
            price += res;
        }

        return price;
    }

    public void updateProductPriceByTitle(String title, int price) throws SQLException {
        final PreparedStatement preparedStatement =
                connection.prepareStatement("UPDATE Product SET price=? WHERE title=?;");

        preparedStatement.setInt(1, price);
        preparedStatement.setString(2, title);
        preparedStatement.execute();
    }

    public void updateProductStockBalance(int productID, int number) throws SQLException {
        final PreparedStatement preparedStatement =
                connection.prepareStatement("UPDATE Product SET stock_balance=? WHERE product_id=?;");

        preparedStatement.setInt(1, number);
        preparedStatement.setInt(2, productID);
        preparedStatement.execute();
    }

    public void deleteProductByTitle(String t) throws SQLException {
        final PreparedStatement preparedStatement =
                connection.prepareStatement("DELETE FROM Product WHERE title=?;");

        preparedStatement.setString(1, t);
        preparedStatement.execute();
    }

    public void createPurchase(Purchase p) throws SQLException {
        final PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO Purchase(delivery, payment_amount, purchase_status, user_id) VALUES(?, ?, ?, ?);");

        preparedStatement.setString(1, p.getDelivery());
        preparedStatement.setInt(2, p.getPaymentAmount());
        preparedStatement.setString(3, p.getPurchaseStatus());
        preparedStatement.setInt(4, p.getUserID());

        preparedStatement.execute();
    }

    public List<Purchase> readPurchases() throws SQLException {
        final Statement statement = connection.createStatement();
        final ResultSet resultSet = statement.executeQuery("SELECT * FROM Purchase;");

        List<Purchase> result = new ArrayList<>();
        while (resultSet.next()) {
            final String delivery = resultSet.getString("delivery");
            final int amount = resultSet.getInt("payment_amount");
            final String status = resultSet.getString("purchase_status");
            final int userID = resultSet.getInt("user_id");
            final int purchaseID = resultSet.getInt("purchase_ID");

            final Purchase purchase = new Purchase(delivery, amount, status, userID, purchaseID);
            result.add(purchase);
        }
        return result;
    }

    public void updatePurchaseStatus(int id, String status) throws SQLException {
        final PreparedStatement preparedStatement =
                connection.prepareStatement("UPDATE Purchase SET purchase_status=? WHERE purchase_id=?;");

        preparedStatement.setString(1, status);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public void deletePurchaseByID(int id) throws SQLException {
        final PreparedStatement preparedStatement =
                connection.prepareStatement("DELETE FROM Purchase WHERE purchase_id=?;");

        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public void createUser(User u) throws SQLException {
        final PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO Customer(name, surname, address, phone_number) VALUES(?, ?, ?, ?);");

        preparedStatement.setString(1, u.getName());
        preparedStatement.setString(2, u.getSurname());
        preparedStatement.setString(3, u.getAddress());
        preparedStatement.setString(4, u.getNumber());

        preparedStatement.execute();
    }

    public List<User> readUsers() throws SQLException {
        final Statement statement = connection.createStatement();
        final ResultSet resultSet = statement.executeQuery("SELECT * FROM Customer;");

        List<User> result = new ArrayList<>();
        while (resultSet.next()) {
            final String name = resultSet.getString("name");
            final String surname = resultSet.getString("surname");
            final String address = resultSet.getString("address");
            final String number = resultSet.getString("phone_number");
            final int id = resultSet.getInt("user_id");

            final User user = new User(name, surname, address, number, id);
            result.add(user);
        }
        return result;
    }

    public void updateUserAddress(int id, String address) throws SQLException {
        final PreparedStatement preparedStatement =
                connection.prepareStatement("UPDATE Customer SET address=? WHERE user_id=?;");

        preparedStatement.setString(1, address);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public void deleteUserByID(int id) throws SQLException {
        final PreparedStatement preparedStatement =
                connection.prepareStatement("DELETE FROM Customer WHERE user_id=?;");

        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public void createTicket(Ticket t) throws SQLException {
        final PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO Ticket(message_text, priority, ticket_status, user_id) VALUES(?, ?, ?, ?);");

        preparedStatement.setString(1, t.getMessageText());
        preparedStatement.setString(2, t.getPriority());
        preparedStatement.setString(3, t.getTicketStatus());
        preparedStatement.setInt(4, t.getUserID());

        preparedStatement.execute();
    }

    public List<Ticket> readTickets() throws SQLException {
        final Statement statement = connection.createStatement();
        final ResultSet resultSet = statement.executeQuery("SELECT * FROM Ticket;");

        List<Ticket> result = new ArrayList<>();
        while (resultSet.next()) {
            final String name = resultSet.getString("message_text");
            final String surname = resultSet.getString("priority");
            final String address = resultSet.getString("ticket_status");
            final int userID = resultSet.getInt("user_id");
            final int ticketID = resultSet.getInt("ticket_id");

            final Ticket ticket = new Ticket(name, surname, address, userID, ticketID);
            result.add(ticket);
        }
        return result;
    }

    public void updateTicketStatus(int id, String status) throws SQLException {
        final PreparedStatement preparedStatement =
                connection.prepareStatement("UPDATE Ticket SET ticket_status=? WHERE ticket_id=?;");

        preparedStatement.setString(1, status);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public void deleteTicketByID(int id) throws SQLException {
        final PreparedStatement preparedStatement =
                connection.prepareStatement("DELETE FROM Ticket WHERE ticket_id=?;");

        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public void putInTheBasket(int purchaseID, int productID, int number) throws SQLException {
        final PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO Purchase_products(purchase_id, product_id, number) VALUES(?, ?, ?);");

        preparedStatement.setInt(1, purchaseID);
        preparedStatement.setInt(2, productID);
        preparedStatement.setInt(3, number);

        preparedStatement.execute();
    }

    public Map<Integer, Integer> getBasket(int purchaseID) throws SQLException {
        final PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT * FROM Purchase_products WHERE purchase_id=?;");

        preparedStatement.setInt(1, purchaseID);
        final ResultSet resultSet = preparedStatement.executeQuery();

        Map<Integer, Integer> res = new HashMap<Integer, Integer>();
        while (resultSet.next()) {
            final int productID = resultSet.getInt("product_id");
            final int number = resultSet.getInt("number");
            res.put(productID, number);
        }
        return res;
    }

}