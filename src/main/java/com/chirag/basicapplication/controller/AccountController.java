package com.chirag.basicapplication.controller;

import com.chirag.basicapplication.dto.account.request.CreateAccountRequest;
import com.chirag.basicapplication.entity.Customer;
import com.chirag.basicapplication.repository.CustomerRepo;
import com.chirag.basicapplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<?> openAccount(@RequestBody CreateAccountRequest createAccountRequest, @RequestParam String customer_no){
        Optional<Customer> customer=customerRepo.findBy(customer_no);
        if(customer.isPresent()){
            return ResponseEntity.ok().body(accountService.createAccount(createAccountRequest,customer.get()));
        }
        return ResponseEntity.badRequest().body("Cannot create account as customer not present with customer number");
    }

    @GetMapping
    public ResponseEntity<?> getAccountByCustomer(@RequestParam String customer_no){
        return ResponseEntity.ok().body(accountService.getAllAccount(customer_no));
    }

}
