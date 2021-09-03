package shop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.interfaces.UserDao;
import shop.entities.User;
import shop.repositories.ProductRepository;
import shop.repositories.UserRepository;

import java.util.List;

@Service
public class UserDaoDataJpa implements UserDao {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDaoDataJpa() {}

    @Override
    public User getUserById(Integer id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return addUser(user);
    }

    @Override
    public boolean deleteUserById(Integer id) {
        userRepository.deleteById(id);
        return true;
    }
}
