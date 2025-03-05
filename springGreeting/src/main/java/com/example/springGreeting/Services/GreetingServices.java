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

    private final GreetingRepository greetingRepository;
    private String greeting;

    @Autowired
    public GreetingServices(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
        this.greeting = "Hello User";
    }

    public String getGreeting() {
        return this.greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public Greeting save(Greeting message) {
        MessageEntity me = new MessageEntity(message.getMessage());
        greetingRepository.save(me);
        Greeting info = new Greeting(me.getMessage());
        info.setMessageID(me.getId());
        return info;
    }

    public Greeting findbyID(Long ID) {
        MessageEntity me = greetingRepository.findById(ID)
                .orElseThrow(() -> new RuntimeException("No Record Found"));
        Greeting info = new Greeting(me.getMessage());
        info.setMessageID(me.getId());
        return info;
    }

    public List<Greeting> getAll() {
        return greetingRepository.findAll().stream().map(me -> {
            Greeting info = new Greeting(me.getMessage());
            info.setMessageID(me.getId());
            return info;
        }).collect(Collectors.toList());
    }

    public Greeting updateByID(Greeting message, Long ID) {
        MessageEntity me = greetingRepository.findById(ID)
                .orElseThrow(() -> new RuntimeException("No Record Found"));
        me.setMessage(message.getMessage());
        greetingRepository.save(me);
        Greeting info = new Greeting(me.getMessage());
        info.setMessageID(me.getId());
        return info;
    }

    public String deleteByID(Long ID) {
        MessageEntity me = greetingRepository.findById(ID)
                .orElseThrow(() -> new RuntimeException("No Record Found"));
        greetingRepository.delete(me);
        return "Deleted Successfully";
    }
}
