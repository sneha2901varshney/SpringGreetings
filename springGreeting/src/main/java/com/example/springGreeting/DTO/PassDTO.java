package com.example.springGreeting.DTO;
public class PassDTO {

    String password;

    PassDTO(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

}