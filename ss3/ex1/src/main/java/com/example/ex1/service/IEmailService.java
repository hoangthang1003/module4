package com.example.ex1.service;

import com.example.ex1.model.Email;

import java.util.List;

public interface IEmailService {
    List<String> languagesList();
    List<Integer> pageSize();
    Email email();
}
