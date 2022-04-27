package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.services.CustomerService;
import com.training.model.Customer;

@RequestMapping("/bookstore")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getcustomers()
	{
		return customerService.findCustomers();
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/customer")
	public Customer savecustomer(@RequestBody Customer customer)
	{
		return customerService.saveCustomer(customer);
	}
	

}
