package com.mybank.banking.account.adapter.in.web.controller;

import com.mybank.banking.account.adapter.in.web.dto.CustomerDto;
import com.mybank.banking.account.adapter.in.web.mapper.CustomerMapper;
import com.mybank.banking.account.application.port.in.CustomerWebInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("clientes")
public class CustomerController {

    private final CustomerWebInputPort customerWebInputPort;

    private final CustomerMapper customerMapper;

    @GetMapping("cliente/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(customerMapper.toDto(customerWebInputPort.getById(id)),
                HttpStatus.OK);
    }

    @PostMapping(path = "cliente",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDto> save(@RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(customerMapper.toDto(customerWebInputPort.save(customerMapper.toDomain(customerDto))),
                HttpStatus.CREATED);
    }

    @PutMapping("cliente/{id}")
    public ResponseEntity<?> update(@RequestBody CustomerDto customerDto, @PathVariable Long id) {
        customerWebInputPort.update(customerMapper.toDomain(customerDto),
                id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        customerWebInputPort.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
