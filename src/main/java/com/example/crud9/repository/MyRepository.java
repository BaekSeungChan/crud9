package com.example.crud9.repository;

import com.example.crud9.entity.MyData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository extends JpaRepository<MyData, Long> {
}
