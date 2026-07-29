package com.chirag.basicapplication.controller;

import com.chirag.basicapplication.dto.customer.request.CreateCustomer;
import com.chirag.basicapplication.dto.customer.request.UpdateCustomer;
import com.chirag.basicapplication.dto.customer.response.NewCustomerResponse;
import com.chirag.basicapplication.entity.Customer;
import com.chirag.basicapplication.repository.CustomerRepo;
import com.chirag.basicapplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping("create")
    public ResponseEntity<?> createCustomer(@RequestBody CreateCustomer createCustomer){
        return customerService.saveNewCustomer(createCustomer);
    }

    @GetMapping("find-all")
    public ResponseEntity<List<NewCustomerResponse>> findAll(){
        return ResponseEntity.ok().body(customerService.getAllCustomers());
    }

    @GetMapping()
    public ResponseEntity<?> findCustomer(@RequestParam String customer_no){
        return ResponseEntity.ok().body(customerService.findCustomer(customer_no));
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteCustomer(@RequestParam String customer_no){
        return ResponseEntity.ok().body(customerService.deleteCustomerId(customer_no));
    }

    @PutMapping
    public ResponseEntity<?> updateCustomer(@RequestBody UpdateCustomer updateCustomer,@RequestParam String customer_no){
        Optional<Customer> customer=customerRepo.findBy(customer_no);
        if (customer.isPresent()){
            return ResponseEntity.ok().body(customerService.updatedCustomer(customer.get(),updateCustomer));
        }
        return ResponseEntity.badRequest().body("Customer not present with provided customer_no");
    }
}
