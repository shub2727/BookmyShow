package jfs.backend.bms.food.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class Food {
	@Id
	private String foodId;
	private String foodName;
    private Integer foodQnt;
    private String status;
	private Double foodPrice;
	
}
