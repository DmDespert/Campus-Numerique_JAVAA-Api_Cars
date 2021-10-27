package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.cars.Cars;

import java.util.List;

public interface CarsDao {
    public List<Cars> findAll();

    public Cars findById(int id);

    public Cars save(Cars cars);

    public Cars update(Cars cars, int id);

    public Boolean delete(int id);
}
