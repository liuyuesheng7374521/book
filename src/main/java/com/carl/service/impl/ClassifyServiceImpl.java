package com.carl.service.impl;

import com.carl.dao.ClassifyMapper;
import com.carl.pojo.Classify;
import com.carl.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private  ClassifyMapper classifyMapper;
    @Override
    public List<Classify> findAll() {
        return classifyMapper.selectByExample(null);
    }
}
