package com.mybank.banking.account.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="gender", schema="public")
@Getter
@Setter
@NoArgsConstructor
public class GenderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String genderDescription;

    @OneToOne(mappedBy = "gender")
    private PersonEntity person;

}
