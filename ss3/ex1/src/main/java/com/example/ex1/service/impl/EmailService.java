package com.example.ex1.service.impl;

import com.example.ex1.model.Email;
import com.example.ex1.repository.impl.EmailRepository;
import com.example.ex1.service.IEmailService;

import java.util.List;

public class EmailService implements IEmailService {
    EmailRepository emailRepository = new EmailRepository();

    @Override
    public List<String> languagesList() {
        return emailRepository.languagesList();
    }

    @Override
    public List<Integer> pageSize() {
        return emailRepository.pageSize();
    }

    @Override
    public Email email() {
        return emailRepository.email();
    }

    public void updateEmail(Email email1) {
        emailRepository.updateEmail(email1);
    }
}
