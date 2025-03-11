package com.group.five.demo.controllers;

import com.group.five.demo.entitiy.Sale;
import com.group.five.demo.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SaleController {
    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/")
    public ResponseEntity<Sale> saveSale(@RequestBody Sale sale) {
        return saleService.save(sale);
    }

    @GetMapping("/")
    public ResponseEntity<List<Sale>> findAll() {
        return saleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> findById(@RequestParam("id") int id) {
        return saleService.findById(id);
    }

}
