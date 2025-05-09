package com.example.controller;

import com.example.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.ApplicationContext;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/dynamic")
    public String dynamicNotify(@RequestParam String message, @RequestParam String type) {
        NotificationService service = (NotificationService) context.getBean(type + "Service");
        service.send(message);
        return "Notification sent using " + type;
    }
}

