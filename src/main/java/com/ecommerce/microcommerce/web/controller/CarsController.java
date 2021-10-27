package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.cars.Cars;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
public class CarsController {

    private RestTemplate restTemplate = new RestTemplate();

    /**
     * Get all Cars Models
     * GET METHOD
     * @return
     */
    @RequestMapping(value = "/Cars", method = RequestMethod.GET)
    public Object showAll() {
        return this.restTemplate.getForObject("http://localhost:8081/Models", Object.class);
    }

    /**
     * Get single Car Model
     * @param id
     * @return
     */
    @RequestMapping(value = "/Cars/{id}", method = RequestMethod.GET)
    public Object showById(@PathVariable int id) {
        return this.restTemplate.getForObject("http://localhost:8081/Models/"+id, Object.class);
    }

    /**
     * Add new Car Model
     * @param object
     * @return
     */
    @RequestMapping(value = "/Cars", method = RequestMethod.POST)
    public Object addNew(@RequestBody Object object) {
        return this.restTemplate.postForObject("http://localhost:8081/Models", object, Object.class);
    }

    /**
     * Edit Car Model
     * @param object
     * @param id
     * @return
     */
    @RequestMapping(value = "/Cars/{id}", method = RequestMethod.PUT)
    public Object modifyCar(@RequestBody Object object, @PathVariable int id) {
        this.restTemplate.put("http://localhost:8081/Models/"+id, object);
        return this.showById(id);
    }

    /**
     * Delete Car Model
     * @param id
     * @return
     */
    @RequestMapping(value = "/Cars/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable int id) {
        this.restTemplate.delete("http://localhost:8081/Models/"+id, Object.class);
        return this.showById(id);
    }
}
