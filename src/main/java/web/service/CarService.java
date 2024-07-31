package web.service;

import web.models.Car;

import java.util.List;

public interface CarService {
    List<Car> index(int count);
    Car show(int id);
    void save(Car car);
    void update(int id, Car updatedCar);
    void delete(int id);
}
