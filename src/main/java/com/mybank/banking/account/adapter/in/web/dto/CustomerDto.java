package com.mybank.banking.account.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private String id;
    private String identification;
    private String name;
    private String genderDescription;
    private String birthdate;
    private String address;
    private String phone;
}
