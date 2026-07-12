package com.ecomspring.service;

import com.ecomspring.model.Vendor;
import com.ecomspring.repository.VendorRepository;
import org.springframework.stereotype.Service;

@Service
public class VendorService {
    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public Vendor getVendorById(int vendorId) {
        return vendorRepository.getVendorById(vendorId).
                orElseThrow(() -> new RuntimeException("Vendor id " + vendorId + " not found.."));
    }
}
