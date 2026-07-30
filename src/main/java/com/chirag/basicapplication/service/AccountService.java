package com.chirag.basicapplication.service;

import com.chirag.basicapplication.config.ModelMapping;
import com.chirag.basicapplication.dto.account.request.CreateAccountRequest;
import com.chirag.basicapplication.dto.account.response.AccountResponse;
import com.chirag.basicapplication.entity.Account;
import com.chirag.basicapplication.entity.Customer;
import com.chirag.basicapplication.repository.AccountRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private ModelMapper modelMapper;

    public AccountResponse createAccount(CreateAccountRequest createAccountRequest, Customer customer){
        Account account=new Account();
        account.setAccount_no(createAccountRequest.getAccount_no());
        account.setAccountType(createAccountRequest.getAccountType());
        account.setBalance(createAccountRequest.getBalance());
        account.setStatus(createAccountRequest.getStatus());

        account.setCustomer(customer);

        accountRepo.save(account);

        AccountResponse accountResponse=new AccountResponse();
        accountResponse.setAccount_no(account.getAccount_no());
        accountResponse.setAccountType(account.getAccountType());
        accountResponse.setCreated_at(account.getCreated_at());
        accountResponse.setBalance(account.getBalance());
        accountResponse.setCustomer(account.getCustomer());
        accountResponse.setStatus(account.getStatus());
        accountResponse.setTransactions(account.getTransactions());

        return accountResponse;

    }

    public List<AccountResponse> getAllAccount(String customer_no){
        List<Account> accounts=accountRepo.findByCustomerCustomer_no(customer_no);

        List<AccountResponse> responses=new ArrayList<>();
        for (Account account:accounts){
            AccountResponse accountResponse=modelMapper.map(account,AccountResponse.class);
            responses.add(accountResponse);
        }
        return responses;
    }
}
