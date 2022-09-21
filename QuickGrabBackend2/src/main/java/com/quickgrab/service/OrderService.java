package com.quickgrab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quickgrab.dto.RestaurantOrder;
import com.quickgrab.exception.ResourceNotFoundException;
import com.quickgrab.model.FoodModel;
import com.quickgrab.model.OrderModel;
import com.quickgrab.repository.CustomerRepo;
import com.quickgrab.repository.FoodRepo;
import com.quickgrab.repository.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private FoodRepo foodRepo;

	@Autowired
	CustomerRepo customerRepo;

	public ResponseEntity<OrderModel> createOrder(Integer custId, OrderModel orderModel)
			throws ResourceNotFoundException {
		
		if (!customerRepo.existsById(custId)) {
			throw new ResourceNotFoundException("Customer with Id don't exists");
		}
		orderModel.setCustId(custId);

		return new ResponseEntity<OrderModel>(orderRepo.save(orderModel), HttpStatus.ACCEPTED);
	}

	public ResponseEntity<OrderModel> addFoodToOrder(Integer foodId, Integer orderId) throws ResourceNotFoundException {

		OrderModel orderModel = orderRepo.findById(orderId).orElse(null);
		FoodModel foodModel = foodRepo.findById(foodId).orElse(null);
		if (foodModel == null)
			throw new ResourceNotFoundException("Food Id not found");
		if (orderModel == null)
			throw new ResourceNotFoundException("Order Id not found");

		float orderPrice = orderModel.getOrderPrice();
		int items = orderModel.getItems();
		orderModel.setOrderPrice(orderPrice + foodModel.getFoodPrice());
		orderModel.getFoodModel().add(foodModel);
		orderModel.setItems(items + 1);
		return new ResponseEntity<OrderModel>(orderRepo.save(orderModel), HttpStatus.ACCEPTED);
	}

	public ResponseEntity<List<OrderModel>> showAllOrders() {

		List<OrderModel> orderModel = orderRepo.findAll();
		return new ResponseEntity<List<OrderModel>>(orderModel, HttpStatus.ACCEPTED);
	}

	public OrderModel deleteOrder(Integer orderId) throws ResourceNotFoundException {

		if (!orderRepo.existsById(orderId)) {
			throw new ResourceNotFoundException("Order Id not found");
		} else {
			orderRepo.deleteById(orderId);
		}
		return null;
	}


	public List<RestaurantOrder> getOrderRestaurantInfo(Integer id) {

		List<RestaurantOrder> list = orderRepo.getOrderRestaurantInfo(id);
		System.out.println(orderRepo.getOrderRestaurantInfo(id));
		return list;
	}
}
