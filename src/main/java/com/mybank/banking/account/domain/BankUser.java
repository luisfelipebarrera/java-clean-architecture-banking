package com.mybank.banking.account.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BankUser {

    private Long id;

    private String email;
    private String password;
    private boolean status;

}
