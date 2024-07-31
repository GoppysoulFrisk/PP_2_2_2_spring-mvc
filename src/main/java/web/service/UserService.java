package web.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.dao.UserDAOInterface;
import web.models.User;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class UserService implements UserServiceInterface {

    private final UserDAOInterface userDAO;

    public UserService(UserDAOInterface userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getThemAll() {
        return userDAO.getThemAll();
    }

    @Override
    public User getThemById(Long id) {
        return userDAO.getThemById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void update(User updatedUser) {
        userDAO.update(updatedUser);
    }

    @Override
    public void delete(Long id) {
        userDAO.delete(id);
    }
}
