package com.example.springGreeting.Repository;
import com.example.springGreeting.Entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;


@Repository
public interface GreetingRepository extends JpaRepository<MessageEntity, Event.ID> {


}