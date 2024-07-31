package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import jakarta.transaction.Transactional;
import web.models.User;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class UserDAO implements UserDAOInterface {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    @Override
    public void save(User user) {
        em.persist(user);
    }

    public List<User> getThemAll(/*int count*/) {
        return em.createQuery("from User", User.class).getResultList()/* = listUser.subList(0, count)*/;
    }

//    @Transactional(readOnly = true)
//    public int countForGetThemAll() {
//        return em.createQuery("select p from User p", User.class).getResultList().size();
//    }

    public Optional<User> getThemById(Long id) {
        return Optional.ofNullable(em.find(User.class, id));
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    public void delete(Long id) {
        User user = getThemById(id).get();
        em.remove(user);
    }
}
