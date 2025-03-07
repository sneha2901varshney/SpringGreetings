package com.example.springGreeting.Interfaces;
import com.example.springGreeting.DTO.MessageDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IGreetingInterface {

    public String getGreetings();

    public MessageDTO saveMessage(MessageDTO message);

    public MessageDTO findById(Long id);

    public List<MessageDTO> listAll();

    public MessageDTO editById(MessageDTO message, Long id);

    public String delete(Long id);

}