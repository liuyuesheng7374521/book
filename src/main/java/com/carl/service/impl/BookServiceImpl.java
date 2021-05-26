package com.carl.service.impl;

import com.carl.dao.BookMapper;
import com.carl.pojo.Book;
import com.carl.pojo.BookExample;
import com.carl.pojo.QueryVO;
import com.carl.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;




    @Override
    public void addBook(Book book) {
        bookMapper.insert(book);
    }

    @Override
    public List<Book> findAll(QueryVO queryVO) {
        return bookMapper.findAll(queryVO);
    }

    @Override
    public Book findById(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updatebook(Book book) {
        bookMapper.updateByPrimaryKey(book);
    }

    @Override
    public void delBook(Integer id) {
        bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void delBook(Integer[] id) {
        for (Integer i : id) {
            bookMapper.deleteByPrimaryKey(i);
        }

    }


}
