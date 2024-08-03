package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import jakarta.transaction.Transactional;
import web.models.User;

import java.util.List;
import java.util.Optional;

@Component
public class UserDAO implements UserDAOInterface {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public List<User> getThemAll(/*int count*/) {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public Optional<User> getThemById(Long id) {
        return Optional.ofNullable(em.find(User.class, id));
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public void delete(Long id) {
        User user = getThemById(id).get();
        em.remove(user);
    }
}
