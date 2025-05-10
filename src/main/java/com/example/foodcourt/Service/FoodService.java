package com.example.foodcourt.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodcourt.Entity.FoodEntity;
import com.example.foodcourt.Repository.FoodRepo;

@Service
public class FoodService {
	
	@Autowired
	private FoodRepo repo;

	public void submitfoodform(FoodEntity food) {
		repo.save(food);
		
	}

	public List<FoodEntity> getFoodByCategory(String category) {
		
		return repo.findByCategoryIgnoreCase(category);
	}

	public FoodEntity getFoodById(int id) {
		
		return repo.findById(id).orElse(null);
	}

	public void updatefood(FoodEntity food) {
		repo.save(food);
		
	}

	public void deletefood(int id) {
		repo.deleteById(id);
	}

	

}
