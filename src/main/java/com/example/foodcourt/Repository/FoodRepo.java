package com.example.foodcourt.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foodcourt.Entity.FoodEntity;

@Repository
public interface FoodRepo extends JpaRepository<FoodEntity, Integer>{
	
	List<FoodEntity> findByCategoryIgnoreCase(String category);

}
