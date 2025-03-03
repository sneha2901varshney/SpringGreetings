package com.example.springGreeting.collector;
import com.example.springGreeting.Services.GreetingServices;
import com.example.springGreeting.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    GreetingServices greetingServices;
    @Autowired
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
}