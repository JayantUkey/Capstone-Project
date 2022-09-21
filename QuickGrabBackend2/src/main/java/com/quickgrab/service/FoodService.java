package com.quickgrab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quickgrab.model.FoodModel;

import com.quickgrab.repository.FoodRepo;

@Service
public class FoodService {

	@Autowired
	private FoodRepo foodRepo;

	public ResponseEntity<FoodModel> createFood(FoodModel food) {
		foodRepo.save(food);
		return new ResponseEntity<FoodModel>(food, HttpStatus.ACCEPTED);

	}
}
