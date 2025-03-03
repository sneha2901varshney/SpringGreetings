package com.example.springGreeting.collector;
import com.example.springGreeting.model.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController{
    @GetMapping
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "WEB") String name){
        return new Greeting("Hello" + " " + name + "!");
    }

    @PostMapping
    public Greeting postGreeting(@RequestBody Greeting greeting){
        return new Greeting("Posted: " + greeting.getMessage());
    }

    @PutMapping("/{id}")
    public Greeting putGreeting(@PathVariable int id, @RequestBody Greeting greeting){
        return new Greeting(id + greeting.getMessage());
    }

    @DeleteMapping("/{id}")
    public String deleteGreeting(@PathVariable int id){
        return id + "Deleted";
    }
}