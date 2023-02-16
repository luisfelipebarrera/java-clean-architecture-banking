package com.mybank.banking.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Person {

    private Long id;

    private String identification;
    private String name;
    private String birthdate;
    private String address;
    private String phone;

    private Gender gender;

}
