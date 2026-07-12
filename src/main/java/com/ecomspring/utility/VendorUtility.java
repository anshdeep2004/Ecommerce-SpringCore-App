package com.ecomspring.utility;

import com.ecomspring.model.Vendor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class VendorUtility implements RowMapper<Vendor> {

    @Override
    public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Vendor vendor = new Vendor(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
        return vendor;
    }
}
