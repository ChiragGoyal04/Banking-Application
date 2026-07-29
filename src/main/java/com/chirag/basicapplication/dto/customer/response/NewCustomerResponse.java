package com.chirag.basicapplication.dto.customer.response;

import com.chirag.basicapplication.enums.Status;
import lombok.Data;

import java.lang.invoke.LambdaConversionException;
import java.time.LocalDateTime;

@Data
public class NewCustomerResponse {

    private String customer_no;

    private String first_name;

    private String last_name;

    private String email;

    private String address;

    private Status status;

    private Long phone_no;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;
}
