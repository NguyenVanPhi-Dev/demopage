package com.example.demopage.repository;

import com.example.demopage.model.Tables;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Tables,Long> {
}
