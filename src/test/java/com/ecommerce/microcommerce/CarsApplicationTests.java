package com.ecommerce.microcommerce;

import com.ecommerce.microcommerce.dao.CarsDao;
import com.ecommerce.microcommerce.cars.Cars;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarsApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CarsDao cars;

    /**
     * Ensure that endpoint /Models get Json
     * GET METHOD
     * @throws Exception
     */
    @Test
    public void modelsShouldReturnAllModels() throws Exception {
        String body = this.restTemplate.getForObject("/Models", String.class);
        ObjectMapper jsonParser = new ObjectMapper();
        List<Cars> cars = jsonParser.readValue(body, new TypeReference<List<Cars>>() {});
        assertThat(cars).isEqualTo(this.cars.findAll());
    }

    /**
     * Ensure that endpoint /Models/id return specified Model
     * GET METHOD
     * @throws Exception
     */
    @Test
    public void modelShouldReturnOneModelById() throws Exception {
        Cars body = this.restTemplate.getForObject("/Models/1", Cars.class);
        assertThat(body).isEqualTo(cars.findById(1));
    }

    /**
     * Ensure that endpoint /Models add specified Model
     * POST METHOD
     * @throws Exception
     */
    @Test
    public void modelShouldBeAddToArray() throws Exception {
        Cars newCars = new Cars(4, "Corsa");
        this.restTemplate.postForObject("/Models", newCars, String.class);
        assertThat(newCars).isEqualTo(cars.findById(4));
    }

    /**
     * Ensure that endpoint /Models/id update specified Model
     * PUT METHOD
     * @throws Exception
     */
    @Test
    public void modelByIdShouldBeUpdate() throws Exception {
        Cars updateCars = cars.findById(1);
        updateCars.setModel("Corsa");
        this.restTemplate.put("/Models/1", updateCars);
        assertThat(cars.findById(1)).isEqualTo(updateCars);
    }

    /**
     * Ensure that endpoint /Models/id delete specified Model
     * DELETE METHOD
     * @throws Exception
     */
    @Test
    public void modelShouldBeDeletedById() throws Exception {
        this.restTemplate.delete("/Models/1", Cars.class);
        assertThat(cars.findById(1)).isNull();
    }
}