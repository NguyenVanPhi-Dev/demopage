package com.example.demopage.repository;

import com.example.demopage.model.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish,Long> {
    @Override
    Page<Dish> findAll(Pageable pageable);

}
