package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import java.util.List;

@Repository
public class UserDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public int countForIndex() {
        return sessionFactory.getCurrentSession().createQuery("select p from User p", User.class).getResultList().size();
    }

    @Transactional(readOnly = true)
    public List<User> index(int count) {
        List<User> listUser = sessionFactory.getCurrentSession().createQuery("select p from User p", User.class).getResultList();
        return listUser = listUser.subList(0, count);
    }

    @Transactional(readOnly = true)
    public User show(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Transactional
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Transactional
    public void update(int id, User updatedUser) {
        Session session = sessionFactory.getCurrentSession();
        User userToBeUpdated = session.get(User.class, id);

        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setLastname(updatedUser.getLastname());
        userToBeUpdated.setAge(updatedUser.getAge());
    }

    @Transactional
    public void delete(int id) {
    Session session = sessionFactory.getCurrentSession();
    session.remove(session.get(User.class, id));
    }
}
