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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Restaurant")
public class RestaurantModel {

	public RestaurantModel(int restId, String restName, String restPass, String restAddress, String restContact) {
		super();
		this.restId = restId;
		this.restName = restName;
		this.restPass = restPass;
		this.restAddress = restAddress;
		this.restContact = restContact;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rest_id")
	private int restId;

	@NotNull(message = "Resturant Name is Mandatory")
	@Column(name = "rest_name")
	private String restName;

	@Column(name = "rest_pass")
	private String restPass;

	@NotNull(message = "Restaurant Address is Mandatory")
	@Column(name = "rest_address")
	private String restAddress;

	@NotNull(message = "Restaurant Contact is Mandatory")
	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "The number should contains 10 digits and should start with either 6,7,8,9")
	@Column(name = "rest_contact")
	private String restContact;
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "rest_id", referencedColumnName = "rest_id")
	private List<FoodModel> foodModel;

}
