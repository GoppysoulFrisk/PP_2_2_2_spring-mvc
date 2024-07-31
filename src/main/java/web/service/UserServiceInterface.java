package web.service;

import web.models.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    List<User> getThemAll(/*int count*/);

    User getThemById(Long id);

    void save(User user);

    void update(User updatedUser);

    void delete(Long id);
}
