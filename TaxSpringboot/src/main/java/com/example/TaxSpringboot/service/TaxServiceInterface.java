package com.example.TaxSpringboot.service;

import com.example.TaxSpringboot.entity.TaxForm;

public interface TaxServiceInterface {

	int addTaxDetailsForEmployeeService(TaxForm objTaxForm);

	int addTaxDetailsByNewCustomerService(TaxForm objTaxForm);

}
