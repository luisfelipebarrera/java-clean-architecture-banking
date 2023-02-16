package com.mybank.banking.account.adapter.out.persistence.mapper;

import com.mybank.banking.account.adapter.out.persistence.entity.PersonEntity;
import com.mybank.banking.account.domain.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonEntityMapper {

    Person toDomain(PersonEntity personEntity);
    PersonEntity toEntity(Person user);

}
