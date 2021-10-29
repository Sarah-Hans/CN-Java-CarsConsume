package com.cars.appcarconsume.controller;
import com.cars.appcarconsume.model.Car;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class CarController {

    private RestTemplate restTemplate = new RestTemplate();
    private String url = "http://localhost:8081/api/";



    @RequestMapping(value = "/consumer/cars", method = RequestMethod.GET)
    public Object showAll() {
        return this.restTemplate.getForObject(url+"cars", Car.class);
    }


    @RequestMapping(value = "/consumer/cars/{id}", method = RequestMethod.GET)
    public Object showById(@PathVariable int id) {
        return this.restTemplate.getForObject(url+"cars/"+id, Car.class);
    }


    @RequestMapping(value = "/consumer/cars", method = RequestMethod.POST)
    public Object addNew(@RequestBody Object object) {
        return this.restTemplate.postForObject(url+"cars", object, Car.class);
    }


    @RequestMapping(value = "/consumer/cars/{id}", method = RequestMethod.PUT)
    public Object updateCar(@RequestBody Object object, @PathVariable int id) {
        this.restTemplate.put(url+"cars/update/"+id, Car.class);
        return this.showById(id);
    }


    @RequestMapping(value = "/consumer/delete/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable int id) {
        this.restTemplate.delete(url+"delete/"+id, Car.class);
        return this.showById(id);
    }
}
