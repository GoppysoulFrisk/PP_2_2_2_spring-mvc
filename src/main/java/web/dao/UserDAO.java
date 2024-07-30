package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(User user) {
        em.persist(user);
    }

    @Transactional(readOnly = true)
    public List<User> getThemAll(int count) {
        List<User> listUser = em.createQuery("select p from User p", User.class).getResultList();
        return listUser = listUser.subList(0, count);
    }

    @Transactional(readOnly = true)
    public int countForGetThemAll() {
        return em.createQuery("select p from User p", User.class).getResultList().size();
    }

    @Transactional(readOnly = true)
    public User getThemById(Long id) {
        return em.find(User.class, id);
    }

    @Transactional
    public void update(Long id, User updatedUser) {
        User userToBeUpdated = em.find(User.class, id);

        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setLastname(updatedUser.getLastname());
        userToBeUpdated.setAge(updatedUser.getAge());
    }

    @Transactional
    public void delete(Long id) {
        User user = getThemById(id);
        if (user != null) {
            em.remove(user);
        }
    }
}
