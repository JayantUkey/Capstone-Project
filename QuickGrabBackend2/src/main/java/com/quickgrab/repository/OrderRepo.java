package com.quickgrab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quickgrab.dto.RestaurantOrder;
import com.quickgrab.model.OrderModel;

@Repository

public interface OrderRepo extends JpaRepository<OrderModel, Integer> {

	@Query("SELECT new com.quickgrab.dto.RestaurantOrder(o.items,o.orderPrice,o.custId, f.foodName,f.foodPrice) from OrderModel o JOIN o.foodModel f where rest_id=?1")

	public List<RestaurantOrder> getOrderRestaurantInfo(int restId);

}
