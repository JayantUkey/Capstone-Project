package com.quickgrab.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "OrderDetails")
@Data
public class OrderModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;

	@Column(name = "items")
	private int items;

	@Column(name = "order_price")
	private Float orderPrice;

	@OneToMany(cascade = { CascadeType.DETACH })
	@JoinColumn(name = "order_id", referencedColumnName = "order_id")
	private List<FoodModel> foodModel;
	@Column(name = "cust_id")
	private int custId;

}
