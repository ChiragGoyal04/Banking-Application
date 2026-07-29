package com.chirag.basicapplication.dto.customer.request;

import lombok.Data;

@Data
public class UpdateCustomer {

    private String first_name;

    private String last_name;

    private String email;

    private String address;

    private Long phone_no;
}
