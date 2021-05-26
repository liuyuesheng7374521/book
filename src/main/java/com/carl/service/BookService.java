package com.carl.service;

import com.carl.pojo.Book;
import com.carl.pojo.QueryVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BookService {




    void addBook(Book book);

    List<Book> findAll(QueryVO queryVO);

    Book findById(Integer id);

    void updatebook(Book book);

    void delBook(Integer id);

    void delBook(Integer[] id);
}
