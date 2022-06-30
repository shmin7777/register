package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Register;

@org.springframework.transaction.annotation.Transactional
public interface RegisterRepository extends JpaRepository<Register, Long>{
    List<Register> findAllByCode(String code);
}
