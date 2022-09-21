package com.quickgrab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Food")
public class FoodModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id")
	private int foodId;
	
	@NotNull(message = "Food Name is Mandatory")
	@Column(name = "food_name")
	private String foodName;
	
	@NotNull(message = "Food Price is Mandatory")
	@Column(name = "food_price")
	private Float foodPrice;
	
	@NotNull(message = "Food Type is Mandatory")
	@Column(name = "food_type")
	private String food_type;
	
	@Column(name = "rest_id")
	private Integer restId;
//	@Column(name = "order_id")
//	private Integer orderId;


}
