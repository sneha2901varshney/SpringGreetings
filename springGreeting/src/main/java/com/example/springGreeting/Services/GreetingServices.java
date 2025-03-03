package com.example.springGreeting.Services;

import com.example.springGreeting.Entities.MessageEntity;
import com.example.springGreeting.Repository.GreetingRepository;
import com.example.springGreeting.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GreetingServices {
    @Autowired
    String greeting;
    GreetingRepository greetingRepository;

    public GreetingServices() {
        greeting = "Hello User";
        this.greetingRepository = greetingRepository;

    }
    public String getGreeting() {
        return this.greeting;
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
    public List<Greeting> getAll(){
        List<Greeting> list  = greetingRepository.findAll().stream().map(me ->{
            Greeting Info = new Greeting(me.getMessage());
            Info.setMessageID(me.getId());
            return Info;
        }).collect(Collectors.toList());
        return list;
    }
    public Greeting updateByID(Greeting message, Long ID){
        MessageEntity me = greetingRepository.findById(ID).orElseThrow(()->new RuntimeException("No Record Found"));
        me.setMessage(message.getMessage());
        greetingRepository.save(me);
        Greeting Info = new Greeting(me.getMessage());
        Info.setMessageID(me.getId());
        return Info;
    }
}}