package com.example.springGreeting.model;
public class Greeting{
    String message;
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