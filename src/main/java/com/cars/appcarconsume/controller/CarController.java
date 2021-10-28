package com.cars.appcarconsume.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class CarController {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://localhost:8081/api/";



    @RequestMapping(value = "/consumer/cars", method = RequestMethod.GET)
    public Object showAll() {
        return this.restTemplate.getForObject(url+"cars", Object.class);
    }


    @RequestMapping(value = "/consumer/cars/{id}", method = RequestMethod.GET)
    public Object showById(@PathVariable int id) {
        return this.restTemplate.getForObject(url+"cars/"+id, Object.class);
    }


    @RequestMapping(value = "/consumer/cars", method = RequestMethod.POST)
    public Object addNew(@RequestBody Object object) {
        return this.restTemplate.postForObject(url+"cars", object, Object.class);
    }


    @RequestMapping(value = "/consumer/cars/{id}", method = RequestMethod.POST)
    public Object modifyCar(@RequestBody Object object, @PathVariable int id) {
        this.restTemplate.put(url+"cars/update", object);
        return this.showById(id);
    }


    @RequestMapping(value = "/consumer/delete/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable int id) {
        this.restTemplate.delete(url+"delete/"+id, Object.class);
        return this.showById(id);
    }
}
