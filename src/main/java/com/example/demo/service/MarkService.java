package com.example.demo.service;

import com.example.demo.dto.MarkDto;

import java.util.List;

public interface MarkService {
    List<MarkDto> getAllMarks();
    MarkDto getMarkById(int id);
    void saveOrUpdate (MarkDto markDto);
    void deleteMark (int id);

}

