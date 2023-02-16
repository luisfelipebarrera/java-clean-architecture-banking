package com.mybank.banking.account.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private String identification;
    private String name;
    private String birthdate;
    private String address;
    private String phone;

}
