package com.chirag.basicapplication.service;

import com.chirag.basicapplication.config.ModelMapping;
import com.chirag.basicapplication.dto.customer.request.CreateCustomer;
import com.chirag.basicapplication.dto.customer.request.UpdateCustomer;
import com.chirag.basicapplication.dto.customer.response.NewCustomerResponse;
import com.chirag.basicapplication.entity.Customer;
import com.chirag.basicapplication.repository.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    // creating new customer
    public ResponseEntity<?> saveNewCustomer(CreateCustomer createCustomer){
        Customer customer=modelMapper.map(createCustomer, Customer.class);

        Customer savedCustomer=customerRepo.save(customer);

        NewCustomerResponse newCustomerResponse=modelMapper.map(savedCustomer,NewCustomerResponse.class);

        return ResponseEntity.ok().body(newCustomerResponse);

    }

    // fetching all customers
    public List<NewCustomerResponse> getAllCustomers(){
        List<Customer> customers=customerRepo.findAll();

        List<NewCustomerResponse> newCustomerResponses=new ArrayList<>();
        for (Customer customer:customers){
            NewCustomerResponse response=modelMapper.map(customer,NewCustomerResponse.class);
            newCustomerResponses.add(response);
        }
        return newCustomerResponses;
    }

    // find customer by customer_number
    public NewCustomerResponse findCustomer(String customer_no){
        Optional<Customer> customer= Optional.ofNullable(customerRepo.findBy(customer_no).orElseThrow(() -> new IllegalArgumentException("Customer not found with provided customer no")));
        NewCustomerResponse response=modelMapper.map(customer.get(),NewCustomerResponse.class);
        return response;
    }

    public String deleteCustomerId(String customer_no){
        Optional<Customer> customer=customerRepo.findBy(customer_no);
        if(customer.isPresent()){
            customerRepo.delete(customer.get());
            return "Customer deleted Successfully";
        }
        return "Customer not found with provided customer_no";
    }

    public NewCustomerResponse updatedCustomer(Customer customer, UpdateCustomer updateCustomer){
        modelMapper.map(updateCustomer, customer);
        NewCustomerResponse response=modelMapper.map(customer,NewCustomerResponse.class);
        customerRepo.save(customer);
        return response;
    }
}
