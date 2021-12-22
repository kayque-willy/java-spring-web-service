package com.service.mailservice.controller;

import javax.validation.Valid;

import com.service.mailservice.dto.EmailDto;
import com.service.mailservice.model.EmailModel;
import com.service.mailservice.service.EmailService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// -------------------- COMUNICAÇÃO SINCRONA --------------------
// O RestController recebe requisições HTTP e realiza a comunicação sincorona 
// entre o serviço e o requisitante por Transferência de Estado Representacional (REST) 
@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }

}
