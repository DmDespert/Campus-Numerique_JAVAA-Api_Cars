package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.cars.Cars;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarsDaoImpl implements CarsDao {
    public static List<Cars> cars = new ArrayList<>();
    static {
        cars.add(new Cars(1, new String("Scenic MPV")));
        cars.add(new Cars(2, new String("Polo 6")));
        cars.add(new Cars(3, new String("AMG C 63 S")));
    }

    /**
     * Find all method return list of cars
     * @return
     */
    @Override
    public List<Cars> findAll() {
        return cars;
    }

    /**
     * Find one Model method, return Car by id
     * @param id
     * @return
     */
    @Override
    public Cars findById(int id) {
        for (Cars tableCars : cars) {
            if (tableCars.getId() == id) {
                return tableCars;
            }
        }
        return null;
    }

    /**
     * Save Model method, return Car to add
     * @param cars
     * @return
     */
    @Override
    public Cars save(Cars cars) {
        boolean trueOrFalse = false;
        for (Cars tableCars : CarsDaoImpl.cars) {
            if (tableCars.getId() == cars.getId()) {
                trueOrFalse = true;
                break;
            }
        }
        if(!trueOrFalse) {
            CarsDaoImpl.cars.add(cars);
            return cars;
        }
        return null;
    }

    /**
     * Update Model method, return edited Car
     * @param cars
     * @param id
     * @return
     */
    @Override
    public Cars update(Cars cars, int id) {
        for (Cars tableCars : CarsDaoImpl.cars) {
            if (tableCars.getId() == id) {
                tableCars.setModel(cars.getModel());
                return tableCars;
            }
        }
        return null;
    }

    /**
     * Delete Car method, return true or false success
     * @param id
     * @return
     */
    @Override
    public Boolean delete(int id) {
        for (Cars tableCars : cars) {
            if (tableCars.getId() == id) {
                cars.remove(tableCars);
                return true;
            }
        }
        return false;
    }

}
