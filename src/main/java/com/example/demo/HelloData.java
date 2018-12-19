package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloData{

	@Autowired
	private Customer customer;
	
	@RequestMapping("/nameRS")
	public String helloRS() {
		//System.out.println(customer.getDataRequestScope().hashCode()+" RS");
		return customer.getDataRequestScope().getName();
	}
	
	@RequestMapping("/nameSSUpdated")
	public String helloSSUpdated() {
		//System.out.println(customer.hashCode()+"SS");
		System.out.println(customer.getDataSessionScope().getName());
		customer.getDataSessionScope().setName("Session Scope Updated");
		return customer.getDataSessionScope().getName();
	}
	
	@RequestMapping("/nameSS")
	public String helloSS() {
	//	System.out.println(customer.hashCode()+"GSS");
		System.out.println(customer.hashCode());
		return customer.getDataSessionScope().getName();
	}

}