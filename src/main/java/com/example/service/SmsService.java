package com.example.service;

import org.springframework.stereotype.Service;

@Service("smsService")
public class SmsService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
