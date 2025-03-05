package com.example.springGreeting.Repository;

import com.example.springGreeting.Entities.MessageEntity;
import com.example.springGreeting.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<MessageEntity, Long> {
}
