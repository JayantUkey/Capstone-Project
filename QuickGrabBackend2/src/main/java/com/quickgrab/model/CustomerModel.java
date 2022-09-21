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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Customer")
public class CustomerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id")
	private int custId;

	@NotNull(message = "Customer Name is Mandatory")
	@Column(name = "cust_name")
	private String custName;

	@Column(name = "cust_pass")
	@NotNull(message = "Password must not be blank")
	private String custPass;

	@NotNull(message = "Customer Address is Mandatory")
	@Column(name = "cust_address")
	private String custAddress;

	@NotNull(message = "Customer Contact is Mandatory")
	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "The number should contains 10 digits and should start with either 6,7,8,9")
	@Column(name = "cust_contact")
	private String custContact;

	@Email
	@Column(name = "cust_email")
	private String custEmail;
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "cust_id", referencedColumnName = "cust_id")
	private List<OrderModel> orderModel;

}
