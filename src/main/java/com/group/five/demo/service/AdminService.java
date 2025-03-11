package com.group.five.demo.service;

import com.group.five.demo.entitiy.Admin;
import com.group.five.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public ResponseEntity<List<Admin>> findAll() {
        return ResponseEntity.ok(adminRepository.findAll());
    }

    public ResponseEntity<Admin> findById(Integer id) {
        return ResponseEntity.ok(adminRepository.findById(id).orElse(null));
    }

    public ResponseEntity<Admin> save(Admin admin) {
        return ResponseEntity.ok(adminRepository.save(admin));
    }

    public ResponseEntity<Admin> update(Admin admin, int id) {
        Admin admin1 = adminRepository.findById(id).orElse(null);
        if (admin1 != null) {
            admin1.setName(admin.getName());
            adminRepository.save(admin1);
            return ResponseEntity.ok(admin1);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Admin> delete(Integer id) {
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin != null) {
            adminRepository.delete(admin);
            return ResponseEntity.ok(admin);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Admin> findByName(String name) {
        return ResponseEntity.ok(adminRepository.findByName(name));
    }

    public Boolean login(Admin admin) {
        return adminRepository.existsByNameAndPassword(admin.getName(), admin.getPassword());
    }


}
