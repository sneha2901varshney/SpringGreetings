package com.example.springGreeting.collector;
import com.example.springGreeting.Services.GreetingServices;
import com.example.springGreeting.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    GreetingServices greetingServices;
    public GreetingController(GreetingServices greetingServices) {
        this.greetingServices = greetingServices;
    }
    Greeting message;
    @GetMapping("/get")
    public String greeting() {
        return "Hello World";
    }
    @PostMapping("/post")
    public String greetingPost(@RequestBody Greeting message) {
        return "Hello Post Request from"+message.getMessage();
    }
    @PutMapping("/put/{message}")
    public String greetingPut(@PathVariable String message) {
        return "Hello Put Request from"+message;
    }
    @DeleteMapping("/delete/{message}")
    public String greetingDelete(@PathVariable String message) {
        return "Hello Delete Request from"+message;
    }
    @PatchMapping("/patch/{message}")
    public String greetingPatch(@PathVariable String message) {
        return "Hello Patch Request from"+message;
    }

    @GetMapping("/services")
    public String greetingServices() {
        return greetingServices.getGreeting();
    }

    @GetMapping("/query")
    public String query(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName){
        if(firstName != null && lastName != null)
            return "Hello "+firstName+" "+lastName+"Welcome to My Application";
        else if(firstName != null)
            return "Hello "+firstName+" Welcome to Application";
        else if(lastName != null)
            return "Hello "+lastName+" Welcome to Application";
        else
            return "Hello, Welcome to Application";
    }

    @PostMapping("/save")
    public String save(@RequestBody Greeting message){
        return greetingServices.save(message).getMessage();
    }
    @GetMapping("/find/{ID}")
    public Greeting findbyID(@PathVariable Long ID){
        return greetingServices.findbyID(ID);
    }
    @GetMapping("/all")
    public List<Greeting> getAll(){
        return greetingServices.getAll();

    }
    @PutMapping("/update/{ID}")
    public Greeting updateByID(@RequestBody Greeting message,@PathVariable Long ID){
        return greetingServices.updateByID(message,ID);
    }
    @DeleteMapping("/delete/{ID}")
    public String deleteByID(@PathVariable Long ID){
        return greetingServices.deleteByID(ID);
    }

}