package com.mybank.banking.account.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="bank_user", schema="public")
@Getter
@Setter
@NoArgsConstructor
public class BankUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String userName;
    private String password;
    private boolean status;

    @OneToOne(mappedBy = "bankUser")
    private CustomerEntity customer;
}
