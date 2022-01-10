package com.example.demo.rowMapper;

import com.example.demo.dto.MarkDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MarkRowMapper implements RowMapper<MarkDto> {
    @Override
    public MarkDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        MarkDto markDto = new MarkDto();
        markDto.setId(rs.getInt("id"));
        markDto.setName(rs.getString("name"));
        return markDto;
    }
}
