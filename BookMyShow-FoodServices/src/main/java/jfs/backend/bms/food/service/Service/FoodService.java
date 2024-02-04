package jfs.backend.bms.food.service.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import jfs.backend.bms.food.service.Dto.FoodDto;

public interface FoodService {
	
	public FoodDto addFood(FoodDto foodDto);
	
	public List<FoodDto> getAllFood();

	public Double createOrder(Map<String,Integer> foodDto	);
	
	public FoodDto updateFood(String foodId,FoodDto foodDto);
	
	public String deleteFood(String foodId);
	
	public FoodDto getFoodById(String foodId);

}
