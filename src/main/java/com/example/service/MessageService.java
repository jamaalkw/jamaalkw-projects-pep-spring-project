package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.repository.MessageRepository;
import com.example.entity.Message;
import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.exception.MessageNotCreatedException;

import java.util.*;

@Service
public class MessageService {
    MessageRepository messageRepository;
    AccountRepository accountRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, AccountRepository accountRepository) {
        this.messageRepository = messageRepository;
        this.accountRepository = accountRepository;
    }

    /**
     * This method checks whether a given string is just whitespace.
     * @param str - a String object.
     * @return true if all characters are whitespace, false otherwise.
     */
    private boolean whiteSpaceChecker(String str) {
        if (str.length() <= 0) return true;

        for (char ch : str.toCharArray()) {
            if (!Character.isWhitespace(ch)) return false;
        }

        return true;
    }

    public Message createMessage(Message message) throws MessageNotCreatedException {
        Message newMessage = null;
        if ((message.getMessageText().length() < 255) && (!whiteSpaceChecker(message.getMessageText())) && (accountRepository.findAccountByAccountId(message.getPostedBy()).isPresent())) {
            newMessage = messageRepository.save(message);
        }

        if (newMessage == null) throw new MessageNotCreatedException();

        return newMessage;
    }

    public Integer deleteMessage(Integer message_id) {
        Optional<Message> messageOptional = messageRepository.findMessageByMessageId(message_id);

        if (messageOptional.isPresent()) {
            messageRepository.delete(messageOptional.get());
            return 1;
        }

        return null;
    }

    public Integer updateMessage(Integer message_id, Message message) {
        Optional<Message> messageOptional = messageRepository.findMessageByMessageId(message_id);
        Message updatedMessage = null;

        if ((messageOptional.isPresent()) && (!whiteSpaceChecker(message.getMessageText())) && (message.getMessageText().length() <= 255)) {
            updatedMessage = messageOptional.get();
            updatedMessage.setMessageText(message.getMessageText());
            messageRepository.save(updatedMessage);
        }

        if (updatedMessage == null) throw new MessageNotCreatedException();

        return 1;
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public List<Message> getMessagesByAccountId(Integer account_id) {
        return messageRepository.findMessagesByPostedBy(account_id);
    }

    public Message getMessageById(Integer id) {
        Optional<Message> optionalMessage = messageRepository.findMessageByMessageId(id);

        if (optionalMessage.isPresent()) {
            return optionalMessage.get();
        }
        
        return null;
    }
}
