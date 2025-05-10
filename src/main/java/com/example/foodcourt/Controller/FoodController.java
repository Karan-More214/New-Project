package com.example.foodcourt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodcourt.Entity.FoodEntity;
import com.example.foodcourt.Service.FoodService;

@Controller
@RequestMapping("/food")
public class FoodController {
	
	@Autowired
	private FoodService fs;
	
	@GetMapping("/")
	public String Test()
	{
		return "Home";
	}
	
	@GetMapping("/add")
	public String viewfoodform(Model model) {
		model.addAttribute("food", new FoodEntity());
		return "AddFood";
		}
	
	@PostMapping("/submit-item")
	public String submitfoodform(@ModelAttribute FoodEntity food) {
		fs.submitfoodform(food);
		return "redirect:/food/";
	}
	
	@GetMapping("/category")
	public String getFoodByCategory(@RequestParam("name")String category,Model model) {
		
		List<FoodEntity> foodList = fs.getFoodByCategory(category);
		model.addAttribute("category", category);
		model.addAttribute("foodList", foodList);
		return "Category";
	}
	
	@GetMapping("/edit/{id}")
	public String editfood(@PathVariable("id") int id,Model model) 
	{
		 FoodEntity food = fs.getFoodById(id); 
		 model.addAttribute("food", food);
		return "Updatefood";
	}
	
	@PostMapping("/update")
	public String updatefood(@ModelAttribute FoodEntity food) {
		fs.updatefood(food);
		return "redirect:/food/category?name="+food.getCategory();
	}
	
	@GetMapping("/delete/{id}")
	public String deletefood(@PathVariable("id") int id)
	{
		fs.deletefood(id);
		return "redirect:/food/"; 
	}
	

}
