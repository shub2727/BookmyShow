package jfs.backend.bms.food.service.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jfs.backend.bms.food.service.Service.FoodService;
import jfs.backend.bms.food.service.entity.Food;
import jfs.backend.bms.food.service.exception.ResourceNotFoundException;
import jfs.backend.bms.food.service.Dto.FoodDto;
import jfs.backend.bms.food.service.repo.FoodRepository;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository foodRepository;

	@Override
	public FoodDto addFood(FoodDto foodDto) {

		Food food = new Food();
	    String string = UUID.randomUUID().toString();

		foodDto.setFoodId(string);
		
		BeanUtils.copyProperties(foodDto, food);

		FoodDto foodDto2 = new FoodDto();

		this.foodRepository.save(food);

		BeanUtils.copyProperties(food, foodDto2);

		return foodDto2;
	}

	@Override
	public List<FoodDto> getAllFood() {

		List<Food> foodList = this.foodRepository.findAll();

		List<FoodDto> foodDtos = new ArrayList();

		foodList.stream().map((x) -> {

			FoodDto foodDto = new FoodDto();

			BeanUtils.copyProperties(x, foodDto);

			foodDtos.add(foodDto);

			return x;

		}).collect(Collectors.toList());

		return foodDtos;
	}

	public Double createOrder(Map<String,Integer> foodDto	) {

		Double totalAmount = 0D;

		for (Map.Entry<String, Integer> food : foodDto.entrySet()) {
			Food food1 = foodRepository.findByFoodName(food.getKey());
			if (food1 != null && food1.getStatus().equalsIgnoreCase("Available")) {
				totalAmount += (food.getValue() * food1.getFoodPrice());
			}
		}

		return totalAmount;
	}

	@Override
	public FoodDto updateFood(String foodId,FoodDto foodDto) {

		FoodDto foodDto2 = new FoodDto();
		Food food = this.foodRepository.findById(foodId)
				.orElseThrow(() -> new ResourceNotFoundException("Food", "foodId", foodId));

		BeanUtils.copyProperties(foodDto, food);
		
		this.foodRepository.save(food);
	
		BeanUtils.copyProperties(food, foodDto2);

		return foodDto2;
	}

	@Override
	public String deleteFood(String foodId) {

		Food food = this.foodRepository.findById(foodId)
				.orElseThrow(() -> new ResourceNotFoundException("Food", "foodId", foodId));

		if (food.getFoodId().equals(foodId)) {

			this.foodRepository.deleteById(foodId);

			return "Food Deleted Successfully....!";
		}

		return "Failed To Delete Food.....!";
	}

	@Override
	public FoodDto getFoodById(String foodId) {

		Food food = this.foodRepository.findById(foodId)
				.orElseThrow(() -> new ResourceNotFoundException("Food", "foodId", foodId));

		FoodDto foodDto = new FoodDto();

		BeanUtils.copyProperties(food, foodDto);

		return foodDto;
	}

}
