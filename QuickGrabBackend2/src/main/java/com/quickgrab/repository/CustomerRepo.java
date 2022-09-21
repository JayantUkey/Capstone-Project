package com.quickgrab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quickgrab.dto.RestaurantFood;
import com.quickgrab.model.CustomerModel;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerModel, Integer> {

	@Query("SELECT new com.quickgrab.dto.RestaurantFood(r.restName,r.restAddress,r.restContact, f.foodName, f.foodPrice) from RestaurantModel r JOIN r.foodModel f where food_id=?1")

	public List<RestaurantFood> getJoinInformation(int foodId);
	
	CustomerModel findByCustContact(String custContact);

	CustomerModel findByCustEmail(String custEmail);

}
