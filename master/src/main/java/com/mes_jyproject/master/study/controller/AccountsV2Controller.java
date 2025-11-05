package com.mes_jyproject.master.study.controller;

import com.mes_jyproject.master.study.contains.AccountsConstants;
import com.mes_jyproject.master.study.dto.CustomerDto;
import com.mes_jyproject.master.study.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v2/accounts" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountsV2Controller {

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccounts(@RequestBody CustomerDto customerDto){

        return ResponseEntity.status(HttpStatus.CREATED).body(  new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }
}
