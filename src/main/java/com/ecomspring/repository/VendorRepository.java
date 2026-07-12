package com.ecomspring.repository;

import com.ecomspring.model.Vendor;
import com.ecomspring.utility.VendorUtility;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class VendorRepository {
    private final VendorUtility vendorUtility;
    private final JdbcTemplate jdbcTemplate;

    public VendorRepository(VendorUtility vendorUtility, JdbcTemplate jdbcTemplate) {
        this.vendorUtility = vendorUtility;
        this.jdbcTemplate = jdbcTemplate;
    }


    public Optional<Vendor> getVendorById(int vendorId) {
        String sql = "Select * from vendor where id=?";
        return jdbcTemplate.query(sql, vendorUtility, vendorId).stream().findFirst();
    }
}
