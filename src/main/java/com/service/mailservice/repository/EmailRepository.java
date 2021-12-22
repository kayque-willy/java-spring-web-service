package com.service.mailservice.repository;

import com.service.mailservice.model.EmailModel;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailModel, UUID>{
    
}
