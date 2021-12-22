package com.service.mailservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// -------------------- COMUNICAÇÃO ASSINCRONA --------------------
// Na classe RabbitMQConfig é definido o broker com uso do RabbitMQ. 
// O broker recebe e transmite as mensagens e acordo com o Protocolo avançado 
// de enfileiramento de mensagens (AMQP)
@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.queue}")
    private String queue;

    @Bean
    public Queue queue() {
        return new Queue(queue, true);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
