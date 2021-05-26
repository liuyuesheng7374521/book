package com.carl.dao.impl;

import com.carl.dao.ClassifyMapper;
import com.carl.pojo.Classify;
import com.carl.pojo.ClassifyExample;

import java.util.List;

public class ClassifyMapperImpl implements ClassifyMapper {
    @Override
    public int countByExample(ClassifyExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(ClassifyExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Classify record) {
        return 0;
    }

    @Override
    public int insertSelective(Classify record) {
        return 0;
    }

    @Override
    public List<Classify> selectByExample(ClassifyExample example) {
        return null;
    }

    @Override
    public Classify selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Classify record, ClassifyExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Classify record, ClassifyExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Classify record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Classify record) {
        return 0;
    }
}
