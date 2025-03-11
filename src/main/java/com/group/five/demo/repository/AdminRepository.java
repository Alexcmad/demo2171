package com.group.five.demo.repository;

import com.group.five.demo.entitiy.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByName(String name);
    Boolean existsByNameAndPassword(String name, String password);
}
