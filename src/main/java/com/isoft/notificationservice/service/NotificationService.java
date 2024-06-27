package com.isoft.notificationservice.service;

import com.isoft.notificationservice.entity.Notification;
import com.isoft.notificationservice.repo.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    public void saveNotification(String message){
        Notification notification=new Notification(message);
        notificationRepository.save(notification);

    }

    @KafkaListener(topics = "${kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(@Payload String message,
                        String partition

                       ) {
        try {
            // Process and save the notification
            Notification notification = new Notification(message, System.currentTimeMillis());
            notificationRepository.save(notification);
            System.out.println("Notification saved: " + message);

            // Manually acknowledge the message after successful processing

        } catch (Exception e) {
            System.err.println("Error processing message: " + message);
            e.printStackTrace();
            // Optionally: handle the error, e.g., send it to a dead letter topic
        }
    }
}
