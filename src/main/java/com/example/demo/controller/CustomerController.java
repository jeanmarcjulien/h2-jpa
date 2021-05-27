package com.example.demo.controller;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository){
        this.repository = repository;
    }

    /*
    localhost:8080/create

    {
        "firstName": "John",
        "lastName": "Doe"
    }

    {
        "firstName": "John2",
        "lastName": "Doe2"
    }
    */

    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer) {
        return this.repository.save(customer);
    }

    //localhost:8080/list
    @GetMapping("/list")
    public Iterable<Customer> list() {
        return this.repository.findAll();
    }

    //localhost:8080/read/lastname/Doe
    @GetMapping("/read/lastname/{lastName}")
    public Iterable<Customer> read(@PathVariable String lastName) {
        return this.repository.findByLastName(lastName);
    }
    /*
    localhost:8080/delete

    {
        "id": 1
    }
    */

    @DeleteMapping("delete")
    public void delete(@RequestBody Customer customer) {
        this.repository.delete(customer);
    }

}
