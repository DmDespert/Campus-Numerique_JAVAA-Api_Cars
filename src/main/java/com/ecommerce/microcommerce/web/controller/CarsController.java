package com.ecommerce.microcommerce.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class CarsController {

    @Value("${service.url}")
    private String url;

    private RestTemplate restTemplate = new RestTemplate();

    /**
     * Get all Cars Models
     * GET METHOD
     * @return
     */
    @RequestMapping(value = "/Cars", method = RequestMethod.GET)
    public Object showAll() {
        return this.restTemplate.getForObject(url+"/Models", Object.class);
    }

    /**
     * Get single Car Model
     * @param id
     * @return
     */
    @RequestMapping(value = "/Cars/{id}", method = RequestMethod.GET)
    public Object showById(@PathVariable int id) {
        return this.restTemplate.getForObject(url+"/Models/"+id, Object.class);
    }

    /**
     * Add new Car Model
     * @param object
     * @return
     */
    @RequestMapping(value = "/Cars", method = RequestMethod.POST)
    public Object addNew(@RequestBody Object object) {
        return this.restTemplate.postForObject( url+"/Models", object, Object.class);
    }

    /**
     * Edit Car Model
     * @param object
     * @param id
     * @return
     */
    @RequestMapping(value = "/Cars/{id}", method = RequestMethod.PUT)
    public Object modifyCar(@RequestBody Object object, @PathVariable int id) {
        this.restTemplate.put(url+"/Models/"+id, object);
        return this.showById(id);
    }

    /**
     * Delete Car Model
     * @param id
     * @return
     */
    @RequestMapping(value = "/Cars/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable int id) {
        this.restTemplate.delete(url+"/Models/"+id, Object.class);
        return this.showById(id);
    }
}
