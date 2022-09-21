package com.quickgrab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.quickgrab.model.FoodModel;

@Repository
public interface FoodRepo extends JpaRepository<FoodModel, Integer> {

}
