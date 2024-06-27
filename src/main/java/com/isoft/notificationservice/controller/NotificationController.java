package com.isoft.notificationservice.controller;

import com.isoft.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    @GetMapping("/testNotification")
    public ResponseEntity<String> testNotification(@RequestParam String message){
        notificationService.saveNotification(message);
        return  ResponseEntity.ok("Notificationed Saved");

    }
}
