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
		c.setTaxForm(objTaxForm);
		cr.save(c);
		//int i = cr.updateCust(objTaxForm, c.getCustomerId());
		return 1;
	}

	@Override
	public int addTaxDetailsByCustomerService(TaxForm objTaxForm) {
		TaxForm t = tr.findById(objTaxForm.getTaxformId()).orElse(null);
		t.setTotalIncomeSalary(objTaxForm.getTotalIncomeSalary());
		t.setOtherIncome(objTaxForm.getOtherIncome());
		t.setInterestIncome(objTaxForm.getInterestIncome());
		t.setRentalIncome(objTaxForm.getRentalIncome());
		t.setPpf(objTaxForm.getPpf());
		t.setMedicalInsurance(objTaxForm.getMedicalInsurance());
		t.setEducaionLoan(objTaxForm.getEducaionLoan());
		t.setNps(objTaxForm.getNps());
		t.setSavingsInterest(objTaxForm.getSavingsInterest());
		t.setVerifiedStatus("Pending");
		t.setPayableTax(objTaxForm.getPayableTax());
		t.setTaxformId(objTaxForm.getTaxformId());
		tr.save(t);
		Customer c1 = cr.getCustByPan(objTaxForm.getPan());
		c1.setTaxForm(objTaxForm);
		cr.save(c1);
		return 1;
	}

	
	
}
