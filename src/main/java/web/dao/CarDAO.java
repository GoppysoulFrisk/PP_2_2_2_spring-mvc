package web.dao;

import web.models.Car;

import java.util.List;
import java.util.Optional;

public interface CarDAO {
     List<Car> index(int count);
     Optional<Car> show(int id);
     void save(Car car);
     void update(int id, Car updatedCar);
     void delete(int id);
}
