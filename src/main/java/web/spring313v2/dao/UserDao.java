package web.spring313v2.dao;

import web.spring313v2.model.Role;
import web.spring313v2.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    void createNewUser(User user);
    void editUser(User user);
    void deleteUserById(Long id);
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    Optional<User> getUserByLogin(String login);
    Optional<Role> getRoleByName(String name);
}
