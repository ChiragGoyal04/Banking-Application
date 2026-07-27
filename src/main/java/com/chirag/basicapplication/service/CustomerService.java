package com.chirag.basicapplication.service;

import com.chirag.basicapplication.config.ModelMapping;
import com.chirag.basicapplication.dto.customer.request.CreateCustomer;
import com.chirag.basicapplication.dto.customer.response.NewCustomerResponse;
import com.chirag.basicapplication.entity.Customer;
import com.chirag.basicapplication.repository.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<?> saveNewCustomer(CreateCustomer createCustomer){
        Customer customer=modelMapper.map(createCustomer, Customer.class);

        Customer savedCustomer=customerRepo.save(customer);

        NewCustomerResponse newCustomerResponse=modelMapper.map(savedCustomer,NewCustomerResponse.class);

        return ResponseEntity.ok().body(newCustomerResponse);

    }
}
