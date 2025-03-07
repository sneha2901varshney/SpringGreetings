package com.example.springGreeting.Interfaces;
import com.example.springGreeting.DTO.AuthUserDTO;
import com.example.springGreeting.DTO.LoginDTO;
import com.example.springGreeting.DTO.PassDTO;
import org.springframework.stereotype.Service;

@Service
public interface IAuthInterface {

    public String register(AuthUserDTO user);


    public String login(LoginDTO user);

    public AuthUserDTO forgotPassword(PassDTO pass, String email);

    public String resetPassword(String email, String currentPass, String newPass);
}