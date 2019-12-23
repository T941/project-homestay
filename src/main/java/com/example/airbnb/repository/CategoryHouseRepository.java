package com.example.airbnb.repository;


import com.example.airbnb.model.CategoryHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryHouseRepository extends JpaRepository<CategoryHouse,Long> {
}
