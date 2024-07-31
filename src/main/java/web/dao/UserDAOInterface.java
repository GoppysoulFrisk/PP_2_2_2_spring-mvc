package web.dao;

import web.models.User;

import java.util.List;
import java.util.Optional;

public interface UserDAOInterface {

    List<User> getThemAll(/*int count*/);

    Optional<User> getThemById(Long id);

    void save(User user);

    void update(User updatedUser);

    void delete(Long id);
}
