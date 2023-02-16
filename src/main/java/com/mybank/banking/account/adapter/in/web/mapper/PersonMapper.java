package com.mybank.banking.account.adapter.in.web.mapper;

import com.mybank.banking.account.domain.Person;
import com.mybank.banking.account.adapter.in.web.dto.PersonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDto toDto(Person person);
    Person toDomain(PersonDto personDto);

}
