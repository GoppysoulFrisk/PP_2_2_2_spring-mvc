package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.Car;

import java.util.List;
import java.util.Optional;

@Component
public class CarDAOImpl implements CarDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public CarDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    @Transactional(readOnly = true)
//    public int countForIndex() {
//        return sessionFactory.getCurrentSession().createQuery("select p from Car p", Car.class).getResultList().size();
//    }

    @Transactional(readOnly = true)
    public List<Car> index(int count) {
        List<Car> listCar = sessionFactory.getCurrentSession().createQuery("select p from Car p", Car.class).getResultList();
        return listCar.subList(0, count);
    }

    @Transactional(readOnly = true)
    public Optional<Car> show(int id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(Car.class, id));
    }

    @Transactional
    public void save(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Transactional
    public void update(int id, Car updatedCar) {
        Session session = sessionFactory.getCurrentSession();
        Car carToBeUpdated = session.get(Car.class, id);

        carToBeUpdated.setModel(updatedCar.getModel());
        carToBeUpdated.setColor(updatedCar.getColor());
        carToBeUpdated.setYear(updatedCar.getYear());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Car.class, id));
    }
}
