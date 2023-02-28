package com.example.ex1.repository;

import com.example.ex1.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<String> languagesList();
    List<Integer> pageSize();
        Email email();
        void updateEmail(Email email);
}
