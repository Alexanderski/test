package com.example.demo.service;

import com.example.demo.dto.MarkDto;
import com.example.demo.dto.ModelDto;
import com.example.demo.dto.StoreDto;

import java.util.List;

public interface ModelService {
    List<StoreDto> getAllMarks();
    MarkDto getMarkWithModelsByMarkId (int id);
    ModelDto getModelById(int id);
    void saveOrUpdate (ModelDto modelDto);
    void deleteModel (int id);
}
