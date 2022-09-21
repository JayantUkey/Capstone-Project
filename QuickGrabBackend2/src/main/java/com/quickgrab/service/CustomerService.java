package com.quickgrab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickgrab.dto.RestaurantFood;
import com.quickgrab.exception.ResourceNotFoundException;
import com.quickgrab.model.CustomerModel;
import com.quickgrab.model.FoodModel;

import com.quickgrab.repository.CustomerRepo;
import com.quickgrab.repository.FoodRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private FoodRepo foodRepo;

	public CustomerModel signUpCustomer(CustomerModel customer) throws ResourceNotFoundException {

		if (customerRepo.findByCustContact(customer.getCustContact()) != null)
			throw new ResourceNotFoundException("Customer Contact is already exist");

		if (customerRepo.findByCustEmail(customer.getCustEmail()) != null)
			throw new ResourceNotFoundException("Customer Email is already exist");

		return customerRepo.save(customer);

	}
	

	public List<FoodModel> getallfood(){
		return foodRepo.findAll();
	}

	
	public List<RestaurantFood> getJoinInformation(Integer id) throws ResourceNotFoundException {

		if (!foodRepo.existsById(id)) {
			throw new ResourceNotFoundException("Food Id not found");
		}

		return customerRepo.getJoinInformation(id);
	}

	
	public CustomerModel editCustomer(Integer id, CustomerModel customerModel) throws ResourceNotFoundException {

		if (!customerRepo.existsById(id)) {
			throw new ResourceNotFoundException("Customer Id not found");
		}

		return customerRepo.findById(id).map(customer -> {
			customer.setCustName(customerModel.getCustName());
			customer.setCustEmail(customerModel.getCustEmail());
			customer.setCustContact(customerModel.getCustContact());
			customer.setCustAddress(customerModel.getCustAddress());
			customer.setCustPass(customerModel.getCustPass());
			return customerRepo.save(customer);
		}).orElseThrow(() -> new ResourceNotFoundException("Customer id not found"));

	}

}
