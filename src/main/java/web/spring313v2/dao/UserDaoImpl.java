package web.spring313v2.dao;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.spring313v2.model.Role;
import web.spring313v2.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createNewUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUserById(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("From User", User.class).getResultList();
    }

    @Override
    public Optional<User> getUserById(Long id) {

        User user = (User) entityManager.createQuery("SELECT u FROM User u WHERE u.id = :id")
                .setParameter("id", id).getSingleResult();
        if (user == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> getUserByLogin(String login) {

        User user = (User) entityManager.createQuery("SELECT u FROM User u WHERE u.login = :login")
                .setParameter("login", login).getSingleResult();
        if (user == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(user);
    }

    @Override
    public Optional<Role> getRoleByName(String name) {

        Role role = (Role) entityManager.createQuery("SELECT r FROM Role r WHERE r.name = :name")
                .setParameter("name", name).getSingleResult();
        if (role == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(role);
    }

}
