package com.example.demo.rowMapper;

import com.example.demo.dto.MarkDto;
import com.example.demo.dto.ModelDto;
import com.example.demo.dto.StoreDto;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MarkStoresRowMapper implements ResultSetExtractor<MarkDto> {
    @Override
    public MarkDto extractData(ResultSet rs) throws SQLException, DataAccessException {
        MarkDto markDto = new MarkDto();
        while (rs.next()) {
            if (markDto.getId() == 0) {
                markDto.setId(rs.getInt("mark_id"));
                markDto.setName(rs.getString("mark_name"));
            }
            StoreDto storeDto = new StoreDto();
            storeDto.setId(rs.getInt("id"));
            storeDto.setName(rs.getString("name"));
            storeDto.setMark_id(rs.getInt("mark_id"));

            List<StoreDto> stores = markDto.getStores();
            stores.add(storeDto);
            markDto.setStores(stores);
        }
        return markDto;
    }

}