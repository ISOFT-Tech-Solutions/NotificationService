package com.isoft.notificationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    private String id;
    public String message;
    private long timeStamp;

    public Notification(String message) {
        this.message = message;
    }

    public Notification(String message, long timeStamp) {
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
