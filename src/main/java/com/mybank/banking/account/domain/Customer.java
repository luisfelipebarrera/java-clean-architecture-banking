package com.mybank.banking.account.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class Customer extends Person {

    private Long id;

    private BankUser bankUser;

    @Builder
    public Customer(Person person, Long id, BankUser bankUser) {
        super(person.getId(), person.getIdentification(), person.getName(), person.getBirthdate(), person.getAddress(),
                person.getPhone(), person.getGender());
        this.id = id;
        this.bankUser = bankUser;
    }

}