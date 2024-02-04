package jfs.backend.bms.food.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jfs.backend.bms.food.service.entity.Food;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, String>{

    Food findByFoodName(String keyword);

}
