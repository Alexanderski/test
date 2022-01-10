package com.example.demo.service;


import com.example.demo.dao.MarkDao;
import com.example.demo.dto.MarkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkServiceImpl implements MarkService{
    private MarkDao markDao;
    @Autowired
    public MarkServiceImpl(MarkDao markDao) {
        this.markDao = markDao;
    }

    @Override
    public List<MarkDto> getAllMarks() {
        return markDao.getAllMarks();
    }

    @Override
    public MarkDto getMarkById(int id) {
        return markDao.getMarkById(id);
    }

    @Override
    public void saveOrUpdate(MarkDto markDto) {
        markDao.saveOrUpdate(markDto);
    }

    @Override
    public void deleteMark(int id) {
        markDao.deleteMark(id);
    }
}
