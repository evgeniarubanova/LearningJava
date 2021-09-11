package shop.dao.interfaces;

import shop.entities.User;

import java.util.List;

public interface UserDao {
    User getUserById(Integer id);
    User getUserByLogin(String userLogin);
    List<User> getAllUsers();
    User addUser(User user);
    User updateUser(User user);
    boolean deleteUserById(Integer id);
}
