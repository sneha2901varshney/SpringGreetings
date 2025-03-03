package com.example.springGreeting.Services;

import com.example.springGreeting.Entities.MessageEntity;
import com.example.springGreeting.Repository.GreetingRepository;
import com.example.springGreeting.model.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingServices {
    String greeting;
    GreetingRepository greetingRepository;
    public GreetingServices() {
        greeting = "Hello User";
    }
    public String getGreeting() {
        return greeting;
    }
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
    public Greeting save(Greeting message){
        MessageEntity me = new MessageEntity(message.getMessage());

        greetingRepository.save(me);

        Greeting Info = new Greeting(me.getMessage());

        Info.setMessageID(me.getId());

        return Info;
    }
    public Greeting findbyID(Long ID){
        MessageEntity me = greetingRepository.findById(ID).orElseThrow(()->new RuntimeException("No Record Found"));
        Greeting Info = new Greeting(me.getMessage());
        Info.setMessageID(me.getId());
        return Info;
    }
}