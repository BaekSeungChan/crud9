package com.example.crud9.repository;

import com.example.crud9.entity.YouData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YouRepository extends JpaRepository<YouData, Long> {
}
