package com.example.demo.service;

import com.example.demo.dto.MarkDto;
import com.example.demo.dto.ModelDto;
import com.example.demo.dto.StoreDto;

import java.util.List;

public interface StoreService {
    List<StoreDto> getAllStores();
    /*MarkDto getMarkWithStoresByMarkId (int id);*/
    StoreDto getStoreById(int id);
    void saveOrUpdate (StoreDto storeDto);
    void deleteStore (int id);
}
