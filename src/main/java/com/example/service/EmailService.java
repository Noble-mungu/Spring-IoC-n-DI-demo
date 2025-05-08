package com.example.service;

import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}
