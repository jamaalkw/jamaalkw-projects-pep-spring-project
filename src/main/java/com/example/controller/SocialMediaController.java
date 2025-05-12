package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Message;
import com.example.service.MessageService;
import com.example.entity.Account;
import com.example.service.AccountService;

import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.example.exception.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {
    private final MessageService messageService;
    private final AccountService accountService;

    @Autowired
    SocialMediaController(MessageService messageService, AccountService accountService) {
        this.messageService = messageService;
        this.accountService = accountService;
    }
    
    // create
    // DONE
    @PostMapping("/messages")
    public Message createMessage(@RequestBody Message message) throws MessageNotCreatedException {
        return messageService.createMessage(message);
    }

    // delete
    // DONE
    @DeleteMapping("/messages/{message_id}")
    public Integer deleteMessage(@PathVariable Integer message_id) {
        return messageService.deleteMessage(message_id);
    }

    // update
    // DONE
    @PatchMapping(value = "/messages/{message_id}")
    public Integer updateMessage(@PathVariable Integer message_id, @RequestBody Message updatedMessage) {
      return messageService.updateMessage(message_id, updatedMessage);
    }

    // get all
    // DONE
    @GetMapping("/messages")
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    // get by account id
    // DONE
    @GetMapping("/accounts/{account_id}/messages")
    public List<Message> getMessagesByAccountId(@PathVariable Integer account_id) {
        return messageService.getMessagesByAccountId(account_id);
    }

    // get by id
    // DONE
    @GetMapping("/messages/{message_id}")
    public Message getMessageById(@PathVariable Integer message_id) {
        return messageService.getMessageById(message_id);
    }

    // get existing account
    // DONE
    @PostMapping("/login")
    public Account accountLogin(@RequestBody Account account) {
        return accountService.accountLogin(account.getUsername(), account.getPassword());
    }

    // create new account
    // DONE
    @PostMapping("/register")
    public Account accountRegister(@RequestBody Account account) {
        return accountService.accountRegister(account.getUsername(), account.getPassword());
    }
}