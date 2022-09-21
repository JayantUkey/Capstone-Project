package com.quickgrab.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quickgrab.exception.ResourceNotFoundException;
import com.quickgrab.model.FoodModel;
import com.quickgrab.model.RestaurantModel;
import com.quickgrab.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;

	@PostMapping
	public ResponseEntity<RestaurantModel> signUpRestaurant(@Valid @RequestBody RestaurantModel restaurant)
			throws ResourceNotFoundException {
		return restaurantService.signUpRestaurant(restaurant);
	}

	@PostMapping("/food/{rid}")
	public ResponseEntity<RestaurantModel> addFood(@PathVariable Integer rid, @Valid @RequestBody FoodModel foodModel)
			throws ResourceNotFoundException {
		return restaurantService.addFood(rid, foodModel);
	}

	@DeleteMapping("{rid}/food/{fid}")
	public FoodModel deleteFood(@PathVariable Integer rid, @PathVariable Integer fid) throws ResourceNotFoundException {
		return restaurantService.deletingFood(rid, fid);
	}

	@PutMapping("{rid}/food/{fid}")
	public FoodModel updateFood(@PathVariable Integer rid, @PathVariable Integer fid,
			@Valid @RequestBody FoodModel food) throws ResourceNotFoundException {
		return restaurantService.updateFood(rid, food, fid);
	}

	@GetMapping("get-food/{rid}")
	public ResponseEntity<List<FoodModel>> showFood(@PathVariable Integer rid) throws ResourceNotFoundException {
		return restaurantService.showFoodItems(rid);
	}

}
