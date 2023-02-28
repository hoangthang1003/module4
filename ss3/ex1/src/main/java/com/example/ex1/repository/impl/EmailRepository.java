package com.example.ex1.repository.impl;

import com.example.ex1.model.Email;
import com.example.ex1.repository.IEmailRepository;

import java.util.ArrayList;
import java.util.List;

public class EmailRepository implements IEmailRepository {
    private static List<String> languagesList;
    private static List<Integer> pageSize;
    private static Email email;

    static {
        email= new Email("English", 25, false, "Thor, King, Asgard");

        languagesList = new ArrayList<>();
        languagesList.add("English");
        languagesList.add("Vietnamese");
        languagesList.add("japanese");
        languagesList.add("China");
        pageSize = new ArrayList<>();
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100 );
    }

    @Override
    public List<String> languagesList() {
        return languagesList;
    }

    @Override
    public List<Integer> pageSize() {
        return pageSize;
    }

    @Override
    public Email email() {
        return email;
    }


}
