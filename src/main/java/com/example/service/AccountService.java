package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.entity.Account;
import com.example.repository.AccountRepository;
import java.util.*;
import com.example.exception.*;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
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

    public Account accountLogin(String username, String password) {
        Optional<Account> optionalAccount = accountRepository.findAccountByUsernameAndPassword(username, password);
        Account loggedInAccount = null;
        if (optionalAccount.isPresent()) {
            loggedInAccount = optionalAccount.get();
        }

        if (loggedInAccount == null) throw new AccountLoginException();

        return loggedInAccount;
    }

    public Account accountRegister(String username, String password) {
        Account newAccount = null;
        Optional<Account> optionalAccount = accountRepository.findAccountByUsername(username);

        if (optionalAccount.isPresent()) throw new AccountRegisterDuplicateException();

        if ((password.length() >= 4) && (!whiteSpaceChecker(username))) {
            newAccount = new Account(username, password);
            accountRepository.save(newAccount);
        }

        if (newAccount == null) throw new AccountRegisterGeneralException();

        return newAccount;
    }
}