package jfs.backend.bms.food.service.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jfs.backend.bms.food.service.Service.FoodService;
import jfs.backend.bms.food.service.Dto.FoodDto;

@RestController
@RequestMapping("/api/foods")
public class FoodServiceController {
	
	@Autowired
	private FoodService foodService;
	
	@PostMapping("/")
	public ResponseEntity<FoodDto> addFood(@RequestBody FoodDto foodDto){
		
		FoodDto addFood = this.foodService.addFood(foodDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(addFood);
	}


	@PostMapping("/order")
	public ResponseEntity<Double> OrderFood(@RequestBody Map<String,Integer> foodDto){

		Double d= foodService.createOrder(foodDto);

		//FoodDto addFood = this.foodService.addFood(foodDto);

		return new ResponseEntity<>(d,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getAllFoods")
	public ResponseEntity<List<FoodDto>> getAllFoods(){
		List<FoodDto> allFood = this.foodService.getAllFood();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(allFood);
		
	}
	
	@PutMapping("/updateFood/{foodId}")
	public ResponseEntity<FoodDto> updateFood(@PathVariable String foodId, @RequestBody FoodDto foodDto){
	
		FoodDto updateFood = this.foodService.updateFood(foodId,foodDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(updateFood);
	}
	
	@DeleteMapping("/deleteFood/{foodId}")
	public ResponseEntity<String> deleteFood(@PathVariable String foodId){
		
		String deleteFood = this.foodService.deleteFood(foodId);
		return ResponseEntity.status(HttpStatus.CREATED).body(deleteFood);
	}
	
	
	@GetMapping("/getFoodByID/{foodId}")
	public ResponseEntity<FoodDto> getFoodById(@PathVariable String foodId){
		
		FoodDto foodById = this.foodService.getFoodById(foodId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(foodById);
		
	}

}
