package com.carl.dao.impl;

import com.carl.dao.BookMapper;
import com.carl.pojo.Book;
import com.carl.pojo.BookExample;
import com.carl.pojo.QueryVO;

import java.util.List;

public class BookMapperImpl implements BookMapper {
    @Override
    public int countByExample(BookExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(BookExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Book record) {
        return 0;
    }

    @Override
    public int insertSelective(Book record) {
        return 0;
    }

    @Override
    public List<Book> selectByExample(BookExample example) {
        return null;
    }

    @Override
    public Book selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Book record, BookExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Book record, BookExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Book record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Book record) {
        return 0;
    }

    @Override
    public List<Book> findAll(QueryVO queryVO) {
        return null;
    }

}
