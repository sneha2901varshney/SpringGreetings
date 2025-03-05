package com.example.springGreeting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Greeting{
    String message;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long MessageID;

    public Greeting(String message) {
        this.message = message;
        this.MessageID = null;
    }
    public Long getMessageID() {
        return MessageID;
    }
    public void setMessageID(Long messageID) {
        this.MessageID = messageID;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}