package com.quickgrab.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quickgrab.dto.RestaurantFood;
import com.quickgrab.exception.ResourceNotFoundException;
import com.quickgrab.model.CustomerModel;
import com.quickgrab.model.FoodModel;

import com.quickgrab.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public CustomerModel signUpCustomer(@Valid @RequestBody CustomerModel customer) throws ResourceNotFoundException {
		return customerService.signUpCustomer(customer);
	}

	@GetMapping("/foodlist")
	public List<FoodModel> getFood() {
		return customerService.getallfood();
	}

	@GetMapping("/getFood/{fid}")
	public List<RestaurantFood> getJointInformation(@PathVariable Integer fid) throws ResourceNotFoundException {
		return customerService.getJoinInformation(fid);
	}

	// for editing customer
	@PutMapping("{cid}")
	public CustomerModel editCustomer(@PathVariable Integer cid, @Valid @RequestBody CustomerModel customer)
			throws ResourceNotFoundException {
		return customerService.editCustomer(cid, customer);
	}
}
