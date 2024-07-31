package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.CarDAO;
import web.models.Car;

import java.util.List;

@Component
public class CarServiceImpl implements CarService {

    private final CarDAO carDAO;

    @Autowired
    public CarServiceImpl(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public List<Car> index(int count) {
        return carDAO.index(count).stream().limit(Long.MAX_VALUE).toList();
    }

    @Override
    public Car show(int id) {
        return carDAO.show(id).orElse(null);
    }

    @Override
    public void save(Car car) {
        carDAO.save(car);
    }

    @Override
    public void update(int id, Car updatedCar) {
        carDAO.update(id, updatedCar);
    }

    @Override
    public void delete(int id) {
        carDAO.delete(id);
    }
}
