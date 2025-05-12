package com.example.repository;

import com.example.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface MessageRepository extends JpaRepository<Message, Long> {
    public Optional<Message> findMessageByMessageId(Integer messageId);
    public List<Message> findMessagesByPostedBy(Integer postedBy);
}
