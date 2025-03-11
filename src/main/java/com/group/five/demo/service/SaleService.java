package com.group.five.demo.service;

import com.group.five.demo.entitiy.Sale;
import com.group.five.demo.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    private final SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public ResponseEntity<List<Sale>> findAll() {
        return ResponseEntity.ok(saleRepository.findAll());
    }

    public ResponseEntity<Sale> findById(Integer id) {
        return ResponseEntity.ok(saleRepository.findById(id).orElse(null));
    }

    public ResponseEntity<Sale> save(Sale sale) {
        return ResponseEntity.ok(saleRepository.save(sale));
    }
}
