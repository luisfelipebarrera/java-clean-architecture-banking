package com.mybank.banking.account.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="person", schema="public")
@Getter
@Setter
@NoArgsConstructor
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String identification;
    private String name;
    private String birthdate;
    private String address;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    private GenderEntity gender;

    @OneToOne(mappedBy = "person")
    private CustomerEntity customer;

}
