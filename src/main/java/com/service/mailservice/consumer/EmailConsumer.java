package com.service.mailservice.consumer;

import com.service.mailservice.dto.EmailDto;
import com.service.mailservice.model.EmailModel;
import com.service.mailservice.service.EmailService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

// -------------------- COMUNICAÇÃO ASSINCRONA --------------------
// O EmailConsumer se inscreve no broker definido na classe RabbitMQConfig 
// para receber a fila de mensagens que for sendo enviadas.
@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDto emailDto) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);
        System.out.println("Email Status: " + emailModel.getStatusEmail().toString());
    }
}