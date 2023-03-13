package com.example.ex1.service;

import com.example.ex1.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void create(Book book);

    Book findById(int id);
}
