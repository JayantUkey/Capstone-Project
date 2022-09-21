package com.quickgrab.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quickgrab.dto.RestaurantOrder;
import com.quickgrab.exception.ResourceNotFoundException;

import com.quickgrab.model.OrderModel;
import com.quickgrab.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("create-order/{cId}")
	public ResponseEntity<OrderModel> createOrder(@PathVariable Integer cId, @Valid @RequestBody OrderModel orderModel)
			throws ResourceNotFoundException {
		return orderService.createOrder(cId, orderModel);
	}

	@PostMapping("add-food/{fId}/{oId}")
	public ResponseEntity<OrderModel> addFoodToOrder(@PathVariable Integer fId, @PathVariable Integer oId)
			throws ResourceNotFoundException {
		return orderService.addFoodToOrder(fId, oId);
	}

	@GetMapping
	public ResponseEntity<List<OrderModel>> showOrders() {
		return orderService.showAllOrders();
	}

	@DeleteMapping("{oid}")
	public OrderModel deleteOrder(@PathVariable Integer oid) throws ResourceNotFoundException {
		return orderService.deleteOrder(oid);
	}


	@GetMapping("/{rId}")
	public List<RestaurantOrder> getOrderByRestId(@PathVariable Integer rId) {
		return orderService.getOrderRestaurantInfo(rId);
	}

}
