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
    public ResponseEntity<Message> createMessage(@RequestBody Message message) throws MessageNotCreatedException {
        return ResponseEntity.ok(messageService.createMessage(message));
    }

    // delete
    // DONE
    @DeleteMapping("/messages/{message_id}")
    public ResponseEntity<Integer> deleteMessage(@PathVariable Integer message_id) {
        return ResponseEntity.ok(messageService.deleteMessage(message_id));
    }

    // update
    // DONE
    @PatchMapping(value = "/messages/{message_id}")
    public ResponseEntity<Integer> updateMessage(@PathVariable Integer message_id, @RequestBody Message updatedMessage) {
      return ResponseEntity.ok(messageService.updateMessage(message_id, updatedMessage));
    }

    // get all
    // DONE
    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getAllMessages() {
        return ResponseEntity.ok(messageService.getAllMessages());
    }

    // get by account id
    // DONE
    @GetMapping("/accounts/{account_id}/messages")
    public ResponseEntity<List<Message>> getMessagesByAccountId(@PathVariable Integer account_id) {
        return ResponseEntity.ok(messageService.getMessagesByAccountId(account_id));
    }

    // get by id
    // DONE
    @GetMapping("/messages/{message_id}")
    public ResponseEntity<Message> getMessageById(@PathVariable Integer message_id) {
        return ResponseEntity.ok(messageService.getMessageById(message_id));
    }

    // get existing account
    // DONE
    @PostMapping("/login")
    public ResponseEntity<Account> accountLogin(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.accountLogin(account.getUsername(), account.getPassword()));
    }

    // create new account
    // DONE
    @PostMapping("/register")
    public ResponseEntity<Account> accountRegister(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.accountRegister(account.getUsername(), account.getPassword()));
    }
}