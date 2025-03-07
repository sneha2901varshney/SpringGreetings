package com.example.springGreeting.collector;

import com.example.springGreeting.DTO.* ;

import com.example.springGreeting.Services.AuthenticationService;
import com.example.springGreeting.Services.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.springGreeting.Interfaces.IAuthInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    EmailService emailService;

    @Autowired
    IAuthInterface iAuthInterface;

    //UC9 --> For Registration of a user
    @PostMapping(path = "/register")
    public String register(@RequestBody AuthUserDTO user){
        return iAuthInterface.register(user);
    }

    //UC10 --> For User Login
    @PostMapping(path ="/login")
    public String login(@RequestBody LoginDTO user){
        return iAuthInterface.login(user);
    }

    //UC11 --> For sending mail to another person
    @PostMapping(path = "/sendMail")
    public String sendMail(@RequestBody MailDTO message){
        emailService.sendEmail(message.getTo(), message.getSubject(), message.getBody());
        return "Mail sent";
    }

    //UC12 --> Added Swagger Config to use Swagger at url(/swagger)


    //UC13 --> Added forgot password functionality
    @PutMapping("/forgotPassword/{email}")
    public AuthUserDTO forgotPassword(@RequestBody PassDTO pass, @PathVariable String email){
        return iAuthInterface.forgotPassword(pass, email);
    }

    //UC14 --> Added reset password functionality
    @PutMapping("/resetPassword/{email}")
    public String resetPassword(@PathVariable String email ,@RequestParam String currentPass, @RequestParam String newPass){
        return iAuthInterface.resetPassword(email, currentPass, newPass);
    }
}