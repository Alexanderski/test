package com.example.demo.dao;

import com.example.demo.dto.MarkDto;

import java.util.List;

public interface MarkDao {
    List<MarkDto> getAllMarks();
    MarkDto getMarkById(int id);
    void saveOrUpdate (MarkDto markDto);
    void deleteMark (int id);
}
