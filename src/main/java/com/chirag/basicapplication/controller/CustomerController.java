package com.chirag.basicapplication.controller;

import com.chirag.basicapplication.dto.customer.request.CreateCustomer;
import com.chirag.basicapplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("create")
    public ResponseEntity<?> createCustomer(@RequestBody CreateCustomer createCustomer){
        return customerService.saveNewCustomer(createCustomer);
    }
}
