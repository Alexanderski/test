package com.example.demo.rowMapper;

import com.example.demo.dto.ModelDto;
import com.example.demo.dto.StoreDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreRowMapper implements RowMapper<StoreDto> {
    @Override
    public StoreDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        StoreDto storeDto = new StoreDto();
        storeDto.setId(rs.getInt("id"));
        storeDto.setName(rs.getString("name"));
        storeDto.setMark_id(rs.getInt("mark_id"));
        return storeDto;
    }
}
