package com.group.five.demo.controllers;

import com.group.five.demo.entitiy.Admin;
import com.group.five.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        return adminService.save(admin);
    }

    @GetMapping("/")
    public ResponseEntity<List<Admin>> findAll() {
        return adminService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> findById(@RequestParam("id") int id) {
        return adminService.findById(id);
    }

    @PostMapping("/login")
    public Boolean login(@RequestBody Admin admin) {
        return adminService.login(admin);
    }

}
