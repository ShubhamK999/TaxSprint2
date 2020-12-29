package com.example.TaxSpringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaxSpringboot.entity.TaxForm;
import com.example.TaxSpringboot.service.TaxServiceInterface;

@RestController
public class TaxController {
	@Autowired
	private TaxServiceInterface tsi;
	
	@PutMapping("/taxDetailsForEmployee")
	public String addTaxDetailsForEmployee(@RequestBody TaxForm objTaxForm) {
		String str = "Taxform details not added";
		int i = tsi.addTaxDetailsForEmployeeService(objTaxForm);
		if(i>0) {
			str = "Taxform details added successfully";
		}
		return str;
		
	}
	
	@PutMapping("/taxDetailsByNew")
	public String addTaxDetailsByNewCustomer(@RequestBody TaxForm objTaxForm) {
		String str= "Taxform details not added";
		int i = tsi.addTaxDetailsByNewCustomerService(objTaxForm);
		if(i>0) {
			str = "Taxform details added successfully(New Customer)";
		}
		return str;
	}
	
	@PutMapping("/taxDetailsByCustomer")
	public String addTaxDetailsByCustomer(@RequestBody TaxForm objTaxForm) {
		String str= "Taxform details not added";
		int i = tsi.addTaxDetailsByCustomerService(objTaxForm);
		if(i>0) {
			str = "Taxform details added successfully";
		}
		return str;
		
	}

	
}
