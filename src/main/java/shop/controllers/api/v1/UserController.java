package shop.controllers.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import shop.dao.interfaces.UserDao;
import shop.dto.UserDto;
import shop.entities.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    private UserDao userDao;

    @GetMapping(value = "/all",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Collection<UserDto> getAllUsers() {
        final Collection<User> allUsers = userDao.getAllUsers();
        final List<UserDto> result = new ArrayList<>(allUsers.size());
        for (User user : allUsers) {
            result.add(
                    new UserDto(
                            user.getName(),
                            user.getSurname(),
                            user.getAddress(),
                            user.getNumber(),
                            user.getLogin()));
        }
        return result;
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto getUser(@RequestParam String userLogin) {
        User user = userDao.getUserByLogin(userLogin);
        return new UserDto(
                user.getName(),
                user.getSurname(),
                user.getAddress(),
                user.getNumber(),
                user.getLogin());
    }

    @PostMapping(value = "/create",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto createUser(@RequestBody UserDto userDto) {
        userDao.addUser(
                new User(
                        userDto.getName(),
                        userDto.getSurname(),
                        userDto.getAddress(),
                        userDto.getNumber(),
                        userDto.getLogin(),
                        userDto.getPassword()
                )
        );
        return userDto;
    }

    @PutMapping(value = "/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto updateUser(@RequestParam Integer id, @RequestBody UserDto userDto) {
        userDao.updateUser(
                new User(
                        id,
                        userDto.getName(),
                        userDto.getSurname(),
                        userDto.getAddress(),
                        userDto.getNumber(),
                        userDto.getLogin(),
                        userDto.getPassword()
                )
        );
        return userDto;
    }

    @DeleteMapping(value = "/delete")
    public void deleteUser(@RequestParam Integer id) {
        userDao.deleteUserById(id);
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
