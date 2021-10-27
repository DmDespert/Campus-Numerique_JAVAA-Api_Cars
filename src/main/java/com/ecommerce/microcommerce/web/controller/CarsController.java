package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.CarsDao;
import com.ecommerce.microcommerce.cars.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@EnableSwagger2
public class CarsController {

    @Autowired //Indique à Spring de fabriquer une Instance
    private CarsDao carsDao;

    /**
     * Get all Cars
     * GET METHOD
     * @return
     */
    @RequestMapping(value = "/Cars", method = RequestMethod.GET)
    public List<Cars> listCars() {
        return carsDao.findAll();
    }

    /**
     * Get Car by Id
     * GET METHOD
     * @param id
     * @return
     */
    @GetMapping(value = "/Cars/{id}")
    public Cars showCars(@PathVariable int id) {
        return carsDao.findById(id);
    }

    /**
     * Add Car
     * POST METHOD
     * @param cars
     * @return
     */
    @PostMapping(value = "/Cars")
    public Cars addModel(@RequestBody Cars cars) {
        return carsDao.save(cars);
    }

    /**
     * Edit Car
     * PUT METHOD
     * @param cars
     * @param id
     * @return
     */
    @PutMapping(value = "/Cars/{id}")
    public Cars editModel(@RequestBody Cars cars, @PathVariable int id) {
        return carsDao.update(cars, id);
    }

    /**
     * Delete Car
     * DELETE METHOD
     * @param id
     * @return
     */
    @DeleteMapping(value = "/Cars/{id}")
    public Boolean deleteModel(@PathVariable int id) {
        return carsDao.delete(id);
    }
}
