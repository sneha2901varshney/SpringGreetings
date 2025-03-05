package com.example.springGreeting.collector;
import com.example.springGreeting.DTO.MessageDTO;
import com.example.springGreeting.Repository.GreetingRepository;
import com.example.springGreeting.Services.GreetingServices;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("greetings")
public class GreetingController {

    GreetingServices greetingService;

    public GreetingController(GreetingServices greetingService) {
        this.greetingService = greetingService;
    }
    //UC1
    @GetMapping("/get")
    public String getGreetings(){
        return "{\"message\": \"Hello from GET Request!\"}";
    }

    @PostMapping("/post")
    public String postGreetings(@RequestBody MessageDTO message){
        return "{\""+message.getMessage()+": \"Hello from POST Request!\"}";
    }

    @PutMapping("/put/{message}")
    public String putGreetings(@PathVariable String message){
        return "{\""+message+": \"Hello from PUT Request!\"}";
    }

    //UC2
    @GetMapping("/service")
    public String serviceGreetings(){
        return greetingService.getGreetings();
    }

    //UC3
    @GetMapping("/query")
    public String query(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName){

        if(firstName != null && lastName != null)
            return "Hello "+firstName+" "+lastName+" Welcome to Bridgelabz";
        else if(firstName != null)
            return "Hello "+firstName+" Welcome to Bridgelabz";
        else if(lastName != null)
            return "Hello "+lastName+" Welcome to Bridgelabz";
        else
            return "Hello, Welcome to Bridgelabz";
    }

    //UC4
    @PostMapping("/save")
    public MessageDTO save(@RequestBody MessageDTO message){
        return greetingService.saveMessage(message);
    }

    //UC5
    @GetMapping("/find/{id}")
    public MessageDTO findById(@PathVariable Long id){

        return greetingService.findById(id);

    }

    //UC6
    @GetMapping("/listAll")
    public List<MessageDTO> listAll(){
        return greetingService.listAll();
    }

    //UC7
    @PostMapping("/edit/{id}")
    public MessageDTO editById(@RequestBody MessageDTO message, @PathVariable Long id){
        return greetingService.editById(message, id);
    }

    //UC8
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return greetingService.delete(id);
    }

}