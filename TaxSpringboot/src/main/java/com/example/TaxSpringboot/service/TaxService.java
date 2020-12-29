package com.example.TaxSpringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.TaxSpringboot.dao.CustomerRepository;
import com.example.TaxSpringboot.dao.TaxformRepository;
import com.example.TaxSpringboot.entity.TaxForm;
import com.example.TaxSpringboot.entity.Customer;


@Service
public class TaxService implements TaxServiceInterface {
	
	@Autowired
	TaxformRepository tr;
	
	@Autowired
	CustomerRepository cr;

	@Override
	public int addTaxDetailsForEmployeeService(TaxForm objTaxForm) {
		tr.save(objTaxForm);
		return 1;
	}

	@Override
	@Transactional
	public int addTaxDetailsByNewCustomerService(TaxForm objTaxForm) {
		tr.save(objTaxForm);
		Customer c = cr.getCustByPan(objTaxForm.getPan());
		System.out.println(objTaxForm.getPan());
		System.out.println(c.getPan());
		int i = cr.updateCust(objTaxForm, c.getCustomerId());
		return i;
	}

}
