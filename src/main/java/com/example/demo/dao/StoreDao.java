package com.example.demo.dao;

import com.example.demo.dto.MarkDto;
import com.example.demo.dto.StoreDto;

import java.util.List;

public interface StoreDao {
    List<StoreDto> getAllStores();
    /*MarkDto getMarkWithStoresByMarkId (int id);*/
    StoreDto getStoreById(int id);
    void saveOrUpdate (StoreDto storeDto);
    void deleteStore (int id);
}
